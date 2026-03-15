package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario {
    private Integer id;
    private double horas_trab, salario;
    private String name;
    private Cargos cargo;
    private boolean ativo;
    private double valorHoraExtraTotal;
    private LocalDate dataAdmissao;
    private Contracts contracts;
    private Account account;

    public Funcionario(Integer id, String name, Cargos cargo, LocalDate date, Contracts contracts) {
        this.id = id;
        this.name = name;
        this.cargo = cargo;
        this.salario = cargo.getSalario();
        this.dataAdmissao = date;
        this.contracts = contracts;
        this.ativo = true;
    }

    //Constructor do Banco de Dados para a RAM
    public Funcionario(Integer id, Double horas_trab, Double salario, String name, Cargos cargo, boolean ativo, Double valorHoraExtraTotal, LocalDate dataAdmissao, Contracts contracts, Account account) {
        this.id = id;
        this.name = name;
        this.salario = salario;
        this.horas_trab = horas_trab;
        this.valorHoraExtraTotal = valorHoraExtraTotal;
        this.ativo = ativo;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        this.contracts = contracts;
        this.account = account;
    }

    public double getHorasTrab() {
        return horas_trab;
    }
    public Integer getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public double getSalario() {
        return salario;
    }

    public double getDescontoContratual() {
        return this.contracts.getTaxaDesconto().calcularDesconto(this.salario);
    }

    public double getTotalAReceber() {
        double valorExtraValido = this.contracts.isPermiteHoraExtra() ? this.valorHoraExtraTotal : 0.0; 
        return (this.salario + valorExtraValido) - getDescontoContratual();

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
        int carga = this.contracts.getCargaSemanal();      
        if (carga == 0) {
            return 0.0; 
        }

        return this.salario / (carga * 4.5);
    }

    public void setHorasTrab(double horas_trab) {
        double valorHoraBase = this.getValorHoraBase();
        double dinheiroExtra = this.contracts.getValorHorasExtrasPorContrato().calcularHoraExtra(valorHoraBase, horas_trab);
        this.valorHoraExtraTotal += dinheiroExtra;
        this.horas_trab += horas_trab;
    }

    public void setSalarioBruto(double aumento) {
        this.salario += aumento;
    }

    public void setAccount(String loginDigitado, String senhaDigitada) {
        this.account = new Account(loginDigitado, senhaDigitada);
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
        this.salario = cargo.getSalario();
    }

    public void setSalarioPorcentagem(double aumento) {
        double valorDoAcrescimo = (this.salario * aumento) / 100;
        this.salario += valorDoAcrescimo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public void setId(int id) {
        this.id = id;
    }

}
