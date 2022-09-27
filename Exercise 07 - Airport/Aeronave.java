package pacote;

public class Aeronave {
    String modelo;
    int capacidadePassageiros;
    double capacidadeCombustivel;
    boolean voando,temPiloto;

    public Aeronave(String modelo, int capacidadePassageiros, double capacidadeCombustivel) {
        this.modelo = modelo;
        this.capacidadePassageiros = capacidadePassageiros;
        this.capacidadeCombustivel = capacidadeCombustivel;
        voando = false;
        temPiloto = false;
    }

    public void aterrisar(Aeroporto a){
        if(a.funcionando){
            voando = false;
            System.out.println("Pousou");
        }else{
            System.out.println("Aeroporto fechado");
        }
    }
    public void decolar(Aeroporto a){
        if(!temPiloto){
            System.out.println("Não há píloto");
        } else if(!a.funcionando){
            System.out.println("Aeroporto fechado");
        } else if(voando){
            System.out.println("Aeronave já está voando");
        }
        else{
            voando = true;
            System.out.println("Decolou");
        }
    }
}
