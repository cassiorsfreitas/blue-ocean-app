package org.academiadecodigo.tailormoons.blue_ocean.dto;

public class CustomerDto {

    private Integer id;

    private String username;

    private String email;

    private String city;

    private Integer score;


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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public Integer getScore() {
        return score;
    }


    public void setScore(Integer score) {
        this.score = score;
    }

}
