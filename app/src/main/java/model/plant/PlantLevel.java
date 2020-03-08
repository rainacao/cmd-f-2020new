package model.plant;

public class PlantLevel {
    // xp represents number of completed tasks
    // level up every 5 xp
    // evolve every 2 levels
    private static final int EXP_PER_LEVEL = 5;

    private int currentLevel;
    private int exp;

    public PlantLevel(int currentLevel, int exp) {
        this.currentLevel = currentLevel;
        this.exp = exp;
    }

    public void addEXP(int exp) {
        this.exp += exp;
        while (this.exp >= EXP_PER_LEVEL) {
            this.exp -= EXP_PER_LEVEL;
            updateLevel();
        }
    }

    public void updateLevel() {
        currentLevel++;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getEXP() {
        return exp;
    }

}
