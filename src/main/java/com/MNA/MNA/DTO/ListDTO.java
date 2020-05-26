package com.MNA.MNA.DTO;

import java.io.Serializable;

public class ListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String status;

    private Long novel_id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(Long novel_id) {
        this.novel_id = novel_id;
    }
}
