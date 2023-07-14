package com.abdoulaye.gestionstock.services.impl;

import com.abdoulaye.gestionstock.dto.CategorieDto;
import com.abdoulaye.gestionstock.exception.EntityNotFoundException;
import com.abdoulaye.gestionstock.exception.ErrorCodes;
import com.abdoulaye.gestionstock.exception.InvalidEntityException;
import com.abdoulaye.gestionstock.exception.InvalidOperationException;
import com.abdoulaye.gestionstock.model.Article;
import com.abdoulaye.gestionstock.repository.ArticleRepository;
import com.abdoulaye.gestionstock.repository.CategorieRepository;
import com.abdoulaye.gestionstock.services.CategoryService;
import com.abdoulaye.gestionstock.validator.CategorieValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategorieRepository categoryRepository;
  private final ArticleRepository articleRepository;



  @Override
  public CategorieDto save(CategorieDto dto) {
    List<String> errors = CategorieValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article n'est pas valide {}", dto);
      throw new InvalidEntityException("La categorie n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
    }
    return CategorieDto.fromEntity(
        categoryRepository.save(CategorieDto.toEntity(dto))
    );
  }

  @Override
  public CategorieDto findById(Integer id) {
    if (id == null) {
      log.error("Category ID est null");
      return null;
    }
    return categoryRepository.findById(id)
        .map(CategorieDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune category avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.CATEGORY_NOT_FOUND)
        );
  }

  @Override
  public CategorieDto findByCode(String code) {
    if (!StringUtils.hasLength(code)) {
      log.error("Category CODE is null");
      return null;
    }
    return categoryRepository.findCategorieByCodeCategorie(code)
        .map(CategorieDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune category avec le CODE = " + code + " n' ete trouve dans la BDD",
            ErrorCodes.CATEGORY_NOT_FOUND)
        );
  }

  @Override
  public List<CategorieDto> findAll() {
    return categoryRepository.findAll().stream()
        .map(CategorieDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Category ID is null");
      return;
    }
//    List<Article> articles = articleRepository.findAllByCategorieId(id);
//    if (!articles.isEmpty()) {
//      throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",
//          ErrorCodes.CATEGORY_ALREADY_IN_USE);
//    }
    categoryRepository.deleteById(id);
  }
}
