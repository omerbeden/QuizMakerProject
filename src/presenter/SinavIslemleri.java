package presenter;

import model.Sinav;
import presenter.ISinavIslemleri;
import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import java.util.ArrayList;
import model.Soru;

public class SinavIslemleri implements ISinavIslemleri {
	
	DBManager db = new DBManager(new MySql());
        public Sinav sinav;


        public void SinavIslemleri(Sinav sinav){
           this.sinav = sinav;
        }
	 public void sinaviDByeKaydet(Sinav sinav) {
		db.sinaviDbyeKaydet(sinav);
	}
         
         	
	
	public ArrayList<Soru> sorulariAyarla(float csyuzde,float kyuzde,float dyyuzde) {
		
		
		ArrayList<Soru> soruBankasiSorular = SoruBankasi.sorular; 
		
		for(int i=0;i<soruBankasiSorular.size();i++) {
			
			if(soruBankasiSorular.get(i).
                                getDers().getName().
                                equalsIgnoreCase(sinav.getSinavKategorisi().
                                        getName())) {
				sinav.getSinavSorulari().add(soruBankasiSorular.get(i));
				
			}
		}
		
		return sinav.getZorlukDerecesi().zorlukHesapla(sinav,csyuzde,kyuzde,dyyuzde);
	}
}
