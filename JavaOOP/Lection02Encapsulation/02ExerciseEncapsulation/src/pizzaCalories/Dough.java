package pizzaCalories;

public class Dough {


    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) throws ValidationException {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }


    private void setFlourType(String flourType) throws ValidationException {
        if ("White".equalsIgnoreCase(flourType) || "Wholegrain".equalsIgnoreCase(flourType)){
            this.flourType = flourType;
            return;
        }
        throw new ValidationException("Invalid type of dough.");
    }

    private void setBakingTechnique(String bakingTechnique) throws ValidationException {
        if ("Crispy".equalsIgnoreCase(bakingTechnique)
                || "Chewy".equalsIgnoreCase(bakingTechnique)
                || "Homemade".equalsIgnoreCase(bakingTechnique)){
            this.bakingTechnique = bakingTechnique;
            return;
        }
        throw new ValidationException("Invalid type of dough.");

    }

    private void setWeight(double weight) throws ValidationException {
        if (weight < 1 || 200 < weight){
            throw new ValidationException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double flourValue = 0;
        switch (this.flourType){
            case "White": flourValue = 1.5;break;
            case "Wholegrain": flourValue = 1.0;break;
        }

        double bakingTechniqueValue = 0;
        switch (this.bakingTechnique){
            case "Crispy": bakingTechniqueValue = 0.9;break;
            case "Chewy": bakingTechniqueValue = 1.1;break;
            case "Homemade": bakingTechniqueValue = 1.0;break;
        }

        return (this.weight*2)* flourValue * bakingTechniqueValue;
    }
}
