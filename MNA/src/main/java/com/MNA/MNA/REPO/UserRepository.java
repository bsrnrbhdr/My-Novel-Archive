package com.MNA.MNA.REPO;


import com.MNA.MNA.MODEL.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
//    @Query(nativeQuery = true, value = "select MIN(user_id) from user_tbl")
//    Long getMax_Id();
///**
////this part may used later for showing novels in different tables  according to their status
//    @Query(value = "SELECT l.status as status,n.novel_name as novel_name FROM usr_novel_list l INNER JOIN novel_tbl n ON l.novel_id = n.novel_id" +
//            " INNER JOIN user_tbl u ON l.user_id = u.user_id " +
//            "WHERE u.user_id = :user_id AND l.status =:status ", nativeQuery = true)
//    List<NovelStatusQueryDTO> findAllNovel(@Param("user_id") Long user_id, @Param("status") String status);
// **/
//    @Query(value = "SELECT l.status as status,n.novel_name as novel_name FROM usr_novel_list l INNER JOIN novel_tbl n ON l.novel_id = n.novel_id" +
//            " INNER JOIN user_tbl u ON l.user_id = u.user_id " +
//            "WHERE u.user_id = :user_id", nativeQuery = true)
//    List<NovelStatusQueryDTO> findAllNovel(@Param("user_id") Long user_id);
//

}
