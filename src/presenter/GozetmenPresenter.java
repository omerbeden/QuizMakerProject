/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Gozetmen;
import view.IGozetmenView;

/**
 *
 * @author Tarza
 */
public class GozetmenPresenter {
    
    	DBManager db = new DBManager(new MySql());
        IGozetmenView view;
        
        public GozetmenPresenter(IGozetmenView view ){
            this.view = view;
        }
        
        	
	public void gozetmenEkle(String gozetmen_adi,String gozetmen_soyadi) {
		db.dbGozetmenEkle(gozetmen_adi,gozetmen_soyadi);
	}
	
	public void gozetmenCikar(int id) {
		db.gozetmenCikar(id);
	}
	
	public void gozetmenGuncelle(int id,String gozetmen_adi,String gozetmen_soyadi) {
		db.gozetmenGuncelle(id,gozetmen_adi,gozetmen_soyadi);
	}
        
        public void gozetmenGridDoldur(JTable jtable){
            GozetmenIslemleri sb = new GozetmenIslemleri();
            
        sb.getArrayList().removeAll(sb.getArrayList());
       String dizim[][]=new String[sb.arrayDoldur().size()][];
             for (int i = 0; i < sb.getArrayList().size(); i++) {     
                     dizim[i]=new String[]{                                   
                     valueOf(sb.getArrayList().get(i).getId()),
                     valueOf(sb.getArrayList().get(i).getGozetmenAdi()),
                     valueOf(sb.getArrayList().get(i).getGozetmenSoyadi()),

                     };
       TableModel tabloModeli=new DefaultTableModel(
             dizim,
             new String[] {"Gözetmen ID", "Gözetmen Adı", "Gözetmen Soyadi"}                                                 
                           );
       jtable.setModel(tabloModeli);
        }

        }
}
