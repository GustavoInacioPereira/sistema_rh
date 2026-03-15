package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import entities.Funcionario;
import utilities.VerifyCod;
import utilities.VerifyCodFun;
import utilities.VerifyType;

public class SalaryIncrease {
    public static void aumentoSalario(Scanner sc, List<Funcionario> funcionarios, int codFun) {
        double aumento;
        Connection conn = DB.dbConnect();
                    
                    codFun = VerifyCodFun.verificaCodFun(sc, funcionarios);
                    if (!funcionarios.get(codFun).isAtivo()) {
                        System.out.println("Não é possível realizar operações em funcionários excluídos!");
                    } else {
                        
                        System.out.printf("Digite a opção: %n1 - Aumento com valor Bruto %n2 - Aumento em Porcentagem acima do salario base %n");
                        int escolhaOpcaoAumento = VerifyCod.verificaCod(1, 2, sc);
                    switch (escolhaOpcaoAumento) {
                        case 1:
                            System.out.printf("Digite o valor dado de aumento: %n");  
                            aumento = VerifyType.lerDouble(sc, "Valor Inválido");
                            try (PreparedStatement pst = conn.prepareStatement("UPDATE employee SET salario = ? WHERE idEmployee = ?")) {
                                pst.setDouble(1, (funcionarios.get(codFun).getSalario() + aumento));
                                pst.setInt(2, funcionarios.get(codFun).getId());
                                pst.executeUpdate();
                            } catch (Exception e) {
                                throw new DbException(e.getMessage());
                            }                           
                            funcionarios.get(codFun).setSalarioBruto(aumento);
                            break;
                    
                        case 2: 
                            System.out.print("Digite será a % dado de aumento:  (Não é necessario colocar %)"); 
                            aumento = VerifyType.lerDouble(sc, "Valor Inválido");
                            try (PreparedStatement pst = conn.prepareStatement("UPDATE employee SET salario = ? WHERE idEmployee = ?")) {
                                double valorDoAcrescimo = (funcionarios.get(codFun).getSalario() * aumento) / 100;
                                pst.setDouble(1, funcionarios.get(codFun).getSalario() + valorDoAcrescimo);
                                pst.setInt(2, funcionarios.get(codFun).getId());
                                pst.executeUpdate();
                            } catch (Exception e) {
                                throw new DbException(e.getMessage());
                            }                           

                            funcionarios.get(codFun).setSalarioPorcentagem(aumento);
                        default:
                            break;
                    }
                    }   

                    
    }
}
