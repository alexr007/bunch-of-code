package ua.danit.utils;

import ua.danit.dao.UserDAO;
import ua.danit.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    List<String> list;

    public UserList(List<String> list) {
        this.list = list;
    }

    public List<User> userList () {
        UserDAO userDAO = new UserDAO();
        List<User> userList = new ArrayList<>();

        for (String girl : list) {
            User user = userDAO.get(girl);
            userList.add(user);
        }

        return userList;
    }

}
