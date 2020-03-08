package com.kyrie.arknights.model;

import com.litesuits.orm.db.annotation.Table;

/**
 * Created by Kyrie
 * Date: 2020/3/8
 */
@Table("position")
public class Position extends Tag {
    public static int MELEE = 1;
    public static int RANGED = 2;

    public Position(int id, String name) {
        super(id, name);
    }
}
