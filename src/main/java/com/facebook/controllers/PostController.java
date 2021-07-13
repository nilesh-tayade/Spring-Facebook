package com.facebook.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.facebook.entities.Post;
import com.facebook.entities.User;
import com.facebook.repository.PostRepository;
import com.facebook.repository.UserRepository;



@RestController
@CrossOrigin("*")
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public List<Post> getAllPost()
	{
		return postRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Post getPost(@PathVariable("id") int id )
	{
		return postRepository.findById(id).get();
	}

	@PostMapping("/")
	public Post savePost(@RequestBody Post post )
	{
		return postRepository.save(post);
	}
	
	@PutMapping("/{id}")
	public Post updatePost(@RequestBody Post post,@PathVariable("id") int id  )
	{
		post.setId(id);
		return postRepository.save(post);
	}
	 
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable("id") int id )
	{
		 postRepository.deleteById(id);
	}
	
	@GetMapping("/user/{id}")
	public List<Post> getAllPostByUser(@PathVariable("id") int id)
	{
		User user =userRepository.findById(id).get();
		return postRepository.findByUser(user);
	}
	 
	
}
