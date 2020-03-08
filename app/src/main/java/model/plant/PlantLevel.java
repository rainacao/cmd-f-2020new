package model.plant;

public class PlantLevel {
    private int currentLevel;
    private int xp;

    public PlantLevel(int currentLevel, int xp) {
        this.currentLevel = currentLevel;
        this.xp = xp;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getXp() {
        return xp;
    }


}
