/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cs241_assignment2.knowledge_repository;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Issac
 */
public interface UserRepository extends CrudRepository<User, Long>{
    
}
