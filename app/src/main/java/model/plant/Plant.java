package model.plant;

import model.exceptions.NoMoreEvolutionException;

public class Plant extends PlantLevel {
    final String BASE_STATE="0";
    final static String FIRST_STATE="1";
    final static String SECOND_STATE="2";
    final static String THIRD_STATE="3";

    private PlantLevel plantLevel;
    private boolean dead;
    private String currentEvolutionState;

    public Plant() {
        super(0, 0);
        dead = false;
        currentEvolutionState = BASE_STATE;
    }

    public void killPlant() {
        dead = true;
    }

    public void upgradePlant() throws NoMoreEvolutionException {
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
            case THIRD_STATE:
            default: throw new NoMoreEvolutionException();

        }
    }

}
