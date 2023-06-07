package com.abdoulaye.gestionstock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Commandefournisseur")
public class CommandeFournisseur extends AbstratEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "date_commande")
    private Instant dateCommande;
    @ManyToOne()
    @JoinColumn(name = "id_fournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
}
