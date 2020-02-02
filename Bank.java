import java.util.*;
import static util.Keyboard.*;
import util.Keyboard;


class Bank {
    private String bankName;
    private List<Account> accounts;
    private PersonService personService;
    public Bank(String bankName){
        this.bankName = bankName;
        this.accounts = new ArrayList<Account>();
        this.personService = new PersonService();
    }
    public Account createAccount(Person p) {
        long personId = personService.createPerson(p);
        Card card     = new Card(this.bankName, personId);
        Account acc   = new Account("IB00001" + bankName + personId, p.getCNP(), card);
        this.accounts.add(acc);
        return acc;
    }
    public List<Card> getCardsByCNP(long CNP) {
        for(Account a: this.accounts) {
            if(a.getCNP() == CNP){
                return a.getCards();
            }
        }
        return Collections.emptyList(); // noua! -> null.
    }
    public void createCardForAccount(Account ac){
        for(Account a: this.accounts){
            if(ac.getCNP() == a.getCNP()){
                long personId = personService.getPersonIdByCNP(ac.getCNP());
                Card c = new Card(this.bankName, personId);
                ac.addCard(c);
            }
        }
    }
}