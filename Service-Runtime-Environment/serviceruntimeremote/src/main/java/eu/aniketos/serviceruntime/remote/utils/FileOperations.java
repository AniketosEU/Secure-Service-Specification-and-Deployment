package eu.aniketos.serviceruntime.remote.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileOperations {
	
	public static void addFilesToExistingZip(File zipFile, File newFile) throws IOException 
	{
		String tempFileName = new String("temp_" + System.currentTimeMillis());
		
		File tempFile = new File("webapps/generator/WEB-INF/service_descriptions/" + 
								 tempFileName + ".tmp");
		copyFile(zipFile, tempFile);
		
		byte[] buf = new byte[1024];
		
		ZipInputStream zin = new ZipInputStream(new FileInputStream(tempFile));
		ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipFile));
		
		ZipEntry entry = zin.getNextEntry();
		while (entry != null) 
		{
			String name = entry.getName();
//			boolean notInFiles = true;
				
			if (newFile.getName().equals(name)) 
			{
//				notInFiles = false;
				entry = zin.getNextEntry();
				continue;
			} else {
//			if (notInFiles) 
//			{
				// Add ZIP entry to output stream
				zout.putNextEntry(new ZipEntry(name));
				
				// Transfer bytes from the ZIP file to the output file
				int len;
				while ((len = zin.read(buf)) > 0) 
				{
					zout.write(buf, 0, len);
				}
			}
			entry = zin.getNextEntry();
		}
		
		// Close the streams		
		zin.close();
		
		// Compress the files
		InputStream in = new FileInputStream(newFile);
		
		// Add ZIP entry to output stream
		zout.putNextEntry(new ZipEntry(newFile.getName()));
		
		// Transfer bytes from the file to the ZIP file
		int len;
		while ((len = in.read(buf)) > 0) 
		{
			zout.write(buf, 0, len);
		}
		
		// Complete the entry
		zout.closeEntry();
		in.close();
		
		// Complete the ZIP file
		zout.close();
		tempFile.delete();
	}
	
	public static void copyFile(File source, File dest) throws IOException
	{
		File inputFile = source;
		File outputFile = dest;

		InputStream finput = new BufferedInputStream(new FileInputStream(inputFile));
		OutputStream foutput = new BufferedOutputStream(new FileOutputStream(outputFile));
		
		byte[] buffer = new byte[1024 * 500];
		int bytes_read = 0;
		
		while((bytes_read = finput.read(buffer)) > 0)
		foutput.write(buffer, 0, bytes_read);
		finput.close();
		foutput.close();
	}
	
	public static void copyDirectory(File source, File dest) throws IOException
	{
		File[] listFiles = source.listFiles();
		for(int i = 0; i < listFiles.length; i++)
		{
			File targetFile = new File(dest.getAbsolutePath()+"/"+listFiles[i].getName());
			copyFile(listFiles[i],targetFile);
		}
	}
	
	public static boolean deleteDirectory(File dir) 
	{
        if (dir.isDirectory()) 
        {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) 
            {
                boolean success = deleteDirectory(new File(dir, children[i]));
                if (!success) 
                {
                    return false;
                }
            }
        }
    
        // The directory is now empty so delete it
        return dir.delete();
    }
}
