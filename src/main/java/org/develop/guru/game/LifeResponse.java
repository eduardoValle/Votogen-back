package org.develop.guru.game;

import org.develop.guru.entities.Life;
import java.util.ArrayList;

/**
 *
 * Created by Luiz Eduardo on 30/03/2017.
 */
public class LifeResponse {

    private ArrayList<Life> lifes = new ArrayList();
    private int numLifes;

    public LifeResponse() {
    }

    public LifeResponse(ArrayList<Life> lifes) {
        this.lifes = lifes;
    }

    public ArrayList<Life> getLifes() {
        return lifes;
    }

    public void setLifes(ArrayList<Life> lifes) {
        this.lifes = lifes;
    }
}
