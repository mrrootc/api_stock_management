package com.abdoulaye.gestionstock.repository;

import com.abdoulaye.gestionstock.models.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Long> {
}
