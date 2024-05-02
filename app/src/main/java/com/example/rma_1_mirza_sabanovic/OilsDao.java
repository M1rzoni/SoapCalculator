package com.example.rma_1_mirza_sabanovic;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface OilsDao {
    @Insert
    public void addOils(Oils oils);

    @Update
    public void updateOils(Oils oils);

    @Delete
    public void deleteOils(Oils oils);

    @Query("select * from oils")
    public List<Oils> getAllOils();

    @Query("select * from oils where oils_id ==:oils_id")
    public Oils getOils(int oils_id);
}
