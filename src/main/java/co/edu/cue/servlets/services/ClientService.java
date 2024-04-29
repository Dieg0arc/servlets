package co.edu.cue.servlets.services;

import co.edu.cue.servlets.mapping.dtos.ClientDTO;

import java.sql.SQLException;
import java.util.List;

public interface ClientService {
    List<ClientDTO> list()  throws SQLException;

    List<ClientDTO> listar();
    ClientDTO byId(int id_number);
    void save(ClientDTO c);
    void delete(int id_number);

    void update(ClientDTO c);
}