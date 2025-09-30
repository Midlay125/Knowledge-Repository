/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs241_assignment2.knowledge_repository;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Issac
 */

@Controller
public class AppController {
    
    private final ForumService categoryService;
    private final ThreadService threadService;
    private final PostService postService;
    
   public AppController(ForumCategoryService categoryService,
                           ThreadService threadService,
                           PostService postService) {
        this.categoryService = categoryService;
        this.threadService = threadService;
        this.postService = postService;
    }

    @GetMapping("/")
    public String forumHome(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("threads", threadService.getAllThreads());
        return "forum";
    }

    @GetMapping("/thread/{id}")
    public String viewThread(@PathVariable Long id, Model model) {
        Thread thread = threadService.getThread(id);
        model.addAttribute("thread", thread);
        model.addAttribute("posts", thread.getPosts());
        model.addAttribute("newPost", new Post());
        return "thread";
    }

    @GetMapping("/new-thread")
    public String newThreadForm(Model model) {
        model.addAttribute("thread", new Thread());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "new-thread";
    }

    @PostMapping("/new-thread")
    public String createThread(@ModelAttribute ThreadEntity thread) {
        threadService.saveThread(thread);
        return "redirect:/";
    }

    @PostMapping("/thread/{id}/reply")
    public String replyToThread(@PathVariable Long id, @ModelAttribute Post post) {
        Thread thread = threadService.getThread(id);
        post.setThread(thread);
        postService.savePost(post);
        return "redirect:/thread/" + id;
    }
}