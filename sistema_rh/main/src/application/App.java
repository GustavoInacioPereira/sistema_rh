package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.DB;
import entities.Cargos;
import entities.Funcionario;

import services.ReadDB;

import views.ViewOption;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            List<Cargos> cargos = new ArrayList<Cargos>();
            ReadDB.setCargoList(cargos);
            ReadDB.readEmployeeDB(funcionarios);
            ViewOption.mostraOpcao(sc, funcionarios, cargos);
            sc.close();
            
        } catch (Exception e) {
            DB.dbClose();
            System.out.println("Erro fatal");
        }

    }
}
