package space.android3.lesson3.data.model;

import com.google.gson.annotations.SerializedName;

public class FilmModel {

    @SerializedName("id")
    private int filmId;

    @SerializedName("title")
    private String title;

    @SerializedName("user")
    private Integer user;

    @SerializedName("group")
    private Integer group;

    @SerializedName("content")
    private String content;

    public FilmModel(int filmId, String title, Integer user, Integer group, String content) {
        this.filmId = filmId;
        this.title = title;
        this.user = user;
        this.group = group;
        this.content = content;
    }

    public FilmModel(String toString, String toString1, int parseInt, String toString2) {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FilmModel(String toString, String title, Integer user, Integer group) {
        this.title = title;
        this.user = user;
        this.group = group;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }
}
