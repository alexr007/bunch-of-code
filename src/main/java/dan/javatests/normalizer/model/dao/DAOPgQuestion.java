package dan.javatests.normalizer.model.dao;

import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.Utc;
import dan.javatests.normalizer.model.DbConn;
import dan.javatests.normalizer.model.dto.Question;
import dan.javatests.normalizer.model.outcome.OutcomeQuestion;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DAOPgQuestion implements DAO<Question> {
    private final DataSource source;

    public DAOPgQuestion(DbConn conn) {
        this.source = conn.source();
    }

    @Override
    public Question get(int pk) {
        try {
            return new JdbcSession(source)
                    .sql("SELECT * FROM question WHERE q_id = ?")
                    .set(pk)
                    .select(new OutcomeQuestion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Question();
    }

    @Override
    public Question insert(Question e) {
        try {
            return new JdbcSession(source)
                    .sql("INSERT into question (q_number, q_header, q_text) VALUES (?, ?, ?)")
                    .set(e.getNumber())
                    .set(e.getHeader())
                    .set(e.getText())
                    .insert(new OutcomeQuestion());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return new Question();
    }

    @Override
    public Question update(Question e) {
        try {
            return new JdbcSession(source)
                    .sql("UPDATE question SET q_number=?, q_header=?, q_text=?, q_date_add=? WHERE q_id = ?")
                    .set(e.getNumber())
                    .set(e.getHeader())
                    .set(e.getText())
                    .set(new Utc(e.getDate()))
                    .set(e.getId())
                    .update(new OutcomeQuestion());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return new Question();
    }

    @Override
    public void delete(int pk) {
        try {
            new JdbcSession(source)
                    .sql("DELETE FROM question WHERE q_id = ?")
                    .set(pk)
                    .execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}