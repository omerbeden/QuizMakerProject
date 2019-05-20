package presenter;

import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import java.util.ArrayList;
import model.Ders;

public class DersIslemleri {
	
	private Ders ders;
	private  DBManager db = new DBManager(new MySql()) ;
	ArrayList<Ders> dersler=new ArrayList<Ders>();
        
	private static DersIslemleri instance = new DersIslemleri();
	
	private  DersIslemleri() {
            
	}
	
	public static DersIslemleri getInstance() {
		
		return instance;
	}
	
	public Ders getDers() {
		return ders;
	}

	public void setDers(Ders ders) {
		this.ders = ders;
	}

	
	public void dersEkle(Ders ders) {
		this.ders = ders;
		System.out.println("veri tab�na ekleniyor");
		db.dbDersEkle((ders));
		
	}
	
	public void  dersCikar(int id) {
		
		System.out.println("veri taban�ndan ��kart�l�yor");
		db.dersCikar(id);
                
	}
	
	public void  dersGuncelle(Ders ders,Ders guncellenmis) {
		db.dersGuncelle(ders);
		
	}
        
        
        public ArrayList<Ders> arrayDoldur(){
            dersler.removeAll(dersler);
            db.dersArrayDoldur(dersler);
            return dersler;
        }
        
        public ArrayList<Ders> getArrayList(){
            return dersler;
        }
       
}
