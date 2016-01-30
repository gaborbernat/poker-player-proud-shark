package org.leanpoker.player.domain;

import java.util.List;

public class OtherPlayer {
	private int id;
	private String name;
	private String status;
	private String version;
	private int stack;
	private int bet;
	private List<Card> hole_cards;

	public OtherPlayer(int id, String name, String status, String version, int stack, int bet) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.version = version;
		this.stack = stack;
		this.bet = bet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStack() {
		return stack;
	}

	public void setStack(int stack) {
		this.stack = stack;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public List<Card> getHole_cards() {
		return hole_cards;
	}
	
	public void setHole_cards(List<Card> hole_cards) {
		this.hole_cards = hole_cards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bet;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stack;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OtherPlayer other = (OtherPlayer) obj;
		if (bet != other.bet)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stack != other.stack)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OtherPlayer [id=" + id + ", name=" + name + ", status=" + status + ", version=" + version + ", stack="
				+ stack + ", bet=" + bet + "]";
	}

}
