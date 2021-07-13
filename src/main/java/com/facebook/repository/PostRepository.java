package com.facebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facebook.entities.Post;
import com.facebook.entities.User;



@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
	public List<Post> findByUser(User user);

}
