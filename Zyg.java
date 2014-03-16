/*
 * This is the class Zyg. Zyg represent the gamete, half the genetic code neccesary for reproduction.
 * Zyg contains a non-variable list of characters, which can be either upper or lower case, representing
 * the alleles that are present in that particular gamete, or Zyg.
 */
public class Zyg
{
    public char[] allels;
    
    public Zyg(char[] ss)
    {   allels = ss;   }
    
    public String toString()
    {
        String s = "";
        for(char c : allels)
        {   s += c;   }
        return s;
    }
}