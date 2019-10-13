package ua.danit.model;

import ua.danit.utils.IdGenerator;

public class Messege {
    private Integer id;
    private String whoMessege;
    private String whomMessege;
    private Long time;
    private String text;

    public Messege() {
        IdGenerator idGenerator = new IdGenerator();
        this.id = idGenerator.makeId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhoMessege() {
        return whoMessege;
    }

    public void setWhoMessege(String whoMessege) {
        this.whoMessege = whoMessege;
    }

    public String getWhomMessege() {
        return whomMessege;
    }

    public void setWhomMessege(String whomMessege) {
        this.whomMessege = whomMessege;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
