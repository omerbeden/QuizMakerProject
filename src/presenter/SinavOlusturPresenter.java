/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import model.Sinav;
import dataBaseISlemleri.DBISLEMLERI;
import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Ders;
import model.Derslik;
import model.Gozetmen;
import model.Soru;
import view.ISınavOlusturView;


/**
 *
 * @author Tarza
 */
public class SinavOlusturPresenter {

   public  DBManager db = new DBManager(new MySql()) ; 
    public ISınavOlusturView isinav;
   public  GozetmenIslemleri gi = new GozetmenIslemleri();
   public  SinavIslemleri si = new SinavIslemleri();
   public  DersIslemleri di = DersIslemleri.getInstance();
    
    public SinavOlusturPresenter(ISınavOlusturView isinav){
        this.isinav = isinav;
    }
    
    
    
    
    public void sinavOlustur(String sinavAdi,String sinavKategorisi,String binaAdi,String salonKodu,String salonNo,String derslikKapasitesi,String gözetmen_adi,String zd, float sc,float sc1,float sc2) {
    
      
        Derslik derslik = new Derslik(binaAdi,salonKodu,salonNo,derslikKapasitesi);
        Sinav sinav = new Sinav();
        si.sinav=sinav;
        Gozetmen gozetmen = new Gozetmen();
        gozetmen.setGozetmenAdi(gözetmen_adi);
        gozetmen.setGozetmenSoyadi(" ");
        sinav.setSinavAdi(sinavAdi);
        Ders ders = new Ders();
        ders.setName(sinavKategorisi);
        sinav.setSinavKategorisi(ders);
        sinav.setDerslik(derslik);
        sinav.setGozetmen(gozetmen);
                if(zd=="KOLAY"){
                    sinav.setZorlukDerecesi(new Kolay());
                }else if(zd=="NORMAL"){
                    sinav.setZorlukDerecesi(new Normal());

                }else{
                     sinav.setZorlukDerecesi(new Zor());

                }
                
                
        
        sinav.setSinavSorulari(si.sorulariAyarla(sc,sc1,sc2));
        for(Soru s : sinav.getSinavSorulari()){
            
        System.out.println(s);
        }
                db.sinaviDbyeKaydet(sinav);

    }

    public void comboBoxDoldur(JComboBox tx_ders) {
        tx_ders.removeAllItems();
        for(Gozetmen d : gi.arrayDoldur()){
            tx_ders.addItem(d.getGozetmenAdi()+" "+d.getGozetmenSoyadi());
        }
        
    }
      
        public void comboBoxDersDoldur(JComboBox tx_ders) {
        tx_ders.removeAllItems();
        for(Ders d : di.arrayDoldur()){
            tx_ders.addItem(d.getName());
        }

        }

    public void gridDoldur(JTable jTable1) {
      Sinav sinav = new Sinav();
       String dizim[][]=new String[sinav.getSinavSorulari().size()][];
             for (int i = 0; i < sinav.getSinavSorulari().size(); i++) {     
                     dizim[i]=new String[]{                                   
                     valueOf(sinav.getSinavSorulari().get(i).getId()),
                     valueOf(sinav.getSinavSorulari().get(i).getSoruMetni()),
                     valueOf(sinav.getSinavSorulari().get(i).getDogruCevap()),
                     valueOf(sinav.getSinavSorulari().get(i).getPuan()),
                     valueOf(sinav.getSinavSorulari().get(i).getZorlukDerecesi()),
                     valueOf(sinav.getSinavSorulari().get(i).getDers().getName())
                     };
       TableModel tabloModeli=new DefaultTableModel(
             dizim,
             new String[] {"Soru ID", "Soru Metni", "Doğru Cevap", "Puan","Zorluk","Kategori"}                                                 
                           );
       jTable1.setModel(tabloModeli);
    }
    }
    
    public boolean puanHesapla(int istenilenPuan){
        Sinav sinav = new Sinav();
        PuanHesabi puanHesabi = new PuanHesabi(sinav.getSinavSorulari());
        
        if(puanHesabi.sorularinPuanlariniHesapla(istenilenPuan)){
            return true;
        }
        
        return false;
        
        
    }  

    public void soruSil(int id) {
        
    }
    
}
