package org.develop.votogen.service;

/**
 *
 * Created by donat on 06-Apr-17.
 */
public class CodeResponse {

    private Integer id;
    private String message;

    public CodeResponse(Integer id, String message){

        this.id = id;
        this.message = message;

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
