package com.abdoulaye.gestionstock.dto;

import com.abdoulaye.gestionstock.model.MouvementStock;
import com.abdoulaye.gestionstock.model.SourceMouvementStock;
import com.abdoulaye.gestionstock.model.TypeMouvementStock;
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
    private SourceMouvementStock sourceMvt;
    private Integer idEntreprise;

    public static MouvementStockDto fromEntity(MouvementStock mouvementStock){
        if(mouvementStock == null){
            return null;
        }
        return MouvementStockDto.builder()
                .id(mouvementStock.getId())
                .quantite(mouvementStock.getQuantite())
                .dateMvt(mouvementStock.getDateMvt())
                .typeMvt(mouvementStock.getTypeMvt())
                .article(ArticleDto.fromEntity(mouvementStock.getArticle()))
                .sourceMvt(mouvementStock.getSourceMvt())
                .idEntreprise(mouvementStock.getIdEntreprise())
                .build();
    }

    public static MouvementStock toEntity(MouvementStockDto mouvementStockDto){
        if(mouvementStockDto == null){
            return null;
        }

        MouvementStock mouvementStock = new MouvementStock();
        mouvementStock.setId(mouvementStockDto.getId());
        mouvementStock.setQuantite(mouvementStockDto.getQuantite());
        mouvementStock.setDateMvt(mouvementStockDto.getDateMvt());
        mouvementStock.setTypeMvt(mouvementStockDto.getTypeMvt());
        mouvementStock.setIdEntreprise(mouvementStockDto.getIdEntreprise());
        mouvementStock.setArticle(ArticleDto.toEntity(mouvementStockDto.getArticle()));
        mouvementStock.setSourceMvt(mouvementStock.getSourceMvt());
        return mouvementStock;
    }
}
