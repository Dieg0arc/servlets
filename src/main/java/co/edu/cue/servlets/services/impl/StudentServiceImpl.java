package co.edu.cue.servlets.services.impl;

import co.edu.cue.servlets.mapping.dtos.ClientDTO;
import co.edu.cue.servlets.repositories.impl.ClientRepositoryJdbcImpl;
import co.edu.cue.servlets.services.ClientService;
import co.edu.cue.servlets.services.ServiceJdbcException;
import org.jetbrains.kotlin.org.apache.maven.model.Repository;

import java.sql.Connection;
import java.sql.SQLException;

public class ClientServiceImpl implements ClientService{
    private Repository<ClientDTO> studentRepository;
    public ClientServiceImpl(Connection connection) {
        this.studentRepository = new ClientRepositoryJdbcImpl(connection);
    }
    @Override
    public List<ClientDTO> list() {
        try {
            return studentRepository.list();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),
                    throwables.getCause());
        }
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
