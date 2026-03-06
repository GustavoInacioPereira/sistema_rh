package entities;


public enum Cargos {

    CEO(0, "CEO", 40000.00, true),
    GERENTE(1,"Gerente", 16000.00, true),
    SUPERVISOR(2, "Supervisor",6000.00, true),
    COORDENADOR(3, "Coordenador", 4000.00, true),
    BALCONISTA(4,"Balconista", 2100.00, false),
    VENDEDOR(5, "Vendedor", 1900.00, false),
    AUXILIAR_LIMPEZA(6,"Auxiliar de Limpeza", 1400.00, false); 


    private double salario;
    private int codCargo;
    private String nameCargo;
    private boolean isLideranca;
    
        Cargos (int codCargo, String nameCargo, double salario, boolean isLideranca) {
        this.codCargo = codCargo;
        this.nameCargo = nameCargo;
        this.salario = salario;
        this.isLideranca = isLideranca;
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
    public boolean getIsLideranca() {
        return isLideranca;
    }
   
   


}


