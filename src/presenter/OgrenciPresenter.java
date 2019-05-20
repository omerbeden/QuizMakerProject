/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import static java.lang.String.valueOf;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import view.IOgrenciView;

/**
 *
 * @author Gabya
 */
public class OgrenciPresenter {
    
    DBManager db = new DBManager(new MySql());
        IOgrenciView view;
        
        public OgrenciPresenter(IOgrenciView view ){
            this.view = view;
        }
        
        
        public void ogrenciEkle(String ogrenci_adi,String ogrenci_soyadi,int ogrenci_numara) {
		db.dbOgrenciEkle(ogrenci_adi,ogrenci_soyadi,ogrenci_numara);
	}
	
	public void ogrenciCikar(int id) {
		db.ogrenciCikar(id);
	}
	
	public void ogrenciGuncelle(int id,String ogrenci_adi,String ogrenci_soyadi,int ogrenci_numara) {
		db.ogrenciGuncelle(id,ogrenci_adi,ogrenci_soyadi,ogrenci_numara);
	}
        
        public void ogrenciGridDoldur(JTable jtable){
            OgrenciIslemleri sb = new OgrenciIslemleri();
            
        sb.getArrayList().removeAll(sb.getArrayList());
       String dizim[][]=new String[sb.arrayDoldur().size()][];
             for (int i = 0; i < sb.getArrayList().size(); i++) {     
                     dizim[i]=new String[]{                                   
                     valueOf(sb.getArrayList().get(i).getId()),
                     valueOf(sb.getArrayList().get(i).getOgrenciAdi()),
                     valueOf(sb.getArrayList().get(i).getOgrenciSoyadi()),
                     valueOf(sb.getArrayList().get(i).getOgrenciNumara()),

                     };
       TableModel tabloModeli=new DefaultTableModel(
             dizim,
             new String[] {"Ogrenci ID", "Ogrenci Adı", "Ogrenci Soyadi", "Ogrenci Numara"}                                                 
                           );
       jtable.setModel(tabloModeli);
        }

        }
        
    
}
