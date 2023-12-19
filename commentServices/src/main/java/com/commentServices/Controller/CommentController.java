package com.commentServices.Controller;

import com.commentServices.Entity.Comment;
import com.commentServices.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/microComment")
public class CommentController {
    @Autowired
    private CommentService commentService;



    //Post A Comments for a Post
    @PostMapping
    public ResponseEntity<Comment> createPost(
            @RequestBody Comment comment
    ){
        Comment comment1 = commentService.saveData(comment);
        return new ResponseEntity<>(comment1, HttpStatus.CREATED);
    }


    //Search All Comments By postId
    //http://localhost:8082/api/microComment/postId ---->Used in post for getting all comments bia postId
    @GetMapping("/{postId}")
    public ResponseEntity<List<Comment>>getPostById(
            @PathVariable String postId
    ){
        List<Comment> allCommentByPostId = commentService.findAllCommentByPostId(postId);
        return new ResponseEntity<>(allCommentByPostId,HttpStatus.OK);
    }

    //Find All Post
    @GetMapping
    public ResponseEntity<List<Comment>> getALlPost(){
        List<Comment> allData = commentService.getAllData();
        return new ResponseEntity<>(allData,HttpStatus.OK);
    }

    //Update Comments By CommentsId
    @PutMapping("/{commentId}")
    public ResponseEntity<Comment>updatePostById(
            @PathVariable String commentId,
            @RequestBody Comment comment
    ){
        Comment byCommentId = commentService.updateCommentById(comment,commentId);
        return new ResponseEntity<>(byCommentId,HttpStatus.OK);
    }

    //Delete Comments By PostId
    @DeleteMapping("/{postId}")
    public ResponseEntity<Comment> deleteById(
            @PathVariable String postId
    ){

        Comment comment = commentService.deleteCommentById(postId);
        return new ResponseEntity<>(comment,HttpStatus.OK);
    }
}
