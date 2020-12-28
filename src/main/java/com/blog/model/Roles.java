package com.blog.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Roles {


    @Id
    @GeneratedValue
    private Long id;


    private String name;
    private String mark;

    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "role_user",joinColumns = {@JoinColumn(name = "role_id")}
            ,inverseJoinColumns ={@JoinColumn(name = "user_id")})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> users = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
