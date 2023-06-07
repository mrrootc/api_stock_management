package com.abdoulaye.gestionstock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vente ")
public class Vente extends AbstratEntity{

    @Column(name = "code")
    private String code;
    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes;
}
