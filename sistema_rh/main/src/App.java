import java.util.Scanner;
import entities.Funcionario;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Funcionario fun = new Funcionario();

        String tab_cod[] = { "CEO", "Gerente", "Supervisor", "Coordenador", "Balconista", "Vendedor",
                "Auxiliar de Limpeza", "Jovem Aprendiz" };

        IO.print("Digite seu codigo de funcionario: ");
        fun.cod_fun  = sc.nextInt();

        while (fun.cod_fun > tab_cod.length - 1 || fun.cod_fun < 0) {
            IO.println("Codigo de Funcionario Inexistente");
            IO.print("Digite novamente seu codigo de funcionario: ");
             fun.cod_fun = sc.nextInt();
        }

        IO.print("Digite a quantidade de horas trabalhadas: ");
        fun.horas_trab = sc.nextInt();

            System.out.printf("Olá %s o valor a receber é de: R$%.2f" , tab_cod[fun.cod_fun], fun.calculo_pag());
            sc.close();
        } 
}
