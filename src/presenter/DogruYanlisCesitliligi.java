package presenter;

import presenter.SoruCesitliligi;
import model.Sinav;
import java.util.ArrayList;
import model.*;

public class DogruYanlisCesitliligi extends SoruCesitliligi{

	
	
	public DogruYanlisCesitliligi(float yuzde) {
		super(yuzde);
	}

    @Override
      int soruCesitliğiniAdediGetir(Sinav si) {
        int adet=0;
       for(int i=0;i<si.getSinavSorulari().size();i++){
           
           if(si.getSinavSorulari().get(i).getSoruTipi().equalsIgnoreCase("dogruyanlis"))
               adet++;
       }
        
        return adet;
    }
	
	
}
