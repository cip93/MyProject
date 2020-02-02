import java.util.*;
import static util.Keyboard.*;
import util.Keyboard;

public class app1 {
    public static void main (String[]args){
        Bank bank = new Bank("ING");
        Atm atm = new Atm(bank);
        Person p = new Person("Ciprian", 123, "a@gma");
        Account c = bank.createAccount(p);
        bank.createCardForAccount(c);
        bank.createCardForAccount(c);
        while (true) {
            try {
                atm.display();
            } catch (AccountNotFoundForCNPException e) {
                println(e.getMessage());
            }
        }
    }
}