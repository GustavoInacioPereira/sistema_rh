package entities;


public class Cargos {


    private Double salario;
    private int codCargo;
    private String nameCargo;
    private boolean isLideranca;
    
        public Cargos (int codCargo, String nameCargo, double salario, boolean isLideranca) {
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


