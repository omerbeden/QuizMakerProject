package presenter;

import model.Sinav;
import presenter.ZorlukDerecesi;
import java.util.ArrayList;
import model.Soru;

public class Normal extends ZorlukDerecesi {


	private ArrayList<Soru> kolaylarinYuzdesi = new ArrayList<Soru>();
	private ArrayList<Soru> normallerinYuzdesi = new ArrayList<Soru>();
	private ArrayList<Soru> zorlarinYuzdesi = new ArrayList<Soru>();
	
	


	private ArrayList<Soru> kolaylarinYuzdesi(Sinav sinav, float csyuzde,float kyuzde,float dyyuzde) {
		int size = sinav.getSinavSorulari().size();
		
		for(int i=0;i<size;i++) {
			
			if(kolaylarinYuzdesi.size()==Math.ceil(size*0.3)){
				break;
			}
			
			else if(sinav.getSinavSorulari().get(i).getZorlukDerecesi().equalsIgnoreCase(("kolay"))) {
				kolaylarinYuzdesi.add(sinav.getSinavSorulari().get(i));
			}
			
			
			
		}
		
		return kolaylarinYuzdesi;
	}
	
	
	private ArrayList<Soru> normallerinYuzdesi(Sinav sinav, float csyuzde,float kyuzde,float dyyuzde){
		
		int size = sinav.getSinavSorulari().size();
		
		for(int i=0;i<size;i++) {
			
			if(normallerinYuzdesi.size()==Math.ceil(size*0.5)) {
				break;
			}
			
			else if(sinav.getSinavSorulari().get(i).getZorlukDerecesi().equalsIgnoreCase("normal")) {
				normallerinYuzdesi.add(sinav.getSinavSorulari().get(i));
			}
			
			
		}
		
		return normallerinYuzdesi;
	}
	
	private ArrayList<Soru> zorlarinYuzdesi(Sinav sinav, float csyuzde,float kyuzde,float dyyuzde){
		int size = sinav.getSinavSorulari().size();
		for(int i=0;i<size;i++) {
			if(zorlarinYuzdesi.size()==Math.ceil(size*0.2)) {
				break;
			}
			
			else if(sinav.getSinavSorulari().get(i).getZorlukDerecesi().equalsIgnoreCase("zor")) {
				zorlarinYuzdesi.add(sinav.getSinavSorulari().get(i));
			}
			
		
		}
		
		return zorlarinYuzdesi;
	}
	
	@Override
	public ArrayList<Soru>  zorlukHesapla(Sinav sinav, float csyuzde,float kyuzde,float dyyuzde) {
		
		ArrayList<Soru> normalOlanSinavinSorulari = new ArrayList<Soru>();
		
		normalOlanSinavinSorulari.addAll(kolaylarinYuzdesi(sinav,csyuzde,kyuzde,dyyuzde) );
		normalOlanSinavinSorulari.addAll(normallerinYuzdesi(sinav,csyuzde,kyuzde,dyyuzde) );
		normalOlanSinavinSorulari.addAll(zorlarinYuzdesi(sinav,csyuzde,kyuzde,dyyuzde) );
		
		
		System.out.println("zorlarinyuzdesi boyutu: "+zorlarinYuzdesi.size());
		System.out.println("kolaylarinyuzdesi boyutu: "+kolaylarinYuzdesi.size());
		System.out.println("normallerinyuzdesi boyutu: "+normallerinYuzdesi.size());
		System.out.println("normal e g�re hesaplandi");
		return  normalOlanSinavinSorulari;
	}

}
