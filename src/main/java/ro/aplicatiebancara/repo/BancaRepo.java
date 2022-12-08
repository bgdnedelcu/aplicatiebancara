package ro.aplicatiebancara.repo;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ro.aplicatiebancara.view.BancaView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class BancaRepo {

    private List<BancaView> lista;



    public BancaRepo() {
        lista = new ArrayList<>() {{
           add(new BancaView(1, "BT", "Siderurgistilor", "BTRO"));
           add(new BancaView(2, "BRD", "Centru", "BRDROBU"));
           add(new BancaView(3, "CEC", "La General", "CECBNK"));
        }};
    }

    public List<BancaView> getLista() {
        return lista;
    }
}
