package org.develop.guru.entities;

import javax.persistence.*;

@Entity
public class Codes {
    private static final long serialVersionUID = 7740893708926140114L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer userId;

    @Column(unique = true)
    private String code;

    @Column
    private String dateCode;

    @Column
    private String dateCodeEx;

    public Codes (){
        super();
    }

    public Codes (Integer userId, String code, String dateCode, String dateCodeEx){
        super();
        this.userId = userId;
        this.code = code;
        this.dateCode = dateCode;
        this.dateCodeEx = dateCodeEx;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDateCode() {
        return dateCode;
    }

    public void setDateCode(String dateCode) {
        this.dateCode = dateCode;
    }

    public String getDateCodeEx() {
        return dateCodeEx;
    }

    public void setDateCodeEx(String dateCodeEx) {
        this.dateCodeEx = dateCodeEx;
    }
}