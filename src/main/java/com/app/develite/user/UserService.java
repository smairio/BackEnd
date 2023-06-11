package com.app.develite.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    //Save User
    public User saveUser(User adminDetails){
        return userRepository.save(adminDetails);
    }

    //get one admin
    public UserGetDto getUser(long id){
        User admin = userRepository.findById(id).get();
        return UserGetMapper.toDTO(admin);
    }


    public UserGetDto getUserByUsername(String username){
        User admin = userRepository.findByUsername(username).get();

        return UserGetMapper.toDTO(admin);
    }

    //read
    public List<User> getUsers(){
        return userRepository.findAll();

    }

    public List <UserGetDto> getUsersByDto(){
        List <UserGetDto> adminsDto = new ArrayList<>();
        List <User> admins = userRepository.findAll();

        for( User x : admins){
            adminsDto.add(getUser(x.getId()));
        }

        return adminsDto;
    }


    //delete 
    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
    
    public boolean deleteUserByUsername(String username) {
        UserGetDto user = getUserByUsername(username);
        if (user != null) {
            return deleteUser(user.getId());
        }
        return false;
    }
    

    //update == this fuction needs more modification to do only one attribute modification without deleting the other attributes
    public User updateUser(Long id,User ReceivedUserDetails){
        User adm = userRepository.findById(id).get();

        if (ReceivedUserDetails.getUsername()!=null){
            adm.setUsername(ReceivedUserDetails.getUsername());
        }


        if (ReceivedUserDetails.getFirstname()!=null){
            adm.setFirstname(ReceivedUserDetails.getFirstname());
        }

        if (ReceivedUserDetails.getLastname()!=null){
        adm.setLastname(ReceivedUserDetails.getLastname());}
       

        if (ReceivedUserDetails.getEmail()!=null){
        adm.setEmail(ReceivedUserDetails.getEmail());
        }
        if (ReceivedUserDetails.getPhone_number()!=null){
        adm.setPhone_number(ReceivedUserDetails.getPhone_number());}


        if (ReceivedUserDetails.getAddress()!=null){
        adm.setAddress(ReceivedUserDetails.getAddress());}

        if (ReceivedUserDetails.getRole()!=null){
            adm.setRole(ReceivedUserDetails.getRole());}
        
        
            return userRepository.save(adm);
    }

    //update user by username
    public User updateUserByUsername(String username,User ReceivedUserDetails){
        User adm = userRepository.findByUsername(username).get();

        if (ReceivedUserDetails.getUsername()!=null){
            adm.setUsername(ReceivedUserDetails.getUsername());
        }


        if (ReceivedUserDetails.getFirstname()!=null){
            adm.setFirstname(ReceivedUserDetails.getFirstname());
        }

        if (ReceivedUserDetails.getLastname()!=null){
        adm.setLastname(ReceivedUserDetails.getLastname());}
       

        if (ReceivedUserDetails.getEmail()!=null){
        adm.setEmail(ReceivedUserDetails.getEmail());
        }
        if (ReceivedUserDetails.getPhone_number()!=null){
        adm.setPhone_number(ReceivedUserDetails.getPhone_number());}


        if (ReceivedUserDetails.getAddress()!=null){
        adm.setAddress(ReceivedUserDetails.getAddress());}

        if (ReceivedUserDetails.getRole()!=null){
            adm.setRole(ReceivedUserDetails.getRole());}
        
        
            return userRepository.save(adm);
    }
///////////////////////////////////////////////////////////////////



}

