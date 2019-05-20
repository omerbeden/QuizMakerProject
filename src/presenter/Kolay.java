package presenter;

import model.Sinav;
import presenter.ZorlukDerecesi;
import java.util.ArrayList;
import model.Soru;

public class Kolay extends ZorlukDerecesi{

	
	
	private ArrayList<Soru> kolaylarinYuzdesi = new ArrayList<Soru>();
	private ArrayList<Soru> normallerinYuzdesi = new ArrayList<Soru>();
	private ArrayList<Soru> zorlarinYuzdesi = new ArrayList<Soru>();
	
	

	private ArrayList<Soru> kolaylarinYuzdesi(Sinav sinav, float csyuzde,float kyuzde,float dyyuzde) {
            
		 int size = SoruBankasi.sorular.size();
	
		for(int i=0;i<size;i++) {
			
			if((kolaylarinYuzdesi.size()==Math.ceil(size*0.5)-1)) {
				break;
			}
			
                        
                        
                        else if(((SoruBankasi.sorular.get(i).getZorlukDerecesi().equalsIgnoreCase(("kolay"))&& SoruBankasi.sorular.get(i).getSoruTipi().equalsIgnoreCase("coktansecmeli") && (coktanSecmeliSoruGetir()/100)<csyuzde)) ||
                                ((SoruBankasi.sorular.get(i).getZorlukDerecesi().equalsIgnoreCase(("kolay"))&& SoruBankasi.sorular.get(i).getSoruTipi().equalsIgnoreCase("klasik") && (klasikSoruGetir()/100)<kyuzde)) ||
                                ((SoruBankasi.sorular.get(i).getZorlukDerecesi().equalsIgnoreCase(("kolay"))&& SoruBankasi.sorular.get(i).getSoruTipi().equalsIgnoreCase("dogruyanlis") && (dogruYanlisSoruGetir()/100)<dyyuzde))
                        ) {
				kolaylarinYuzdesi.add(SoruBankasi.sorular.get(i));
                         
                                
				
			}
		}
		
		return kolaylarinYuzdesi;
	}
	
	
	private ArrayList<Soru> normallerinYuzdesi(Sinav sinav, float csyuzde,float kyuzde,float dyyuzde){
		int size = SoruBankasi.sorular.size();
		for(int i=kolaylarinYuzdesi.size();i<size;i++) {
			
			if(normallerinYuzdesi.size()==Math.ceil(size*0.3)) {
				break;
			}
			
			else if(((SoruBankasi.sorular.get(i).getZorlukDerecesi().equalsIgnoreCase(("normal"))&& SoruBankasi.sorular.get(i).getSoruTipi().equalsIgnoreCase("coktansecmeli") && (coktanSecmeliSoruGetir()/100)<csyuzde)) ||
                                ((SoruBankasi.sorular.get(i).getZorlukDerecesi().equalsIgnoreCase(("normal"))&& SoruBankasi.sorular.get(i).getSoruTipi().equalsIgnoreCase("klasik") && (klasikSoruGetir()/100)<kyuzde)) ||
                                ((SoruBankasi.sorular.get(i).getZorlukDerecesi().equalsIgnoreCase(("normal"))&& SoruBankasi.sorular.get(i).getSoruTipi().equalsIgnoreCase("dogruyanlis") && (dogruYanlisSoruGetir()/100)<dyyuzde))) 
                                {
				normallerinYuzdesi.add(SoruBankasi.sorular.get(i));
			}
			
			
		}
		
		return normallerinYuzdesi;
	}
	
	private ArrayList<Soru> zorlarinYuzdesi(Sinav sinav, float csyuzde,float kyuzde,float dyyuzde){
		int size = SoruBankasi.sorular.size();
		
		for(int i=normallerinYuzdesi.size();i<size;i++) {
			
			if(zorlarinYuzdesi.size()==Math.ceil(size*0.2)) {
			}
			
			else if(((SoruBankasi.sorular.get(i).getZorlukDerecesi().equalsIgnoreCase(("zor"))&& SoruBankasi.sorular.get(i).getSoruTipi().equalsIgnoreCase("coktansecmeli") && (coktanSecmeliSoruGetir()/100)<csyuzde)) ||
                                ((SoruBankasi.sorular.get(i).getZorlukDerecesi().equalsIgnoreCase(("zor"))&& SoruBankasi.sorular.get(i).getSoruTipi().equalsIgnoreCase("klasik") && (klasikSoruGetir()/100)<kyuzde)) ||
                                ((SoruBankasi.sorular.get(i).getZorlukDerecesi().equalsIgnoreCase(("zor"))&& SoruBankasi.sorular.get(i).getSoruTipi().equalsIgnoreCase("dogruyanlis") && (dogruYanlisSoruGetir()/100)<dyyuzde))) {
				zorlarinYuzdesi.add(SoruBankasi.sorular.get(i));
			}
			
		}
		
		return zorlarinYuzdesi;
	}
	
	
	@Override
	public ArrayList<Soru>  zorlukHesapla(Sinav sinav, float csyuzde,float kyuzde,float dyyuzde) {
		
	
		ArrayList<Soru> kolayOlanSinavinSorulari = new ArrayList<Soru>();
		kolayOlanSinavinSorulari.addAll(kolaylarinYuzdesi(sinav,csyuzde,kyuzde,dyyuzde));
		kolayOlanSinavinSorulari.addAll(zorlarinYuzdesi(sinav,csyuzde,kyuzde,dyyuzde));
		kolayOlanSinavinSorulari.addAll(normallerinYuzdesi(sinav,csyuzde,kyuzde,dyyuzde));
		
		
		//sinav.sinavSorulari=kolayOlanSinavinSorulari;
		System.out.println("zorlarinyuzdesi boyutu: "+zorlarinYuzdesi.size());
		System.out.println("kolaylarinyuzdesi boyutu: "+kolaylarinYuzdesi.size());
		System.out.println("normallerinyuzdesi boyutu: "+normallerinYuzdesi.size());
		System.out.println("kolaya g�re hesapland�");
		return kolayOlanSinavinSorulari;
		
	}
	public float coktanSecmeliSoruGetir(){
            float coktansecmelisayi=0;
            for(int i = 0; i<kolaylarinYuzdesi.size();i++)
                if(kolaylarinYuzdesi.get(i).getSoruTipi().equalsIgnoreCase("coktansecmeli"))
                    coktansecmelisayi++;
                return coktansecmelisayi;
        }
        public float klasikSoruGetir(){
            float klasiksorusayisi=0;
            for(int i = 0; i<kolaylarinYuzdesi.size();i++)
                if(kolaylarinYuzdesi.get(i).getSoruTipi().equalsIgnoreCase("klasik"))
                    klasiksorusayisi++;
                return klasiksorusayisi;
        }
        public float dogruYanlisSoruGetir(){
            float dogruyanlissorusayisi=0;
            for(int i = 0; i<kolaylarinYuzdesi.size();i++)
                if(kolaylarinYuzdesi.get(i).getSoruTipi().equalsIgnoreCase("dogruyanlis"))
                    dogruyanlissorusayisi++;
                return dogruyanlissorusayisi;
        }
	

}
