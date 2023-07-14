package com.abdoulaye.gestionstock.controller;

import com.abdoulaye.gestionstock.controller.api.FournisseurApi;
import com.abdoulaye.gestionstock.dto.FournisseurDto;
import com.abdoulaye.gestionstock.services.FournisseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FournisseurController implements FournisseurApi {

  private final FournisseurService fournisseurService;


  @Override
  public FournisseurDto save(FournisseurDto dto) {
    return fournisseurService.save(dto);
  }

  @Override
  public FournisseurDto findById(Integer id) {
    return fournisseurService.findById(id);
  }

  @Override
  public List<FournisseurDto> findAll() {
    return fournisseurService.findAll();
  }

  @Override
  public void delete(Integer id) {
    fournisseurService.delete(id);
  }
}
