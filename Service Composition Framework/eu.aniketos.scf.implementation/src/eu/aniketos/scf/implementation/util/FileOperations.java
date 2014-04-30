/*******************************************************************************
 * Copyright (c) 2012, Project: FP7-ICT-257930 Aniketos
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * 
 *  -  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *  -  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *  -  Neither the name of institution nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package eu.aniketos.scf.implementation.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class FileOperations {

	private static Logger logger = Logger.getLogger(FileOperations.class);
	
	public static void addFilesToExistingZip(java.io.File zipFile, java.io.File newFile) throws IOException 
	{
		String tempFileName = new String("temp_" + System.currentTimeMillis());
		
		java.io.File tempFile = new java.io.File("webapps/generator/WEB-INF/service_descriptions/" + tempFileName + ".tmp");
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
	
	public static void copyFile(java.io.File source, java.io.File dest) throws IOException
	{
		java.io.File inputFile = source;
		java.io.File outputFile = dest;

		InputStream finput = new BufferedInputStream(new FileInputStream(inputFile));
		OutputStream foutput = new BufferedOutputStream(new FileOutputStream(outputFile));
		
		byte[] buffer = new byte[1024 * 500];
		int bytes_read = 0;
		
		while((bytes_read = finput.read(buffer)) > 0)
		foutput.write(buffer, 0, bytes_read);
		finput.close();
		foutput.close();
	}
	
	public static void copyDirectory(java.io.File source, java.io.File dest) throws IOException
	{
		java.io.File[] listFiles = source.listFiles();
		for(int i = 0; i < listFiles.length; i++)
		{
			java.io.File targetFile = new java.io.File(dest.getAbsolutePath()+"/"+listFiles[i].getName());
			copyFile(listFiles[i],targetFile);
		}
	}
	
	public static boolean deleteDirectory(java.io.File dir) 
	{
        if (dir.isDirectory()) 
        {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) 
            {
                boolean success = deleteDirectory(new java.io.File(dir, children[i]));
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
