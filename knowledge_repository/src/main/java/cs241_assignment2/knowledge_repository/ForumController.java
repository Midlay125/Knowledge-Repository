/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs241_assignment2.knowledge_repository;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Issac
 */

@Controller
@RequestMapping("/forum")
public class ForumController {

    private final ThreadService threadService;
    private final PostService postService;

    public ForumController(ThreadService threadService, PostService postService) {
        this.threadService = threadService;
        this.postService = postService;
    }

    @GetMapping
    public String forumPage(Model model) {
        model.addAttribute("threads", threadService.listAll());
        return "forum"; // list of threads
    }

    @GetMapping("/{thread_id}")
    public String viewThread(@PathVariable("thread_id") Long id, Model model) {
        ForumThread thread = threadService.get(id);
        model.addAttribute("thread", thread);
        model.addAttribute("posts", thread.getPosts());
        model.addAttribute("newPost", new Post());
        return "thread"; // thread details + posts
    }

    @GetMapping("/new_thread")
    public String newThreadForm(Model model, Principal principal) {
        ForumThread thread = new ForumThread();
        thread.setAuthor(principal.getName());
        model.addAttribute("thread", thread);
        return "new_thread";
    }

    @PostMapping("/new_thread")
    public String createThread(@ModelAttribute ForumThread thread, Principal principal) {
        thread.setAuthor(principal.getName());
        threadService.save(thread);
        return "redirect:/forum";
    }

    @PostMapping("/{thread_id}/reply")
    public String replyToThread(@PathVariable("thread_id") Long id, @ModelAttribute Post post, Principal principal) {
        ForumThread thread = threadService.get(id);
        post.setAuthor(principal.getName());
        post.setThread(thread);
        postService.savePost(post);
        return "redirect:/forum/" + id;
    }
    
    @PostMapping("/{thread_id}/delete")
    public String deleteThread(@PathVariable(name = "thread_id") Long id, Principal principal) {
        ForumThread thread = threadService.get(id);
        threadService.delete(id);
        return "redirect:/forum";
    }
}