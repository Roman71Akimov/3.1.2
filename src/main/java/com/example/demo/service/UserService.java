package com.example.demo.service;



import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> showAllUsers();
    public User getUser(Long id);

    public void save(User user);

    public void delete(Long id);

    public void update(User user);
}
