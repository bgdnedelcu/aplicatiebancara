package ro.aplicatiebancara.controller;

import com.sun.source.tree.ReturnTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.aplicatiebancara.service.BancaService;
import ro.aplicatiebancara.view.BancaView;
import ro.aplicatiebancara.view.ConturiView;
import ro.aplicatiebancara.view.PersoaneView;

import java.util.List;

@RestController
@RequestMapping("api/banca")


public class BancaController {

    private final BancaService bancaService;

    @Autowired
    public BancaController(BancaService bancaService){
        this.bancaService = bancaService;
    }

    @GetMapping("allBanks")
    public List<BancaView> getBanci(BancaView bancaView){
        return bancaService.getBanci();
    }

    @PostMapping("adaugaBanca")
    public ResponseEntity adaugaBanca(@RequestBody BancaView bancaView){
        return bancaService.adaugaBanca(bancaView);
    }

    @GetMapping("numeBanca")
    public String afiseazaNumeBanca(@RequestParam ("id") Integer id){
        return bancaService.afiseazaNumeBanca(id);
    }


    @GetMapping("allPers")
    public List<PersoaneView> getAllPers(){
        return bancaService.afiseazaPersoane();
    }

    @PostMapping("adaugaPers")
    public ResponseEntity adaugaPersoana(@RequestBody  PersoaneView persoaneView){
        return bancaService.adaugaPersoana(persoaneView);
    }

    @GetMapping("conturi")
    public List<ConturiView> getAllConturi(){
        return bancaService.getListaConturi();
    }

    @PostMapping("adaugaCont")
    public ResponseEntity adaugaCont(@RequestBody ConturiView conturiView){
        return bancaService.adaugaCont(conturiView);
    }




//    @GetMapping("specificBank")
//    public ResponseEntity afiseazaBancaSpecifica(@RequestBody String nume, @RequestParam nume){
//        return bancaService.afiseazaDetaliiBanca(nume);
//    }

//    @PutMapping("modificaAdresaBanca")
//    public ResponseEntity modificaBanca(@RequestBody BancaView bancaView, @RequestParam ("nume") String adresa){
//        return bancaService.modificaAdresaBanca(bancaView, bancaView.getAdresa());
//    }


}
