package com.MNA.MNA.REPO;

import com.MNA.MNA.MODEL.Novel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelRepo extends JpaRepository<Novel, Long> {

}