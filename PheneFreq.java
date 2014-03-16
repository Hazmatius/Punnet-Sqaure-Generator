public class PheneFreq
{
    private Chrom c;
    private int n;
    
    public PheneFreq(Chrom c)
    {
        this.c = c;
        n = 1;
    }
    public boolean checkChrom(Chrom chrom)
    {
        if(c.getPheno().equals(chrom.getPheno()))
        {
            n++;
            return true;
        }
        else
        {
            return false;
        }
    }
    public Chrom getChrom(){
        return c;   }
    public int getFreq()
    {   return n;   }
}