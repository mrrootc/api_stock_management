package com.abdoulaye.gestionstock.services.impl;

import com.abdoulaye.gestionstock.dto.MouvementStockDto;
import com.abdoulaye.gestionstock.exception.ErrorCodes;
import com.abdoulaye.gestionstock.exception.InvalidEntityException;
import com.abdoulaye.gestionstock.model.TypeMouvementStock;
import com.abdoulaye.gestionstock.repository.MvtStkRepository;
import com.abdoulaye.gestionstock.services.ArticleService;
import com.abdoulaye.gestionstock.services.MouvementStockService;
import com.abdoulaye.gestionstock.validator.MouvementStockValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MouvementStockServiceImpl implements MouvementStockService {

  private final MvtStkRepository repository;
  private final ArticleService articleService;


  @Override
  public BigDecimal stockReelArticle(Integer idArticle) {
    if (idArticle == null) {
      log.warn("ID article is NULL");
      return BigDecimal.valueOf(-1);
    }
    articleService.findById(idArticle);
    return repository.stockReelArticle(idArticle);
  }

  @Override
  public List<MouvementStockDto> mvtStkArticle(Integer idArticle) {
    return repository.findAllByArticleId(idArticle).stream()
        .map(MouvementStockDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public MouvementStockDto entreeStock(MouvementStockDto dto) {
    return entreePositive(dto, TypeMouvementStock.ENTRE);
  }

  @Override
  public MouvementStockDto sortieStock(MouvementStockDto dto) {
    return sortieNegative(dto, TypeMouvementStock.SORTIE);
  }

  @Override
  public MouvementStockDto correctionStockPos(MouvementStockDto dto) {
    return entreePositive(dto, TypeMouvementStock.CORRECTION_POS);
  }

  @Override
  public MouvementStockDto correctionStockNeg(MouvementStockDto dto) {
    return sortieNegative(dto, TypeMouvementStock.CORRECTION_NEG);
  }

  private MouvementStockDto entreePositive(MouvementStockDto dto, TypeMouvementStock typeMvtStk) {
    List<String> errors = MouvementStockValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
    }
    dto.setQuantite(
        BigDecimal.valueOf(
            Math.abs(dto.getQuantite().doubleValue())
        )
    );
    dto.setTypeMvt(typeMvtStk);
    return MouvementStockDto.fromEntity(
        repository.save(MouvementStockDto.toEntity(dto))
    );
  }

  private MouvementStockDto sortieNegative(MouvementStockDto dto, TypeMouvementStock typeMvtStk) {
    List<String> errors = MouvementStockValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
    }
    dto.setQuantite(
        BigDecimal.valueOf(
            Math.abs(dto.getQuantite().doubleValue()) * -1
        )
    );
    dto.setTypeMvt(typeMvtStk);
    return MouvementStockDto.fromEntity(
        repository.save(MouvementStockDto.toEntity(dto))
    );
  }
}
