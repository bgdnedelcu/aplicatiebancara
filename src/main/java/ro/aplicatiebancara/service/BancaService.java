package ro.aplicatiebancara.service;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ro.aplicatiebancara.repo.BancaRepo;
import ro.aplicatiebancara.repo.ConturiRepo;
import ro.aplicatiebancara.repo.PersoaneRepo;
import ro.aplicatiebancara.view.BancaView;
import ro.aplicatiebancara.view.ConturiView;
import ro.aplicatiebancara.view.PersoaneView;

import java.util.ArrayList;
import java.util.List;

@Service
public class BancaService {

    private BancaRepo bancaRepo;
    private PersoaneRepo persoaneRepo;
    private ConturiRepo conturiRepo;

    @Autowired
    public BancaService(BancaRepo bancaRepo, PersoaneRepo persoaneRepo, ConturiRepo conturiRepo) {
        this.bancaRepo = bancaRepo;
        this.persoaneRepo = persoaneRepo;
        this.conturiRepo = conturiRepo;
    }
    public ResponseEntity adaugaBanca(BancaView bancaView) {
        bancaRepo.getLista().add(bancaView);
        return ResponseEntity.ok("banca a fost adaugata");
    }

    public List<BancaView> getBanci() {
        return bancaRepo.getLista();
    }

    public BancaView afiseazaOBanca(BancaView bancaView) {
        return bancaView;
    }

//    public BancaView afiseazaDetaliiBanca(List<BancaView> lista, String nume) {
//        BancaView banca = null;
//        for(BancaView bank : bancaRepo.getLista()){
//            if (bank)
//        }
////        if(bancaRepo.getLista().isEmpty())
////            return ResponseEntity.badRequest().body("lista cu banci e goala");
//        for (BancaView banca : bancaRepo.getLista()) {
//            if (nume.equals(banca.getNumeBanca())) {
//                afiseazaOBanca(banca);
//            }
//        }
//        return
////        return ResponseEntity.badRequest().body("banca nu exista");
//
//    }

//    public ResponseEntity modificaAdresaBanca(BancaView bancaView, String nume){
//        if(bancaRepo.getLista().isEmpty())
//            return ResponseEntity.badRequest().body("lista cu banci e goala");
//        for(BancaView banca : bancaRepo.getLista()){
//            if(adresa.equals(bancaView.getAdresa())){
//                banca.setAdresa(bancaView.getAdresa());
//                return ResponseEntity.ok("adresa a fost modificata");
//            }
//
//        }
//        return ResponseEntity.badRequest().body("banca nu exista");
//    }

    public String afiseazaNumeBanca(Integer id){
        BancaView bancaView = null;
        String numebanca = null;
        for(BancaView banca : bancaRepo.getLista()){
            if(banca.getId() == id) {
                bancaView = banca;
                numebanca = banca.getNumeBanca();
                bancaView.setNumeBanca(numebanca);
            }
        }
        return bancaView.getNumeBanca();
    }

    public List<PersoaneView> afiseazaPersoane(){
        return persoaneRepo.getListaPersoane();
    }

    public ResponseEntity adaugaPersoana(PersoaneView persoana){
       persoaneRepo.getListaPersoane().add(persoana);
       return ResponseEntity.ok("Persoana a fost adaugata");
    }

    public List<ConturiView> getListaConturi(){
        return conturiRepo.getListaConturi();

    }

    public ResponseEntity adaugaCont(ConturiView conturiView){
        conturiRepo.getListaConturi().add(conturiView);
        return ResponseEntity.ok("Contul a fost adaugat");
    }


}