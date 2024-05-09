package co.edu.cue.servlets.repositories.impl;

import co.edu.cue.servlets.mapping.dtos.ClientDTO;
import co.edu.cue.servlets.mapping.mapper.ClienteMapper;
import co.edu.cue.servlets.model.Client;
import org.jetbrains.kotlin.org.apache.maven.model.Repository;

import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryJdbcImpl implements Repository<Client> {
    private Connection conn;

    public ClientRepositoryJdbcImpl(Connection conn){
        this.conn =conn;
}
    private Client createCLient(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setName(resultSet.getString("name"));
        client.setIdnumber(resultSet.getInt("id_number"));
        client.setPhone_numbre(resultSet.getInt("phone_number"));
        return client;
    }

    @Override
    public List<ClientDTO> List()  throws SQLException{
        List<ClientDTO> Client = new ArrayList<>();
        try (Statement stmt= conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from vehicles")) {
            while (rs.next()){
                Client client = createCLient(rs);
                ClientDTO ClientDTO = ClienteMapper.mapFromModel(client);
                Client.add(ClientDTO);
            }

        }  return Client;
    }

    private Client createCLient(){
        return null;
    }
@Override
    public List<Client> list() throws SQLException {
        List<Client> client = new ArrayList<Client>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT s.* order by s.id ASC")) {
            while (rs.next()) {
                Client ps= getClient(rs);
                client.add(ps);
            }
        }
        return client;
    }

    private Client getClient(ResultSet rs) {
        return null;
    }

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
