package com.abdoulaye.gestionstock.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jshell.execution.Util;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur extends AbstratEntity{

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "datenaissance")
    private Instant dateDeNaissance;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "image")
    private String image;

    @Embedded
    private Adresse adresse;

    @Column(name = "motdepasse")
    private String motDePasse;

    @OneToMany( fetch = FetchType.EAGER,mappedBy = "utilisateur")
    @JsonIgnore
    private List<Role> roles;

    @ManyToOne()
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;
}
