package com.abdoulaye.gestionstock.services.impl;

import com.abdoulaye.gestionstock.dto.ClientDto;
import com.abdoulaye.gestionstock.exception.EntityNotFoundException;
import com.abdoulaye.gestionstock.exception.ErrorCodes;
import com.abdoulaye.gestionstock.exception.InvalidEntityException;
import com.abdoulaye.gestionstock.exception.InvalidOperationException;
import com.abdoulaye.gestionstock.model.CommandeClient;
import com.abdoulaye.gestionstock.repository.ClientRepository;
import com.abdoulaye.gestionstock.repository.CommandeClientRepository;
import com.abdoulaye.gestionstock.services.ClientService;
import com.abdoulaye.gestionstock.validator.ClientValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;
  private final CommandeClientRepository commandeClientRepository;


  @Override
  public ClientDto save(ClientDto dto) {
    List<String> errors = ClientValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Client n'est pas valide {}", dto);
      throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
    }

    return ClientDto.fromEntity(
        clientRepository.save(
            ClientDto.toEntity(dto)
        )
    );
  }

  @Override
  public ClientDto findById(Integer id) {
    if (id == null) {
      log.error("Client ID est null");
      return null;
    }
    return clientRepository.findById(id)
        .map(ClientDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun Client avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.CLIENT_NOT_FOUND)
        );
  }

  @Override
  public List<ClientDto> findAll() {
    return clientRepository.findAll().stream()
        .map(ClientDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Client ID est null");
      return;
    }
    List<CommandeClient> commandeClients = commandeClientRepository.findAllByClientId(id);
    if (!commandeClients.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer un client qui a deja des commande clients",
          ErrorCodes.CLIENT_ALREADY_IN_USE);
    }
    clientRepository.deleteById(id);
  }
}
