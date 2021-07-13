package com.facebook.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.facebook.entities.LoginRequest;
import com.facebook.entities.User;
import com.facebook.services.UserService;
import com.facebook.utility.UploadHelper;

@CrossOrigin("*")
@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UploadHelper uploadHelper;
	
	@GetMapping("/")
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int id)
	{
		return userService.getById(id);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody LoginRequest loginRequest)
	{
		return userService.login(loginRequest);
	}
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user)
	{
		
		System.out.println(user);
		return userService.saveUser(user);
	}
	

	@PutMapping("/{id}")
	public User saveUser(@RequestBody User user,@PathVariable("id") int id)
	{
		user.setId(id);
		return userService.saveUser(user);
	}
	

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id)
	{
		 userService.deleteUser(id);
	}
	
	
	@PostMapping("/uploadProfile/{id}")
	public void uplaodProfile(@RequestParam("imageFile") MultipartFile file,@PathVariable("id") int id) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		System.out.println("Reached To upload ");
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		
		if(file.isEmpty())
		{
				System.out.println("Select File");
		}
		
	boolean status=	uploadHelper.upload(file);
	
	if(status)
	{
		System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());

		String imgUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString();
		User user = userService.getById(id);

		user.setProfileUrl(imgUrl);
		userService.saveUser(user);
		System.out.println(" profile Image url saved");
	}
	
	}

	@PostMapping("/uploadCover/{id}")
	public void uplaodCover(@RequestParam("imageFile") MultipartFile file,@PathVariable("id") int id) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		System.out.println("Reached To upload ");
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		
		if(file.isEmpty())
		{
				System.out.println("Select File");
		}
		
	boolean status=	uploadHelper.upload(file);
	
	if(status)
	{
		System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());

		String imgUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString();
		User user = userService.getById(id);

		user.setCoverUrl(imgUrl);
		userService.saveUser(user);
		System.out.println("cover Image url saved");
	}
	
	}

	@PostMapping("/uploadPhotos/{id}")
	public void uplaodPhotos(@RequestParam("imageFile") MultipartFile file,@PathVariable("id") int id) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		System.out.println("Reached To upload ");
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		
		if(file.isEmpty())
		{
				System.out.println("Select File");
		}
		
	boolean status=	uploadHelper.upload(file);
	
	if(status)
	{
		System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());

		String imgUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString();
		User user = userService.getById(id);
			user.getPhotos().add(imgUrl);
		userService.saveUser(user);
		System.out.println("photos added to list url saved");
	}
	
	}

	
}
