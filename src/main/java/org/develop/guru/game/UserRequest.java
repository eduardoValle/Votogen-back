package org.develop.guru.game;

import java.util.List;

/**
 *
 * Created by Luiz Eduardo on 08/06/2017.
 */

public class UserRequest {

    private List<Integer> userId;

    public UserRequest() {
        super();
    }

    public List<Integer> getUserID() {
        return userId;
    }

    public void setUserID(List<Integer> userId) {
        this.userId = userId;
    }
}
