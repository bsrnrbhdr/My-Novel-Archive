package com.MNA.MNA.REPO;

import com.MNA.MNA.MODEL.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "select MIN(user_id) from user_tbl")
    Long getMax_Id();

    @Query(value = "SELECT n.novel_name,l.status FROM usr_novel_list l INNER JOIN novel_tbl n ON l.novel_id = n.novel_id" +
            " INNER JOIN user_tbl u ON l.user_id = u.user_id " +
            "WHERE u.user_id = :user_id AND l.status =:status ",  nativeQuery = true)
    List<String> findAllNovel(@Param("user_id") Long user_id, @Param("status") String status);

    @Query(value = "SELECT n.novel_name,l.status FROM usr_novel_list l INNER JOIN novel_tbl n ON l.novel_id = n.novel_id" +
            " INNER JOIN user_tbl u ON l.user_id = u.user_id " +
            "WHERE u.user_id = :user_id AND l.status = reading ",  nativeQuery = true)
    List<String> findAllCurrentlyReading(@Param("user_id") Long user_id);

    @Query(value = "SELECT n.novel_name,l.status FROM usr_novel_list l INNER JOIN novel_tbl n ON l.novel_id = n.novel_id" +
            " INNER JOIN user_tbl u ON l.user_id = u.user_id " +
            "WHERE u.user_id = :user_id AND l.status = read ",  nativeQuery = true)
    List<String> findAllRead(@Param("user_id") Long user_id);

    @Query(value = "SELECT n.novel_name,l.status FROM usr_novel_list l INNER JOIN novel_tbl n ON l.novel_id = n.novel_id" +
            " INNER JOIN user_tbl u ON l.user_id = u.user_id " +
            "WHERE u.user_id = :user_id AND l.status = dropped  ",  nativeQuery = true)
    List<String> findAllDropped(@Param("user_id") Long user_id);

    ////////////////////////////////////////////////////
    @Query(value = "SELECT count(*) FROM usr_novel_list l INNER JOIN novel_tbl n ON l.novel_id = n.novel_id" +
            " INNER JOIN user_tbl u ON l.user_id = u.user_id " +
            "WHERE u.user_id = :user_id ",  nativeQuery = true)
    Integer NovelCount(@Param("user_id") Long user_id);

    @Query(value = "SELECT count(*) FROM usr_novel_list l INNER JOIN novel_tbl n ON l.novel_id = n.novel_id" +
            " INNER JOIN user_tbl u ON l.user_id = u.user_id " +
            "WHERE u.user_id = :user_id AND l.status = reading ",  nativeQuery = true)
    Integer CountCurrentlyReading(@Param("user_id") Long user_id);

    @Query(value = "SELECT count(*) FROM usr_novel_list l INNER JOIN novel_tbl n ON l.novel_id = n.novel_id" +
            " INNER JOIN user_tbl u ON l.user_id = u.user_id " +
            "WHERE u.user_id = :user_id AND l.status = read ",  nativeQuery = true)
    Integer CountRead(@Param("user_id") Long user_id);

    @Query(value = "SELECT count(*) FROM usr_novel_list l INNER JOIN novel_tbl n ON l.novel_id = n.novel_id" +
            " INNER JOIN user_tbl u ON l.user_id = u.user_id " +
            "WHERE u.user_id = :user_id AND l.status = dropped  ",  nativeQuery = true)
    Integer CountDropped(@Param("user_id") Long user_id);
}
