import java.util.Scanner;

public class Punnett
{
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
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the first Chromosome: ");
        String c1 = in.next();
        System.out.print("Please enter the second Chromosome: ");
        String c2 = in.next();
        Chrom chromo1 = cgetFrom(c1);
        Chrom chromo2 = cgetFrom(c2);
        Grid board = new Grid(chromo1, chromo2);
        System.out.print("\n" + chromo1.toString() + " x " + chromo2.toString() + "\n\n");
        System.out.print(board.toString());
        System.out.println("\n");
        ChromFreqList cfl = new ChromFreqList(board);
        System.out.println("Genotype Frequencies\n"+cfl.toString());
        PheneFreqList pfl = new PheneFreqList(board);
        System.out.println("Phenotype Frequencies\n"+pfl.toString());
        
    }
}