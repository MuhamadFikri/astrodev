package id.astrodev.muhamadfikri.footballclub.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import id.astrodev.muhamadfikri.footballclub.model.DetailFootballTeam;

@Database(entities ={DetailFootballTeam.class}, version = 1)
public abstract class FootballDatabase extends RoomDatabase {

    public abstract DetailFootballTeamDao detailFootballTeamDao();
    private static FootballDatabase footballDatabase;

    public static FootballDatabase getFootballDatabase(Context context) {
        synchronized (FootballDatabase.class) {
            if (footballDatabase == null) {
                footballDatabase = Room.databaseBuilder(context, FootballDatabase.class, "db_football").allowMainThreadQueries().build();
            }
        }
        return footballDatabase;
    }
}
