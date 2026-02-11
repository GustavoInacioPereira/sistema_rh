import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cod, hr;
        double pag;
        String tab_cod[] = { "CEO", "Gerente", "Supervisor", "Coordenador", "Balconista", "Vendedor",
                "Auxiliar de Limpeza", "Jovem Aprendiz" };

        IO.print("Digite seu codigo de funcionario: ");
        cod = sc.nextInt();

        while (cod > tab_cod.length - 1 || cod < 0) {
            IO.println("Codigo de Funcionario Inexistente");
            IO.print("Digite novamente seu codigo de funcionario: ");
            cod = sc.nextInt();
        }

        IO.print("Digite a quantidade de horas trabalhadas: ");
        hr = sc.nextInt();

            if (cod < 4) {
                pag = 5.50 + (40 * 5.50) / 100;
            } else {
                pag = 5.50;
            }

            System.out.printf("Olá " + tab_cod[cod] + " o valor a receber é de: " + hr * pag);
            sc.close();
        } 
}
