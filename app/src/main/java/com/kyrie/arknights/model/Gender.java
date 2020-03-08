package com.kyrie.arknights.model;

import com.litesuits.orm.db.annotation.Table;

/**
 * Created by Kyrie
 * Date: 2020/3/8
 */
@Table("gender")
public class Gender extends Tag{
    public static int MALE = 1;
    public static int FEMALE = 2;

    public Gender(int id, String name) {
        super(id, name);
    }
}
