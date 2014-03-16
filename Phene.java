public class Phene
{
    public String pheno;
    public int number;
    
    public Phene(String ph)
    {   pheno = ph;
        number = 1;   }
    
    public void add()
    {   number++;   }
    
    public boolean equals(Phene p)
    {   return (pheno.equals(p.pheno));   }
}