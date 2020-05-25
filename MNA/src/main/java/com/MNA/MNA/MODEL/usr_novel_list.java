package com.MNA.MNA.MODEL;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="usr_novel_list")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class usr_novel_list {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "novel_list_id", unique = true)
    private Long Id;

    @Column(name = "status", length = 10)
    private String status;

    @JsonIgnoreProperties
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    @JsonIgnoreProperties
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "novel_id", nullable = false)
    private Novel novel_id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Novel getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(Novel novel_id) {
        this.novel_id = novel_id;
    }
}