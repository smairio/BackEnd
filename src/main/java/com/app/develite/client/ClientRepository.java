package com.app.develite.client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client,Long> {

    Client findByCompanyname(String companyname);
    
}
