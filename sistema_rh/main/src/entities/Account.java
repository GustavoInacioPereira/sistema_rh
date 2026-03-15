package entities;

public class Account {
    private Integer idAccount;
    private String login;
    private String senha;

   public Account(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

       public Account(Integer idAccount, String login, String senha) {
        this.idAccount = idAccount;
        this.login = login;
        this.senha = senha;
    }

    public boolean validar(String loginDigitado, String senhaDigitada) {
        return loginDigitado.equals(login) && senhaDigitada.equals(senha);
    }

    public Integer getIdAccount() {
        return idAccount;
    }

}
