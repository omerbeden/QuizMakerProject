package presenter;

import presenter.IGozetmenIslemleri;
import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Ders;
import model.Gozetmen;
import view.IGozetmenView;

public class GozetmenIslemleri implements IGozetmenIslemleri{
	
	DBManager db = new DBManager(new MySql());
        ArrayList<Gozetmen> gozetmen = new ArrayList<Gozetmen>();
        
        
	@Override
	public void gozetmenEkle(String gozetmen_adi, String gozetmen_soyadi) {
		db.dbGozetmenEkle(gozetmen_adi,gozetmen_soyadi);
	}
	@Override
	public void gozetmenCikar(int id) {
		db.gozetmenCikar(id);
	}
	
	public void gozetmenGuncelle(int id,String gozetmen_adi, String gozetmen_soyadi) {
		db.gozetmenGuncelle(id,gozetmen_adi,gozetmen_soyadi);
	}
        
         public ArrayList<Gozetmen> arrayDoldur(){
       
            db.gozetmenArrayDoldur(gozetmen);
            return gozetmen;
        }

    public ArrayList<Gozetmen> getArrayList() {
        return gozetmen;
    }

    

        

}
