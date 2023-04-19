package unit11.pi;

import org.apfloat.Apfloat;

public class PiTimer {
    private static final long NUM_TERMS = 100000;
    private static final long PRECESION = 100;

    private static void timeCalculation (PiCalculator calculator, long numTerms) {
        long start = System.currentTimeMillis ();
        Apfloat pi = calculator.calculate (numTerms);
        long end = System.currentTimeMillis ();

        System.out.println ("\tPI = " + pi.toString (true));
        System.out.println ("\tIt took " + (end - start) / 1000.0 + 
            " seconds to calculate PI to " + NUM_TERMS + " terms.");
        System.out.println ("\tCorrectly calculated pi to " + PiMillion.countCorrect (pi.toString (true)) +
            " decimal places.");
    }    

    public static void main(String[] args) {
         //I believe that i got the results I did because #1 NilakanthaTermCalculator is not that percise
        //Leading to be why I only got 17 decimal places correct. and #2
        //I believe it took almost 20 seconds to calculator since it is going one
        //at a time 100,000 times. 

        //my results are differnt than pi timer. this time it only took 14 seconds to calculate
        System.out.println("St with Nilakantha");
        timeCalculation (new STCalculator (new NilakanthaTermCalculator (PRECESION)), NUM_TERMS);
        System.out.println("Mt with Nilakantha");
        timeCalculation (new MTCalculator (new NilakanthaTermCalculator (PRECESION)), NUM_TERMS);
        System.out.println("MtChunk with Nilakantha");
        timeCalculation (new MTChunkCalculator (new NilakanthaTermCalculator (PRECESION)), NUM_TERMS);

        System.out.println("St with Ramaunujan");
        timeCalculation (new STCalculator (new RamanujamTermCalculator(PRECESION)), NUM_TERMS);
        System.out.println("Mt with Ramaunujan");
        timeCalculation (new MTCalculator (new RamanujamTermCalculator(PRECESION)), NUM_TERMS);
        System.out.println("MtChunk with Ramaunujan");
        timeCalculation (new MTChunkCalculator (new RamanujamTermCalculator(PRECESION)), NUM_TERMS);
    }
}
