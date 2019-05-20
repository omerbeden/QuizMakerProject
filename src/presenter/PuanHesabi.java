package presenter;

import presenter.IPuanHesabi;
import java.util.ArrayList;
import model.Soru;

public class PuanHesabi implements IPuanHesabi {

	protected ArrayList<Soru> sorular;
	
	private  int toplamPuan;
	
	public PuanHesabi(ArrayList<Soru> sorular) {
		this.sorular=sorular;
	}
	
	@Override
	public boolean sorularinPuanlariniHesapla(int istenilenPuan) {
		int puan=0;
		
		for(int i=0;i<sorular.size();i++) {
			puan = puan + sorular.get(i).getPuan();
		}
		toplamPuan = puan;
		if(puan < istenilenPuan)
			return false;
		
		else if(puan > istenilenPuan)
			return false;
				
		return true;
	}


	public int getToplamPuan() {
		return toplamPuan;
	}
        
        public void setToplamPuan(int toplamPuan) {
		this.toplamPuan = toplamPuan;
        }
	
	

}
