package model.bo;

import java.util.List;
import model.bean.User;
import model.dao.UserDAO;

public class UserBO {
    private UserDAO userDAO = new UserDAO();

    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(String id) {
        return userDAO.deleteUser(id);
    }
    
    public User getUserById(String id) {
        return userDAO.getUserById(id);
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public boolean checkLogin(String username, String password) {
        User u = userDAO.getUserByUsername(username);
        if (u != null && u.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    
    public boolean forgotPassword(String username, String newPassword) {
        return userDAO.forgotPassword(username, newPassword);
    }
}
