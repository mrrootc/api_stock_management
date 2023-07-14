package com.abdoulaye.gestionstock.services;

import com.abdoulaye.gestionstock.dto.CategorieDto;

import java.util.List;

public interface CategoryService {

  CategorieDto save(CategorieDto dto);

  CategorieDto findById(Integer id);

  CategorieDto findByCode(String code);

  List<CategorieDto> findAll();

  void delete(Integer id);

}
