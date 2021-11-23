package com.ciclo4reto1.web;

import com.ciclo4reto1.model.User;
import com.ciclo4reto1.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class UserController
 * @author Santiago Reyes
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    /**
     * Atributo userS
     */
    @Autowired
    private UserService userS;
    
    /**
     * @return userS.getAll();
     */
    @GetMapping("/all")
    public List<User> getUsers(){
        return userS.getAll();
    }
   
    /**
     * @param user
     * @return userS.save(user);
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userS.save(user);
    }
    
    /**
     * @param email
     * @return userS.getEmail(email);
     */
    @GetMapping("/{email}")
    public boolean getEmail(@PathVariable("email") String email){
        return userS.getEmail(email);
    }
    
    /**
     * @param email
     * @param password
     * @return userS.getVerifyUser(email, password);
     */
    @GetMapping("/{email}/{password}")
    public User getVerifyUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userS.getVerifyUser(email, password);
    }
}