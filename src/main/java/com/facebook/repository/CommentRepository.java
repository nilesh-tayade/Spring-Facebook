package com.facebook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facebook.entities.Comment;



@Repository
public interface  CommentRepository extends JpaRepository<Comment,Integer> {

}
