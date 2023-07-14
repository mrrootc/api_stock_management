package com.abdoulaye.gestionstock.services;

import com.abdoulaye.gestionstock.dto.MouvementStockDto;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface MouvementStockService {

  BigDecimal stockReelArticle(Integer idArticle);

  List<MouvementStockDto> mvtStkArticle(Integer idArticle);

  MouvementStockDto entreeStock(MouvementStockDto dto);

  MouvementStockDto sortieStock(MouvementStockDto dto);

  MouvementStockDto correctionStockPos(MouvementStockDto dto);

  MouvementStockDto correctionStockNeg(MouvementStockDto dto);


}
