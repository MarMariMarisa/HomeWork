package unit11.pi;

import org.apfloat.Apfloat;

public class MTChunkCalculator extends PiCalculator {
    public Apfloat pi = Apfloat.ZERO;
    public long numTerms;
   
    public MTChunkCalculator(PiTermCalculator termCalc){
        super(termCalc);
    }
    @Override
    public Apfloat calculate(long numTerms){
        this.numTerms = numTerms;
        for(int i = 0; i < 1000;i++){
            PiChunkThread piT = new PiChunkThread(this,pi,termCalc, i);
            Thread thread = new Thread(piT);
            thread.run();
        }
        
        return termCalc.finalAdjustment(pi);
    }   
}
