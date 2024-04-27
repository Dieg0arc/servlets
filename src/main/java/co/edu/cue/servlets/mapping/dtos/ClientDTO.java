package co.edu.cue.servlets.mapping.dtos;

import lombok.Builder;

@Builder
public record ClientDTO (String name, int idnumber, int phone_number) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public int idnumber() {
        return idnumber;
    }

    @Override
    public int phone_number() {
        return phone_number;
    }
}
