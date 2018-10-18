public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0);//this value is ignored!
    if (deno == 0){
      nume = 0;
      deno = 1;
    }
    numerator = nume;
    denominator = deno;
    reduce();
  }

  public double getValue(){
    return (double) getNumerator() / (double) getDenominator();//???
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber q = new RationalNumber(denominator, numerator);
  return q;
}
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    if (this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator()){
      return true;
    }
    else {return false;}
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (getDenominator() == 1){
      return "" + getNumerator();
    }
    return getNumerator() + "/" + getDenominator();
  }



  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    if (a < 0){
      a = a * -1;
    }
    while (a > 0 && b > 0) {
      int prevA = a;
      a = b;
      b = (prevA % b);
    }
    if (a == 0){
     return b;
   }
    if (b == 0){
      return a;
    }
    return 1;
  }
//Credit to Timothy Stransberry for helping me on this.  My previous one was a car wreck.


  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    if (denominator < 0){
      numerator = numerator * -1;
      denominator = denominator * -1;
    }
    if (gcd(numerator,denominator) != 0){
    numerator = numerator / gcd(numerator,denominator);
    denominator = denominator / gcd(numerator,denominator);
  }}



  /******************Operations!!!!****************/


  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber m = new RationalNumber (this.getNumerator() * other.getNumerator(), this.getDenominator() * other.getDenominator() );
    return m;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber d = this.reciprocal();
    return d.multiply(other);
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int y = this.getNumerator() * other.getDenominator() + other.getNumerator() * this.getDenominator();
    int x = this.getDenominator() * other.getDenominator();
    RationalNumber a = new RationalNumber(y,x);
    a.reduce();
    return a;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int v = this.getNumerator() * other.getDenominator() - other.getNumerator() * this.getDenominator();
    int t = this.getDenominator() * other.getDenominator();
    RationalNumber s = new RationalNumber(v,t);
    s.reduce();
    return s;
  }
}
