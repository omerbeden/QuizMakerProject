package presenter;

import model.Sinav;
import java.util.ArrayList;
import model.Soru;

public class SoruCesitliligiManager {
	
	protected SoruCesitliligi kCesitliligi;
	protected SoruCesitliligi csCesitliligi;
	protected SoruCesitliligi dyCesitliligi;

	public SoruCesitliligiManager(SoruCesitliligi kCesitliligi,SoruCesitliligi csCesitliligi,
									SoruCesitliligi dyCesitliligi) {

		this.csCesitliligi = csCesitliligi;
		this.dyCesitliligi = dyCesitliligi;
		this.kCesitliligi = kCesitliligi;
	}

	private boolean bosMu(Sinav sinav) {
		if(sinav.getSinavSorulari().size()>0)
			return false;
		return true;
	}
	
	private void sinavSorulariniSıfırla(Sinav sinav) {
		if(bosMu(sinav)==false) {
			sinav.getSinavSorulari().removeAll(sinav.getSinavSorulari());
		}
	}
	
	
	
	

}
