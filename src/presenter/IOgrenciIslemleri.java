/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import model.Ogrenci;

public interface IOgrenciIslemleri {
    
    public void ogrenciEkle(String ogrenci_adi,String ogrenci_soyadi,int ogrenci_numara);
	public void ogrenciCikar(int id);
	public void ogrenciGuncelle(int id,String ogrenci_adi,String ogrenci_soyadi,int ogrenci_numara);
    
}
