package com.hdu.mxd.entity;



public class UserAndPower {
    private Integer id;
    private String username;
    private String password;
    private int sId;
    private int author;
    private String power;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAndPower(Integer id, String username, String password, int sId, int author) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sId = sId;
        this.author = author;
    }

    public UserAndPower() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sId=" + sId +
                ", author=" + author +
                ", power=" + power +
                '}';
    }
}
