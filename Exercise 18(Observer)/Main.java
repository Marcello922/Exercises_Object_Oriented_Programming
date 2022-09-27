package observer;

public class Main {

    public static void main(String[] args) {
        SuperInteressante sp = new SuperInteressante();
        Leitor l = new Leitor();
        sp.registrar(l);
        sp.publicarArtigo("Fatec ZL faz parceria com o MIT para desenvolvimento de novas tecnologias");
    }
}
