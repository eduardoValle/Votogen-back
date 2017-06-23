package org.develop.guru.game;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author motoka
 */
public class CardsResponse {

    private List<String> message = new LinkedList<>();

    public CardsResponse() {
    }

    public CardsResponse(List<String> msg) {
        this.message = msg;
    }
    
    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
