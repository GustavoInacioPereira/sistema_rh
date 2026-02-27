package entities;


public enum Cargos {

    CEO(0, "CEO", 40000.00, true),
    GERENTE(1,"Gerente", 16000.00, true),
    SUPERVISOR(2, "Supervisor",6000.00, true),
    COORDENADOR(3, "Coordenador", 4000.00, true),
    BALCONISTA(4,"Balconista", 2100.00, false),
    VENDEDOR(5, "Vendedor", 1900.00, false),
    AUXILIAR_LIMPEZA(6,"Auxiliar de Limpeza", 1400.00, false); 


    private double salario, valor_base;
    private int codCargo;
    private String nameCargo;
    private double valor_hora = 5.50;
    
        Cargos (int codCargo, String nameCargo, double salario, boolean isLideranca) {
        this.codCargo = codCargo;
        this.nameCargo = nameCargo;
        this.salario = salario;
        this.valor_base = isLideranca ?  valor_hora + (40 * valor_hora) / 100 : valor_hora;
    }

 

    public int getCodCargo() {
        return codCargo;
    }
    public String getNameCargo() {
        return nameCargo;
    }
    public double getSalario() {
        return salario;
    }
    public double getValorHora() {
        return valor_base;
    }
   
   


}


