package org.academiadecodigo.tailormoons.blue_ocean.command;

public class FlagDto {

    private Integer id;

    private Float coordX;

    private Float coordY;

    private Integer customerId;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Float getCoordX() {
        return coordX;
    }


    public void setCoordX(Float coordX) {
        this.coordX = coordX;
    }


    public Float getCoordY() {
        return coordY;
    }


    public void setCoordY(Float coordY) {
        this.coordY = coordY;
    }


    public Integer getCustomerId() {
        return customerId;
    }


    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    @Override
    public String toString() {
        return "FlagDto{" +
                "id=" + id +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", customerId=" + customerId +
                '}';
    }

}
