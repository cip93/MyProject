class Person {
    private String name;
    private long CNP;
    private String email;
    public Person(String name,long CNP,String email){
        this.name = name;
        this.CNP = CNP;
        this.email = email;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public long getCNP(){
        return this.CNP;
    }
}

