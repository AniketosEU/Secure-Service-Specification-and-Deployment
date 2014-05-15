package eu.aniketos.serviceruntime.remote.tomcat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class that provides methods for creating a WAR file from a source folder
 * @author Kostas Giannakakis
 *
 */
public class WarCreator {

	/**
	 * Create a WAR file from a source folder
	 * @param srcFolder The folder that contains the files to be included in the WAR file
	 * @param destWarFile The destination of the created WAR file
	 * @throws Exception
	 */
	public void create(String srcFolder, String destWarFile) 
			throws Exception 
	{
		ZipOutputStream war = null;
		FileOutputStream fileWriter = null;

		fileWriter = new FileOutputStream(destWarFile);
		war = new ZipOutputStream(fileWriter);

		addFolderToWar("", srcFolder, war);
		
		war.flush();
		war.close();
	}
	
	/**
	 * Adds a file to the WAR file
	 * @param path The path of the file
	 * @param srcFile The file to add
	 * @param war The WAR file
	 * @throws Exception
	 */
	private void addFileToWar(String path, String srcFile, ZipOutputStream war) 
			throws Exception 
	{
		java.io.File folder = new java.io.File(srcFile);
	    if (folder.isDirectory()) 
	    {
	    	addFolderToWar(path, srcFile, war);
	    } 
	    else 
	    {
	    	byte[] buf = new byte[1024];
	    	int len;
	    	FileInputStream in = new FileInputStream(srcFile);
	    	war.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
	    	while ((len = in.read(buf)) > 0) 
	    	{
	    		war.write(buf, 0, len);
	    	}
	    	in.close();
	    }
	}
	
	/**
	 * Adds a folder to the WAR file
	 * @param path The path
	 * @param srcFolder The folder
	 * @param war The WAR file
	 * @throws Exception
	 */
	private void addFolderToWar(String path, String srcFolder, ZipOutputStream war)
			throws Exception
	{
		java.io.File folder = new java.io.File(srcFolder);

		for (String fileName : folder.list()) 
		{
			if (path.equals("")) 
			{
				addFileToWar(folder.getName(), srcFolder + "/" + fileName, war);
			} 
			else 
			{
				addFileToWar(path + "/" + folder.getName(), srcFolder + "/" + fileName, war);
			}
		}
	}
}
