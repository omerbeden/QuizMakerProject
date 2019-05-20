package presenter;

import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import javax.swing.JComboBox;
import model.Ders;
import model.OgretimUyesi;
import view.IOgretimUyesi;


public class OgretimUyesiPresenter {
    
    OgretimUyesiIslemleri islem = new OgretimUyesiIslemleri();
    IOgretimUyesi uye;
    
    public OgretimUyesiPresenter(IOgretimUyesi uye){
        this.uye = uye;
    }
    
    public void sil(int id){
        for(int i=0;i<islem.ogretimUyeleri.size();i++){
            if(islem.ogretimUyeleri.get(i).getId()==id){
            islem.ogretimUyesiCikar(islem.ogretimUyeleri.get(i));
            }
        }
    }
    
    public void ekle(String ad,String soyad,String ders){
        
        OgretimUyesi uye = new OgretimUyesi();
        uye.setAd(ad);
        uye.setSoyad(soyad);
        uye.getDers().add(new Ders(ders));
        islem.ogretimUyesiEkle(uye);
    }
    
    public void ogretimUyesineDersEkle(int id,String Ders){
        islem.ogretimUyesineDersEkle(id, Ders);
    }
    
    
}
