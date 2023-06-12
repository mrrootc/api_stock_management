package com.abdoulaye.gestionstock.repository;

import com.abdoulaye.gestionstock.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
