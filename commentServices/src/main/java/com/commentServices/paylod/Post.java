package com.commentServices.paylod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String postId;
    private String tittle;
    private String content;
    private String description;
}
