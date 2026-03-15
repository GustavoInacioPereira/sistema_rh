package services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import entities.Funcionario;
import utilities.VerifyCodFun;

public class DeleteEmployee {
    public static void delete(Scanner sc, List<Funcionario> funcionarios) {
        int codFun = 0;
        codFun = VerifyCodFun.verificaCodFun(sc, funcionarios);
        Connection conn = DB.dbConnect();

        try (PreparedStatement pst = conn.prepareStatement("UPDATE employee SET isAtivo = ?, idAccount = ? WHERE idEmployee = ?")) {
            pst.setBoolean(1, Boolean.FALSE);
            pst.setNull(2, java.sql.Types.NULL);
            pst.setInt(3, funcionarios.get(codFun).getId());
            pst.executeUpdate();
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }

        try (PreparedStatement pst = conn.prepareStatement("DELETE FROM accountEmployee WHERE idAccount = ?;")) {
            pst.setInt(1, funcionarios.get(codFun).getAccount().getIdAccount());
            pst.executeUpdate();
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }

        funcionarios.remove(codFun);
        System.out.println("Funcionário excluído!");

    }
}
