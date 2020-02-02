import java.util.*;
import static util.Keyboard.*;
import util.Keyboard;

class Account {
    private String IBAN;
    private long CNP;
    private List<Card> cards;
    public Account(String IBAN,long CNP, Card c){
        this.IBAN = IBAN;
        this.CNP = CNP;
        this.cards = new ArrayList<Card>();
        this.cards.add(c); //un cont trebuie sa aibe cel putin un card
    }
    public void addCard(Card c){
        this.cards.add(c);
    }
    public void setIBAN(String iban){
        IBAN = iban;
    }
    public String getIBAN(){
        return this.IBAN;
    }
    public List<Card> getCards(){
        return cards;
    }
    public long getCNP(){
        return CNP;
    }
}