
package presenter;

import presenter.SoruCesitliligi;
import model.Sinav;
import java.util.ArrayList;
import model.Soru;

public class CoktanSecmeliCesitliligi extends SoruCesitliligi{


	
	
	public CoktanSecmeliCesitliligi(float yuzde) {
		super(yuzde);
	}


    @Override
    int soruCesitliğiniAdediGetir(Sinav si) {
        int adet=0;
       for(int i=0;i<si.getSinavSorulari().size();i++){
           
           if(si.getSinavSorulari().get(i).getSoruTipi().equalsIgnoreCase("coktanSecmeli"))
               adet++;
       }
        
        return adet;
    }

    
            
}


