package ua.danit.model;

import ua.danit.utils.IdGenerator;

public class Liked {
    private Integer id;
    private String whoLiked;
    private String whomLiked;

    public Liked() {
        IdGenerator idGenerator = new IdGenerator();
        this.id = idGenerator.makeId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhoLiked() {
        return whoLiked;
    }

    public void setWhoLiked(String whoLiked) {
        this.whoLiked = whoLiked;
    }

    public String getWhomLiked() {
        return whomLiked;
    }

    public void setWhomLiked(String whomLiked) {
        this.whomLiked = whomLiked;
    }
}
