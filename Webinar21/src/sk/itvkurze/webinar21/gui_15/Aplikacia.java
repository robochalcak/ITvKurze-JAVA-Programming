package sk.itvkurze.webinar21.gui_15;

import javax.swing.SwingUtilities;

public class Aplikacia
{

   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new HlavneOkno();
         }  
      });     
   }
}
