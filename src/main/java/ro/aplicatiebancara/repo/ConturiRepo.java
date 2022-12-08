package ro.aplicatiebancara.repo;

import org.springframework.stereotype.Component;
import ro.aplicatiebancara.view.ConturiView;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConturiRepo {

    private List<ConturiView> listaConturi;

    public ConturiRepo() {
        listaConturi = new ArrayList<>() {{
            add(new ConturiView(1, 1, 2, 23300, "RO394858391"));
            add(new ConturiView(2, 2, 1, 67000, "RO394858345"));

        }};


    }

    public List<ConturiView> getListaConturi(){
        return listaConturi;
    }

}
