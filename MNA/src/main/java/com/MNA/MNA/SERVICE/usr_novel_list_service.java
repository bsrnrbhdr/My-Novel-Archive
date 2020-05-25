package com.MNA.MNA.SERVICE;
import com.MNA.MNA.DTO.ListDTO;
import com.MNA.MNA.MODEL.Novel;
import com.MNA.MNA.MODEL.User;
import com.MNA.MNA.MODEL.usr_novel_list;
import com.MNA.MNA.REPO.NovelRepo;
import com.MNA.MNA.REPO.UserRepository;
import com.MNA.MNA.REPO.usr_novel_list_Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


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

    public usr_novel_list SaveToList(ListDTO request) {
        usr_novel_list usr_novel_listModel = new usr_novel_list();
        User user =  userRepository.getOne(request.getUser_id());
        Novel novel = novelRepo.getOne(request.getNovel_id());
        usr_novel_listModel.setUser_id(user);
        usr_novel_listModel.setNovel_id(novel);
        usr_novel_listModel.setStatus(request.getStatus());
        return usr_novel_listRepository.save(usr_novel_listModel);
    }

//    public DeveloperModel findById(Long id) {
//        return developerRepository.findOne(id);
//    }
//
//    public DeveloperModel updateDeveloper(Long id, DeveloperRequest request) {
//        DeveloperModel updatedDeveloper = Optional.ofNullable(developerRepository.findOne(id)).map(developer -> {
//            developer.setName(request.getName());
//            developer.setSurname(request.getSurname());
//            return developer;
//        }).get();
//        return  developerRepository.save(updatedDeveloper);
//    }
//
//    public void deleteDeveloper(Long id) {
//        developerRepository.delete(id);
//    }
//
//
//    public usr_novel_list findById(Long id) {
//        return novel_listRepository.getOne(id);
//    }
//
//    public usr_novel_list save(usr_novel_list novel) {
//        return novel_listRepository.save(novel);
//    }
//
//    public void deleteById(Long id) {
//        novel_listRepository.deleteById(id);
//    }

//    public List<usr_novel_list> getUserEntry(User usr_id){return novel_listRepository.find_usr_novel_listBy_user_id(usr_id);}
}