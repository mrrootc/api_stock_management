package com.abdoulaye.gestionstock.controller;

import com.abdoulaye.gestionstock.controller.api.EntrepriseApi;
import com.abdoulaye.gestionstock.dto.EntrepriseDto;
import com.abdoulaye.gestionstock.services.EntrepriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EntrepriseController implements EntrepriseApi {

  private final EntrepriseService entrepriseService;

  @Override
  public EntrepriseDto save(EntrepriseDto dto) {
    return entrepriseService.save(dto);
  }

  @Override
  public EntrepriseDto findById(Integer id) {
    return entrepriseService.findById(id);
  }

  @Override
  public List<EntrepriseDto> findAll() {
    return entrepriseService.findAll();
  }

  @Override
  public void delete(Integer id) {
    entrepriseService.delete(id);
  }
}
