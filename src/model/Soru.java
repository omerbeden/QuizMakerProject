package model;

import java.util.Comparator;

public abstract class Soru implements Comparable<Soru>{

	private String zorlukDerecesi;
	protected String dogruCevap;
	private int puan;
	private Ders ders;
	protected  String soruMetni;
	protected  String soruTipi;
        protected int id;
        
        
	public Soru() {
		
	}
	
	public Soru(String soruMetni,String zorlukDerecesi, String dogruCevap, int puan, Ders ders) {
		
		this.zorlukDerecesi = zorlukDerecesi;
		this.dogruCevap = dogruCevap;
		this.puan = puan;
		this.ders = ders;
		this.soruMetni = soruMetni;
                
	}
	
	public abstract void setDogruCevap(String str);
	public abstract void setSoruMetni(String soruMetni);
       


	public String getDogruCevap() {
		return dogruCevap;
	}
	
	public void setZorlukDerecesi(String zorlukDerecesi) {
		this.zorlukDerecesi = zorlukDerecesi;
	}

	public String getZorlukDerecesi() {
		return zorlukDerecesi;
	}

	public void guncelleZorlukDerecesi(String zorlukDerecesi) {

		if (zorlukDerecesi == null) {
			System.out.println("guncellemek icin �nce bir zorlukDerecen olmali");
			return;
		}

		setZorlukDerecesi(zorlukDerecesi);
	}
        public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuan() {
		return puan;
	}

	public void setPuan(int puan) {
		this.puan = puan;
	}
        
	

	public String getSoruMetni() {
		return soruMetni;
	}

	public Ders getDers() {
		return ders;
	}
        
        public String getSoruTipi() {
	return soruTipi;
	}

	public void setDers(Ders ders) {
		this.ders = ders;
	}

	@Override
	public int compareTo(Soru soru) {
		int comp = ((Soru)soru).getPuan();
		return  this.puan-comp;
	}
	
	public static Comparator<Soru> soruKategorisiComp = new Comparator<Soru>() {

		@Override
		public int compare(Soru arg0, Soru arg1) {
			
			String soruDers0 = arg0.ders.getName();
			String soruDers1 = arg1.ders.getName();
			
			return soruDers0.compareTo(soruDers1);
		}
		
	};

	@Override
	public String toString() {
		return "Soru [zorlukDerecesi=" + zorlukDerecesi + ", dogruCevap=" + dogruCevap + ", puan=" + puan + ", ders="
				+ ders + ", soruMetni=" + soruMetni + "soru tipi: "+soruTipi +"]";
	}
        
       
	
	
	

}
