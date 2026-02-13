import java.util.Scanner;
import entities.Funcionario;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        IO.print("Digite seu codigo de funcionario: ");
        int cod_fun  = sc.nextInt();

        while (cod_fun > Funcionario.getLengthTab_cod() - 1 || cod_fun < 0) {
            IO.println("Codigo de Funcionario Inexistente");
            IO.print("Digite novamente seu codigo de funcionario: ");
            cod_fun = sc.nextInt();
        }

        IO.print("Digite a quantidade de horas trabalhadas: ");
        double horas_trab = sc.nextInt();

        Funcionario fun = new Funcionario(cod_fun, horas_trab);
        System.out.printf("Olá %s o valor a receber é de: R$%.2f" , fun.getCargoAtual(), fun.calculo_pag());
        sc.close();
        } 
}
