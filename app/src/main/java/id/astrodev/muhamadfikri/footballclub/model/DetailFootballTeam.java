package id.astrodev.muhamadfikri.footballclub.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "teams")
public class DetailFootballTeam implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idTeam")
    @SerializedName("idTeam")
    private int idTeam_;

    @ColumnInfo(name = "strTeam")
    @SerializedName("strTeam")
    private String strTeam_;

    @ColumnInfo(name = "strStadium")
    @SerializedName("strStadium")
    private String strStadium_;

    @ColumnInfo(name = "strStadiumThumb")
    @SerializedName("strStadiumThumb")
    private String strStadiumThumb_;

    @ColumnInfo(name = "strStadiumDescription")
    @SerializedName("strStadiumDescription")
    private String strStadiumDescription_;

    @ColumnInfo(name = "strStadiumLocation")
    @SerializedName("strStadiumLocation")
    private String strStadiumLocation_;

    @ColumnInfo(name = "strDescriptionEn")
    @SerializedName("strDescriptionEn")
    private String strDescriptionEn_;

    @ColumnInfo(name = "strTeamBadge")
    @SerializedName("strTeamBadge")
    private String strTeamBadge_;

    public int getIdTeam_() {
        return idTeam_;
    }

    public void setIdTeam_(int idTeam_) {
        this.idTeam_ = idTeam_;
    }

    public String getStrTeam_() {
        return strTeam_;
    }

    public void setStrTeam_(String strTeam_) {
        this.strTeam_ = strTeam_;
    }

    public String getStrStadium_() {
        return strStadium_;
    }

    public void setStrStadium_(String strStadium_) {
        this.strStadium_ = strStadium_;
    }

    public String getStrStadiumThumb_() {
        return strStadiumThumb_;
    }

    public void setStrStadiumThumb_(String strStadiumThumb_) {
        this.strStadiumThumb_ = strStadiumThumb_;
    }

    public String getStrStadiumDescription_() {
        return strStadiumDescription_;
    }

    public void setStrStadiumDescription_(String strStadiumDescription_) {
        this.strStadiumDescription_ = strStadiumDescription_;
    }

    public String getStrStadiumLocation_() {
        return strStadiumLocation_;
    }

    public void setStrStadiumLocation_(String strStadiumLocation_) {
        this.strStadiumLocation_ = strStadiumLocation_;
    }

    public String getStrDescriptionEn_() {
        return strDescriptionEn_;
    }

    public void setStrDescriptionEn_(String strDescriptionEn_) {
        this.strDescriptionEn_ = strDescriptionEn_;
    }

    public String getStrTeamBadge_() {
        return strTeamBadge_;
    }

    public void setStrTeamBadge_(String strTeamBadge_) {
        this.strTeamBadge_ = strTeamBadge_;
    }

}
