package com.postServices.paylod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class postDto {
    private String postId;
    private  String tittle;
    private String description;
    private String content;

    List<Comment>  comments;
}
