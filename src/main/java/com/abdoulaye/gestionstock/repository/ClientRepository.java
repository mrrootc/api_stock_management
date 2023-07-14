package com.abdoulaye.gestionstock.repository;


import com.abdoulaye.gestionstock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
