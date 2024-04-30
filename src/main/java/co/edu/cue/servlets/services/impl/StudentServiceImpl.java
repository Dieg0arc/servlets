package co.edu.cue.servlets.services.impl;

import co.edu.cue.servlets.mapping.dtos.ClientDTO;
import org.jetbrains.kotlin.org.apache.maven.model.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService{
    private Repository<ClientDTO> studentRepository;
    public StudentServiceImpl(Connection connection) {
        this.studentRepository = new StudentRepositoryJdbcImpl(connection);
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
// demas metodos
}
//arreglar