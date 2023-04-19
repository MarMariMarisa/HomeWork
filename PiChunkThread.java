package unit11.pi;

import org.apfloat.Apfloat;

public class PiChunkThread implements Runnable {
    private PiTermCalculator termCalc;
    private int i;
    private MTChunkCalculator calculator;
    @Override
    public void run() {
                synchronized(termCalc){
                    for(int a = i; a < i+100 ;a++){
                        calculator.pi = calculator.pi.add(termCalc.calculateTerm(a));
                    }
                }
    }

    public PiChunkThread(MTChunkCalculator calculator,Apfloat pi,PiTermCalculator termCalc,int i){
        this.calculator = calculator;
        this.termCalc = termCalc;
        this.i = i * 100;
    }
}
