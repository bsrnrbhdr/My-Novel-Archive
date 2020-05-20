package com.tr.MNA.Service;
import com.tr.MNA.Model.User;
import com.tr.MNA.Model.usr_novel_list;
import com.tr.MNA.Repository.usr_novel_list_Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class usr_novel_list_service {

    @Autowired
    private usr_novel_list_Repo novel_listRepository;

    public Iterable<usr_novel_list> findAll() {
        return novel_listRepository.findAll();
    }

    public Optional<usr_novel_list> findById(Long id) {
        return novel_listRepository.findById(id);
    }

    public usr_novel_list save(usr_novel_list novel) {
        return novel_listRepository.save(novel);
    }

    public void deleteById(Long id) {
        novel_listRepository.deleteById(id);
    }
//    public List<usr_novel_list> getUserEntry(User usr_id){return novel_listRepository.find_usr_novel_listBy_user_id(usr_id);}
}