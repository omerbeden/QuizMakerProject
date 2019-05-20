package model;

public class Gozetmen {
	
	protected String gozetmenAdi;
	protected String gozetmenSoyadi;
        protected int id;
	
	public Gozetmen() {
		
	}
	
	public Gozetmen(String gozetmenAdi, String gozetmenSoyadi) {
		this.gozetmenAdi = gozetmenAdi;
		this.gozetmenSoyadi = gozetmenSoyadi;
	}
	
	public String getGozetmenAdi() {
		return gozetmenAdi;
	}
	
	public void setGozetmenAdi(String gozetmenAdi) {
		this.gozetmenAdi = gozetmenAdi;
	}
	
	public String getGozetmenSoyadi() {
		return gozetmenSoyadi;
	}
	
	public void setGozetmenSoyadi(String gozetmenSoyadi) {
		this.gozetmenSoyadi = gozetmenSoyadi;
	}

    public int getId() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }
	
}
