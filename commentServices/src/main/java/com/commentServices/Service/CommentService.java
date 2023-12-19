package com.commentServices.Service;

import com.commentServices.Entity.Comment;
import com.commentServices.Repository.CommentsRepository;
import com.commentServices.paylod.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    private CommentsRepository commentsRepo;

    @Autowired
    private RestTemplate restTemplate;
    public Comment saveData(Comment comment){
        Post post = restTemplate.getForObject("http://POST-SERVICES/api/microPost/" + comment.getPostId(), Post.class);
        if (post!=null){
            comment.setCommentId(UUID.randomUUID().toString());
            comment.setPostId(comment.getPostId());
            Comment save = commentsRepo.save(comment);
            return save;
        }else {
            return null;
        }
    }



    public List<Comment> findAllCommentByPostId(String postId){
        List<Comment> byPostId = commentsRepo.findByPostId(postId);
        return byPostId;
    }

    public List<Comment> getAllData(){
        List<Comment> all = commentsRepo.findAll();
        return all;
    }

    public Comment updateCommentById(Comment comment,String commentId){
        Comment comment1 = commentsRepo.findById(commentId).get();
//        comment1.setPostId(comment.getPostId());
        comment1.setName(comment.getName());
        comment1.setBody(comment.getBody());
        comment1.setEmail(comment.getEmail());
        Comment save = commentsRepo.save(comment1);
        return save;


    }

    public Comment deleteCommentById(String commentId){
        Comment comment = commentsRepo.findById(commentId).get();
        commentsRepo.deleteById(commentId);
        return comment;
    }
}
