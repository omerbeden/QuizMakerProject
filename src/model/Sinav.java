package model;

import presenter.ZorlukDerecesi;
import java.util.ArrayList;
import model.Ders;
import model.Gozetmen;
import model.Soru;
import presenter.SoruBankasi;
import presenter.SoruCesitliligi;
import presenter.ZorlukDerecesi;

public class Sinav {
	
	protected String sinavAdi;
	protected Ders sinavKategorisi;
        protected Derslik derslik;
	protected Gozetmen gözetmen;
	protected ZorlukDerecesi zd;
	
 
	
	private   ArrayList<Soru> sinavSorulari = new ArrayList<Soru>();

	public Sinav() {
		zd=null;
	}

	public Sinav(String sinavAdi, Ders sinavKategorisi, Derslik derslik, Gozetmen gözetmen,
			 ZorlukDerecesi zd) {
		this.sinavAdi = sinavAdi;
		this.sinavKategorisi = sinavKategorisi;
		this.derslik = derslik;
		this.gözetmen = gözetmen;
		this.zd = zd;
	}
        
        public void setSinavAdi(String sinavAdi){
          this.sinavAdi = sinavAdi;
        }
        
        public String getSinavAdi(){
            return this.sinavAdi;
        }
        public void setSinavKategorisi(Ders sinavKategorisi){
          this.sinavKategorisi=sinavKategorisi;
        }
        
        public Ders getSinavKategorisi(){
            return this.sinavKategorisi;
        }
        public void setDerslik(Derslik derslik){
          this.derslik = derslik;
        }
        
        public Derslik getDerslik(){
            return this.derslik;
        }
        
        public void setZorlukDerecesi(ZorlukDerecesi zd){
          this.zd = zd;
        }
        
        public ZorlukDerecesi getZorlukDerecesi(){
            return this.zd;
        }
	
	public Sinav(ZorlukDerecesi zd) {
		this.zd = zd;
		
	}
        
    
        public ArrayList<Soru> getSinavSorulari(){
            return this.sinavSorulari;
        }
        public void setGozetmen(Gozetmen gozetmen) {
        this.gözetmen = gozetmen;
        
    }
        public void setSinavSorulari(ArrayList <Soru> sinavSorulari){
            this.sinavSorulari = sinavSorulari;
        }
             public Gozetmen getGozetmen(){
            return this.gözetmen;
        }
	
}
