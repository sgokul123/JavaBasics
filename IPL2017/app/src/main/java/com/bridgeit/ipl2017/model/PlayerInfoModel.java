package com.bridgeit.ipl2017.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bridgeit on 18/1/17.
 */

public class PlayerInfoModel {
      private  String destination_folder_name;
    private  String  player_batting_style;
    private String player_bowling_style;
    private String player_dob;
    private String player_img_url;
    private String  player_name;
    private String player_nationality;
    private String player_role;

    public PlayerInfoModel(String destination_folder_name,String p_bat_style, String p_bowl_style, String p_dob, String p_img_url,String p_name, String p_nationality, String p_role) {
        this.destination_folder_name=destination_folder_name;
        this.player_batting_style = p_bat_style;
        this.player_bowling_style = p_bowl_style;
        this.player_dob = p_dob;
       this.player_img_url = p_img_url;
        this.player_name = p_name;
        this.player_nationality = p_nationality;
        this.player_role = p_role;
    }

    public PlayerInfoModel() {

    }

    public void setPlayer_bowling_style(String player_bowling_style) {
        this.player_bowling_style = player_bowling_style;
    }

    public void setPlayer_batting_style(String player_batting_style) {
        this.player_batting_style = player_batting_style;
    }

    public void setPlayer_dob(String player_dob) {
        this.player_dob = player_dob;
    }

    public void setPlayer_img_url(String player_img_url) {
        this.player_img_url = player_img_url;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public void setPlayer_nationality(String player_nationality) {
        this.player_nationality = player_nationality;
    }
    public void setDestination_folder_name(String destination_folder_name) {
        this.destination_folder_name = destination_folder_name;
    }

    public String getDestination_folder_name() {
        return destination_folder_name;
    }
    public void setPlayer_role(String player_role) {
        this.player_role = player_role;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public String getPlayer_batting_style() {
        return player_batting_style;
    }

    public String getPlayer_bowling_style() {
        return player_bowling_style;
    }

    public String getPlayer_dob() {
        return player_dob;
    }

    public String getPlayer_img_url() {
        return player_img_url;
    }

    public String getPlayer_nationality() {
        return player_nationality;
    }

    public String getPlayer_role() {
        return player_role;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("destination_folder_name", destination_folder_name);
        result.put("player_batting_style", player_batting_style);
        result.put("player_bowling_style", player_bowling_style);
        result.put("player_dob", player_dob);
        result.put("player_img_url", player_img_url);
        result.put("player_name", player_name);
        result.put("player_nationality", player_nationality);
        result.put("player_role", player_role);
        return result;
    }

}
