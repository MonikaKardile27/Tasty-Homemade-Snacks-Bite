package com.foodorder.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class DiskStorageServiceImpl implements StorageService {
	@Value("${disk.upload.basepath}")
	private String BASEPATH;

//	DiskStorageServiceImpl  implements 
//	the StorageService interface.
//	The purpose of this class is to handle storing, 
//	loading, and deleting files on disk. 
	@Override
	public List<String> loadAll() {
		File dirPath = new File(BASEPATH);
		return Arrays.asList(dirPath.list());
	}
	//BASEPATH is annotated with @Value, indicating that its value will
//	be injected from the 
//	Spring environment using the specified property name.
	//This method lists all the files in the directory 
//	specified by the BASEPATH variable and returns them as a list of strings.

	@Override
	public String store(MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		String ext=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println(ext);
		String fileName = UUID.randomUUID().toString().replaceAll("-", "")+ext;
		File filePath = new File(BASEPATH, fileName);
		try(FileOutputStream out = new FileOutputStream(filePath)) {
			FileCopyUtils.copy(file.getInputStream(), out);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//This method stores the uploaded file onto disk. 
	//It generates a unique file name using UUID, creates a file path using 
	//the BASEPATH variable, and then copies the contents of the uploaded file to the newly created file using FileOutputStream and FileCopyUtils
	@Override
	public Resource load(String fileName) {
		File filePath = new File(BASEPATH, fileName);
		if(filePath.exists())
			return new FileSystemResource(filePath);
		return null;
	}

	@Override
	public void delete(String fileName) {
		File filePath = new File(BASEPATH, fileName);
		if(filePath.exists())
			filePath.delete();
	}

}
