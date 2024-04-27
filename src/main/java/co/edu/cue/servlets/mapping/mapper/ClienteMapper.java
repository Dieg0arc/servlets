package co.edu.cue.servlets.mapping.mapper;

import co.edu.cue.servlets.mapping.dtos.ClientDTO;
import co.edu.cue.servlets.model.Client;

public class ClienteMapper {
    public static ClientDTO mapFromModel(Client cliente){
        return new ClientDTO( cliente.getName(), cliente.getIdnumber(), cliente.getPhone_numbre());

    }
    public static Client mapFromDTO(ClientDTO clienteDTO){
        return Client.builder()
                .name(clienteDTO.name())
                .idnumber(clienteDTO.idnumber())
                .phone_numbre(clienteDTO.phone_number())
                .build();
    }
}