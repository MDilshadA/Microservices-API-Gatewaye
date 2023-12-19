package com.postServices.Repository;

import com.postServices.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post ,String> {
}
