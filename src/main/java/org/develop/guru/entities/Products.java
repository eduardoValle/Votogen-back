package org.develop.guru.entities;

import javax.persistence.*;

/**
 *
 * Created by Luiz Eduardo on 06/06/2017.
 */

@Entity
@Table
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer numberOfLives;

    @Column
    private String valueOfLives;

    @Column
    private String lifeImage;

    public Products() {
        super();
    }

    public Products(Integer numberOfLives, String valueOfLives, String lifeImage) {
        super();
        this.numberOfLives = numberOfLives;
        this.valueOfLives = valueOfLives;
        this.lifeImage = lifeImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(Integer numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public String getValueOfLives() {
        return valueOfLives;
    }

    public void setValueOfLives(String valueOfLives) {
        this.valueOfLives = valueOfLives;
    }

    public String getLifeImage() {
        return lifeImage;
    }

    public void setLifeImage(String lifeImage) {
        this.lifeImage = lifeImage;
    }
}
