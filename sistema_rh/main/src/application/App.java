package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Funcionario;



public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int quanFun;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        do {
            System.out.println("Digite a Quantidade de funcionarios a serem cadastrados: ");
            quanFun = sc.nextInt();
            if(quanFun < 0) {
                System.out.println("Quantidade Invalida");
            }
        } while(quanFun < 0);
        for(int i = 0; i < quanFun; i++) { 
            EmployeeRegistration.cadastroFuncionario(sc, funcionarios);
        }

        AuthenticateFun.autenticarFun(sc, funcionarios);
        

        sc.close();       
        } 
}
