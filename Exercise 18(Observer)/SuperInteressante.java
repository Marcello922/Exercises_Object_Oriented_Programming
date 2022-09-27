package observer;

import java.util.ArrayList;
import java.util.List;

public class SuperInteressante implements Revista {
    List<Leitor> assinantes = new ArrayList<Leitor>();
    String str = "";


    public void publicarArtigo(String artigo){
        str = artigo;
        notificar();
    }

    @Override
    public String artigo() {
        return str;
    }

    @Override
    public void notificar() {
        for (Leitor l:assinantes){
            l.update(this);
        }
    }

    @Override
    public void registrar(Observer o) {
        assinantes.add((Leitor) o);
    }
}
