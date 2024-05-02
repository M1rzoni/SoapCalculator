package com.example.rma_1_mirza_sabanovic;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Oils.class}, version = 1)
public abstract class OilsDatabse extends RoomDatabase {

    public abstract OilsDao getOilsDAO();
}
