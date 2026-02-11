package entities;
public class Funcionario {
    public int cod_fun;
    public double horas_trab;
    
    public double calculo_pag () {
        
        double valor_hora = 5.50;
        
        if (cod_fun < 4) {
                valor_hora += (40 * valor_hora) / 100;
            } 
        
        return horas_trab * valor_hora;
    }

}
