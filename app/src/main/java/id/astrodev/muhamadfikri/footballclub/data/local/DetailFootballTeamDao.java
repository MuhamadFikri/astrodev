package id.astrodev.muhamadfikri.footballclub.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import id.astrodev.muhamadfikri.footballclub.model.DetailFootballTeam;

@Dao
public interface DetailFootballTeamDao {
    @Insert
    void insert(List<DetailFootballTeam> detailFootballTeamList);

    @Query("SELECT * FROM teams ORDER BY strTeam ASC")
    List<DetailFootballTeam> select();

    @Delete
    void delete(DetailFootballTeam detailFootballTeam);

    @Update
    void update(DetailFootballTeam detailFootballTeam);

}