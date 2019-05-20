package model;

public class Ders {

	private String name;
        private int id;
	
	public Ders() {
		name="";
	}
	public Ders(String name) {
		
		this.name = name;
	}
	public String getName() {
		return name;
	}
        public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
        
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return  name ;
	}	
}
