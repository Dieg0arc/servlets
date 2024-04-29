package co.edu.cue.servlets.services.impl;

import co.edu.cue.servlets.mapping.dtos.ClientDTO;
import co.edu.cue.servlets.mapping.mapper.ClienteMapper;
import co.edu.cue.servlets.model.Client;
import co.edu.cue.servlets.services.ClientService;

import java.sql.Connection;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class ClientServiceImpl  implements ClientService {
    private Connection conn;

    private Client createStudent(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setName(resultSet.getString("name"));
        client.setIdnumber(resultSet.getInt("id_number"));
        client.setPhone_numbre(resultSet.getInt("phone_number"));
        return client;
    }

    @Override
    public List<ClientDTO> list()  throws SQLException{
        List<ClientDTO> vehicle = new ArrayList<>();
        try (Statement stmt= conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from vehicles")) {
            while (rs.next()){
                Client client = createStudent(rs);
                ClientDTO vehiclesDto = ClienteMapper.mapFromModel(client);
                vehicle.add(vehiclesDto);
            }

        }  return vehicle;

    }

    private Client createStudent(){
        return null;
    }

    @Override
    public List<ClientDTO> listar() {
        return null;
    }

    @Override
    public ClientDTO byId(int id) {
        return null;
    }

    @Override
    public void save(ClientDTO vehiclesDto) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(ClientDTO vehiclesDto) {

    }
}
