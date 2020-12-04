package com.example.lab6.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@androidx.room.Database(entities = {HistoryEntry.class}, version = 2)
public abstract class Database extends RoomDatabase {
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "local_data";
    private static Database sInstance;

    public static Database getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        Database.class, Database.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries().addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                            }
                        }).build();
            }
        }
        return sInstance;
    }

    public abstract HistoryDAO historyDao();
}
