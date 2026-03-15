package entities;

import services.discountByContract.DiscountCLT;
import services.discountByContract.DiscountPJ;
import services.overtimeByContract.OvertimeCLT;
import services.rules.RulesDiscount;
import services.rules.RulesPayOvertime;

public enum Contracts {
    CLT("CLT", true, true, true, 44, new DiscountCLT(), new OvertimeCLT()),
    PJ("PJ", false, false, false, new DiscountPJ()),
    ESTAGIO("ESTAGIO", false, true, true, 30, new DiscountPJ(), new OvertimeCLT()),
    TEMPORARIO("TEMPORARIO",true, false, true, 44, new DiscountCLT(), new OvertimeCLT());

    private String nameContract;
    private boolean fgts, direitoFerias, permiteHorasExtras;
    private int cargaSemanal;
    private RulesDiscount taxaDesconto;
    private RulesPayOvertime valorHorasExtrasPorContrato;
    

    Contracts (String nameContract, boolean fgts, boolean direitoFerias, boolean permiteHorasExtras, int cargaSemanal, RulesDiscount taxaDesconto, RulesPayOvertime valorHorasExtrasPorContrato) {
        this.nameContract = nameContract;
        this.fgts = fgts;
        this.direitoFerias = direitoFerias;
        this.permiteHorasExtras = permiteHorasExtras;
        this.cargaSemanal = cargaSemanal;
        this.taxaDesconto = taxaDesconto;
        this.valorHorasExtrasPorContrato = valorHorasExtrasPorContrato;
    }

    Contracts (String nameContract, boolean fgts, boolean direitoFerias, boolean permiteHorasExtras, RulesDiscount taxaDesconto) {
        this.nameContract = nameContract;
        this.fgts = fgts;
        this.direitoFerias = direitoFerias;
        this.permiteHorasExtras = permiteHorasExtras;
        this.taxaDesconto = taxaDesconto;
        this.cargaSemanal = 0;
        this.valorHorasExtrasPorContrato = null;
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
    public boolean isPermiteHoraExtra() {
        return permiteHorasExtras;
    }

}
