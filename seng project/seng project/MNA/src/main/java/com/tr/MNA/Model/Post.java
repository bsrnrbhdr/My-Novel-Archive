package com.tr.MNA.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long Id;

    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "content", length = 500)
    private String content;
}