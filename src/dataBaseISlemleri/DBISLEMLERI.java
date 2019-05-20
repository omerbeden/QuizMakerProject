package dataBaseISlemleri;
import java.util.ArrayList;

import model.CoktanSecmeliSoru;
import model.Ders;
import model.DogruYanlisSoru;
import model.Gozetmen;
import model.Ogrenci;
import model.OgretimUyesi;
import model.Sinav;
import model.Soru;

public interface DBISLEMLERI {
	
	public void databaseKlasikSoruEkle(Soru soru);
	public void databaseGozetmenEkle(String gozetmen_adi,String gozetmen_soyadi);
	public void dersEkle(Ders g);
	public void dersCikar(int id);
	public void dersGuncelle(Ders g);
	public void databaseGozetmenCikar(int id);
	public void databaseGozetmenGuncelle(int id,String gozetmen_adi, String gozetmen_soyadi);
	public void sinaviDbyeKaydet(Sinav sinav);
        public void databaseCoktanSecmeliSoruSil(Soru soru);
        public void databaseDogruYanlisSoruSil(Soru soru);
        public void databaseKlasikSoruSil(Soru soru);
        public void databaseCoktanSecmeliEkle(CoktanSecmeliSoru soru);
        public void databaseDogruYanlisSoruEkle(DogruYanlisSoru soru);
        public void dogruYanlisSoruArrayDoldur(ArrayList<Soru> soru);
        public void coktanSecmeliSoruArrayDoldur(ArrayList<Soru> soru);
        public void klasikSoruArrayDoldur(ArrayList<Soru> soru);
        public void dersArrayDoldur(ArrayList<Ders> ders);
        public void dogruYanlisSoruGuncelle(Soru soru);
        public void klasikSoruGuncelle(Soru soru);
        public void coktanSecmeliSoruGuncelle(CoktanSecmeliSoru soru);
        public void gozetmenArrayDoldur(ArrayList<Gozetmen> g);
        
        
        //**********************************************************************
         public void ogrenciArrayDoldur(ArrayList<Ogrenci> g);

  

    public void databaseOgrenciCikar(int id);

 

    public void databaseOgrenciGuncelle(int id, String ogrenci_adi, String ogrenci_soyadi, int ogrenci_numara);

    public void databaseOgrenciEkle(String ogrenci_adi, String ogrenci_soyadi, int ogrenci_numara);
    //*********************************************************************************************

    public void ogretimUyesiArrayDoldur(ArrayList<OgretimUyesi> ogretimUyeleri);

    public void ogretimUyesiEkle(String ogretim_adi, String ogretim_soyadi,String ders);
	

}
