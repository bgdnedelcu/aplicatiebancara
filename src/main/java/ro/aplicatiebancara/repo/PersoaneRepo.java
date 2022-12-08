package ro.aplicatiebancara.repo;

import org.springframework.stereotype.Component;
import ro.aplicatiebancara.view.PersoaneView;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersoaneRepo {

    private List<PersoaneView> listaPersoane;

    public PersoaneRepo(){
        listaPersoane = new ArrayList<>() {{
            add(new PersoaneView(1, "Nedelcu", "Bogdan", "Schela", "1990127170029"));

    }};
    }

    public List<PersoaneView> getListaPersoane(){
        return listaPersoane;
    }

}
