
package model;

import java.util.ArrayList;


public class OgretimUyesi {
    
    ArrayList <Ders> dersler = new ArrayList <Ders>();
    
    private String ad,soyad;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public OgretimUyesi(){
        
    }
    
    public OgretimUyesi(String ad,String soyad){
        this.ad = ad;
        this.soyad = soyad;
    }
    
    public String getIsım(){
        return ad;
    }
    
    public String getSoyad(){
        return soyad;
    }

    public void setDersler(ArrayList<Ders> dersler) {
        this.dersler = dersler;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
    
    public ArrayList<Ders> getDers(){
        return dersler;
    } 
}
