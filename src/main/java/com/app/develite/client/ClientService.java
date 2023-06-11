package com.app.develite.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
    //add client
    public Client addClient(Client client){
        return clientRepository.save(client);
    }
    //get all clients
    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    //get client by id
    public Client getClient(Long Id){
        return clientRepository.findById(Id).get();
    }  
     
    //get client by companyname
    public Client getClientByCompanyName(String companyname){
        return clientRepository.findByCompanyname(companyname);
    }
    //update Client by id
    public Client updateClient(Long id,Client receivedClient){
        Client client = getClient(id);

        if (receivedClient.getCompanyname() != client.getCompanyname()){
            client.setCompanyname(receivedClient.getCompanyname());
        }

        if (receivedClient.getFirstname() != client.getFirstname()){
            client.setFirstname(receivedClient.getFirstname());
        }
        if (receivedClient.getLastname() != client.getLastname()){
            client.setLastname(receivedClient.getLastname());
        }
        if (receivedClient.getEmail() != client.getEmail()){
            client.setEmail(receivedClient.getEmail());
        }
        if (receivedClient.getPhone_number() != client.getPhone_number()){
            client.setPhone_number(receivedClient.getPhone_number());
        }
        if (receivedClient.getFax() != client.getFax()){
            client.setFax(receivedClient.getFax());
        }

        if (receivedClient.getAddress() != client.getAddress()){
            client.setAddress(receivedClient.getAddress());
        }
         if (receivedClient.getGender() != client.getGender()){
            client.setGender(receivedClient.getGender());}
        return clientRepository.save(client);
    }
    //update client by companyname
    public Client updateClientByCompanyName(String companyname,Client receivedClient){
        Client client = getClientByCompanyName(companyname);


        if (receivedClient.getCompanyname() != client.getCompanyname()){
            client.setCompanyname(receivedClient.getCompanyname());
        }

        if (receivedClient.getFirstname() != client.getFirstname()){
            client.setFirstname(receivedClient.getFirstname());
        }
        if (receivedClient.getLastname() != client.getLastname()){
            client.setLastname(receivedClient.getLastname());
        }
        if (receivedClient.getEmail() != client.getEmail()){
            client.setEmail(receivedClient.getEmail());
        }
        if (receivedClient.getPhone_number() != client.getPhone_number()){
            client.setPhone_number(receivedClient.getPhone_number());
        }
        if (receivedClient.getFax() != client.getFax()){
            client.setFax(receivedClient.getFax());
        }

        if (receivedClient.getAddress() != client.getAddress()){
            client.setAddress(receivedClient.getAddress());
        }
         if (receivedClient.getGender() != client.getGender()){
            client.setGender(receivedClient.getGender());}
        return clientRepository.save(client);
    }
    // delete by id
    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public boolean deleteByCompanyName(String companyName) {
        Client client = getClientByCompanyName(companyName);
        if (client != null) {
            clientRepository.deleteById(client.getId());
            return true;
        }
        return false;
    }
    

}
