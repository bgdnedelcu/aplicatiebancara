package ro.aplicatiebancara.view;

import lombok.*;

//@Data - simplificare pentru urmatoarele 5
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class ConturiView {

    private int id;
    private int idBanca;
    private int idPersoana;
    private int sold;
    private String nrCont;




}
