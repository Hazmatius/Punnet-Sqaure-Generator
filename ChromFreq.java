public class ChromFreq
{
    private Chrom c;
    private int n;
    
    public ChromFreq(Chrom c){
        this.c = c;
        n = 1;  }
    public boolean checkChrom(Chrom chrom){
        if(c.isChromEqual(chrom))
        {   
            n++;
            return true;    }
        else
        {   return false;   }
    }
    public Chrom getChrom(){
        return c;   }
    public int getFreq(){
        return n;   }
}