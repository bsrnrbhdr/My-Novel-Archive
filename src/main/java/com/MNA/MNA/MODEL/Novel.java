package com.MNA.MNA.MODEL;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name="novel_tbl")
public class Novel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "novel_id", unique = true)
    private Long Id;

    @JsonIgnoreProperties
    @JsonIgnore
    @OneToMany(targetEntity = usr_novel_list.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "novel_id", referencedColumnName = "novel_id")
    private List<usr_novel_list> novel_lists;

    @Column(name = "novel_name", length = 10)
    private String novel_name;

    @Column(name = "author", length = 10)
    private String author;

    @Column(name = "year", length = 4)
    private Integer year;

    public List<usr_novel_list> getNovel_lists() {
        return novel_lists;
    }

    public void setNovel_lists(List<usr_novel_list> novel_lists) {
        this.novel_lists = novel_lists;
    }

    public String getNovel_name() {
        return novel_name;
    }

    public void setNovel_name(String novel_name) {
        this.novel_name = novel_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}