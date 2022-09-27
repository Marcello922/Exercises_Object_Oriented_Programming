package pacote;

public class Main {
    static Pessoa piloto = new Piloto(100,7000);
    static Pessoa passageiro = new Passageiro("Roberto",21,"São Paulo");
    static Aeronave aeronave = new Aeronave("Boeing 737",180,20000);
    static Aeroporto Congonhas = new Aeroporto(300,"São Paulo");

    static Pessoa piloto2 = new Piloto(100,7000);
    static Pessoa passageiro2 = new Passageiro("Roberto",21,"São Paulo");
    static Aeronave aeronave2 = new Aeronave("Boeing 737",180,20000);
    static Aeroporto Guarulhos = new Aeroporto(300,"Guarulhos");

    public static void main(String[] args) {
        piloto.embarcar(aeronave);
        passageiro.embarcar(aeronave);
        aeronave.decolar(Congonhas);
        aeronave.aterrisar(Guarulhos);
        Guarulhos.fechar();

        passageiro2.embarcar(aeronave2);
        aeronave2.decolar(Guarulhos);
        piloto2.embarcar(aeronave2);
        aeronave2.decolar(Guarulhos);
        Guarulhos.abrir();
        aeronave2.decolar(Guarulhos);
    }

}
