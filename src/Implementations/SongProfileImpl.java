package Implementations;

import TasteProfile.SongProfile;

public class SongProfileImpl extends SongProfile {

	public SongProfileImpl() {
		// TODO Auto-generated constructor stub
	}
	public void setPlayCount(int count) {
		this.total_play_count = count;
	}
	public void setTopThree(TopThreeImpl top) {
		this.top_three_users = top;
	}
}
