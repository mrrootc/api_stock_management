package com.abdoulaye.gestionstock.repository;


import com.abdoulaye.gestionstock.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {

}
