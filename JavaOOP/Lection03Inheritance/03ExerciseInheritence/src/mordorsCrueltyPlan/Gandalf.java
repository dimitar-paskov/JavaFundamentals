package mordorsCrueltyPlan;

public class Gandalf {
    private int foodPoints;

    public Gandalf() {
        this.foodPoints = 0;
    }

    public int getFoodPoints() {
        return foodPoints;
    }

    public void eatFood(String food){
        switch (food.toLowerCase()){
            case "cram":{
                this.foodPoints += 2;
            }break;
            case "lembas":{
                this.foodPoints += 3;
            }break;
            case "apple":{
                this.foodPoints += 1;
            }break;
            case "melon":{
                this.foodPoints += 1;
            }break;
            case "honeycake":{
                this.foodPoints += 5;
            }break;
            case "mushrooms":{
                this.foodPoints -= 10;
            }break;
            default:{
                this.foodPoints -= 1;
            }
        }

    }

    public String getMood(){
        if (this.foodPoints > 15){
            return "JavaScript";
        }else if (this.foodPoints >= 0 ){
            return "Happy";
        }else if (this.foodPoints >= -5){
            return "Sad";
        }else {
            return "Angry";
        }

    }
}
