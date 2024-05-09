package co.edu.cue.servlets.services.impl;

import co.edu.cue.servlets.mapping.dtos.ClientDTO;
import co.edu.cue.servlets.mapping.mapper.ClienteMapper;
import co.edu.cue.servlets.model.Client;
import co.edu.cue.servlets.repositories.Repository;
import co.edu.cue.servlets.services.ClientService;
import co.edu.cue.servlets.services.ServiceJdbcException;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceImpl implements ClientService{
    private Repository<Client> repository;

    @Override
    public List<Client> list() {
        try {
            return Repository.list().stream().map(ClienteMapper::mapFromModel).toList();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),
                    throwables.getCause());
        }
    }

    @Override
    public List<Client> list() {
        return null;
    }

    @Override
    public ClientDTO byId(int id_number) {
        return null;
    }

    @Override
    public void save(ClientDTO c) {

    }

    @Override
    public void delete(int id_number) {

    }

    @Override
    public void update(ClientDTO c) {

    }
// demas metodos
}
//arreglar