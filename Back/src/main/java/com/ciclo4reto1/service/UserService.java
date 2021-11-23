package com.ciclo4reto1.service;

import com.ciclo4reto1.model.User;
import com.ciclo4reto1.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userR;
    
    public List<User> getAll(){
        return userR.getAll();
    }
    
    public Optional<User> getUser(int id){
        return userR.getUser(id);
    }
    
    public User save(User u){
        if(u.getId()==null){
            if(getEmail(u.getEmail()) == false){
                return userR.save(u);
            }else{
                return u;
            }
        }else{
            Optional<User> aux=userR.getUser(u.getId());
            if(!aux.isPresent()){
                return userR.save(u);
            }else{
                return u;
            }
        }
    }
    
    public Boolean getEmail(String email){
        Optional<User> emailUser = userR.getEmail(email);
        return emailUser.isPresent();
    }
    
    public User getVerifyUser(String email, String password) {
        Optional<User> user = userR.getVerifyUser(email, password);

        if (!user.isPresent()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return user.get();
        }
    }
}