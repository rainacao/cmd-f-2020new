package model.plant;

public class PlantLevel {
    // xp represents number of completed tasks
    // level up every 5 xp
    // evolve every 2 levels
    private int currentLevel;
    private int xp;

    public PlantLevel(int currentLevel, int xp) {
        this.currentLevel = currentLevel;
        this.xp = xp;
    }

    public void updateLevel() {
        currentLevel++;
        xp = 0;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getXp() {
        return xp;
    }

}
