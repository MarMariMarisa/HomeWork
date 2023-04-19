package unit11.pi;

import org.apfloat.Apfloat;

public class MTCalculator extends PiCalculator {
    public Apfloat pi = Apfloat.ZERO;
    public long numTerms;
   
    public MTCalculator(PiTermCalculator termCalc){
        super(termCalc);
    }
    @Override
    public Apfloat calculate(long numTerms){
        this.numTerms = numTerms;
        for(int i = 0; i < numTerms;i++){
            piThread piT = new piThread(this,pi,termCalc, i);
            Thread thread = new Thread(piT);
            thread.run();
        }
        
        return termCalc.finalAdjustment(pi);
    }   
}