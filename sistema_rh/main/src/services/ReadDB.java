package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Account;
import entities.Cargos;
import entities.Contracts;
import entities.Funcionario;

public class ReadDB {

    public static Cargos readCargoDB(int cargoID) {
        Connection conn = DB.dbConnect();
        Cargos cargoFind = null;
        try (PreparedStatement pst = conn.prepareStatement("SELECT * FROM cargos WHERE codCargo = ?")) {
            pst.setInt(1, cargoID);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    cargoFind = new Cargos(
                            rs.getInt("codCargo"),
                            rs.getString("nomeCargo"),
                            rs.getDouble("salario"),
                            rs.getBoolean("isLideranca"));
                }
            }

        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
        return cargoFind;
    }

    public static void setCargoList(List<Cargos> cargos) {
        Connection conn = DB.dbConnect();
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM cargos")) {
            while (rs.next()) {
                cargos.add(new Cargos(
                        rs.getInt("codCargo"),
                        rs.getString("nomeCargo"),
                        rs.getDouble("salario"),
                        rs.getBoolean("isLideranca")));
            }
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
    }

    public static Account readAccount(int accountID) {
        Connection conn = DB.dbConnect();
        Account accountFind = null;
        try (PreparedStatement pst = conn.prepareStatement("SELECT * FROM accountEmployee WHERE idAccount = ?")) {
            pst.setInt(1, accountID);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    accountFind = new Account(
                            rs.getInt("idAccount"),
                            rs.getString("login"),
                            rs.getString("senha"));
                }
            }

        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
        return accountFind;
    }

    public static void readEmployeeDB(List<Funcionario> funcionarios) {
        Connection conn = DB.dbConnect();
        try (Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM employee WHERE isAtivo = 1")) {
            while (rs.next()) {
                int idCargo = rs.getInt("idCargo");
                Cargos cargo = readCargoDB(idCargo);
                int idAccount = rs.getInt("idAccount");
                Account account = readAccount(idAccount);
                Contracts contract = Contracts.valueOf(rs.getString("contract"));

                funcionarios.add(new Funcionario(
                        rs.getInt("idEmployee"),
                        rs.getDouble("horasTrab"),
                        rs.getDouble("salario"),
                        rs.getString("nome"),
                        cargo,
                        rs.getBoolean("isAtivo"),
                        rs.getDouble("valorHoraExtra"),
                        rs.getDate("dataAdmissao").toLocalDate(),
                        contract,
                        account));

            }
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
    }
}
