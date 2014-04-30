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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class War {

	public static void warFolder(String srcFolder, String destWarFile) throws Exception 
	{
		ZipOutputStream war = null;
		FileOutputStream fileWriter = null;

		fileWriter = new FileOutputStream(destWarFile);
		war = new ZipOutputStream(fileWriter);

		addFolderToWar("", srcFolder, war);
		
		war.flush();
		war.close();
	}
	
	public static void addFileToWar(String path, String srcFile, ZipOutputStream war) throws Exception 
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
	
	public static void addFolderToWar(String path, String srcFolder, ZipOutputStream war) throws Exception
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
