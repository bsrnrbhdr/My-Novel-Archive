package com.tr.my_novel_archive.repository;

import com.tr.my_novel_archive.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TestRepository extends JpaRepository<Test, Long> {
}
