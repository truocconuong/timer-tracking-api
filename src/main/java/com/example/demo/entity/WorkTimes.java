package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "work_times")
public class WorkTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(insertable = false, updatable = false)
    private int userId;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "userId")
    private User user;
    @Column(name = "checkin")
    private Timestamp checkin;
    @Column(name = "checkout")
    private Timestamp checkout;

    @Column(name = "urls")
    private String urls;

    public WorkTimes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        userId = user.getId();
    }
    public Timestamp getCheckin() {
        return checkin;
    }

    public void setCheckin(Timestamp checkin) {
        this.checkin = checkin;
    }

    public Timestamp getCheckout() {
        return checkout;
    }

    public void setCheckout(Timestamp checkout) {
        this.checkout = checkout;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public WorkTimes(int id, User user, Timestamp checkin, Timestamp checkout, String urls) {
        this.id = id;
        this.user = user;
        this.checkin = checkin;
        this.checkout = checkout;
        this.urls = urls;
    }
}
