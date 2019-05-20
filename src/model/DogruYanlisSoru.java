package model;

import presenter.ISecenekEkleyebilme;


public class DogruYanlisSoru extends Soru implements ISecenekEkleyebilme{

	 String secenekler[]= new String[2];
	
	public DogruYanlisSoru() {
		soruTipi="DogruYanlis";
               
	}

	public DogruYanlisSoru(String soruMetni, String zorlukDerecesi, String dogruCevap, int puan, Ders ders) {
		super(soruMetni, zorlukDerecesi, dogruCevap, puan, ders);
		soruTipi="DogruYanlis";
                secenekler= new String[2];
	}

	@Override
	public void setDogruCevap(String str) {
		super.dogruCevap = str;
		
	}
        
        public void setSecenekler(String  secenekler[]) {
		this.secenekler[0] = secenekler[0];
                this.secenekler[1] = secenekler[1];
		
	}
        
	@Override
	public void setSoruMetni(String soruMetni) {
		super.soruMetni = soruMetni;
	}


    public String[] getSecenekler() {
       return this.secenekler;
    }
    

    @Override
    public void secenekEkle(String secenek) {
            for(int i=0;i<secenekler.length;i++){
           if(secenekler[i]==null)
               secenekler[i]=secenek;break;
        }
    }
}
