package entities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Funcionario {
    private double horas_trab, salario;
    private String name;
    private Cargos cargo;
    private boolean ativo;
    private double valorHoraExtraTotal;
    private LocalDate dataAdmissao;

     public Funcionario (String name, Cargos cargo, String date) {
        this.name = name;
        this.cargo = cargo;
        this.salario = cargo.getSalario();
        this.dataAdmissao = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.ativo = true;
    }
      public Funcionario (String name, Cargos cargo, boolean isAdmittedToday) {
        this.name = name;
        this.cargo = cargo;
        this.salario = cargo.getSalario();
        this.dataAdmissao = LocalDate.now();
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
     public String getDataAdmissao() {
        return dataAdmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
