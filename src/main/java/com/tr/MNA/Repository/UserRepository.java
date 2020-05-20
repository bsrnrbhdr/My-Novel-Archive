package com.tr.MNA.Repository;
import com.tr.MNA.Model.User;

import com.tr.MNA.Model.usr_novel_list;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "select MIN(user_id) from user_tbl")
    Long getMax_Id();

    @Query(value = "SELECT n.novel_name,l.status FROM usr_novel_list l INNER JOIN novel_tbl n ON l.novel_id = n.novel_id" +
            " INNER JOIN user_tbl u ON l.user_id = u.user_id " +
            "WHERE u.user_id = :user_id AND l.status =:status ",  nativeQuery = true)
    List<String> findAllNovel(@Param("user_id") Long user_id,@Param("status") String status);
}
