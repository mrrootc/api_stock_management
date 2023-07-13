package com.abdoulaye.gestionstock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role extends AbstratEntity{
    @Column(name = "nom_role")
    private String nomRole;
    @ManyToOne()
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
}
