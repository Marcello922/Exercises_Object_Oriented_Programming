package model;

public class ConversorData {
    int ano, mes, dia;

    public ConversorData(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }


    protected int dataJuliana(){
        int diaJuliano;

        diaJuliano =  ( 1461 * ( ano + 4800 + ( mes - 14)/12 )  ) / 4 +
                    ( 367 * ( mes - 2- 12 * (  ( mes - 14)/12 )  ) ) /12 -
                    ( 3 * ( ( ano + 4900 + ( mes - 14 ) / 12 ) / 100 )  ) / 4 + dia - 32075;
        return diaJuliano;
    }
}
