package com.ciclo4reto1.repository;

import com.ciclo4reto1.model.User;
import com.ciclo4reto1.repository.crud.UserRepositoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private UserRepositoryCrud UserRC;
    
    public List<User> getAll(){
        return (List<User>) UserRC.findAll();
    }
    
    public Optional<User> getUser(int Id){
        return UserRC.findById(Id);
    }
    
    public User save(User u){
        return UserRC.save(u);
    }
    
    public Optional<User> getEmail(String email){
        return UserRC.findByEmail(email);
    }
    
    public Optional<User> getVerifyUser(String email, String password){
        return UserRC.findByEmailAndPassword(email, password);
    }
}