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
package eu.aniketos.mtm.utils;

import java.io.File;
import java.util.UUID;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class Utils {
	
	/**
	 * Replaces one file's extension.
	 * @param originPath Original file name.
	 * @param extension Desired extension.
	 * @return The file name with the new extension.
	 */
	public static String replaceExtension(String originPath, String extension) {
		String returnPath = "";
		try {
			returnPath = originPath.substring(0, originPath.lastIndexOf('.') + 1) + extension;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return returnPath;
	}
	
	/**
	 * Gets the path of a file.
	 * @param originPath The file name, including the path.
	 * @return The path.
	 */
	public static String getPath(String originPath) {
		return originPath.substring(0, originPath.lastIndexOf(File.separatorChar));
	}
	
	/**
	 * Gets a IFolder object, given an absolute path.
	 * @param path The absolute path of the folder.
	 * @return
	 */
	public static IFolder getFolder(String path) {
		IPath workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
    	String wsRelativePath = path.substring(workspacePath.toString().length());
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(wsRelativePath));
		return folder;
	}
	
	/**
	 * Refreshes a file/folder in the Package Explorer.
	 * @param path The absolute path of the file/folder to refresh.
	 */
	public static void refreshPath(String path) {
	    try {
			IFolder folder = getFolder(path);
	    	folder.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (Exception e) {
		}
	}
	
	/**
	 * Gets the path relative to the workspace, given an absolute path.
	 * @param absPath The absolute path of the file.
	 * @return The relative path.
	 */
	public static String getRelativePath(String absPath) {
    	IPath workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
    	String wsRelativePath = absPath.substring(workspacePath.toString().length());
    	return wsRelativePath;
	}
	
	/**
	 * Gets the IFile corresponding to an absolute path.
	 * @param absPath The absolute path of the file.
	 * @return The corresponding IFile.
	 */
	public static IFile getIFile(String absPath) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(getRelativePath(absPath)));
		return file;
	}
	
	/**
	 * Gets the File corresponding to an absolute path.
	 * @param absPath The absolute path of the file.
	 * @return The corresponding File.
	 */
	public static File getFile(String absPath) {
		File file = new File(absPath);
		return file;
	}
	
	/**
	 * Opens a file with its default editor.
	 * @param filePath The absolute path of the file to open.
	 */
	public static void openFile(String filePath) {
		try {
	    	IPath workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
	    	String wsRelativePath = filePath.substring(workspacePath.toString().length());
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(wsRelativePath));
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			page.openEditor(new FileEditorInput(file), desc.getId());
		} catch(Exception e) {
		}
	}
	
	/**
	 * Get the file name, given a complete path.
	 * @param originPath The complete path.
	 * @return
	 */
	public static String getFileName(String originPath) {
		String file = "";
		try {
			file = originPath.substring(originPath.lastIndexOf(File.separatorChar) + 1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return file;
	}
	
	/**
	 * Get the file name without extension, given a complete path.
	 * @param originPath The complete path.
	 * @return
	 */
	public static String getFileNameWithoutExt(String originPath) {
		String name = "";
		try {
			String fileName = getFileName(originPath);
			name = fileName.substring(0, fileName.lastIndexOf('.'));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public static String generateUniqueID(){
		String id = UUID.randomUUID().toString();
		return id;
	}
}
