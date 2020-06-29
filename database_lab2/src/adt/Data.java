package adt;

public class Data implements Comparable<Data>{
	
	private int key;
	private String value;
	
	public Data(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public int getKey() {
		return key;
	}
	
	public String getValue() {
		return new String(this.value);
	}
	
	@Override
	public String toString() {
		return new String(this.key + ":" + this.value);
	}
	
	@Override
	public int compareTo(Data d) {
	    return this.getKey() - d.getKey();
	}
	
}