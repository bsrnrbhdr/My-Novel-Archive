package com.MNA.MNA.DTO;

import com.MNA.MNA.MODEL.Novel;
import com.MNA.MNA.MODEL.User;

import java.io.Serializable;

public class ListDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String status;
    private Long user_id;
    private Long novel_id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(Long novel_id) {
        this.novel_id = novel_id;
    }
}
