package ua.danit.dao;

import ua.danit.model.Liked;
import ua.danit.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LikedDAO {
    public void save (Liked liked) {
        String sql = "INSERT INTO liked(id, who_liked, whom_liked) VALUES(?,?,?)";

        try (Connection connection = ConnectionToDataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
        {
            statement.setInt(1, liked.getId());
            statement.setString(2, liked.getWhoLiked());
            statement.setString(3, liked.getWhomLiked());
            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public static List<String> getListOfLikedUsers(String login) {

        List<String> likedUsers = new ArrayList<>();

        String sql = "SELECT whom_liked FROM liked WHERE who_liked='" + login + "'";

        try (
                Connection  connection  = ConnectionToDataBase.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
        )
        {
            while ( rSet.next() )
            {
                likedUsers.add(rSet.getString("whom_liked"));

            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return likedUsers;
    }

}
