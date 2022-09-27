package pacote;

public class Piloto extends Pessoa{
    int horasdeVoo;
    double salario;

    public Piloto(int horasdeVoo, double salario) {
        this.horasdeVoo = horasdeVoo;
        this.salario = salario;
    }

    private void pilotar(Aeronave a){
        if(a.temPiloto){
            System.out.println("Aeronave já possui piloto!");
        }else{
            a.temPiloto = true;
            System.out.println();
        }
    }

    @Override
    public void embarcar(Aeronave a){
        if(a.capacidadePassageiros > 0){
            System.out.println("Embarcado");
            pilotar(a);
        }
    }

    @Override
    public void desembarcar(Aeronave a){
        a.capacidadePassageiros++;
        a.temPiloto = false;
        System.out.println("Desembarcado");
    }
}
