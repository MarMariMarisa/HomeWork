package unit11.pi;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apfloat.Apfloat;

public class RamanujamTermCalculator implements PiTermCalculator {
    private final long precision;
    BigDecimal two = new BigDecimal (2);
    Apfloat sqrt2;
    private final Apfloat nineThos;



    public RamanujamTermCalculator(long precision){
        this.precision = precision;
        sqrt2  = new Apfloat(two.sqrt(new MathContext((int)precision)));
        nineThos  = new Apfloat(9801,precision);
    }

    private Apfloat factorial(Apfloat start){
        
        Apfloat factorial = Apfloat.ONE;
        for(Apfloat i = Apfloat.ONE; i.intValue() <= start.intValue(); i = i.add(Apfloat.ONE)){
            factorial = factorial.multiply(i);
        }
        return factorial;
    }

    private Apfloat power(Apfloat start, int power){
        Apfloat base = start;
        if(power == 0){
            base = Apfloat.ONE;
            return base;
        }
        for(int i = 1;i < power;i++){
            base = base.multiply(start);
        }
        return base;
    }
    @Override
    public Apfloat calculateTerm(long n) {
        Apfloat t = new Apfloat(n, precision);
        Apfloat num = factorial(t.multiply(new Apfloat(4, precision))).multiply((new Apfloat(1103, precision)).add(new Apfloat(26390, precision).multiply(t)));
        Apfloat den = power(factorial(t),4).multiply(power(new Apfloat(396, precision),4*(int)n));

        return num.divide(den);
    }

    @Override
    public Apfloat finalAdjustment(Apfloat sum) {
        sum = sum.multiply((new Apfloat(2,precision).multiply(sqrt2.divide(nineThos))));
        return Apfloat.ONE.divide(sum);
    }

    @Override
    public long getPrecision() {
        return precision;
    }

}
