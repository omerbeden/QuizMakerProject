package dataBaseISlemleri;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CoktanSecmeliSoru;
import model.Ders;
import model.Gozetmen;
import model.Ogrenci;
import model.Sinav;
import model.Soru;
import model.*;
import org.apache.derby.tools.sysinfo;

public class MySql implements DBISLEMLERI{
    Connection con;
    
            
    
    
            public void baglantiAc(){
                	try {  
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
     System.out.println("fatih yanlış yaptın");
    }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sorubank","root","123456789");
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }

            }

	@Override
	public void databaseKlasikSoruEkle(Soru soru) {
    try{
        baglantiAc();
            Statement stmt=con.createStatement(); 
            String sorgu=String.format("insert into klasiksorular(soru,dogru_Cevap,zorluk,puan,kategori) values('%s','%s','%s','%s','%s')", soru.getSoruMetni(),soru.getDogruCevap(),soru.getZorlukDerecesi(),soru.getPuan(),soru.getDers().getName());
            int ekleme = stmt.executeUpdate(sorgu);
            System.out.println("Kayıt Eklendi");
            stmt.close();
        }catch(Exception e){ System.out.println(e);}
	}
        
            @Override
    public void databaseCoktanSecmeliEkle(CoktanSecmeliSoru soru) {
       try{
           baglantiAc();
     
        Statement stmt=con.createStatement(); 
        String sorgu=String.format("insert into coktansecmelisorular(soru,a,b,c,d,dogru_Cevap,zorluk,puan,kategori) values('%s','%s','%s','%s','%s','%s','%s','%s','%s')", soru.getSoruMetni(),soru.getSecenekler()[0],soru.getSecenekler()[1],soru.getSecenekler()[2],soru.getSecenekler()[3],soru.getDogruCevap(),soru.getZorlukDerecesi(),soru.getPuan(),soru.getDers().getName());
        int ekleme = stmt.executeUpdate(sorgu);
        System.out.println("Kayıt Eklendi");
        stmt.close();
          }catch(Exception e){ System.out.println(e);}
    }
        @Override
    public void databaseDogruYanlisSoruEkle(DogruYanlisSoru soru) {
        try{
           baglantiAc();
     
        Statement stmt=con.createStatement(); 
        String sorgu=String.format("insert into dogruyanlissorular(soru,dogru_Cevap,puan,zorluk,kategori,a,b) values('%s','%s','%s','%s','%s','%s','%s')", 
                soru.getSoruMetni(),soru.getDogruCevap(),soru.getPuan(),soru.getZorlukDerecesi(),soru.getDers().getName(),soru.getSecenekler()[0],soru.getSecenekler()[1]);
        int ekleme = stmt.executeUpdate(sorgu);
        System.out.println("Kayıt Eklendi");
        stmt.close();
          }catch(Exception e){ System.out.println(e);}
        
        
    }
    
        


	@Override
	public void databaseGozetmenEkle(String gozetmen_adi,String gozetmen_soyadi) {
            try{
           baglantiAc();
     
        Statement stmt=con.createStatement(); 
        String sorgu=String.format("insert into gozetmen(G_adi,soyadi) values('%s','%s')", gozetmen_adi,gozetmen_soyadi);
        int ekleme = stmt.executeUpdate(sorgu);
        System.out.println("Kayıt Eklendi");
        stmt.close();
          }catch(Exception e){ System.out.println(e);}
	}





	@Override
	public void dersEkle(Ders g) {
            try{
           baglantiAc();
        Statement stmt=con.createStatement(); 
        String sorgu=String.format("insert into ders(DERS_ADI) values('%s')", g.getName());
        int ekleme = stmt.executeUpdate(sorgu);
        System.out.println("Kayıt Eklendi");
        stmt.close();
          }catch(Exception e){ System.out.println(e);}
	}

	@Override
	public void dersCikar(int id) {
		try{
           baglantiAc();
        Statement stmt=con.createStatement(); 
            boolean sorgu=stmt.execute("DELETE FROM ders Where id='"+id+"'");
        
        System.out.println("Kayıt Silindi");
        stmt.close();
          }catch(Exception e){ System.out.println(e);}
		
	}

	@Override
	public void dersGuncelle(Ders g) {
            
            
	}

	@Override
	public void databaseGozetmenCikar(int id) {
		try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            
            boolean sonuc=st.execute("DELETE FROM gozetmen Where G_id='"+id+"'");
            st.close();
            
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
		
	}

	@Override
	public void databaseGozetmenGuncelle(int id,String gozetmen_adi, String gozetmen_soyadi) {
		try {
            Connection conn = null;
            Statement st = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            String sorgu=String.format("update gozetmen set G_adi='%s', soyadi='%s'where G_id='%s' ",gozetmen_adi,gozetmen_soyadi,id) ;
            int guncelleme = st.executeUpdate(sorgu);
            st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
		
	}
         

	@Override
	public void sinaviDbyeKaydet(Sinav sinav) {
try{
    String sorgu="";
        baglantiAc();
            Statement stmt=con.createStatement(); 
                                sorgu=String.format("insert into sinavlar(sinav_adi,sinav_zorluk,sinav_kategori) values('%s','%s','%s')", sinav.getSinavAdi(),sinav.getZorlukDerecesi(),sinav.getSinavKategorisi());
                int ekleme = stmt.executeUpdate(sorgu); 
            for(int i = 0;i<sinav.getSinavSorulari().size();i++){
                if(sinav.getSinavSorulari().get(i).getSoruTipi().equalsIgnoreCase("coktansecmeli")){
                    CoktanSecmeliSoru sorular = (CoktanSecmeliSoru) sinav.getSinavSorulari().get(i);
                    
              

                    String sorgu2=String.format("insert into gozetmen(G_id,G_adi,soyadi) values((SELECT MAX(sinavGozetmen_id) from sinavlar),'%s','%s')   ", sinav.getGozetmen().getGozetmenAdi(),sinav.getGozetmen().getGozetmenSoyadi());
        int ekleme2 = stmt.executeUpdate(sorgu2);    
         String sorgu3=String.format("insert into sinavsorulariyeni(sinav_id,sinav_sorusu,a,b,c,d) values((SELECT MAX(sinav_id) from sinavlar),'%s','%s','%s','%s','%s')   ",  sinav.getSinavSorulari().get(i).getSoruMetni(),sorular.getSecenekler()[0],sorular.getSecenekler()[1],sorular.getSecenekler()[2],sorular.getSecenekler()[3]);
        int ekleme3 = stmt.executeUpdate(sorgu3);  
              
              
                }else if(sinav.getSinavSorulari().get(i).getSoruTipi().equalsIgnoreCase("dogruyanlis")){
                    DogruYanlisSoru sorular = (DogruYanlisSoru) sinav.getSinavSorulari().get(i);
                    String sorgu2=String.format("insert into gozetmen(G_id,G_adi,soyadi) values((SELECT MAX(sinavGozetmen_id) from sinavlar),'%s','%s')   ", sinav.getGozetmen().getGozetmenAdi(),sinav.getGozetmen().getGozetmenSoyadi());
        int ekleme2 = stmt.executeUpdate(sorgu2);    
         String sorgu3=String.format("insert into sinavsorulariyeni(sinav_id,sinav_sorusu,a,b) values((SELECT MAX(sinav_id) from sinavlar),'%s','%s','%s')   ",  sinav.getSinavSorulari().get(i).getSoruMetni(),sorular.getSecenekler()[0],sorular.getSecenekler()[1]);
        int ekleme3 = stmt.executeUpdate(sorgu3);                
                
                
                }else {
                    //kalsık
                    String sorgu2=String.format("insert into gozetmen(G_id,G_adi,soyadi) values((SELECT MAX(sinavGozetmen_id) from sinavlar),'%s','%s')   ", sinav.getGozetmen().getGozetmenAdi(),sinav.getGozetmen().getGozetmenSoyadi());
        int ekleme2 = stmt.executeUpdate(sorgu2);    
         String sorgu3=String.format("insert into sinavsorulariyeni(sinav_id,sinav_sorusu) values((SELECT MAX(sinav_id) from sinavlar),'%s')   ",  sinav.getSinavSorulari().get(i).getSoruMetni());
        int ekleme3 = stmt.executeUpdate(sorgu3);                  }
                
            
            System.out.println("Kayıt Eklendi");
            
            }
            stmt.close();
            
        }catch(Exception e){ System.out.println(e);}
            
	}

	@Override
	public void databaseDogruYanlisSoruSil(Soru soru) {
            try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            
            boolean sonuc=st.execute("DELETE FROM dogruyanlissorular Where id='"+soru.getId()+"'");
            st.close();
            
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
	}

    public void dogruYanlisSoruArrayDoldur(ArrayList<Soru> soru) {
        try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM dogruyanlissorular");
            while(rs.next()){
               Soru s =new DogruYanlisSoru();
                s.setSoruMetni(rs.getString("soru"));
                s.setDers(new Ders(rs.getString("kategori")));
                s.setPuan(Integer.parseInt(rs.getString("puan")));
                s.setId(Integer.parseInt(rs.getString("id")));
               s.setDogruCevap(rs.getString("dogru_Cevap"));
               s.setZorlukDerecesi(rs.getString("zorluk"));
               
               soru.add(s);
            }
st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
    }        

    @Override
    public void databaseCoktanSecmeliSoruSil(Soru soru) {
                    try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            
            boolean sonuc=st.execute("DELETE FROM coktansecmelisorular Where id='"+soru.getId()+"'");
            st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
                    
                    
    }

    @Override
    public void databaseKlasikSoruSil(Soru soru) {
                    try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            
            boolean sonuc=st.execute("DELETE FROM klasiksorular Where id='"+soru.getId()+"'");
   st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
    }

    @Override
    public void coktanSecmeliSoruArrayDoldur(ArrayList<Soru> soru) {
                try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM coktansecmelisorular");
            while(rs.next()){
               CoktanSecmeliSoru s =new CoktanSecmeliSoru();
               s.setSoruMetni(rs.getString("soru"));
               s.setDers(new Ders(rs.getString("kategori")));
               s.setPuan(Integer.parseInt(rs.getString("puan")));
               s.setId(Integer.parseInt(rs.getString("id")));
               s.setDogruCevap(rs.getString("dogru_Cevap"));
               s.setZorlukDerecesi(rs.getString("zorluk"));
               s.secenekEkle(rs.getString("a"));
               s.secenekEkle(rs.getString("b"));
               s.secenekEkle(rs.getString("c"));
               s.secenekEkle(rs.getString("d"));

               soru.add(s);
            }
            st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
    }

    @Override
    public void klasikSoruArrayDoldur(ArrayList<Soru> soru) {
                try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM klasiksorular");
            while(rs.next()){

               Soru s =new KlasikSoru();
                s.setSoruMetni(rs.getString("soru"));
                s.setDers(new Ders(rs.getString("kategori")));
                s.setPuan(Integer.parseInt(rs.getString("puan")));
                s.setId(Integer.parseInt(rs.getString("id")));
               s.setDogruCevap(rs.getString("dogru_Cevap"));
               s.setZorlukDerecesi(rs.getString("zorluk"));
               soru.add(s);
            }
st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
    }

    @Override
    public void dersArrayDoldur(ArrayList<Ders> ders) {
try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM ders");
            while(rs.next()){

               Ders d = new Ders();
                d.setId(Integer.parseInt(rs.getString("DERS_ID")));
                d.setName(rs.getString("DERS_ADI"));
               ders.add(d);
            }
st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
    }

    @Override
    public void dogruYanlisSoruGuncelle(Soru soru) {
        try {
            Connection conn = null;
            Statement st = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            String sorgu=String.format("update dogruyanlissorular set soru='%s', dogru_Cevap='%s',puan='%s',zorluk='%s',kategori='%s' where id='%s' ",soru.getSoruMetni(),soru.getDogruCevap(),soru.getPuan(),soru.getZorlukDerecesi(),soru.getDers().getName(),soru.getId()) ;
            int guncelleme = st.executeUpdate(sorgu);
            st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
    }

    @Override
    public void klasikSoruGuncelle(Soru soru) {
try {
            Connection conn = null;
            Statement st = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            String sorgu=String.format("update klasiksorular set soru='%s', dogru_Cevap='%s',puan='%s',zorluk='%s' , kategori='%s'where id='%s' ",soru.getSoruMetni(),soru.getDogruCevap(),soru.getPuan(),soru.getZorlukDerecesi(),soru.getDers().getName(),soru.getId()) ;
            int guncelleme = st.executeUpdate(sorgu);
            st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }    }

    @Override
    public void coktanSecmeliSoruGuncelle(CoktanSecmeliSoru soru) {
try {
            Connection conn = null;
            Statement st = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            String sorgu=String.format("update coktansecmelisorular set soru='%s', a='%s',b='%s',c='%s',d='%s', dogru_Cevap='%s',puan='%s',zorluk='%s',kategori='%s' where id='%s' ",soru.getSoruMetni(),soru.getSecenekler()[0],soru.getSecenekler()[1],soru.getSecenekler()[2],soru.getSecenekler()[3],soru.getDogruCevap(),soru.getPuan(),soru.getZorlukDerecesi(),soru.getDers().getName(),soru.getId());
            int guncelleme = st.executeUpdate(sorgu);
            st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }    }

    @Override
    public void gozetmenArrayDoldur(ArrayList<Gozetmen> g) {
try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM gozetmen");
            while(rs.next()){

               Gozetmen gozetmen = new Gozetmen();
               gozetmen.setID(Integer.parseInt(rs.getString("G_id")));
               gozetmen.setGozetmenAdi(rs.getString("G_adi"));
               gozetmen.setGozetmenSoyadi(rs.getString("soyadi"));
               g.add(gozetmen);
            }
st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
    }

    @Override
    public void databaseOgrenciGuncelle(int id, String ogrenci_adi, String ogrenci_soyadi,int ogrenci_numara) {
        try {
            Connection conn = null;
            Statement st = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            String sorgu=String.format("update ogrenci set O_adi='%s', O_soyadi='%s',O_numara='%s'where O_id='%s' ",ogrenci_adi,ogrenci_soyadi,id,ogrenci_numara) ;
            int guncelleme = st.executeUpdate(sorgu);
            st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
        
    }

    @Override
    public void databaseOgrenciCikar(int id) {
       try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            
            boolean sonuc=st.execute("DELETE FROM ogrenci Where O_id='"+id+"'");
            st.close();
            
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }

    
    }

    @Override
    public void databaseOgrenciEkle(String ogrenci_adi, String ogrenci_soyadi,int ogrenci_numara) {
        try{
           baglantiAc();
     
        Statement stmt=con.createStatement(); 
        String sorgu=String.format("insert into ogrenci(O_adi,O_soyadi,O_numara) values('%s','%s','%s')", ogrenci_adi,ogrenci_soyadi,ogrenci_numara);
        int ekleme = stmt.executeUpdate(sorgu);
        System.out.println("Kayıt Eklendi");
        stmt.close();
          }catch(Exception e){ System.out.println(e);}
    
    }

    @Override
    public void ogrenciArrayDoldur(ArrayList<Ogrenci> g) {
        try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM ogrenci");
            while(rs.next()){

               Ogrenci ogrenci = new Ogrenci();
               ogrenci.setId(Integer.parseInt(rs.getString("O_id")));
               ogrenci.setOgrenciAdi(rs.getString("O_adi"));
               ogrenci.setOgrenciSoyadi(rs.getString("O_soyadi"));
               ogrenci.setOgrenciNumara(Integer.parseInt(rs.getString("O_numara")));
               g.add(ogrenci);
            }
st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
    }
//*******************************************************************************************
    @Override
    public void ogretimUyesiArrayDoldur(ArrayList<OgretimUyesi> ogretimUyeleri) {
       
        try {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbUrl = "jdbc:mysql://localhost:3306/sorubank";
            conn = DriverManager.getConnection(dbUrl, "root", "123456789");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM ogretimUyesi");
            while(rs.next()){

               OgretimUyesi uye = new OgretimUyesi();
               uye.setId(Integer.parseInt(rs.getString("")));
               uye.setAd(rs.getString("adi"));
               uye.setSoyad(rs.getString("soyadi"));
               
               ogretimUyeleri.add(uye);
            }
st.close();
                } catch (InstantiationException ex) {
                  System.out.println(ex.getMessage());
                } catch (IllegalAccessException ex) {
                  System.out.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                  System.out.println(ex.getMessage());
                } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                }
        
    }

    @Override
    public void ogretimUyesiEkle(String ogretim_adi, String ogretim_soyadi,String ogretim_ders) {
       
          try{
           baglantiAc();
     
        Statement stmt=con.createStatement(); 
        String sorgu=String.format("insert into ogretimUyesi(adi,soyadi) values('%s','%s')", ogretim_adi,ogretim_soyadi);
        int ekleme = stmt.executeUpdate(sorgu);
        
        String sorgu2=String.format("insert into gozetmen_dersleri(ders_adi,ögretim_id) values('%s',(SELECT MAX(id) from ogretimuyesi))   ", ogretim_ders);
        int ekleme2 = stmt.executeUpdate(sorgu2);
        System.out.println("Kayıt Eklendi");
        stmt.close();
          }catch(Exception e){ System.out.println(e);}
    }
    
    
   

    
}
