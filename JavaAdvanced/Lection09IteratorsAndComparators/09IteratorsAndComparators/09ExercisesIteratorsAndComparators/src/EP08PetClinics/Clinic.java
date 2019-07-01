package EP08PetClinics;

public class Clinic {
    String name;
    Pet[] rooms;
    int occupiedRooms;
    int indexForInput;

    public Clinic(String name, int capacity) {
        this.name = name;
        if (capacity%2==0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new Pet[capacity];
        this.occupiedRooms = 0;
        this.indexForInput = capacity/2;
    }

    public void add(Pet pet){
        if (pet!=null){

        }else {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        this.rooms[indexForInput] = pet;
        this.occupiedRooms++;
    }




}
