package unit11.pi;

import org.apfloat.Apfloat;

/**
 * Single threaded pi calculator.
 */
public class STCalculator extends PiCalculator {

    /**
     * Constructor
     * @param termCalc Class used to calculate a single term in pi
     */
    public STCalculator (PiTermCalculator termCalc) {
        super (termCalc);
    }

    @Override
    public Apfloat calculate(long numTerms) {
        Apfloat pi = new Apfloat (0, termCalc.getPrecision());
        for (int i = 0; i < numTerms; i++) {
            pi = pi.add (termCalc.calculateTerm (i));
        }
        return termCalc.finalAdjustment (pi);
    }
}
