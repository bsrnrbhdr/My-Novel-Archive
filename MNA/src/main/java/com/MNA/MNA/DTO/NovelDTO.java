package com.MNA.MNA.DTO;


import java.io.Serializable;

public class NovelDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String novel_name;
    private String author;
    private Integer year;

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
}
