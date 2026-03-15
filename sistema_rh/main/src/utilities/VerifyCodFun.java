package utilities;

import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class VerifyCodFun {
    
    // Removi o 'codFun' dos parâmetros, pois ele é lido aqui dentro
    public static int verificaCodFun(Scanner sc, List<Funcionario> funcionarios) {
        int idDigitado;
        int indexEncontrado = -1;

        do {
            System.out.println("Digite o codigo (ID) do funcionario: ");
            idDigitado = VerifyType.lerInt(sc, "Valor Inválido");
            
           
            for (int i = 0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i).getId() == idDigitado) {
                    indexEncontrado = i;
                    break; 
                }
            }

            if (indexEncontrado == -1) {
                System.out.printf("Código Inválido! Nenhum funcionário com ID %d foi encontrado.%n", idDigitado);
            }

        } while (indexEncontrado == -1); 

        
        return indexEncontrado; 
    }
}