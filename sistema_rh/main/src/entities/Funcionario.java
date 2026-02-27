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
    private Contracts contracts;

     public Funcionario (String name, Cargos cargo, String date, Contracts contracts) {
        this.name = name;
        this.cargo = cargo;
        this.salario = cargo.getSalario();
        this.dataAdmissao = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.contracts = contracts;
        this.ativo = true;
    }
      public Funcionario (String name, Cargos cargo, boolean isAdmittedToday, Contracts contracts) {
        this.name = name;
        this.cargo = cargo;
        this.salario = cargo.getSalario();
        this.dataAdmissao = LocalDate.now();
        this.contracts = contracts;
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
    public double getDescontoContratual() {
        return this.salario * this.contracts.getTaxaDesconto();
    }
    public double getTotalAReceber() {
        return (salario + valorHoraExtraTotal) - getDescontoContratual();
    }

     public double getValorHoraExtra() {
        return valorHoraExtraTotal;
    }
    public Cargos getCargo() {
        return cargo;
    }
    public Contracts getContracts() {
        return contracts;
    }
     public String getDataAdmissao() {
        return dataAdmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public double getValorHoraBase() {
        return this.salario / (this.contracts.getCargaSemanal() * 4.5);
    }
    


    public void setHorasTrab(double horas_trab) {
        double valorDaMinhaHora = getValorHoraBase();
        this.valorHoraExtraTotal += (horas_trab * valorDaMinhaHora * 1.5);
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
