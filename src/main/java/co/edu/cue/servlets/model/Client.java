package co.edu.cue.servlets.model;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Client implements Serializable {
    private String name;
    private int idnumber;
    private int phone_numbre;


}