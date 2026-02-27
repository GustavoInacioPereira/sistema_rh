package entities;

public enum Contracts {
    CLT("CLT", true, true, 44, 0.08),
    PJ("PJ", false, false, 40, 0.0),
    ESTAGIO("ESTAGIO", false, true, 30, 0.0),
    TEMPORARIO("TEMPORARIO",true, false, 44, 0.08);

    private String nameContract;
    private boolean fgts, direitoFerias;
    private int cargaSemanal;
    private double taxaDesconto;
    

    Contracts (String nameContract, boolean fgts, boolean direitoFerias, int cargaSemanal, double taxaDesconto) {
        this.nameContract = nameContract;
        this.fgts = fgts;
        this.direitoFerias = direitoFerias;
        this.cargaSemanal = cargaSemanal;
        this.taxaDesconto = taxaDesconto;
    }

    public String getNameContract() {
        return nameContract;
    }
     public boolean getFGTS() {
        return fgts;
    }
     public boolean getDireitoFerias() {
        return direitoFerias;
    }
     public int getCargaSemanal() {
        return cargaSemanal;
    }
     public double getTaxaDesconto() {
        return taxaDesconto;
    }

}
