package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Funcionario;
import services.EmployeeRegistration;
import utilities.VerifyCod;
import views.ViewOption;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int quanFun;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        System.out.println("Digite a Quantidade de funcionarios a serem cadastrados: ");
        quanFun = VerifyCod.verificaCod(0, sc);
      
        EmployeeRegistration.cadastroFuncionario(sc, funcionarios, quanFun);        
        ViewOption.mostraOpcao(sc, funcionarios);
        sc.close();       
        } 
}
