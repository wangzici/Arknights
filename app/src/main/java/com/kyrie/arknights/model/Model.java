package com.kyrie.arknights.model;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

import java.io.Serializable;

/**
 * Created by Kyrie
 * Date: 2020/3/8
 */
public class Model implements Serializable {
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    long id;

    public long getId() {
        return id;
    }
}
