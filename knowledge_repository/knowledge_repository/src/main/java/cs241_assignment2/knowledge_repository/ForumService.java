/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs241_assignment2.knowledge_repository;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Issac
 */
@Service
@Transactional
public class ForumService {
     private final ForumRepository categoryRepo;

    public ForumService(ForumRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Forum> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Forum getCategory(Long id) {
        return categoryRepo.findById(id).orElseThrow();
    }

    public Forum saveCategory(Forum category) {
        return categoryRepo.save(category);
    }
}