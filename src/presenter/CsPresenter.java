
package presenter;

import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import java.awt.List;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.CoktanSecmeliSoru;
import model.Ders;
import model.DogruYanlisSoru;
import model.Soru;
import view.ICoktanSecmeliSoru;



public  class CsPresenter {

    ICoktanSecmeliSoru form;
    ISecenekEkleyebilme secenekEkleyebilme;
    SoruBankasi s1=new SoruBankasi();
        DersIslemleri di = DersIslemleri.getInstance();

    public CsPresenter( ICoktanSecmeliSoru form) {
        
        this.form=form;
    }
    
    public void csSoruSil(int id) {

       for(int i=0;i<s1.sorular.size();i++){
            if(s1.sorular.get(i).getId()==id){
            s1.soruSil(s1.sorular.get(i));
            }
        } 
        
    }

    public void csSoruGuncelle(String text,String text0,String text1,String text2,String text3, Object selectedItem, Object selectedItem0, Object selectedItem1, Object selectedItem2,int id) {
        for(int i=0;i<s1.sorular.size();i++){
            if(s1.sorular.get(i).getId()==id){
                
            CoktanSecmeliSoru soru = (CoktanSecmeliSoru)s1.sorular.get(i);
            
            s1.sorular.get(i).setSoruMetni(text);
            s1.sorular.get(i).setDers(new Ders(selectedItem.toString()));
            s1.sorular.get(i).setDogruCevap(selectedItem0.toString());
            s1.sorular.get(i).setZorlukDerecesi(selectedItem1.toString());
            s1.sorular.get(i).setPuan(Integer.parseInt(selectedItem2.toString()));     
            soru.secenekEkle(text0);
            soru.secenekEkle(text1);
            soru.secenekEkle(text2);
            soru.secenekEkle(text3);
            s1.soruGuncelle(s1.sorular.get(i));
            }    
        }
    }
   
    public void dersGetir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void csSoruEkle(String text, String text0, String text1, String text2, String text3, Object selectedItem, Object selectedItem0, Object selectedItem1, Object selectedItem2) {
        CoktanSecmeliSoru cs = new CoktanSecmeliSoru();
        cs.setSoruMetni(text);          
    //    cs.setSecenek(text0, text1, text2, text3);
        cs.setDers(new Ders(selectedItem.toString()));
        cs.setDogruCevap(selectedItem0.toString());
        cs.setZorlukDerecesi(selectedItem1.toString());
        cs.setPuan(Integer.parseInt(selectedItem2.toString()));
       cs.secenekEkle(text0);
       cs.secenekEkle(text1);
       cs.secenekEkle(text2);
       cs.secenekEkle(text3);

        s1.soruEkle(cs);
    }
    
    public void gridDoldur(JTable table){
       
        SoruBankasi sb= new SoruBankasi();
        sb.getArrayList().removeAll(sb.getArrayList());
       String dizim[][]=new String[sb.coktanSecmeliArrayDoldur().size()][];
             for (int i = 0; i < sb.getArrayList().size(); i++) {     
                     dizim[i]=new String[]{                                   
                     valueOf(sb.getArrayList().get(i).getId()),
                     valueOf(sb.getArrayList().get(i).getSoruMetni()),
                     valueOf(sb.getArrayList().get(i).getDogruCevap()),
                     valueOf(sb.getArrayList().get(i).getPuan()),
                     valueOf(sb.getArrayList().get(i).getZorlukDerecesi()),
                     valueOf(sb.getArrayList().get(i).getDers().getName())
                     };
       TableModel tabloModeli=new DefaultTableModel(
             dizim,
             new String[] {"Soru ID", "Soru Metni", "Doğru Cevap", "Puan","Zorluk","Kategori"}                                                 
                           );
       table.setModel(tabloModeli);
    }
}
        public void comboBoxDoldur(JComboBox tx_ders) {
        tx_ders.removeAllItems();
        for(Ders d : di.arrayDoldur()){
            tx_ders.addItem(d.getName());
        }
    }
            public void kategoriyeGoreListele(JTable jTable1) {
        SoruBankasi sb =new SoruBankasi();
       String dizim[][]=new String[sb.kategorisineGoreListele().size()][];
             for (int i = 0; i < sb.getArrayList().size(); i++) {     
                     dizim[i]=new String[]{                                   
                     valueOf(sb.getArrayList().get(i).getId()),
                     valueOf(sb.getArrayList().get(i).getSoruMetni()),
                     valueOf(sb.getArrayList().get(i).getDogruCevap()),
                     valueOf(sb.getArrayList().get(i).getPuan()),
                     valueOf(sb.getArrayList().get(i).getZorlukDerecesi()),
                     valueOf(sb.getArrayList().get(i).getDers().getName())
                     };
       TableModel tabloModeli=new DefaultTableModel(
             dizim,
             new String[] {"Soru ID", "Soru Metni", "Doğru Cevap", "Puan","Zorluk","Kategori"}                                                 
                           );
       jTable1.setModel(tabloModeli);
    }
    }

    public void puanaGoreListele(JTable jTable1) {
        SoruBankasi sb =new SoruBankasi();
       String dizim[][]=new String[sb.puanaGoreListele().size()][];
             for (int i = 0; i < sb.getArrayList().size(); i++) {     
                     dizim[i]=new String[]{                                   
                     valueOf(sb.getArrayList().get(i).getId()),
                     valueOf(sb.getArrayList().get(i).getSoruMetni()),
                     valueOf(sb.getArrayList().get(i).getDogruCevap()),
                     valueOf(sb.getArrayList().get(i).getPuan()),
                     valueOf(sb.getArrayList().get(i).getZorlukDerecesi()),
                     valueOf(sb.getArrayList().get(i).getDers().getName())
                     };
       TableModel tabloModeli=new DefaultTableModel(
             dizim,
             new String[] {"Soru ID", "Soru Metni", "Doğru Cevap", "Puan","Zorluk","Kategori"}                                                 
                           );
       jTable1.setModel(tabloModeli);
    }
    }
}
