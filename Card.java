class Card{
    private int pin;
    private int amount;
    private String bank;
    private long personID;
    private boolean isBLocked;
    public Card(String bank, long personID){
        this.amount = 0;
        this.pin = 1234;
        this.bank = bank;
        this.personID = personID;
        this.isBLocked = false;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public int getAmount(){
        return amount;
    }
    public long getPersonID(){
        return personID;
    }
    public void setPin(int pin){
        this.pin = pin;
    }
    public int getPin(){
        return pin;
    }
    public void setBank(String bank){
        this.bank = bank;
    }
    public String getBank(){
        return bank;
    }
    public boolean isBLocked(){
        return isBLocked;
    }
    public void setBLocked(boolean blocked){
        isBLocked = blocked;
    }
    public String toString(){
        return "Card ( pin= "+pin+", amount= "+amount+", bank= "+bank+"'"+", personID= "+personID+", isBlocked= "+isBLocked+")";
    }
}