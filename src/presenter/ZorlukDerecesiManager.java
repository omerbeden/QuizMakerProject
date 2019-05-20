package presenter;

import model.Sinav;
import java.util.ArrayList;
import model.Soru;

public class ZorlukDerecesiManager {
	
	
	// bu classa gerek olmayabilir
	//kullanmasak daha iyi sanki teste kullanmad�m
    ///harbiden yok .04.21.2019
	protected ZorlukDerecesi zorlukDerecesi;
	
	public ZorlukDerecesiManager(ZorlukDerecesi zorlukDerecesi) {
            
		this.zorlukDerecesi = zorlukDerecesi;
	}
	
	
	public ArrayList<Soru> executeStrateji(Sinav sinav, float csyuzde,float kyuzde,float dyyuzde) {
		 return zorlukDerecesi.zorlukHesapla(sinav,csyuzde,kyuzde,dyyuzde);
	}

}
