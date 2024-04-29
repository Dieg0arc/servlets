package co.edu.cue.servlets.mapping.dtos;

import lombok.Builder;

@Builder
public record ClientDTO (String name, int idnumber, int phone_number) {

}
