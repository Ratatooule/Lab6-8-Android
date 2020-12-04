package com.example.lab6.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDAO {
    @Insert()
    public void addHistoryEntry(HistoryEntry userEntry);

    @Query("SELECT * FROM history")
    public List<HistoryEntry> getAll();

    @Query("DELETE FROM history")
    public void deleteAll();
}
