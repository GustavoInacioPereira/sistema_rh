package entities;

public class Funcionario {
    private int cod_fun;
    private double horas_trab;
    private double valor_hora = 5.50;
    private static String tab_cod[] = { "CEO", "Gerente", "Supervisor", "Coordenador", "Balconista", "Vendedor",
                "Auxiliar de Limpeza", "Jovem Aprendiz" };

    public int getCodFun() {
        return cod_fun;
    }
    public double getHorasTrab() {
        return horas_trab;
    }
    public static int getLengthTab_cod() {
        return tab_cod.length;
    }
     public String getCargoAtual() {
        return Funcionario.tab_cod[this.cod_fun];
     }


    public void setCodFun(int cod_fun) {
        this.cod_fun = cod_fun;
    }
    public void setHorasTrab(double horas_trab) {
        this.horas_trab = horas_trab;
    }
    public void setValorHora(double valor_hora) {
        this.valor_hora = valor_hora;
    }


    public Funcionario (int cod_fun, double horas_trab) {
        this.cod_fun = cod_fun;
        this.horas_trab = horas_trab;
    }

    public double calculo_pag () {
        double valorFinal = valor_hora;
        if (cod_fun < 4) {
                valorFinal += (40 * valor_hora) / 100;
            }   
        return horas_trab * valorFinal;
    }

}
