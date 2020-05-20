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
@Table(name="novel_tbl")
public class Novel {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "novel_id", unique = true, nullable = false)
    private Long Id;

    @JsonIgnoreProperties
    @JsonBackReference
    @OneToMany(targetEntity = usr_novel_list.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "novel_id", referencedColumnName = "novel_id")
    private List<usr_novel_list> novel_lists;

    @Column(name = "novel_name", length = 10)
    private String novel_nam;

    @Column(name = "author", length = 10)
    private String author;

    @Column(name = "year", length = 4)
    private Integer year;

}