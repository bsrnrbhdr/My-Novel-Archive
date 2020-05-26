package com.MNA.MNA.REPO;


import com.MNA.MNA.MODEL.usr_novel_list;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface usr_novel_list_Repo extends JpaRepository<usr_novel_list, Long> {

    @Query(value = "SELECT * FROM usr_novel_list l WHERE l.user_id= :user_id", nativeQuery = true)
    List<usr_novel_list> findByUserId(@Param("user_id")Long user_id);

}