import java.util.*;
import static util.Keyboard.*;
import util.Keyboard;


class Atm {
    private Bank bank;
    public Atm(Bank bank){
        this.bank = bank;
    }
    public void display() throws AccountNotFoundForCNPException {
        // 1. Search account by CNP
        print("Introdu CNP: ");
        long cnp = Keyboard.nextInt();
        List<Card> accountCards = getCardsByCNP(cnp);
        // 2. Choose A card.
        int op = 0;
        println("Lista Carduri  \n");
        do {
            println(showCards(accountCards));
            println("1. Alege un card: ");
            println("2. Deblocare card");
            println("3. Iesire ");
            print("Optiune: ");
            op = Keyboard.nextInt();
            if(op == 1) {
                Card chosenCard = chooseCard(accountCards);
                if (isCardValid(chosenCard)) {
                    cardOperations(chosenCard);
                } else {
                    println("Ne pare rau, cardul este blocat!");
                }
            }
            if(op == 2) {
                Card chosenCard = chooseCard(accountCards);
                chosenCard.setBLocked(false);
            }
        } while (op!=3);
    }
    private List<Card> getCardsByCNP(long CNP) throws AccountNotFoundForCNPException {
        List<Card> accounCards = bank.getCardsByCNP(CNP);
        if(accounCards.isEmpty()){
            throw new AccountNotFoundForCNPException("Nu s-a gasit un cont cu CNP-ul " + CNP);
        }
        return accounCards;
    }
    public String showCards(List<Card> cards){
        String s = "";
        for(int i = 0; i<cards.size(); i++) {
            s = s + i + "." + cards.get(i).toString() + " \n";
        }
        return s +"\n";
    }
    private Card chooseCard(List<Card> cards){
        print("\nNumar Card: ");
        int op = Keyboard.nextInt();
        return cards.get(op);
    }
    private boolean isCardValid(Card c){
        int pin = 0;
        int incorrectAttempts = 0;
        if(c.isBLocked()) {
            return false;
        }
        do {
            print("Introdu PIN: ");
            pin = Keyboard.nextInt();
            if (pin == c.getPin() && c.getPin() == 1234) {
                print("\nResetati codul PIN: ");
                int newPin = Keyboard.nextInt();
                c.setPin(newPin);
                return true;
            } else if (pin == c.getPin()) {
                return true;
            } else {
                incorrectAttempts++;
            }
        } while (incorrectAttempts <= 2);
        if(incorrectAttempts > 2){
            c.setBLocked(true);
        }
        return false;
    }
    private void cardOperations(Card c){
        int op = 0;
        do {
            println("1. Retrage bani");
            println("2. Depunere bani");
            println("3. Interogare sold");
            println("4. Iesire");
            op = Keyboard.nextInt();
            switch (op) {
                case 1: {
                    print("Suma de retras: ");
                    int sum = Keyboard.nextInt();
                    if (sum <= c.getAmount()) {
                        c.setAmount(c.getAmount() - sum);
                    } else {
                        println("Nu dispui de aceasta suma de bani");
                    }
                    break;
                }
                case 2: {
                    print("Suma pentru depus: ");
                    int sum = Keyboard.nextInt();
                    c.setAmount(c.getAmount() + sum);
                }
                case 3: {
                    println("Suma totala: " + c.getAmount());
                }
                default: {
                    println("Nu exista optiunea aleasa");
                    break;
                }
            }
        } while (op!=4);
    }
}