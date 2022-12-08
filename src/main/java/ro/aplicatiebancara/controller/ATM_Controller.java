package ro.aplicatiebancara.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.aplicatiebancara.service.ATM_Service;
import ro.aplicatiebancara.view.CarduriView;
import ro.aplicatiebancara.view.ConturiView;

@RestController
@RequestMapping("api/atm")

public class ATM_Controller {

    private ATM_Service atm_service;

    public ATM_Controller(ATM_Service atm_service){
        this.atm_service = atm_service;
    }

    @GetMapping("interogareSold")
    public Integer interogareSold(@RequestParam ("combinatie") String combinatie){
        return atm_service.interogareSold(combinatie);
    }

    @PostMapping("retragere")
    public ResponseEntity depunere(@RequestBody CarduriView carduriView, @RequestParam ("sumaRetrasa") Integer sumaRetrasa){
        return atm_service.depunere(carduriView.getNrCard(), carduriView.getPin(), sumaRetrasa);
    }

    @PostMapping("depunere")
    public ResponseEntity retragere(@RequestBody CarduriView carduriView, @RequestParam ("sumaDepusa") Integer sumaDepusa){
        return atm_service.retragere(carduriView.getNrCard(), carduriView.getPin(), sumaDepusa);
    }

}
