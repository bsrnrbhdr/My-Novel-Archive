package com.tr.MNA.Repository;
import com.tr.MNA.Model.Novel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelRepo extends CrudRepository<Novel, Long> {

}