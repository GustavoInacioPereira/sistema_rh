package entities;

public class Cargos {
    
    private double salario, valor_base;
    private int codCargo;
    private String nameCargo;
    private static double valor_hora = 5.50, valorHoraLideranca = valor_hora + (40 * valor_hora) / 100;
    
    public Cargos (int codCargo, String nameCargo, double salario, double valor_base) {
        this.codCargo = codCargo;
        this.nameCargo = nameCargo;
        this.salario = salario;
        this.valor_base = valor_base;
    }

 

    public static final Cargos CEO = new Cargos(0, "CEO", 40000.00, valorHoraLideranca);
    public static final Cargos Gerente = new Cargos(1,"Gerente", 16000.00, valorHoraLideranca);
    public static final Cargos Supervisor = new Cargos(2, "Supervisor",6000.00, valorHoraLideranca);
    public static final Cargos Coordenador = new Cargos(3, "Coordenador", 4000.00, valorHoraLideranca);
    public static final Cargos Balconista = new Cargos(4,"Balconista", 2100.00, valor_hora);
    public static final Cargos Vendedor = new Cargos(5, "Vendedor", 1900.00, valor_hora);
    public static final Cargos Auxiliar_Limpeza = new Cargos(6,"Auxiliar de Limpeza", 1400.00, valor_hora);
    public static final Cargos Jovem_Aprendiz = new Cargos(7,"Jovem Aprendiz", 887.00, valor_hora);
    public static final Cargos[] tab_cod = { CEO, Gerente, Supervisor, Coordenador, Balconista, Vendedor,Auxiliar_Limpeza, Jovem_Aprendiz };
    
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
