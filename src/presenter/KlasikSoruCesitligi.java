package presenter;

import presenter.SoruCesitliligi;
import model.Sinav;
import java.util.ArrayList;
import model.*;

public class KlasikSoruCesitligi extends SoruCesitliligi{
	
	protected ArrayList<Soru> klasikCesitliligi = new ArrayList<Soru>();
	
	public KlasikSoruCesitligi(float yuzde) {
		super(yuzde);
	}
	
	@Override
int soruCesitliğiniAdediGetir(Sinav si) {
        int adet=0;
       for(int i=0;i<si.getSinavSorulari().size();i++){
           
           if(si.getSinavSorulari().get(i).getSoruTipi().equalsIgnoreCase("klasik"))
               adet++;
       }
        
        return adet;
    }

}
