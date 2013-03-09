package com.DotaStats.android;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Player {

	public String name;
	public int level;
	public int kills;
	public int deaths;
	public int assists;
	public int lastHits;
	public int denies;
	public int goldPerMinute;

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
	
	public List<Integer> getIntList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(level);
		list.add(kills);
		list.add(deaths);
		list.add(assists);
		list.add(lastHits);
		list.add(denies);
		list.add(goldPerMinute);
		
		return list;
	}

}
