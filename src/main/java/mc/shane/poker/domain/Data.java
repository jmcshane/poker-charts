package mc.shane.poker.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Data {

	private List<PokerResult> data;
	private String name;
	
	public Data() {
		//do nothing
	}
	
	public Data(List<PokerResult> data, String name) {
		this.name = name;
		this.data = data;
	}

	public List<PokerResult> getData() {
		return data;
	}
	public void setData(List<PokerResult> data) {
		this.data = data;
	}
	public void addData(PokerResult result) {
		this.data.add(result);
	}
	public String getName() {
		return name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Data other = (Data) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("data=");
		sb.append(data);
		sb.append(",");
		sb.append("name=");
		sb.append(name);
		return sb.toString();
	}
	
	
}
