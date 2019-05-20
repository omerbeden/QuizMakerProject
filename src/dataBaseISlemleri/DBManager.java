package dataBaseISlemleri;

import java.util.ArrayList;
import model.CoktanSecmeliSoru;
import model.Ders;
import model.Gozetmen;
import model.Sinav;
import model.*;

public class DBManager {
	DBISLEMLERI db;
	
	public DBManager(DBISLEMLERI db) {
		this.db = db;
	}
	
	public void dbKlasikSoruEkle(Soru soru) {
		db.databaseKlasikSoruEkle(soru);
	}
        public void dbCoktanSecmeliSoruEkle(CoktanSecmeliSoru soru){
            db.databaseCoktanSecmeliEkle(soru);
        }
	public void dbDogruYanlisSoruEkle(DogruYanlisSoru soru){
            db.databaseDogruYanlisSoruEkle(soru);
        }
	public void dbGozetmenEkle(String gozetmen_adi,String gozetmen_soyadi) {
		db.databaseGozetmenEkle(gozetmen_adi,gozetmen_soyadi);
	}
	
	public void dbDersEkle(Ders g) {
		db.dersEkle(g);
	}
	
	public void dersCikar(int id) {
		db.dersCikar(id);
	}
	public void dersGuncelle(Ders g) {
		db.dersGuncelle(g);
	}
	
	public void gozetmenGuncelle(int id,String gozetmen_adi, String gozetmen_soyadi) {
		db.databaseGozetmenGuncelle(id,gozetmen_adi,gozetmen_soyadi);
	}
	public void gozetmenCikar(int id) {
		db.databaseGozetmenCikar(id);
	}
	public void sinaviDbyeKaydet(Sinav sinav) {
		db.sinaviDbyeKaydet(sinav);
	}

	public void databaseDogruYanlisSoruSil(Soru soru) {
		db.databaseDogruYanlisSoruSil(soru);
	}
        public void databaseCoktanSecmeliSoruSil(Soru soru){
            db.databaseCoktanSecmeliSoruSil(soru);
        }
        public void databaseKlasikSoruSil(Soru soru){
            db.databaseKlasikSoruSil(soru);
        }
        public void dogruYanlisSoruArrayDoldur(ArrayList<Soru> soru){
            db.dogruYanlisSoruArrayDoldur(soru);
        }

    public void coktanSecmeliSoruArrayDoldur(ArrayList<Soru> soru) {
        db.coktanSecmeliSoruArrayDoldur(soru);
    }

    public void klasikSoruArrayDoldur(ArrayList<Soru> soru) {
        db.klasikSoruArrayDoldur(soru);
    }
    public void dersArrayDoldur(ArrayList<Ders> ders){
        db.dersArrayDoldur(ders);
    }
    public void dogruYanlisSoruGuncelle(Soru soru){
        db.dogruYanlisSoruGuncelle(soru);
    }
    public void coktanSecmeliSoruGuncelle(CoktanSecmeliSoru soru){
        db.coktanSecmeliSoruGuncelle(soru);
    }
    public void klasikSoruGuncelle(Soru soru){
        db.klasikSoruGuncelle(soru);
    }
    public void gozetmenArrayDoldur(ArrayList<Gozetmen> g){
        db.gozetmenArrayDoldur(g);
    }
    //**********************************************************
   
   
	public void ogrenciCikar(int id) {
		db.databaseOgrenciCikar(id);
	}
    public void dbOgrenciEkle(String ogrenci_adi,String ogrenci_soyadi,int ogrenci_numara) {
		db.databaseOgrenciEkle(ogrenci_adi,ogrenci_soyadi,ogrenci_numara);
	}

    public void ogrenciArrayDoldur(ArrayList<Ogrenci> g) {
        db.ogrenciArrayDoldur(g);
    }

    public void ogrenciGuncelle(int id, String ogrenci_adi, String ogrenci_soyadi, int ogrenci_numara) {
        db.databaseOgrenciGuncelle(id,ogrenci_adi,ogrenci_soyadi, ogrenci_numara);
    }

    public void gozetmenGuncelle(int id, String ogrenci_adi, String ogrenci_soyadi, int ogrenci_numara) {
         db.databaseOgrenciGuncelle(id,ogrenci_adi,ogrenci_soyadi, ogrenci_numara);
    }
//***************************************************************************
    public void ogretımUyesiDersArrayDoldur(ArrayList<OgretimUyesi> ogretimUyeleri) {
        db.ogretimUyesiArrayDoldur(ogretimUyeleri);
    }
    public void ogretimUyesiEkle(String ogretim_adi,String ogretim_soyadi,String ders){
              db.ogretimUyesiEkle(ogretim_adi,ogretim_soyadi,ders);
    }

    public void ogretimUyesiArrayDoldur(ArrayList<OgretimUyesi> ogretimUyeleri) {
      db.ogretimUyesiArrayDoldur(ogretimUyeleri);
    }

    
    


    
}
