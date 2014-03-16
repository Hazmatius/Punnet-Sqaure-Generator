import java.util.Scanner;

public class X
{
    public static String listString(Zyg[] zaz)
    {
        String s = "";
        for (Zyg z : zaz)
        {   s += (z.toString() + "\n");   }
        return s;
    }
    
        public static Chrom cgetFrom(String str)
    {
        int n = str.length()/2;
        String[] strlist = new String[n];
        for(int i=0; i<n; i++){   strlist[i] = str.substring(2*i, 2*(i+1));   }
        Gene[] gs = new Gene[n];
        for(int i=0; i<n; i++){   gs[i] = X.ggetFrom(strlist[i]);   }
        Chrom chromosome = new Chrom(gs);
        return chromosome;
    }
    
        public static Gene ggetFrom(String str)
    {
        Gene g = new Gene(str.charAt(0), str.charAt(1));
        return g;
    }
    
}