package presenter;

import model.Sinav;
import java.util.ArrayList;
import model.Soru;

public abstract class SoruCesitliligi {
	
	protected float yuzde;
        

	
	public SoruCesitliligi(float yuzde) {
		this.yuzde = yuzde;
	}

	abstract int  soruCesitliğiniAdediGetir(Sinav si);

}
