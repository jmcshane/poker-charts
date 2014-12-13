package mc.shane.poker.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PokerResult {
	
	//Represents winnings
	private int y;
	//Represents week number
	private int x;
	
	public PokerResult() {
		
	}
	public PokerResult(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void incrementY(int inc) {
		this.y += inc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		PokerResult other = (PokerResult) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("x=");
		sb.append(x);
		sb.append(",");
		sb.append("y=");
		sb.append(y);
		return sb.toString();
	}
	
	

}
