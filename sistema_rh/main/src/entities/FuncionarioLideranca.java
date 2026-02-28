package entities;
public class FuncionarioLideranca extends Funcionario {
     String  login, senha;

    public FuncionarioLideranca (String name, Cargos cargo, String date, Contracts contracts, String login, String senha) {
        super(name, cargo, date, contracts);
        this.login = login;
        this.senha = senha;
    }

    public FuncionarioLideranca (String name, Cargos cargo, boolean isAdmittedToday, Contracts contracts, String login, String senha) {
        super(name, cargo, isAdmittedToday, contracts);
        this.login = login;
        this.senha = senha;
    }

    public boolean autenticar(String loginDigitado, String senhaDigitada) {
        return this.login.equals(loginDigitado) && this.senha.equals(senhaDigitada); 
     }

    }

