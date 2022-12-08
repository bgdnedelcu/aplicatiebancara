package ro.aplicatiebancara.view;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PersoaneView {

    private int id;
    private String numePer;
    private String prenumePer;
    private String adresa;
    private String cnp;


}
