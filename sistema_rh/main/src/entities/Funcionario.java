package entities;

public class Funcionario {
    private double horas_trab, salario;
    private String name;
    private Cargos cargo;
    private boolean ativo;
    private double valorHoraExtraTotal;



     public Funcionario (String name, Cargos cargo) {
        this.name = name;
        this.cargo = cargo;
        this.salario = cargo.getSalario();
        this.ativo = true;
    }

    
    

    public double getHorasTrab() {
        return horas_trab;
    }
    public String getName() {
        return name;
    }
    public double getSalario() {
        return salario;
    }
     public double getTotalAReceber() {
        return salario + valorHoraExtraTotal;
    }
     public double getValorHoraExtra() {
        return valorHoraExtraTotal;
    }
    public Cargos getCargo() {
        return cargo;
    }
    
    public void setHorasTrab(double horas_trab) {
        
        double valorDaMinhaHora = this.cargo.getValorHora();
        this.valorHoraExtraTotal += (horas_trab * valorDaMinhaHora);

        this.horas_trab += horas_trab;

    }
    public void setSalarioBruto(double aumento) {
        this.salario += aumento;
    }
    public void setSalarioPorcentagem(double aumento) {
        double valorDoAcrescimo = (this.salario * aumento) / 100;
        this.salario += valorDoAcrescimo;
    }

   
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }


}
