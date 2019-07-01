package repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Map<Integer, Person> data;
    private Integer counter;

    public Repository() {
        this.data = new HashMap<>();
        this.counter = 0;
    }


    public void add(Person person){
        data.put(this.counter++, person);
    }

    public Person get(int id){
        return data.get(id);
    }

    public boolean update(int id, Person newPerson){
        if (!data.containsKey(id)){
            return false;
        }

        data.put(id,newPerson);
        return true;
    }

    public boolean delete(int id){
        if (!data.containsKey(id)){
            return false;
        }

        data.remove(id);
        return true;
    }

    public int getCount(){
        return this.data.size();
    }

}
