package com.app.develite.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clients = clientService.getClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
        Client client = clientService.getClient(id);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/companyName/{companyName}")
    public ResponseEntity<Client> getClientByCompanyName(@PathVariable("companyName") String companyName) {
        Client client = clientService.getClientByCompanyName(companyName);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client addedClient = clientService.addClient(client);
        return new ResponseEntity<>(addedClient, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long id, @RequestBody Client clientData) {
        Client updatedClient = clientService.updateClient(id, clientData);
        if (updatedClient != null) {
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping(value = "/companyName/{companyName}")
    public ResponseEntity<Client> updateClientByCompanyName(@PathVariable(value = "companyName") String companyName, @RequestBody Client clientData) {
        Client updatedClient = clientService.updateClientByCompanyName(companyName, clientData);
        if (updatedClient != null) {
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id) {
        boolean deleted = clientService.deleteClient(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/companyName/{companyName}")
    public ResponseEntity<Void> deleteClientByCompanyName(@PathVariable("companyName") String companyName) {
        boolean deleted = clientService.deleteByCompanyName(companyName);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
