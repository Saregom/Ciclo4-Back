package com.ciclo4reto1.repository.crud;

import com.ciclo4reto1.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryCrud extends CrudRepository<User, Integer>{
    
    public Optional<User> findByEmail(String email);
    
    public Optional<User> findByEmailAndPassword(String email, String password);
}
