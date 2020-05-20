package com.tr.MNA.Repository;
import com.tr.MNA.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "select MIN(user_id) from user_tbl")
    Long getMax_Id();
}
