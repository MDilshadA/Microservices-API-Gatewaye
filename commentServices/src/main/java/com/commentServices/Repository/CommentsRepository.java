package com.commentServices.Repository;

import com.commentServices.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment,String> {
    List<Comment> findByPostId(String postId);
}
