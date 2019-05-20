package presenter;

import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import java.util.ArrayList;
import model.*;

public class OgretimUyesiIslemleri {
    
    ArrayList <OgretimUyesi> ogretimUyeleri = new ArrayList<OgretimUyesi>();
    DBManager db = new DBManager(new MySql());
    
    public OgretimUyesiIslemleri(){
        
    }
    
    public void ogretimUyesiEkle(OgretimUyesi uye){
        ogretimUyeleri.add(uye); 
        db.ogretimUyesiEkle(uye.getIsım(), uye.getSoyad(),uye.getDers().get(0).toString());
        
    }
    
    public void ogretimUyesiCikar(OgretimUyesi uye){
        ogretimUyeleri.remove(uye);
    }
    
    public void ogretimUyesineDersEkle(int id,String e){
        
        for(int i=0;i<ogretimUyeleri.size();i++){
            if(ogretimUyeleri.get(i).getId()==id){
                ogretimUyeleri.get(i).getDers().add(new Ders(e));
            }
        }
    }
            public ArrayList<OgretimUyesi> arrayDoldur(){
            ogretimUyeleri.removeAll(ogretimUyeleri);
            db.ogretımUyesiDersArrayDoldur(ogretimUyeleri);
            return ogretimUyeleri;
        }
}
