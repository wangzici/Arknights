package com.kyrie.arknights.model;

import com.litesuits.orm.db.annotation.Table;

/**
 * Created by Kyrie
 * Date: 2020/3/8
 */
public class Tag extends Model{
    protected String name;
    protected String name_jp;

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getName_jp() {
        return name_jp;
    }
}
