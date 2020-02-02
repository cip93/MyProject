import java.util.*;
import static util.Keyboard.*;
import util.Keyboard;


class PersonService {
private Map<Long, Person> personDB;
private Random randomGenerator;
public PersonService(){
        personDB = new HashMap<Long, Person>();
        Date now = new Date();
        long sec = now.getTime();
        randomGenerator = new Random(sec);
        }
public long createPerson(Person p){   //Retrieve
        long personID = generateUserID();
        personDB.put(personID, p);
        return  personID;
        }
public Person getPersonByID(long personID){   //Create
        return personDB.get(personID);
        }
private long generateUserID(){
        return  randomGenerator.nextLong();
        }
public void updatePerson(long personID,String email, String name ) throws NotFoundPersonID{  //Update
        Person p = personDB.get(personID);
        if(p == null) {
        throw new NotFoundPersonID( "There was no person found with this ID: "+ personID);
        }
        else {
        p.setEmail(email);
        p.setName(name);
        personDB.put(personID, p);
        }
        }
public void deletePerson(long personID)throws NotFoundPersonID{   //Delete
        Person p = personDB.get(personID);
        if(p == null) {
        throw new NotFoundPersonID( "There was no person found with this ID: "+ personID);
        }
        else {
        personDB.remove(personID);
        }
    }

    public long getPersonIdByCNP(long cnp){
        long personId = 0;
        Set<Long> personIds = personDB.keySet();
        for(Long id: personIds){
            Person p = personDB.get(id);
            if(p.getCNP() == cnp){
                personId = id;
            }
        }
        if(personId == 0){
            throw new RuntimeException("Nu exista persoana cu CNP-ul " + cnp);
        }
        return personId;
    }
    private long generateUserId() {
        return randomGenerator.nextLong();
    }
}

