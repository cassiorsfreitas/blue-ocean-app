package org.academiadecodigo.tailormoons.blue_ocean.persistence.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractModel implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id; //user_id

    @Version
    private Integer version;

    @CreationTimestamp
    private Date creationTime;

    @UpdateTimestamp
    private Date updateTime;


    @Override
    public Integer getId() {
        return id;
    }


    @Override
    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }


    public Date getCreationTime() {
        return creationTime;
    }


    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
