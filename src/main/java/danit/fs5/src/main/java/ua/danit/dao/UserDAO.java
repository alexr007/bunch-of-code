package ua.danit.dao;

import ua.danit.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {

    public void save (User user) {
        String sql = "INSERT INTO user(login, name, photoURL, password, sex) VALUES(?,?,?,?)";

        try (Connection connection = ConnectionToDataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
        {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPhotoURL());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getSex());

            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public static Map<Integer, User> getListOfUsers(String sex) {

        Map<Integer, User> girlsMap = new HashMap<>();
        int count = 0;

        String sql = "SELECT * FROM public.user WHERE sex='" + sex + "'";

        try (
                Connection  connection  = ConnectionToDataBase.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
        )
        {
            while ( rSet.next() )
            {
                User user = new User();

                user.setLogin(rSet.getString("login"));
                user.setName(rSet.getString("name"));
                user.setPhotoURL(rSet.getString("photoURL"));
                user.setPassword(rSet.getString("password"));
                user.setSex(rSet.getString("sex"));

                girlsMap.put(count, user);
                count++;
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return girlsMap;
    }

    public User get(String str) {
        User user = new User();

        String sql = "SELECT * FROM public.user WHERE login='" + str + "'";

        try (
                Connection  connection  = ConnectionToDataBase.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
        )
        {

            while ( rSet.next() )
            {
                user.setLogin(rSet.getString("login"));
                user.setName(rSet.getString("name"));
                user.setPhotoURL(rSet.getString("photoURL"));
                user.setPassword(rSet.getString("password"));
                user.setSex(rSet.getString("sex"));

                return user;
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return null;
    }
}
