package entities;

import services.discountByContract.DiscountCLT;
import services.discountByContract.DiscountPJ;
import services.overtimeByContract.OvertimeCLT;
import services.overtimeByContract.OvertimePJ;
import services.rules.RulesDiscount;
import services.rules.RulesPayOvertime;

public enum Contracts {
    CLT("CLT", true, true, 44, new DiscountCLT(), new OvertimeCLT()),
    PJ("PJ", false, false, 40, new DiscountPJ(), new OvertimePJ()),
    ESTAGIO("ESTAGIO", false, true, 30, new DiscountPJ(), new OvertimeCLT()),
    TEMPORARIO("TEMPORARIO",true, false, 44, new DiscountCLT(), new OvertimeCLT());

    private String nameContract;
    private boolean fgts, direitoFerias;
    private int cargaSemanal;
    private RulesDiscount taxaDesconto;
    private RulesPayOvertime valorHorasExtrasPorContrato;
    

    Contracts (String nameContract, boolean fgts, boolean direitoFerias, int cargaSemanal, RulesDiscount taxaDesconto, RulesPayOvertime valorHorasExtrasPorContrato) {
        this.nameContract = nameContract;
        this.fgts = fgts;
        this.direitoFerias = direitoFerias;
        this.cargaSemanal = cargaSemanal;
        this.taxaDesconto = taxaDesconto;
        this.valorHorasExtrasPorContrato = valorHorasExtrasPorContrato;
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
     public RulesDiscount getTaxaDesconto() {
        return taxaDesconto;
    }
    public RulesPayOvertime getValorHorasExtrasPorContrato () {
        return valorHorasExtrasPorContrato;
    }

}
