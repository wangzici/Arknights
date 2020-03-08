package com.kyrie.arknights.model;

import com.litesuits.orm.db.annotation.Table;

/**
 * Created by Kyrie
 * Date: 2020/3/8
 */
@Table("affix")
public class Affix extends Tag{
    public static int HEAL = 1;//治疗
    public static int DP_RECOVER = 2;//费用回复
    public static int SUPPORE = 3;//支援
    public static int DPS = 4;//输出;
    public static int AOE = 5;//群攻;
    public static int SLOW = 6;//减速
    public static int SURVIVAL = 7;//生存
    public static int DEFENSE = 8;//防护
    public static int DE_BUFF = 9;//削弱
    public static int SHIFT = 10;//位移
    public static int NUKER = 11;//爆发
    public static int SUMMON = 12;//召唤
    public static int FAST_REDEPLOY = 13;//快速复活
    public static int CROW_CONTROL = 14;//控场
    public static int ROBOT = 15;//机械支援

    public Affix(int id, String name) {
        super(id, name);
    }
}
