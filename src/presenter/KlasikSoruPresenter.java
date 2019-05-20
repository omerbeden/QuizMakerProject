
package presenter;

import static java.lang.String.valueOf;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.CoktanSecmeliSoru;
import model.Ders;
import model.KlasikSoru;
import view.IKlasikSoru;
import view.SoruKlasik1;

public class KlasikSoruPresenter {
    
    
    IKlasikSoru klasik;
       DersIslemleri di = DersIslemleri.getInstance();

    SoruBankasi s1=new SoruBankasi();
    public KlasikSoruPresenter( IKlasikSoru klasik) {
        
        this.klasik=klasik;
    }


    
    
    
    public void klasikSoruEkle(String text, Object selectedItem, Object selectedItem0, Object selectedItem1, Object selectedItem2) {
        KlasikSoru cs = new KlasikSoru();
        cs.setSoruMetni(text);
        cs.setDers(new Ders(selectedItem.toString()));
        cs.setDogruCevap(selectedItem0.toString());
        cs.setZorlukDerecesi(selectedItem1.toString());
        cs.setPuan(Integer.parseInt(selectedItem2.toString()));
        s1.soruEkle(cs);
    }

    
    public void klasikSoruSil(int id) {

        for(int i=0;i<s1.sorular.size();i++){
            if(s1.sorular.get(i).getId()==id){
            s1.soruSil(s1.sorular.get(i));
            }
        }    
    }

    
    public void klasikSoruGuncelle(String text, Object selectedItem, Object selectedItem0, Object selectedItem1, Object selectedItem2,int id) {
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
    
    public void gridDoldur(JTable table){
           
        SoruBankasi sb= new SoruBankasi();
        sb.getArrayList().removeAll(sb.getArrayList());
       String dizim[][]=new String[sb.klasikArrayDoldur().size()][];
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
