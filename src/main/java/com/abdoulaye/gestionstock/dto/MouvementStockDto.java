package com.abdoulaye.gestionstock.dto;

import com.abdoulaye.gestionstock.models.Article;
import com.abdoulaye.gestionstock.models.TypeMouvementStock;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MouvementStockDto {
    private int id;
    private ArticleDto article;
    private BigDecimal quantite;
    private Instant dateMvt;
    private TypeMouvementStock typeMvt;
}
