package unit11.pi;

import org.apfloat.Apfloat;

public abstract class PiCalculator {

    /**
     * Term calculator that will be used to find a single value
     * in the pi series.
     */
    protected final PiTermCalculator termCalc;

    /**
     * Constructor used to store off the term calculator class.
     * @param termCalc Pi Term Calculator
     */
    public PiCalculator (PiTermCalculator termCalc) {
        this.termCalc = termCalc;
    }

    /**
     * Returns the calculated value of Pi to @PRECESION number
     * of decimal places.
     * @param numTerms Number of terms in the series to calculate
     * @return The value of Pi
     */
    abstract Apfloat calculate (long numTerms);
}
