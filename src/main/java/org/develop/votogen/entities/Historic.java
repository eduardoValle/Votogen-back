package org.develop.votogen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.develop.votogen.security.SystemUser;

@Entity
public class Historic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String hour;
    private String date;

    @Column(columnDefinition = "TEXT")
    private String message;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private SystemUser user;

    public Historic() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Historic(SystemUser user, String hour, String message, String date) {
        super();
        this.user = user;
        this.hour = hour;
        this.message = message;
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }
}
