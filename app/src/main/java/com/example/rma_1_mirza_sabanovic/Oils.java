package com.example.rma_1_mirza_sabanovic;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Oils")
public class Oils {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "oils_id")
    int id;

    @ColumnInfo(name = "oils")
    String oils;

    @ColumnInfo(name = "value")
    String value;

    public Oils() {
    }

    public Oils(String oils, String value) {
        this.oils = oils;
        this.value = value;
        this.id = 0;
    }

    public String getOils() {
        return oils;
    }

    public void setOils(String oils) {
        this.oils = oils;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
