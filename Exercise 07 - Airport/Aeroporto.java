package pacote;

public class Aeroporto {
    int capacidadeAeronaves;
    String localização;
    boolean funcionando;

    public Aeroporto(int capacidadeAeronaves, String localização) {
        this.capacidadeAeronaves = capacidadeAeronaves;
        this.localização = localização;
        this.funcionando = true;
    }

    public void fechar(){
        funcionando = false;
    }
    public void abrir(){
        funcionando = true;
    }
}
