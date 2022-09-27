package pacote;

public class Pessoa {
    String nome;
    int idade;
    long cpf;

    public void embarcar(Aeronave a){
        if(a.capacidadePassageiros > 0){
            a.capacidadePassageiros--;
            System.out.println("Embarcado");
        }
    }

    public void desembarcar(Aeronave a){
        a.capacidadePassageiros++;
        System.out.println("Desembarcado");
    }
}
