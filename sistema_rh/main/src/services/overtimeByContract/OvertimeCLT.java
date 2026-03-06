package services.overtimeByContract;
import services.rules.RulesPayOvertime;

public class OvertimeCLT implements RulesPayOvertime{
    @Override
    public double calcularHoraExtra(double valorDaHora, double horasTrabalhadas) {
        return (horasTrabalhadas * valorDaHora * 1.5);
    }

}
