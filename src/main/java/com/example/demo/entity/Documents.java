package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "documents")
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(insertable = false, updatable = false)
    private int userId;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "url")
    private String url;

    @Column(name = "created_at")
    private Timestamp checkin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getCheckin() {
        return checkin;
    }

    public void setCheckin(Timestamp checkin) {
        this.checkin = checkin;
    }

    public Documents(int id, int userId, User user, String url, Timestamp checkin) {
        this.id = id;
        this.userId = userId;
        this.user = user;
        this.url = url;
        this.checkin = checkin;
    }
    public Documents() {

    }
}
