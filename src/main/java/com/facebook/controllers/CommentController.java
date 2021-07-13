package com.facebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.entities.Comment;
import com.facebook.repository.CommentRepository;


@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {

	@Autowired
	private CommentRepository commentRepository;
	
	@PostMapping("/")
	public Comment saveComment(@RequestBody Comment comment)
	{
		return commentRepository.save(comment);
	}
}
