package com.MNA.MNA.REPO;


import com.MNA.MNA.MODEL.usr_novel_list;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface usr_novel_list_Repo extends JpaRepository<usr_novel_list, Long> {
//    @Query("select l from usr_novel_list l where l.user_id = :#{#user.Id}")
//    List<usr_novel_list> find_usr_novel_listBy_user_id(@Param("user") User user);


}