public class Gene
{
    public char allel1;
    public char allel2;
    public char pheno;
    
    public Gene(char ss1, char ss2)
    {
        allel1 = ss1;
        allel2 = ss2;
        getPheno();
    }
    public boolean isGeneEqual(Gene g)
    {   return ((allel1 == g.allel1 && allel2 == g.allel2) || (allel1 == g.allel2 && allel2 == g.allel1));   }
    public boolean isPhenEqual(Gene g)
    {   return (pheno == g.pheno);   }
    private void getPheno()
    {
        if(Character.isUpperCase(allel1)){pheno = allel1;}
        if(Character.isUpperCase(allel2)){pheno = allel2;}
        if(Character.isLowerCase(allel1)&&Character.isLowerCase(allel2)){pheno = allel1;}
    }
    public String toString()
    {   return allel1+""+allel2;   }
}