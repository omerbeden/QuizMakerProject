package presenter;

import model.Gozetmen;

public interface IGozetmenIslemleri {
	
	public void gozetmenEkle(String gozetmen_adi,String gozetmen_soyadi);
	public void gozetmenCikar(int id);
	public void gozetmenGuncelle(int id,String gozetmen_adi,String gozetmen_soyadi);

}
