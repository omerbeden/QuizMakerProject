package model;

import presenter.ISecenekEkleyebilme;


public class CoktanSecmeliSoru extends Soru implements ISecenekEkleyebilme{
	
	 String secenekler[]= new String[4];
	public CoktanSecmeliSoru(String soruMetni, String zorlukDerecesi, String dogruCevap,
							int puan, Ders ders) {
		super(soruMetni, zorlukDerecesi, dogruCevap, puan, ders);
		soruTipi="CoktanSecmeli";
                
	}

    public CoktanSecmeliSoru() {
        soruTipi="CoktanSecmeli";
        
    }



	@Override
	public void setDogruCevap(String str) {
		super.dogruCevap = str;
	}

	@Override
	public void setSoruMetni(String soruMetni) {
		super.soruMetni = soruMetni;
	}
      
    
    public String[] getSecenekler() {
        return secenekler;
    }

    @Override
    public void secenekEkle(String secenek) {
        
        for(int i=0;i<secenekler.length;i++){
           if(secenekler[i]==null){
               secenekler[i]=secenek;
               break;
           }
           
        }
            
        }
    

}
