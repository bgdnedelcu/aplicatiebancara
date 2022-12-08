package ro.aplicatiebancara.repo;

import org.springframework.stereotype.Component;
import ro.aplicatiebancara.view.CarduriView;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarduriRepo {

    private List<CarduriView> listaCarduri;

    public CarduriRepo() {
        listaCarduri = new ArrayList<>() {{
            add(new CarduriView(1, 123, 123, "RO394858391"));
            add(new CarduriView(2, 987, 467, "RO394858395"));
        }};
    }

    public List<CarduriView> getListaCarduri(){
        return listaCarduri;
    }
}