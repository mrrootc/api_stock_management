package com.abdoulaye.gestionstock.dto;



import com.abdoulaye.gestionstock.model.CommandeClient;
import com.abdoulaye.gestionstock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeClientDto {
    private Integer id;
    private String code;
    private Instant dateCommande;
    private ClientDto client;
    private EtatCommande etatCommande;
    private Integer idEntreprise;
    private List<LigneCommandeClientDto> ligneCommandeClients;


    public static CommandeClientDto fromEntity(CommandeClient commandeClient){
        if(commandeClient == null){
            return null;

        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .etatCommande(commandeClient.getEtatCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .idEntreprise(commandeClient.getIdEntreprise())
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto == null){
            return null;
        }

        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        commandeClient.setIdEntreprise(commandeClientDto.getIdEntreprise());
        commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));
        commandeClient.setEtatCommande(commandeClient.getEtatCommande());


        return commandeClient;
    }

    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
