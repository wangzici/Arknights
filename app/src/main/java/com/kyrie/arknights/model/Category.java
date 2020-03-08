package com.kyrie.arknights.model;

import com.litesuits.orm.db.annotation.Table;

/**
 * Created by Kyrie
 * Date: 2020/3/8
 */
@Table("category")
public class Category extends Tag {
    public static int VANGUARD = 1;//先锋
    public static int SNIPER = 2;//狙击
    public static int MEDIC = 3;//医疗
    public static int CASTER = 4;//术士
    public static int GUARD = 5;//近卫
    public static int DEFENDER = 6;//重装
    public static int SUPPORTER = 7;//辅助
    public static int SPECIALIST = 8;//特种

    public Category(int id, String name) {
        super(id, name);
    }
}
