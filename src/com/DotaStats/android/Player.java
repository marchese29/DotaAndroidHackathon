package com.DotaStats.android;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Player {

	public String name;
	public String HeroName;
	public int level;
	public int kills;
	public int deaths;
	public int assists;
	public int lastHits;
	public int denies;
	public int goldPerMinute;

	public Player(JSONObject jsonObject) {
		try {
			this.name = jsonObject.getString("account_name");
			this.HeroName = jsonObject.getString("hero_name");
			this.level = Integer.parseInt(jsonObject.getString("level"));
			this.kills = Integer.parseInt(jsonObject.getString("kills"));
			this.deaths = Integer.parseInt(jsonObject.getString("deaths"));
			this.assists = Integer.parseInt(jsonObject.getString("assists"));
			this.lastHits = Integer.parseInt(jsonObject.getString("last_hits"));
			this.denies = Integer.parseInt(jsonObject.getString("denies"));
			this.goldPerMinute = Integer.parseInt(jsonObject.getString("gold_per_min"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
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
