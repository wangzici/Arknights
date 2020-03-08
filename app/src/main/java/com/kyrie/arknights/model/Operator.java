package com.kyrie.arknights.model;

import com.litesuits.orm.db.annotation.Table;

import java.util.List;

/**
 * Created by Kyrie
 * Date: 2020/3/1
 */
@Table("operator")
public class Operator extends Model {
    private String name;
    private int star;
    private int imgSmall;
    private int aptitude;
    private int position;
    private int category;
    private int gender;
    private List<Integer> affixList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getImgSmall() {
        return imgSmall;
    }

    public void setImgSmall(int imgSmall) {
        this.imgSmall = imgSmall;
    }

    public int getAptitude() {
        return aptitude;
    }

    public void setAptitude(int aptitude) {
        this.aptitude = aptitude;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<Integer> getAffixList() {
        return affixList;
    }

    public void setAffixList(List<Integer> affixList) {
        this.affixList = affixList;
    }
}
