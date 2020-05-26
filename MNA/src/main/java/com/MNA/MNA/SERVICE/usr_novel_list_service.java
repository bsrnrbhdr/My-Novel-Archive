package com.MNA.MNA.SERVICE;
import com.MNA.MNA.DTO.ListDTO;
import com.MNA.MNA.MODEL.Novel;
import com.MNA.MNA.MODEL.User;
import com.MNA.MNA.MODEL.usr_novel_list;
import com.MNA.MNA.REPO.NovelRepo;
import com.MNA.MNA.REPO.UserRepository;
import com.MNA.MNA.REPO.usr_novel_list_Repo;
import lombok.AllArgsConstructor;
import org.hibernate.QueryException;
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
    private usr_novel_list_Repo usr_novel_listRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NovelRepo novelRepo;

    public List<usr_novel_list> findAll(){
        return usr_novel_listRepository.findAll();
    }

//    public usr_novel_list SaveToList(ListDTO request) {
//        usr_novel_list usr_novel_listModel = new usr_novel_list();
//        User user =  userRepository.getOne(request.getUser_id());
//        Novel novel = novelRepo.getOne(request.getNovel_id());
//        usr_novel_listModel.setUser_id(user);
//        usr_novel_listModel.setNovel_id(novel);
//        usr_novel_listModel.setStatus(request.getStatus());
//        return usr_novel_listRepository.save(usr_novel_listModel);
//    }

    public usr_novel_list saveToNovelList(Long id, ListDTO list) {
        usr_novel_list usr_novel_listModel = new usr_novel_list();
        User user =  userRepository.getOne(id);
        Novel novel = novelRepo.getOne(list.getNovel_id());
        usr_novel_listModel.setUser_id(user);
        usr_novel_listModel.setNovel_id(novel);
        usr_novel_listModel.setStatus(list.getStatus());
        return usr_novel_listRepository.save(usr_novel_listModel);
    }

    public List<usr_novel_list> findAllByUserId(Long id) {
        try {
            return usr_novel_listRepository.findByUserId(id);
        } catch (QueryException e) {
            throw new QueryException(e.getMessage());
        }
    }
    public usr_novel_list findById(Long id) {
        return usr_novel_listRepository.getOne(id);
    }
    public void deleteById(Long id) {
        usr_novel_listRepository.deleteById(id);
    }

//    public usr_novel_list updateUNL(Long id, ListDTO request) {
//        usr_novel_list updatedDeveloper = Optional.ofNullable(usr_novel_listRepository.findOne(id)).map(unl -> {
//            unl.setStatus(request.getStatus());
//            return unl;
//        }).get();
//        return  usr_novel_listRepository.save(updatedDeveloper);
//    }

}