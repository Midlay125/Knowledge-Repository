/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs241_assignment2.knowledge_repository;

import jakarta.persistence.*;
import java.util.List;

/**
 *
 * @author Issac
 */
@Entity
public class Forum {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forum_id;
    
    private String name;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Thread> threads;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List threads) {
        this.threads = threads;
    }
    
    
}
