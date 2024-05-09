package co.edu.cue.servlets.repositories;

import co.edu.cue.servlets.mapping.dtos.ClientDTO;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> list() throws SQLException;

    ClientDTO byId(int id_number);

    void save(String id_number);

    void delete(String id_number);

    void update(ClientDTO c);
}
