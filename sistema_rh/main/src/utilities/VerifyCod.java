package utilities;

import java.util.Scanner;

public class VerifyCod {
    public static int verificaCod (int option, int primeiroParametro, int segundoParametro, Scanner sc) {
        do {
                if (option < primeiroParametro || option > segundoParametro) {
                    System.out.println("Codigo Invalido ");
                    System.out.println("Digite outro codigo");
                    option = sc.nextInt();
                }  
            } while (option < primeiroParametro || option > segundoParametro);
            return option;
    }
}
