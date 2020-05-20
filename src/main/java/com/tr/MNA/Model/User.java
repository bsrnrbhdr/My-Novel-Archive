package com.tr.MNA.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="user_tbl")
public class User {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long Id;

    @Column(name = "first_name", length = 10)
    private String username;

    @Column(name = "password", length = 10)
    private String password;
    @Column(name = "email", length = 20)
    private String email;

    @JsonIgnoreProperties
    @JsonBackReference
    @OneToMany(targetEntity = usr_novel_list.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<usr_novel_list> novel_lists;

}