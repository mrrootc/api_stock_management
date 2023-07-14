package com.abdoulaye.gestionstock.controller;


import com.abdoulaye.gestionstock.controller.api.VentesApi;
import com.abdoulaye.gestionstock.dto.VenteDto;
import com.abdoulaye.gestionstock.services.VentesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VentesController implements VentesApi {

  private final VentesService ventesService;

  @Override
  public VenteDto save(VenteDto dto) {
    return ventesService.save(dto);
  }

  @Override
  public VenteDto findById(Integer id) {
    return ventesService.findById(id);
  }

  @Override
  public VenteDto findByCode(String code) {
    return ventesService.findByCode(code);
  }

  @Override
  public List<VenteDto> findAll() {
    return ventesService.findAll();
  }

  @Override
  public void delete(Integer id) {
    ventesService.delete(id);
  }
}
