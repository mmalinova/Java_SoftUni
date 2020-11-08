package footballTeam;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (!NameValidation.isNonEmpty(name)) {
            throw new IllegalArgumentException(ConstantMessages.INVALID_STRING_EXCEPTION);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        if(!StatValidation.isInTheRange(endurance)) {
            throw new IllegalArgumentException("Endurance" + ConstantMessages.INVALID_RANGE_EXCEPTION);
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if(!StatValidation.isInTheRange(sprint)) {
            throw new IllegalArgumentException("Sprint" + ConstantMessages.INVALID_RANGE_EXCEPTION);
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if(!StatValidation.isInTheRange(dribble)) {
            throw new IllegalArgumentException("Dribble" + ConstantMessages.INVALID_RANGE_EXCEPTION);
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if(!StatValidation.isInTheRange(passing)) {
            throw new IllegalArgumentException("Passing" + ConstantMessages.INVALID_RANGE_EXCEPTION);
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if(!StatValidation.isInTheRange(shooting)) {
            throw new IllegalArgumentException("Shooting" + ConstantMessages.INVALID_RANGE_EXCEPTION);
        }
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
//The overall skill level of a player is calculated as the average of his stats.
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }
}
