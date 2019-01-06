package id.astrodev.muhamadfikri.footballclub.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsFootball {

    @SerializedName("teams")
    private final List<DetailFootballTeam> detailFootballTeams;

    public ResponsFootball(List<DetailFootballTeam> detailFootballTeams) {
        this.detailFootballTeams = detailFootballTeams;
    }

    public List<DetailFootballTeam> getDetailFootballTeams() {
        return detailFootballTeams;
    }

}
