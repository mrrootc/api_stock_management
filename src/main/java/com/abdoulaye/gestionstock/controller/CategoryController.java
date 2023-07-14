package com.abdoulaye.gestionstock.controller;

import com.abdoulaye.gestionstock.controller.api.CategorieApi;
import com.abdoulaye.gestionstock.dto.CategorieDto;
import com.abdoulaye.gestionstock.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController implements CategorieApi {

  private final CategoryService categoryService;

  @Override
  public CategorieDto save(CategorieDto dto) {
    return categoryService.save(dto);
  }

  @Override
  public CategorieDto findById(Integer idCategory) {
    return categoryService.findById(idCategory);
  }

  @Override
  public CategorieDto findByCode(String codeCategory) {
    return categoryService.findByCode(codeCategory);
  }

  @Override
  public List<CategorieDto> findAll() {
    return categoryService.findAll();
  }

  @Override
  public void delete(Integer id) {
    categoryService.delete(id);
  }
}
