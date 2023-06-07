package com.abdoulaye.gestionstock.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)//Cette annation permet de creer une
public class AbstratEntity implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @CreatedDate
    @Column(name = "dateCreation", nullable = false)
    @JsonIgnore //Cette annotation veut dire que nous avons pas besoin de la colonne la lors de l'appel a l'API
    private Date dateCreation;

    @LastModifiedDate
    @Column(name = "deniereModification")
    private Date dateModification;
}
