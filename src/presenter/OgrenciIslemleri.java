/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import java.util.ArrayList;
import model.Gozetmen;
import model.Ogrenci;


public class OgrenciIslemleri implements IOgrenciIslemleri {
    
    DBManager db = new DBManager(new MySql());
        ArrayList<Ogrenci> ogrenci = new ArrayList<Ogrenci>();

    @Override
    public void ogrenciEkle(String ogrenci_adi, String ogrenci_soyadi,int ogrenci_numara) {
       db.dbOgrenciEkle(ogrenci_adi,ogrenci_soyadi,ogrenci_numara);
    }

    @Override
    public void ogrenciCikar(int id) {
       db.ogrenciCikar(id);
    }

    @Override
    public void ogrenciGuncelle(int id, String ogrenci_adi, String ogrenci_soyadi,int ogrenci_numara) {
        db.ogrenciGuncelle(id,ogrenci_adi,ogrenci_soyadi,ogrenci_numara);
    }
    public ArrayList<Ogrenci> arrayDoldur(){
       
            db.ogrenciArrayDoldur(ogrenci);
            return ogrenci;
        }

    public ArrayList<Ogrenci> getArrayList() {
        return ogrenci;
    }

}
