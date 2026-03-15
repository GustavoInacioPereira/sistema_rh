package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import entities.Cargos;
import entities.Funcionario;
import utilities.VerifyCod;
import utilities.VerifyCodFun;

public class Promotion {
    public static void promocao(int codFun, List<Funcionario> funcionarios, List<Cargos> cargos, Scanner sc) {
        Connection conn = DB.dbConnect();
        String loginDigitado = null, senhaDigitada = null;
        int idContaGerada = 0;
        codFun = VerifyCodFun.verificaCodFun(sc, funcionarios);
        Funcionario f = funcionarios.get(codFun);
        System.out.printf("Digite o Codigo do Cargo: %n");
        for (int l = 0; l < cargos.size(); l++) {
            System.out.printf("%d - %s%n", l, cargos.get(l).getNameCargo());
        }
        int codCargo = VerifyCod.verificaCod(0, cargos.size(), sc);

        if (cargos.get(codCargo).getIsLideranca() && f.getAccount() == null) {
            System.out
                    .printf("Cargo de Liderança Detectado %nRealize cadastro para acessar o Painel Administrativo %n");
            System.out.printf("Digite o Login: %n");
            loginDigitado = sc.nextLine();
            System.out.printf("Digite a Senha: %n");
            senhaDigitada = sc.nextLine();

            try (PreparedStatement pst = conn.prepareStatement("INSERT INTO accountEmployee (login, senha) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                pst.setString(1, loginDigitado);
                pst.setString(2, senhaDigitada);
                pst.executeUpdate();
                try (ResultSet rsAcc = pst.getGeneratedKeys()) {
                    if (rsAcc.next()) {
                        idContaGerada = rsAcc.getInt(1);
                    }
                }
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
            f.setAccount(loginDigitado, senhaDigitada);

        }

        if (idContaGerada > 0) {
            try (PreparedStatement pst = conn.prepareStatement("UPDATE employee SET idAccount = ? WHERE idEmployee = ?")) {
                pst.setInt(1, idContaGerada);
                pst.setInt(2, f.getId());
                pst.executeUpdate();
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }

        try (PreparedStatement pst = conn.prepareStatement("UPDATE employee SET idCargo = ?, salario = ? WHERE idEmployee = ?")) {
            pst.setInt(1, cargos.get(codCargo).getCodCargo());
            pst.setDouble(2, cargos.get(codCargo).getSalario());
            pst.setInt(3, f.getId());
            pst.executeUpdate();


        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }

            f.setCargo(cargos.get(codCargo));
            funcionarios.get(codFun).setCargo(cargos.get(codCargo));


    }
}
