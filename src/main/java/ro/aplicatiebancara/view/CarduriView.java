package ro.aplicatiebancara.view;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class CarduriView {

    private int id;
    private int nrCard;
    private int pin;
    private String nrCont;



}
