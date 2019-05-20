package presenter;

import model.Sinav;
import java.util.ArrayList;
import model.Soru;

public abstract class ZorlukDerecesi {

	abstract ArrayList<Soru> zorlukHesapla(Sinav sinav,float csyuzde,float kyuzde,float dyyuzde);

}
