package com.blog.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Date;


@Entity
public class TemporaryArticle {

    @Id
    @GeneratedValue
    private Long id ;

    private String title;

    @Column(columnDefinition = "longtext")//声明大文本类型
    private String content;

    @Temporal(TemporalType.TIMESTAMP) //声明longtext类型
    private Date saveTime;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)//
    @JoinColumn(name = "user_id")
    private User user;


    public TemporaryArticle() {
    }


    public TemporaryArticle(String title, String content, Date saveTime) {
        this.title = title;
        this.content = content;
        this.saveTime = saveTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }


}
