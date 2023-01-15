package com.example.demo.service;


import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{

   // private UserDAO userDAO = new UserDAOImpl();
    private final UserDAO userDAO;
@Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> showAllUsers() {
        return userDAO.showAllUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void save(User user) {
    userDAO.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
    userDAO.delete(id);
    }

    @Override
    @Transactional
    public void update(User user) {
    userDAO.update(user);
    }


}
