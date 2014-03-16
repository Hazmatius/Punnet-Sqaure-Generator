/*
 * This is the class Chrom. Chrom, short for chromosome, contains a non-variable list of Genes. Chrom can be created
 * manually from genes, or two Zygs can be merged to form a new Chrom. Chrom has a method that returns a non-
 * variable list of all possible Zygs.
 */
public class Chrom
{
    public Gene[] g;
    public int l;
    public int n;
    public String pheno = "";
    
    public Chrom(Gene[] gg)
    {   
        g = gg;
        n = (int)(Math.pow(2.0, (double)(g.length)));
        l = (Integer.toBinaryString(n-1)).length();
        pHeno();
    }
    
    public Chrom(Zyg z1, Zyg z2)
    {
        g = new Gene[z1.allels.length];
        for(int i=0; i<g.length; i++)
        {   g[i] = new Gene(z1.allels[i], z2.allels[i]);   }
        n = (int)(Math.pow(2.0, (double)(g.length)));
        l = (Integer.toBinaryString(n-1)).length();
        pHeno();
    }
    
    private void pHeno()
    {
        for(int i=0; i<g.length; i++)
        {
            pheno+=g[i].pheno;
        }
    }
    
    private String convertBin(int n, int l)
    {
        String s = Integer.toBinaryString(n-1);
        int d = l - s.length() + 1;
        while (d>1)
        {
            s = "0" + s;
            d--;
        }
        return s;
    }
    
    //Given the symbolic binary permutation "bin", getZygote determins the corresponding Zyg from the
    //list "g" of Genes.
    private Zyg genZygote(int n)
    {
        String bin = convertBin(n,l);
        String[] b = new String[g.length];
        //This is the symbolic binary permutation. 
        for(int i=0;i<g.length;i++)
        {   b[i] = bin.substring(i,i+1);   }
        
        //this is going to be the list of characters that will be used to construct the new Zyg.
        char[] c = new char[g.length];
        //This is going to go through the symbolic binary permutation and the gene list and match the two.
        for(int i=0; i<g.length;i++)
        {
            if (b[i].equals("0"))
            {   c[i] = (char)(g[i].allel1);   }
            if (b[i].equals("1"))
            {   c[i] = (char)(g[i].allel2);   }
        }
        
        Zyg z = new Zyg(c);
        return z;
    }
    
    public Zyg[] getZygotes()
    {
        int n = (int)(Math.pow(2.0, (double)(g.length)));
        Zyg[] zygotes = new Zyg[n];
        int count = 0;
        while(n > 0)
        {
            zygotes[n-1] = genZygote(n);
            n--;
        }
        return zygotes;
    }
    
    public String toString()
    {
        String s = "";
        for(Gene e : g)
        {   s+=e.toString();   }
        return s;
    }
    
    public Gene[] getGenes()
    {
        return g;
    }
    
    public String getPheno()
    {
        return pheno;
    }
    
    public boolean isChromEqual(Chrom c)
    {
        boolean equals = true;
        if(c.getGenes().length==g.length)
        {
            for(int i=0; i<g.length; i++)
            {
                if(!c.getGenes()[i].isGeneEqual(g[i]))
                {
                    equals = false;
                }
            }
        }
        return equals;
    }
    
    public boolean isPheneEqual(Chrom c)
    {
        return c.getPheno().equals(this.getPheno());
    }
}