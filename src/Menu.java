import javax.swing.*;

public class Menu {
    Account account = new Account("Jurandir",23112023, 950f, 9991);

    public Menu() {
        account.doLogin();

        String msg = "1 - Depósito\n2 - Saque\n3 - Saldo\n4 - Trocar senha\n5 - Sair";
        int option;

        while(true) {
            option = Integer.parseInt(JOptionPane.showInputDialog(null,msg,"Banco Neverland"));

            switch(option) {
                case 1:
                    account.doDeposit();
                    break;
                case 2:
                    account.doWithdraw();
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    account.changePassword();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
