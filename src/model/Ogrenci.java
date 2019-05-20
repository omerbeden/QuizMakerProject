
package model;


public class Ogrenci {
    protected String ogrenciAdi;
	protected String ogrenciSoyadi;
        protected int id;
        protected int ogrenciNumara;
	
	public Ogrenci() {
		
	}
	
	public Ogrenci(String ogrenciAdi, String ogrenciSoyadi,int ogrenci_Numara) {
		this.ogrenciAdi = ogrenciAdi;
		this.ogrenciSoyadi = ogrenciSoyadi;
                this.ogrenciNumara=ogrenciNumara;
	}

    public int getOgrenciNumara() {
        return ogrenciNumara;
    }

    public void setOgrenciNumara(int ogrenciNumara) {
        this.ogrenciNumara = ogrenciNumara;
    }

    

    public String getOgrenciAdi() {
        return ogrenciAdi;
    }

    public String getOgrenciSoyadi() {
        return ogrenciSoyadi;
    }

    public int getId() {
        return id;
    }

    public void setOgrenciAdi(String ogrenciAdi) {
        this.ogrenciAdi = ogrenciAdi;
    }

    public void setOgrenciSoyadi(String ogrenciSoyadi) {
        this.ogrenciSoyadi = ogrenciSoyadi;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    
    
    
}
