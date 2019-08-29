package com.jacky.learn.shiro.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid2")
    private String id;
    private String creUserId;
    private String crtUserName;
    private String crtTime;
    private String uptUserId;
    private String uptUserName;
    private String uptTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreUserId() {
        return creUserId;
    }

    public void setCreUserId(String creUserId) {
        this.creUserId = creUserId;
    }

    public String getCrtUserName() {
        return crtUserName;
    }

    public void setCrtUserName(String crtUserName) {
        this.crtUserName = crtUserName;
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime;
    }

    public String getUptUserId() {
        return uptUserId;
    }

    public void setUptUserId(String uptUserId) {
        this.uptUserId = uptUserId;
    }

    public String getUptUserName() {
        return uptUserName;
    }

    public void setUptUserName(String uptUserName) {
        this.uptUserName = uptUserName;
    }

    public String getUptTime() {
        return uptTime;
    }

    public void setUptTime(String uptTime) {
        this.uptTime = uptTime;
    }
}
