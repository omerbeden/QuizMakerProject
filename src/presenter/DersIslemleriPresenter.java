
package presenter;

import dataBaseISlemleri.DBISLEMLERI;
import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Ders;
import view.IDERSIslemleri;
import view.IDYForm;


public class DersIslemleriPresenter {
    
     IDERSIslemleri ders;
    DersIslemleri dersI=DersIslemleri.getInstance();

    public DersIslemleriPresenter ( IDERSIslemleri ders) {
        
        
        this.ders=ders;
    }
    
    public void dersEkle(String dersAdi) {
      
        dersI.dersEkle(new Ders(dersAdi));
        
    }

 
    public void dersSil(int id) {
        dersI.dersCikar(id);
    }

   
    public void dersGuncelle() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    public void gridDoldur(JTable table){
       String dizim[][]=new String[dersI.arrayDoldur().size()][];
             for (int i = 0; i < dersI.getArrayList().size(); i++) {     
                     dizim[i]=new String[]{                                   
                     valueOf(dersI.getArrayList().get(i).getId()),
                     valueOf(dersI.getArrayList().get(i).getName())
                     };
       TableModel tabloModeli=new DefaultTableModel(
             dizim,
             new String[] {"Ders ID", "Ders Adı"}                                                 
                           );
       table.setModel(tabloModeli);
    }
    }
}
