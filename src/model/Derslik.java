/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gabya
 */
public class Derslik {
    private String binaAdi;
    private String salonNo;
    private String salonKodu;
    private String derslikKapasitesi;


    public Derslik(String binaAdi, String salonNo, String salonKodu,String derslikKapasitesi) {
        this.binaAdi = binaAdi;
        this.salonNo = salonNo;
        this.salonKodu = salonKodu;
        this.derslikKapasitesi = derslikKapasitesi;
    }
    
    public Derslik(){
    binaAdi="";
    salonNo="";
    salonKodu="";
    }

    public String getBinaAdi() {
        return binaAdi;
    }

    public void setBinaAdi(String binaAdi) {
        this.binaAdi = binaAdi;
    }

    public String getSalonNo() {
        return salonNo;
    }

    public void setSalonNo(String salonNo) {
        this.salonNo = salonNo;
    }

    public String getSalonKodu() {
        return salonKodu;
    }

    public void setSalonKodu(String salonKodu) {
        this.salonKodu = salonKodu;
    }
    
     public String getDerslikKapasitesi() {
        return derslikKapasitesi;
    }

    public void setDerslikKapasitesi(String derslikKapasitesi) {
        this.derslikKapasitesi = derslikKapasitesi;
    }
    
    
    
    
}
