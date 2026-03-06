package services.discountByContract;
import services.rules.RulesDiscount;

public class DiscountCLT implements RulesDiscount {
    @Override
    public double calcularDesconto(double salarioBruto) {
        return salarioBruto * 0.08;
    }

}
