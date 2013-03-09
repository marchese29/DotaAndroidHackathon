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

	/**
	 * For Test use only!
	 */
	public Player(String name, int level, int kills, int deaths, int assists,
			int lastHits, int denies, int goldPerMinute) {
		this.name = name;
		this.level = level;
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
		this.lastHits = lastHits;
		this.denies = denies;
		this.goldPerMinute = goldPerMinute;
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
