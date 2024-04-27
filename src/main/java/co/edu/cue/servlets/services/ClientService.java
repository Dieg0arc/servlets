package co.edu.cue.servlets.services;

import co.edu.cue.servlets.mapping.dtos.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> listar();
}