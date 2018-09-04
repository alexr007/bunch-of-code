package dan.javatests.normalizer.model.dto;

import java.sql.Timestamp;

public class User extends AbstractEntity {
    private String name;
    private Timestamp date;
    private String login;
    private String passwd;
    private int groupId;

    public User() {
    }

    public User(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public User(String name, String login, String passwd, int groupId) {
        this.name = name;
        this.login = login;
        this.passwd = passwd;
        this.groupId = groupId;
    }

    @Override
    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Timestamp getDate() {
        return date;
    }

    public User setDate(Timestamp date) {
        this.date = date;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPasswd() {
        return passwd;
    }

    public User setPasswd(String passwd) {
        this.passwd = passwd;
        return this;
    }

    public int getGroupId() {
        return groupId;
    }

    public User setGroupId(int groupId) {
        this.groupId = groupId;
        return this;
    }

    @Override
    public String toString() {
        return String.format("User:[id:%d, Name:%s, Login:%s, Passwd:%s, Group:%s]",id,name,login,passwd,groupId);
    }
}
