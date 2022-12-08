package ro.aplicatiebancara.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.aplicatiebancara.repo.CarduriRepo;
import ro.aplicatiebancara.repo.ConturiRepo;
import ro.aplicatiebancara.view.CarduriView;
import ro.aplicatiebancara.view.ConturiView;
import ro.aplicatiebancara.view.Transfer;

@Service
public class ATM_Service {

    private CarduriRepo carduriRepo;
    private ConturiRepo conturiRepo;


    public ATM_Service(CarduriRepo carduriRepo, ConturiRepo conturiRepo){
        this.carduriRepo = carduriRepo;
        this.conturiRepo = conturiRepo;
    }

    public Integer interogareSold(String combinatie){
        CarduriView carduriView = null;
        ConturiView conturiView = null;
        int sold = 0;
        String pin = "";
        String nrCard = "";
        for(int i = 0; i <= 2; i++) {
            nrCard += combinatie.charAt(i);
        }
        for(int j = 3; j <= 5; j++){
            pin += combinatie.charAt(j);
        }
        int pin2 = Integer.parseInt(pin);
        int nrCard2 = Integer.parseInt(nrCard);

        for(CarduriView card : carduriRepo.getListaCarduri()){
            if(card.getNrCard() == nrCard2 && card.getPin() == pin2){
                carduriView = card;
            }
        }
        for(ConturiView cont: conturiRepo.getListaConturi()){
            if(cont.getNrCont().equals(carduriView.getNrCont())){
                conturiView = cont;
            }
        }

        return conturiView.getSold();
    }

    public ResponseEntity retragere(int nrCard, int pin, int sumaRetrasa){
        CarduriView carduriView = null;
        ConturiView conturiView = null;

        for(CarduriView card : carduriRepo.getListaCarduri()){
            if(card.getNrCard() == nrCard && card.getPin() == pin){
                carduriView = card;
            }
        }
        for(ConturiView cont : conturiRepo.getListaConturi()){
            if(cont.getNrCont().equals(carduriView.getNrCont())){
                conturiView = cont;
                conturiView.setSold(conturiView.getSold() - sumaRetrasa);
            }
        }

        return ResponseEntity.ok("Suma a fost retrasa din cont");
    }

    public ResponseEntity depunere(int nrCard, int pin, int sumaDepusa){
        CarduriView carduriView = null;
        ConturiView conturiView = null;

        for(CarduriView card : carduriRepo.getListaCarduri()){
            if(card.getNrCard() == nrCard && card.getPin() == pin){
                carduriView = card;
            }
        }
        for(ConturiView cont : conturiRepo.getListaConturi()){
            if(cont.getNrCont().equals(carduriView.getNrCont())){
                conturiView = cont;
                conturiView.setSold(conturiView.getSold() + sumaDepusa);
            }
        }

        return ResponseEntity.ok("Suma a fost retrasa din cont");
    }

    public ResponseEntity transfer(int sumaTransfer){
        CarduriView carduriView = null;
        ConturiView conturiView = null;
        for(CarduriView card : carduriRepo.getListaCarduri()){

        }

    }

}
