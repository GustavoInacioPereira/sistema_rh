package services.overtimeByContract;
import services.rules.RulesPayOvertime;

public class OvertimePJ implements RulesPayOvertime{
    @Override
    public double calcularHoraExtra(double valorDaHora, double horasTrabalhadas) {
        return (horasTrabalhadas * valorDaHora * 1.0);
    }

}
