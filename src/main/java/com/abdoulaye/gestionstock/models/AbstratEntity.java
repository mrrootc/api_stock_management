package com.abdoulaye.gestionstock.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)//Cette annation permet de creer une
public class AbstratEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    @Column(name = "dateCreation", nullable = false)
    @JsonIgnore //Cette annotation veut dire que nous avons pas besoin de la colonne la lors de l'appel a l'API
    private Date dateCreation;

    @LastModifiedDate
    @Column(name = "deniereModification")
    private Date dateModification;
}
