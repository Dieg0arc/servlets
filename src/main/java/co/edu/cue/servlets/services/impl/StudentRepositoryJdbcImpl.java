package co.edu.cue.servlets.services.impl;

import co.edu.cue.servlets.mapping.dtos.ClientDTO;
import co.edu.cue.servlets.model.Client;
import kotlin.script.experimental.dependencies.Repository;

import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryJdbcImpl implements Repository<Client> {
    private Connection conn;
    public StudentRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public List<ClientDTO> list() throws SQLException {
        List<Client> students = new ArrayList<Client>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT s.* order by s.id ASC")) {
            while (rs.next()) {
                Client ps= getStudent(rs);
                Client.add(s);
            }
        }
        return mapper.mapFromModel(Client);
    }
//mirar por que saca error el get, el add y el mapper
    @Override
    public String[] repositoriesCoordinates() {
        return new String[0];
    }

    @Override
    public String[] options() {
        return new String[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
