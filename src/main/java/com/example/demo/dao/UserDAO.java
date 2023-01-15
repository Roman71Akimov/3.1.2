package com.example.demo.dao;



import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDAO {
    public List <User> showAllUsers();
    public User getUser(Long id);

    public void save(User user);

    public void delete(Long id);

    public void update(User user);



}
