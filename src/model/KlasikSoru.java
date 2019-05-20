package model;

public class KlasikSoru extends Soru{

	

	public KlasikSoru(String soruMetni, String zorlukDerecesi, String dogruCevap,
					int puan, Ders ders) {
		super(soruMetni, zorlukDerecesi, dogruCevap, puan, ders);
		soruTipi="Klasik";
	}
	
	public KlasikSoru() {
		soruTipi="Klasik";
	}

	@Override
	public void setDogruCevap(String str) {
		super.dogruCevap=str;
	}

	@Override
	public void setSoruMetni(String soruMetni) {
		super.soruMetni=soruMetni;
	}

    
        
}
