package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class VerifyType {
   

    public static int lerInt(Scanner sc, String mensagemErro) {
        while (true) {
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println(mensagemErro);
            }
        }
    }
    public static double lerDouble(Scanner sc, String mensagemErro) {
        while (true) {
            try {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println(mensagemErro);
            }
        }
    }

    public static LocalDate verifyDate (Scanner sc) {       
        while (true) {
            try {
                LocalDate date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));;
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Data Inválida");
            }
        }
    }
}
