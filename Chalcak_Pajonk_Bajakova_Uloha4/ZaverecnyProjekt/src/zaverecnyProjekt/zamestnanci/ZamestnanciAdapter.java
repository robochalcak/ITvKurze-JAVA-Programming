package zaverecnyProjekt.zamestnanci;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import zaverecnyProjekt.zapisovacDat.IPracaSubory;
/**
 * Trieda sluzi na zapis a nacitanie zamestnancov zo suboru 
 * @author Robert Chalcak
 *
 */
public class ZamestnanciAdapter implements IPracaSubory, Serializable
{

   private String subor;
   /**
    * Vytvara prazdny objekt a nastavuje cestu nazov suboru, s ktorym bude
    * system pracovat
    * @throws ClassNotFoundException
    * @throws IOException
    */
   public ZamestnanciAdapter() throws ClassNotFoundException, IOException
   {
      this.subor = "zamestnanci.dat";    
   }
   /**
    * Zapise vsetkych zamestnancov do suboru 
    */
   @Override
   public void zapis(ArrayList<Object> zamestnanci)
   {          
      try{
      FileOutputStream fos = new FileOutputStream(subor);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
         for(int i = 0; i < zamestnanci.size();i++)
         {
               oos.writeObject(zamestnanci.get(i));
         }
         oos.close();
         zamestnanci.clear();     
      }
      
      catch(Exception ex)
      {
         JOptionPane.showMessageDialog(null,"Ulozenie do suboru sa nepodarilo!");
         return;
      }
      
   }
   /**
    * Nacita vsetkych zamestnancov zo suboru 
    */
   @Override
   public void nacitaj(ArrayList<Object> objs) throws IOException,
         ClassNotFoundException
   {
      if(objs.size()>0)
      {
         objs.clear();
      }
     
      try
      {
         FileInputStream fis = new FileInputStream(subor);
         ObjectInputStream ois = new ObjectInputStream(fis);
         while(ois!=null)
         {
            objs.add(ois.readObject());
         }
         
      }catch(Exception ex)
      {
         return;
      }
   }

}
