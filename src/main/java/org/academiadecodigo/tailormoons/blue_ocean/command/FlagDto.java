package org.academiadecodigo.tailormoons.blue_ocean.command;

public class FlagDto {

    private Float lat;

    private Float lng;

    private Integer customerId;


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


    public Integer getCustomerId() {
        return customerId;
    }


    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    public FlagDto(Float lat, Float lng, Integer customerId) {
        this.lat = lat;
        this.lng = lng;
        this.customerId = customerId;
    }

}
