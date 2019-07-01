package footballTeamGenerator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) throws ValidationException {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private boolean isInRangeZeroToHundred(int num){
        if (0 <= num && num <= 100){
            return true;
        }
        return false;
    }

    private void setName(String name) throws ValidationException {
        if (name == null || name.trim().length() < 1){
            throw new ValidationException("A name should not be empty. ");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) throws ValidationException {
        if (isInRangeZeroToHundred(endurance)){
            this.endurance = endurance;
        }else{
            throw new ValidationException("Endurance should be between 0 and 100. ");
        }
    }

    private void setSprint(int sprint) throws ValidationException {
        if (isInRangeZeroToHundred(sprint)){
            this.sprint = sprint;
        }else{
            throw new ValidationException("Sprint should be between 0 and 100. ");
        }
    }

    private void setDribble(int dribble) throws ValidationException {
        if (isInRangeZeroToHundred(dribble)){
            this.dribble = dribble;
        }else{
            throw new ValidationException("Dribble should be between 0 and 100. ");
        }

    }

    private void setPassing(int passing) throws ValidationException {
        if (isInRangeZeroToHundred(passing)){
            this.passing = passing;
        }else{
            throw new ValidationException("Passing should be between 0 and 100. ");
        }

    }

    private void setShooting(int shooting) throws ValidationException {
        if (isInRangeZeroToHundred(shooting)){
            this.shooting = shooting;
        }else{
            throw new ValidationException("Shooting should be between 0 and 100. ");
        }

    }

    public double overallSkillLevel(){
        return (this.endurance + this.dribble + this.passing + this.sprint + this.shooting)/5.0;
    }
}
