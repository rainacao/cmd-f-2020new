package model.plant;

import model.exceptions.NoMoreEvolutionException;

public class Plant {

    public final static int BASE_STATE = 0;
    public final static int FIRST_STATE = 1;
    public final static int SECOND_STATE = 2;
    public final static int THIRD_STATE = 3;

    private static final int EVOLUTION_1 = 2;
    private static final int EVOLUTION_2 = 4;
    private static final int EVOLUTION_3 = 6;

    private static final int EXP_PER_LEVEL = 5;
    private static final int COINS_PER_LEVEL = 5;

    private static final int LEVEL_TO_START_EARNING_COINS = 6;

    private boolean isDead;
    private int level;
    private int exp;
    private int currentEvolutionState;
    private int coins = 0;

    public Plant() {
        isDead = false;
        level = 0;
        exp = 0;
        currentEvolutionState = BASE_STATE;
    }

    public Plant(int level, int exp){
        isDead = false;
        this.level = level;
        this.exp = exp;
        currentEvolutionState = BASE_STATE;
    }

    public void updatePlantWithEXP(int exp) {
        this.exp += exp;
        while (this.exp >= EXP_PER_LEVEL) {
            this.exp -= EXP_PER_LEVEL;
            updateLevel();
            checkEvolution();
            updateCoins();
        }
    }

    public void killPlant() {
        isDead = true;
    }

    public void checkEvolution() {
        try {
            if (level == EVOLUTION_1 || level == EVOLUTION_2 || level == EVOLUTION_3) {
                evolvePlant();
            }
        } catch (NoMoreEvolutionException e) {
            System.out.println("The plant cannot evolve any further.");
        }
    }

    public void evolvePlant() throws NoMoreEvolutionException {
        switch(currentEvolutionState){
            case BASE_STATE:
                currentEvolutionState = FIRST_STATE;
                break;
            case FIRST_STATE:
                currentEvolutionState = SECOND_STATE;
                break;
            case SECOND_STATE:
                currentEvolutionState = THIRD_STATE;
                break;
            default:
                throw new NoMoreEvolutionException();

        }
    }

    public void updateLevel() {
        level++;
    }

    public void updateCoins() {
        if (level >= LEVEL_TO_START_EARNING_COINS) {
            coins += 5;
        }
    }

    public int getLevel() {
        return level;
    }

    public int getEXP() {
        return exp;
    }

    public int getCurrentEvolutionState() {
        return currentEvolutionState;
    }
}
