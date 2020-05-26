package com.MNA.MNA.MODEL;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="user_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true)
    @JsonIgnore
    private Long Id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "first_name", length = 10,nullable = false)
    private String username;

    @NotBlank(message = "password is mandatory")
    @Column(name = "password", length = 10,nullable = false)
    private String password;

    @NotBlank(message = "email is mandatory")
    @Column(name = "email", length = 20,nullable = false)
    private String email;

    @JsonIgnoreProperties
    @JsonIgnore
    @OneToMany(targetEntity = usr_novel_list.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<usr_novel_list> novel_lists;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<usr_novel_list> getNovel_lists() {
        return novel_lists;
    }

    public void setNovel_lists(List<usr_novel_list> novel_lists) {
        this.novel_lists = novel_lists;
    }
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}