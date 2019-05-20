package presenter;

import model.Soru;

public interface ISoruIslemleri {

	void soruEkle(Soru soru);

	void soruSil(Soru soru);
        void soruGuncelle(Soru soru);
}
