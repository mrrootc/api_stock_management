package com.abdoulaye.gestionstock.controller.api;

import com.abdoulaye.gestionstock.dto.VenteDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abdoulaye.gestionstock.utils.Constants.VENTES_ENDPOINT;

@Api("ventes")
public interface VentesApi {

  @PostMapping(VENTES_ENDPOINT + "/create")
  VenteDto save(@RequestBody VenteDto dto);

  @GetMapping(VENTES_ENDPOINT + "/{idVente}")
  VenteDto findById(@PathVariable("idVente") Integer id);

  @GetMapping(VENTES_ENDPOINT + "/{codeVente}")
  VenteDto findByCode(@PathVariable("codeVente") String code);

  @GetMapping(VENTES_ENDPOINT + "/all")
  List<VenteDto> findAll();

  @DeleteMapping(VENTES_ENDPOINT + "/delete/{idVente}")
  void delete(@PathVariable("idVente") Integer id);

}
