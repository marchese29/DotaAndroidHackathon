package com.DotaStats.android;

import org.json.JSONObject;

public class Player {
	
	private String name;
	private int level;
	private int kills;
	private int deaths;
	private int assists;
	private int lastHits;
	private int denies;
	private int goldPerMinute;
	
	public Player(JSONObject jsonObject) {
		// TODO: Populate the player data from the JSONObject.
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getKills() {
		return this.kills;
	}
	
	public int getDeaths() {
		return this.deaths;
	}
	
	public int getAssists() {
		return this.assists;
	}
	
	public int getLastHits() {
		return this.lastHits;
	}
	
	public int getDenies() {
		return this.denies;
	}
	
	public int getGoldPerMinute() {
		return this.goldPerMinute;
	}

}
