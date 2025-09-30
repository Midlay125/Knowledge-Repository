/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs241_assignment2.knowledge_repository;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Issac
 */
@Service
public class PostService {
    private final PostRepository postRepo;

    public PostService(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> getPostsByThread(Thread thread) {
        return thread.getPosts();
    }

    public Post savePost(Post post) {
        return postRepo.save(post);
    }
}