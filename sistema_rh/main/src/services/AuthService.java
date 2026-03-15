package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DB;
import db.DbException;

public class AuthService {

    public static boolean autenticarLider(String login, String senha) {
        Connection conn = DB.dbConnect();
        
        
        String sql = """
            SELECT e.idEmployee 
            FROM employee e 
            INNER JOIN accountEmployee a ON e.idAccount = a.idAccount 
            INNER JOIN cargos c ON e.idCargo = c.codCargo 
            WHERE a.login = ? AND a.senha = ? AND e.isAtivo = 1 AND c.isLideranca = 1
            """;
                     
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, login);
            pst.setString(2, senha);
            
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next(); 
            }
            
        } catch (Exception e) {
            throw new DbException("Falha crítica no serviço de autenticação: " + e.getMessage());
        }
    }
}