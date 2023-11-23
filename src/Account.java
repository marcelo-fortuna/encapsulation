import javax.swing.*;

/**
 * Class created to creating objects of type Account.
 */
public class Account {

    private String name;
    private int accountNumber;
    private float balance;
    private int password;
    private boolean isLogged = false;

    /**
     * Constructor method of the object in memory.
     * @param name Name of client.
     * @param accountNumber Number account of client.
     * @param balance Balance of an account.
     * @param password Password of a client account.
     */
    public Account(String name, int accountNumber, float balance, int password) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean verifyAccountNumber(int accountNumber) {
        return accountNumber == getAccountNumber();
    }

    public boolean verifyPassword(int password) {
        return password == getPassword();
    }

    public boolean verifyBalance(float value) {
        return value <= getBalance();
    }

    /**
     * Method to show account client data.
     */
    public void showData() {
        if(!isLogged) return;

        System.out.println("Cliente: " + getName());
        System.out.println("Conta: " + getAccountNumber());
        System.out.println("Saldo: " + getBalance());
    }

    public void showBalance() {
        if (!isLogged) return;

        JOptionPane.showMessageDialog(null, "Saldo: " + getBalance());
    }

    public boolean doLogin() {
        int i = 4;

        if(!isLogged) {
            while (i > 0) {
                int accountNumber = 0;
                int password = 0;

                accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Número da sua conta: "));

                if (verifyAccountNumber(accountNumber)) {
                    password = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));

                    if (verifyPassword(password)) {
                        return this.isLogged = true;
                    } else {
                        i = i - 1;
                        JOptionPane.showMessageDialog(null, "Senha incorreta.\nTentativas restantes: " + i);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "A conta inserida não existe.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,"Você já está logado, " + getName());
        }
        return this.isLogged = false;
    }

    public void changePassword() {
        if(isLogged) {
            int oldpw, newpw, newpwconfirm;

            oldpw = Integer.parseInt(JOptionPane.showInputDialog("Digite a senha antiga: "));

            if(verifyPassword(oldpw)) {
                newpw = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova senha: "));
                newpwconfirm = Integer.parseInt(JOptionPane.showInputDialog("Confirme a nova senha: "));

                if(newpw == newpwconfirm) {
                    setPassword(newpw);
                    JOptionPane.showMessageDialog(null, "Senha alterada com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "As senhas não coincidem.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta.");
        }
    }

    public void doWithdraw() {
        if(!isLogged) return;
        
        float withdrawValue = 0;

        withdrawValue = Float.parseFloat(JOptionPane.showInputDialog("Valor do saque: "));

        if(verifyBalance(withdrawValue)) {
            setBalance(getBalance() - withdrawValue);
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente.");
        }
    }

    public void doDeposit() {
        if(!isLogged) return;

        int accountNumber = 0;

        accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));

        if (verifyAccountNumber(accountNumber)) {
            float depositValue = 0;

            depositValue = Float.parseFloat(JOptionPane.showInputDialog("Insira o valor do depósito: "));

            if(verifyBalance(depositValue)) {
                setBalance(getBalance() + depositValue);
                JOptionPane.showMessageDialog(null, "Valor depositado.");
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente.");
            }
        }
    }
}
