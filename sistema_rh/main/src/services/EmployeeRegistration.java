package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import entities.Cargos;
import entities.Funcionario;
import utilities.VerifyCod;
import utilities.VerifyType;
import entities.Contracts;

public class EmployeeRegistration {
    
    public static void cadastroFuncionario(Scanner sc, List<Funcionario> funcionarios, List<Cargos> cargos, int quanFun) {
        
        for (int indice = 0; indice < quanFun; indice++) {
            LocalDate date = null;
            
            System.out.printf("Digite seu nome: %n");
            String name = sc.nextLine();
            
            System.out.printf("Digite o codigo do seu cargo: %n");
            for (int j = 0; j < cargos.size(); j++) {
                System.out.printf("%d - %s%n", j, cargos.get(j).getNameCargo());
            }
            int codCargo = VerifyCod.verificaCod(0, (cargos.size() - 1), sc);
            Cargos cargoSelecionado = cargos.get(codCargo);

            System.out.printf("Digite o Regime de Trabalho: %n");
            for (int i = 0; i < Contracts.values().length; i++) {
                System.out.printf("%d - %s%n", i + 1, Contracts.values()[i]);
            }
            int optionRegime = VerifyCod.verificaCod(1, Contracts.values().length, sc);
            
            Contracts escolhaRegimeContrato = Contracts.values()[optionRegime - 1]; 

            System.out.printf("Digite a opção abaixo: %n1 - Admitido na data de Hoje %n2 - Admitido em outra data %n");
            int optionAdmissao = VerifyCod.verificaCod(1, 2, sc);

            if (optionAdmissao == 1) {
                date = LocalDate.now();
            } else {
                System.out.printf("Digite a data de admissão: (dd/MM/yyyy) %n");
                date = VerifyType.verifyDate(sc);
            }

            Connection conn = DB.dbConnect();
            try {
                
                Integer idContaGerada = null;
                String loginDigitado = null;
                String senhaDigitada = null;

                
                if (cargoSelecionado.getIsLideranca()) {
                    System.out.printf("Cargo de Liderança Detectado! %nRealize cadastro para acessar o Painel Administrativo %n");
                    System.out.printf("Digite o Login: %n");
                    loginDigitado = sc.nextLine();
                    System.out.printf("Digite a Senha: %n");
                    senhaDigitada = sc.nextLine();

                    String sqlAccount = "INSERT INTO accountemployee (login, senha) VALUES (?, ?)";
                    try (PreparedStatement pstAcc = conn.prepareStatement(sqlAccount, Statement.RETURN_GENERATED_KEYS)) {
                        pstAcc.setString(1, loginDigitado);
                        pstAcc.setString(2, senhaDigitada);
                        pstAcc.executeUpdate();
                        
                        try (ResultSet rsAcc = pstAcc.getGeneratedKeys()) {
                            if (rsAcc.next()) {
                                idContaGerada = rsAcc.getInt(1);
                            }
                        }
                    }
                }

                String sqlEmp = "INSERT INTO employee (nome, salario, horasTrab, valorHoraExtra, contract, dataAdmissao, isAtivo, idCargo, idAccount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                try (PreparedStatement pst = conn.prepareStatement(sqlEmp, Statement.RETURN_GENERATED_KEYS)) {
                    pst.setString(1, name);
                    pst.setDouble(2, cargoSelecionado.getSalario());
                    pst.setDouble(3, 0.0);
                    pst.setDouble(4, 0.0);
                    pst.setString(5, escolhaRegimeContrato.name());
                    pst.setDate(6, java.sql.Date.valueOf(date));
                    pst.setBoolean(7, Boolean.TRUE);
                    pst.setInt(8, cargoSelecionado.getCodCargo());
                    
                    if (idContaGerada != null) {
                        pst.setInt(9, idContaGerada);
                    } else {
                        pst.setNull(9, java.sql.Types.INTEGER);
                    }

                    pst.executeUpdate();

                    try (ResultSet rsEmp = pst.getGeneratedKeys()) {
                        if (rsEmp.next()) {
                            int idGenerate = rsEmp.getInt(1);
                            
                            Funcionario novoFuncionario = new Funcionario(idGenerate, name, cargoSelecionado, date, escolhaRegimeContrato);
                            
                            if (idContaGerada != null) {
                                novoFuncionario.setAccount(loginDigitado, senhaDigitada);
                            }                        
                            funcionarios.add(novoFuncionario);
                            System.out.printf("Funcionario Cadastrado com Sucesso! %n");
                        }
                    }
                }

            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}