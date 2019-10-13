package ua.danit.dao;

import ua.danit.model.Messege;
import ua.danit.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MessegeDAO {
    public void save (Messege messege) {

        String sql = "INSERT INTO messeges(id, who_messege, whom_messege, time, text) VALUES(?,?,?,?,?)";

        try (Connection connection = ConnectionToDataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
        {
            statement.setInt(1, messege.getId());
            statement.setString(2, messege.getWhoMessege());
            statement.setString(3, messege.getWhomMessege());
            statement.setLong(4, messege.getTime());
            statement.setString(5, messege.getText());

            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public List<Messege> get(String whoMessege, String whomMessege) {
        List<Messege> list = new ArrayList<>();
        String sql = "SELECT * FROM public.messeges WHERE who_messege='" + whoMessege + "' AND whom_messege='" + whomMessege+"'";

        try (
                Connection  connection  = ConnectionToDataBase.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
        )
        {

            while ( rSet.next() )
            {
                Messege messege = new Messege();

                messege.setId(rSet.getInt("id"));
                messege.setWhoMessege(rSet.getString("who_messege"));
                messege.setWhomMessege(rSet.getString("whom_messege"));
                messege.setTime(rSet.getLong("time"));
                messege.setText(rSet.getString("text"));

                list.add(messege);
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return list;

    }


}
