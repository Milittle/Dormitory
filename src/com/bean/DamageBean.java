package com.bean;

/**
 * Created by mizeshuang on 2016/6/4.
 */
public class DamageBean {
    private int Damage_ID;
    private int Building_ID;
    private String Damage_Description;
    private String Damage_State;
    private String Building_Name;
    private int Repair_ID;

    public int getRepair_ID() {
        return Repair_ID;
    }

    public void setRepair_ID(int repair_ID) {
        Repair_ID = repair_ID;
    }

    public String getBuilding_Name() {
        return Building_Name;
    }

    public void setBuilding_Name(String building_Name) {
        Building_Name = building_Name;
    }

    public int getDamage_ID() {
        return Damage_ID;
    }

    public void setDamage_ID(int damage_ID) {
        Damage_ID = damage_ID;
    }

    public int getBuilding_ID() {
        return Building_ID;
    }

    public void setBuilding_ID(int building_ID) {
        Building_ID = building_ID;
    }

    public String getDamage_Description() {
        return Damage_Description;
    }

    public void setDamage_Description(String damage_Description) {
        Damage_Description = damage_Description;
    }

    public String getDamage_State() {
        return Damage_State;
    }

    public void setDamage_State(String damage_State) {
        Damage_State = damage_State;
    }
}
