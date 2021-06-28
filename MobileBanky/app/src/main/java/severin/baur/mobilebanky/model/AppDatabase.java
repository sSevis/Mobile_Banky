package com.example.pendenzverwaltung_uek335.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pendenzverwaltung_uek335.model.Pendenz;

//database is created
@Database(entities = {Pendenz.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //setting database name
    private static final String DB_NAME = "Pendenz_Verwaltung";
    private static AppDatabase appDb;

    //creating
    public static AppDatabase getAppDb(Context context) {
        if (appDb == null) {
            appDb = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return appDb;
    }

    public abstract PendenzDao getPendenzDao();

}
