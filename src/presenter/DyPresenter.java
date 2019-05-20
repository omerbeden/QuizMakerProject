
package presenter;

import dataBaseISlemleri.DBManager;
import dataBaseISlemleri.MySql;
import static java.lang.String.valueOf;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Ders;
import model.DogruYanlisSoru;
import model.Soru;
import view.IDYForm;


public  class DyPresenter {

    IDYForm form;
   
    SoruBankasi s1=new SoruBankasi();
    DersIslemleri di = DersIslemleri.getInstance();
    public DyPresenter( IDYForm form) {
        
        this.form=form;
    }
    
    public void dySoruSil(int id) {
        for(int i=0;i<s1.sorular.size();i++){
            if(s1.sorular.get(i).getId()==id){
            s1.soruSil(s1.sorular.get(i));
            }
        } 
    }

    public void dySoruGuncelle(String text, Object selectedItem, Object selectedItem0, Object selectedItem1, Object selectedItem2,int id) {
        for(int i=0;i<s1.sorular.size();i++){
            if(s1.sorular.get(i).getId()==id){
            s1.sorular.get(i).setSoruMetni(text);
            s1.sorular.get(i).setDers(new Ders(selectedItem.toString()));
            s1.sorular.get(i).setDogruCevap(selectedItem0.toString());
            s1.sorular.get(i).setZorlukDerecesi(selectedItem1.toString());
            s1.sorular.get(i).setPuan(Integer.parseInt(selectedItem2.toString()));
            s1.soruGuncelle(s1.sorular.get(i));
            }
        } 
    }

   
    public void dersGetir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void dySoruEkle(String text, String text0, String text1, Object selectedItem, Object selectedItem0, Object selectedItem1, Object selectedItem2) {
         
        DogruYanlisSoru dy = new DogruYanlisSoru();
        dy.setSoruMetni(text);
     //   dy.setSecenekler(text0, text1);
        dy.setDers(new Ders(selectedItem.toString()));
        dy.setDogruCevap(selectedItem0.toString());
        dy.setZorlukDerecesi(selectedItem1.toString());
        dy.setPuan(Integer.parseInt(selectedItem2.toString()));
        s1.soruEkle(dy);
    }
    
    public void gridDoldur(JTable table){
        SoruBankasi sb= new SoruBankasi(); 
        sb.getArrayList().removeAll(sb.getArrayList());
       String dizim[][]=new String[sb.dogruYanlisArrayDoldur().size()][];
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
