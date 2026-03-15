package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import entities.Funcionario;
import utilities.VerifyCodFun;
import utilities.VerifyType;

public class ExtraHour {
    public static void set(Scanner sc, List<Funcionario> funcionarios) {
        int codFun = 0;
        codFun = VerifyCodFun.verificaCodFun(sc, funcionarios);
        Connection conn = DB.dbConnect();

        System.out.println("Digite a Quantidade de Horas extras: ");
        double horasExtras = VerifyType.lerDouble(sc, "Valor Inválido");

        if (!funcionarios.get(codFun).getContracts().isPermiteHoraExtra()) {
                System.out.println("Não é permitido registro de horas extras para o regime " + funcionarios.get(codFun).getContracts().getNameContract());  
                return;
        } else {
            funcionarios.get(codFun).setHorasTrab(horasExtras);
            try (PreparedStatement pst = conn
                    .prepareStatement("UPDATE employee SET horasTrab = ?, valorHoraExtra = ? WHERE idEmployee = ?")) {
                pst.setDouble(1, funcionarios.get(codFun).getHorasTrab());
                pst.setDouble(2, funcionarios.get(codFun).getValorHoraExtra());
                pst.setInt(3, funcionarios.get(codFun).getId());
                pst.executeUpdate();
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }

        }

    }
}
