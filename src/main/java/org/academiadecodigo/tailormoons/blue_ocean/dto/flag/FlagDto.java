package org.academiadecodigo.tailormoons.blue_ocean.dto.flag;

import java.util.Date;

public abstract class FlagDto {

    private Integer id;

    private Float lat;

    private Float lng;

    private String description;

    private Integer customerId;

    private String state;

    private String creationTime;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Float getLat() {
        return lat;
    }


    public void setLat(Float lat) {
        this.lat = lat;
    }


    public Float getLng() {
        return lng;
    }


    public void setLng(Float lng) {
        this.lng = lng;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getCustomerId() {
        return customerId;
    }


    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getCreationTime() {
        return creationTime;
    }


    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
