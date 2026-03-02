package utilities;

import java.util.Scanner;

public class VerifyCod {
    public static int verificaCod (int primeiroParametro, int segundoParametro, Scanner sc) {
        int option = VerifyType.lerInt(sc, "Valor Inválido");
        do {
                if (option < primeiroParametro || option > segundoParametro) {
                    System.out.println("Codigo Invalido ");
                    System.out.println("Digite outro codigo");
                    option = sc.nextInt();
                    sc.nextLine();
                }  
            } while (option < primeiroParametro || option > segundoParametro);
            return option;
    }
    public static int verificaCod (int primeiroParametro, Scanner sc) {
        int option = VerifyType.lerInt(sc, "Valor Inválido");
        do {
                if (option <= primeiroParametro) {
                    System.out.println("Quantidade Invalida ");
                    System.out.println("Digite outra Quantidade");
                    option = sc.nextInt();
                    sc.nextLine();
                }  
            } while (option < primeiroParametro);
            return option;
    }
}
