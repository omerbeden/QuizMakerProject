/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Soru;
/**
 *
 * @author Tarza
 */
public interface ICoktanSecmeliSoru {
    public void csSoruEkle();
    public void csSoruSil();
    public void csSoruGuncelle();
    public void dersGetir();
    public void gridDoldur();
    public void comoboBoxDoldur();

    public void kategoriyeGoreListele();
    public void puanaGoreListele();
}
