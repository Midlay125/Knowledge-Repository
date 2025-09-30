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
public class ThreadService {
    private final ThreadRepository threadRepo;

    public ThreadService(ThreadRepository threadRepo) {
        this.threadRepo = threadRepo;
    }

    public List<Thread> getAllThreads() {
        return threadRepo.findAll();
    }

    public Thread getThread(Long id) {
        return threadRepo.findById(id).orElseThrow();
    }

    public Thread saveThread(Thread thread) {
        return threadRepo.save(thread);
    }
}