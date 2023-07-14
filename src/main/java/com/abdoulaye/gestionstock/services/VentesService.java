package com.abdoulaye.gestionstock.services;

import com.abdoulaye.gestionstock.dto.VenteDto;

import java.util.List;

public interface VentesService {

  VenteDto save(VenteDto dto);

  VenteDto findById(Integer id);

  VenteDto findByCode(String code);

  List<VenteDto> findAll();

  void delete(Integer id);

}
