package sk.itvkurze.webinar24.nesynchronizovany_bankovy_ucet;


public class BankovyUcet2
{
   private double aktualnyZostatok;
   private double dostatokProstriedkovNaUcte;

   public BankovyUcet2()
   {
      this.aktualnyZostatok = 0;
      this.dostatokProstriedkovNaUcte=0;
     
   }

   public double getAktualnyZostatok()
   {
      return aktualnyZostatok;
   }

   public synchronized void vloz(double ciastka)
   {
         System.out.println("Vklad "+ciastka+ " Eur.");
         double novyZostatok = aktualnyZostatok + ciastka;
         System.out.println(", novy zostatok je "+novyZostatok + " Eur.");
         
   }

   public synchronized void vyber(double ciastka)
   {
     
         System.out.println("Vklad "+ciastka+ " Eur.");
         double novyZostatok = aktualnyZostatok - ciastka;
         System.out.println(", novy zostatok je "+novyZostatok + " Eur.");
         this.aktualnyZostatok -= ciastka;
     
   }
}
