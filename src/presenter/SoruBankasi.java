package presenter;

import presenter.ISoruIslemleri;
import presenter.IPuanaGoreListelebilme;
import presenter.IKategorisineGoreListelenebilme;
import java.util.ArrayList;
import java.util.Collections;

import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import model.CoktanSecmeliSoru;
import model.DogruYanlisSoru;
import model.*;

public  class SoruBankasi implements ISoruIslemleri,IPuanaGoreListelebilme,IKategorisineGoreListelenebilme {
	

	protected static ArrayList<Soru> sorular = new ArrayList<Soru>();
        
	DBManager db = new DBManager(new MySql());

	@Override
	public void soruEkle(Soru soru) {
            
		if(soru.getSoruTipi().equalsIgnoreCase("klasik")){
                    db.dbKlasikSoruEkle(soru);
                } else if(soru.getSoruTipi().equalsIgnoreCase("coktansecmeli")){
                    db.dbCoktanSecmeliSoruEkle((CoktanSecmeliSoru)soru);
                } else {
                    db.dbDogruYanlisSoruEkle((DogruYanlisSoru)soru);
                    
                }
	}
        public ArrayList<Soru> dogruYanlisArrayDoldur(){
            db.dogruYanlisSoruArrayDoldur(sorular);
            return this.sorular;
        }
        public ArrayList<Soru> coktanSecmeliArrayDoldur(){
            db.coktanSecmeliSoruArrayDoldur(sorular);
            return this.sorular;
        }
        public ArrayList<Soru> getArrayList(){
            return this.sorular;
        }
        
        public ArrayList<Soru> klasikArrayDoldur(){
            db.klasikSoruArrayDoldur(sorular);
            return this.sorular;
        }
	@Override
	public void soruSil(Soru soru) {
            sorular.remove(soru);
                if(soru.getSoruTipi().equalsIgnoreCase("klasik")){
                    db.databaseKlasikSoruSil(soru);
                    
                } else if(soru.getSoruTipi().equalsIgnoreCase("coktansecmeli")){
                    db.databaseCoktanSecmeliSoruSil(soru);     
                   
                } else {
                   db.databaseDogruYanlisSoruSil(soru);
                   
                }     
	}
 
	@Override
	public ArrayList<Soru> kategorisineGoreListele() {
		Collections.sort(sorular, Soru.soruKategorisiComp);
		return sorular;
	}

	@Override
	public ArrayList<Soru> puanaGoreListele() {
		Collections.sort(sorular);
                return sorular;
	}

    @Override
    public void soruGuncelle(Soru soru) {
        if(soru.getSoruTipi().equalsIgnoreCase("klasik")){
                db.klasikSoruGuncelle(soru);
                } else if(soru.getSoruTipi().equalsIgnoreCase("coktansecmeli")){
                    db.coktanSecmeliSoruGuncelle((CoktanSecmeliSoru)soru);     
                } else {
                    db.dogruYanlisSoruGuncelle(soru);
                   
                } 
    }
   
	
}
