package com.tr.MNA.Repository;


import com.tr.MNA.Model.User;
import com.tr.MNA.Model.usr_novel_list;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface usr_novel_list_Repo extends JpaRepository<usr_novel_list, Long> {
//    @Query("select l from usr_novel_list l where l.user_id = :#{#user.Id}")
//    List<usr_novel_list> find_usr_novel_listBy_user_id(@Param("user") User user);
}