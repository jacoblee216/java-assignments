import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {
    private BigInteger numerator = new BigInteger("0");
    private BigInteger denominator = new BigInteger("1");
    public Rational() {
        this.numerator = new BigInteger("0");
        this.denominator = new BigInteger("1");
    }
    public Rational(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        BigInteger n1 = a.abs();
        BigInteger d1= b.abs();
        BigInteger gcd = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n1) <= 0 && i.compareTo(d1) <= 0; i = i.add(BigInteger.ONE)) {
            if (n1.mod(i).equals(BigInteger.ZERO) && d1.mod(i).equals(BigInteger.ZERO)) {
                gcd = i;
            }
        }
        return gcd;
    }
    public BigInteger getNumerator() {
        return this.numerator;
    }
    public BigInteger getDenominator() {
        return this.denominator;
    }
    public Rational add(Rational secondRational) {
        BigInteger n = this.numerator.multiply(secondRational.getDenominator()).add(this.denominator.multiply(secondRational.getNumerator()));
        BigInteger d = this.denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }
    public Rational subtract(Rational secondRational) {
        BigInteger n = this.numerator.multiply(secondRational.getDenominator()).subtract(this.denominator.multiply(secondRational.getNumerator()));
        BigInteger d = this.denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }
    public Rational multiply(Rational secondRational) {
        BigInteger n = this.numerator.multiply(secondRational.getNumerator());
        BigInteger d = this.denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }
    public Rational divide(Rational secondRational) {
        BigInteger n = this.numerator.multiply(secondRational.getDenominator());
        BigInteger d = this.denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator + "";
        } else {
            return numerator + "/" + denominator;
        }
    }
    @Override
    public boolean equals(Object other) {
        if (this.subtract((Rational)(other)).getNumerator().equals(BigInteger.ZERO)) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int intValue() {
        return (int)doubleValue();
    }
    @Override
    public float floatValue() {
        return (float)doubleValue();
    }
    @Override
    public double doubleValue() {
        double doubleNumerator = numerator.doubleValue();
        double doubleDenominator = denominator.doubleValue();
        return doubleNumerator / doubleDenominator;
    }
    @Override 
    public long longValue() {
        return (long)doubleValue();
    }
    @Override
    public int compareTo(Rational r) {
        if (this.subtract(r).getNumerator().compareTo(BigInteger.ZERO) == 1) {
            return 1;
        } else if (this.subtract(r).getNumerator().compareTo(BigInteger.ZERO) == -1) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Enter rational r1 with numerator and denominator seperated by a space: ");
        java.util.Scanner input = new java.util.Scanner(System.in);
        BigInteger n1 = input.nextBigInteger();
        BigInteger d1 = input.nextBigInteger();
        Rational r1 = new Rational(n1,d1);
        System.out.println("Enter rational r2 with numerator and denominator seperated by a space: ");
        BigInteger n2 = input.nextBigInteger();
        BigInteger d2 = input.nextBigInteger();
        Rational r2 = new Rational(n2,d2);
        System.out.println(r1 + " + " + r2 + " = " + (r1.add(r2)));
        System.out.println(r1 + " - " + r2 + " = " + (r1.subtract(r2)));
        System.out.println(r1 + " * " + r2 + " = " + (r1.multiply(r2)));
        System.out.println(r1 + " / " + r2 + " = " + (r1.divide(r2)));
        System.out.println(r2 + " is " + r2.doubleValue());

    }
}
