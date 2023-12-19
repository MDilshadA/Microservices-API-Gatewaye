package com.postServices.Controller;

import com.postServices.Entity.Post;
import com.postServices.Services.PostServices;
import com.postServices.paylod.postDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/microPost")
public class PostController {
    @Autowired
    private PostServices postServices;

    //http:localhost:8081/api/microPost
    @PostMapping
    public ResponseEntity<Post> createPost(
            @RequestBody Post post
    ){
        Post post1 = postServices.saveData(post);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);
    }
    //http:localhost:8081/api/microPost/{postId}
    @GetMapping("/{postId}")
    public ResponseEntity<Post>getPostById(
            @PathVariable String postId
    ){
        Post byPostId = postServices.findByPostId(postId);
        return new ResponseEntity<>(byPostId,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getALlPost(){
        List<Post> allData = postServices.getAllData();
        return new ResponseEntity<>(allData,HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post>updatePostById(
            @PathVariable String postId,
            @RequestBody Post post
    ){
        Post byPostId = postServices.updatePostById(post,postId);
        return new ResponseEntity<>(byPostId,HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Post> deleteById(
            @PathVariable String postId
    ){

        Post post = postServices.deletePostById(postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
//  http://localhost:8081/api/microPost/{postId}/comments
    @GetMapping("/{postId}/comments")
    public ResponseEntity<postDto> getPostWithComments(
            @PathVariable String postId
    ){
        postDto dto=postServices.getPostWithCommets(postId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
