package com.abdoulaye.gestionstock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mouvementstock")
public class MouvementStock extends AbstratEntity{
    @ManyToOne()
    @JoinColumn(name = "id_article")
    private Article article;
}
