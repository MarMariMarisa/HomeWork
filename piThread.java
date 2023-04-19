package unit11.pi;

import org.apfloat.Apfloat;

public class piThread implements Runnable {
    private PiTermCalculator termCalc;
    private int i;
    private MTCalculator calculator;
    @Override
    public void run() {
                synchronized(termCalc){
                    calculator.pi = calculator.pi.add(termCalc.calculateTerm(i));
                }
    }

    public piThread(MTCalculator calculator,Apfloat pi,PiTermCalculator termCalc,int i){
        this.calculator = calculator;
        this.termCalc = termCalc;
        this.i = i;
    }
}
