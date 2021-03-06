import java.util.*;

public class ChromFreqList
{
    public ArrayList<ChromFreq> chroms = new ArrayList<ChromFreq>();
    private Grid g;
    
    public ChromFreqList(Grid g)
    {
        this.g = g;
        calcFreq();
    }
    
    public void calcFreq()
    {
        for(int i=0; i<g.getBoard().length; i++)
        {
            for(int j=0; j<g.getBoard()[0].length; j++)
            {
                for(int k=0; k<chroms.size(); k++)
                {
                    chroms.get(k).checkChrom(g.getBoard()[i][j]);
                }
                if(!isInChromList(g.getBoard()[i][j]))
                {
                    chroms.add(new ChromFreq(g.getBoard()[i][j]));
                }
            }
        }
    }
    public boolean isInChromList(Chrom c)
    {
        boolean iicl = false;
        for(int i=0; i<chroms.size(); i++)
        {
            if(c.isChromEqual(chroms.get(i).getChrom()))
            {
                iicl = true;
            }
        }
        return iicl;
    }
    public String toString()
    {
        int total  = 0;
        for(int i=0; i<chroms.size(); i++)
        {
            total+=chroms.get(i).getFreq();
        }
        String output = "";
        for(int i=0; i<chroms.size(); i++)
        {
            output+=(chroms.get(i).getChrom().toString() + ":  " + (chroms.get(i).getFreq()) + "/" + total + " - " + (chroms.get(i).getFreq()+0.0)/total*100 + "%\n");
        }
        return output;
    }
}