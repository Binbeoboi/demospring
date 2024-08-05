package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    private List<User> users = new ArrayList<>(Arrays.asList(new User(1, "Hoang"), new User(2, "An")));

    @PostMapping("/user")
    public User create(@RequestBody User user){
        users.add(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getAll(){
        return users;
    }

    @DeleteMapping("/user")
    public void delete(@RequestParam(name="id") int id){
        users.remove(users.stream().filter(n -> n.getId() == id).findFirst().get());
    }

    @PutMapping("/user")
    public void update(@RequestBody User user){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getId() == user.getId()){
                users.set(i, user);
                break;
            }
        }
    }
}
