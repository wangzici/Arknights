package com.kyrie.arknights.model;

import com.litesuits.orm.db.annotation.Table;

/**
 * Created by Kyrie
 * Date: 2020/3/8
 */
@Table("aptitude")
public class Aptitude extends Tag{
    public static int STARTER = 1;
    public static int SENIOR = 2;
    public static int TOP = 3;

    public Aptitude(int id, String name) {
        super(id, name);
    }
}
