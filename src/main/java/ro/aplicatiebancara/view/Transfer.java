package ro.aplicatiebancara.view;

import org.springframework.stereotype.Component;

@Component
public class Transfer extends CarduriView{
    private String contTransfer;



    public Transfer(int id, int nrCard, int pin, String nrCont, String contTransfer) {
        super(id, nrCard, pin, nrCont);
        this.contTransfer = contTransfer;
    }
}
