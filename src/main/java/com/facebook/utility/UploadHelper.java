package com.facebook.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadHelper {
	//public final String upload_dir="F:\\Spring WorkSpace\\API\\FileUpload\\src\\main\\resources\\static\\images";
	
 public final String upload_dir= new ClassPathResource("/static/images").getFile().getAbsolutePath();

	public UploadHelper() throws IOException {
		super();
	}
	
	public boolean upload(MultipartFile file)
	{
		boolean f= false;
	
		try {
			
			Path path = Paths.get(upload_dir+File.separator+file.getOriginalFilename());
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			f= true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	
		return f;
	}

}
