package entities;

public class Account {
    private String login;
    private String senha;

   public Account(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean validar(String loginDigitado, String senhaDigitada) {
        return loginDigitado.equals(login) && senhaDigitada.equals(senha);
    }

}
