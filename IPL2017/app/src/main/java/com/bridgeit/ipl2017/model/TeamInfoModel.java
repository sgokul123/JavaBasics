package com.bridgeit.ipl2017.model;

/**
 * Created by bridgeit on 23/1/17.
 */

public class TeamInfoModel {


    private  String owner;
    private  String teamname;
    private  String url;

    public TeamInfoModel() {

    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }



    public String getTeamname() {
        return teamname;
    }

    public String getOwner() {
        return owner;
    }

    public String getUrl() {
        return url;
    }



    public TeamInfoModel(String owner, String teamname, String url) {
        this.owner = owner;
        this.teamname = teamname;
        this.url = url;
    }

}
