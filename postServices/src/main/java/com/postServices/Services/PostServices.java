package com.postServices.Services;

import com.postServices.Entity.Post;
import com.postServices.Repository.PostRepository;
import com.postServices.paylod.postDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServices {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PostRepository postRepo;
    public Post saveData(Post post){
        post.setId(UUID.randomUUID().toString());
        Post save = postRepo.save(post);
        return save;
    }

    public Post findByPostId(String postId){
        Post post = postRepo.findById(postId).get();
        return post;
    }

    public List<Post> getAllData(){
        List<Post> all = postRepo.findAll();
        return all;
    }

    public Post updatePostById(Post post,String postId){
        Post post1 = postRepo.findById(postId).get();
        post1.setTittle(post.getTittle());
        post1.setContent(post.getContent());
        post1.setDescription(post.getDescription());

        Post save = postRepo.save(post1);
        return save;


    }

    public Post deletePostById(String postId){
        Post post = postRepo.findById(postId).get();
        postRepo.deleteById(postId);
        return post;
    }

    public postDto getPostWithCommets(String postId) {
        Post post = postRepo.findById(postId).get();
        ArrayList comments = restTemplate.getForObject("http://COMMENTS-SERVICES/api/microComment/"+postId, ArrayList.class);
        //http://COMMENTS-SERVICES/api/microComment/"+postId---->Search Comments By PostId bia getForObject()
        //here in getForObject(URL,ArrayList-><because we want to get all comments as Array>)

        postDto dto=new postDto();
        dto.setPostId(post.getId());
        dto.setTittle(post.getTittle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());
        dto.setComments(comments);
        return dto;
    }
}
