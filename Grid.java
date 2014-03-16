import java.util.ArrayList;

public class Grid
{
    public Chrom c1;
    public Chrom c2;
    public Zyg[] z1;
    public Zyg[] z2;
    public Chrom[][] board;
    public Phene[] phenelist;
    
    public Grid(Chrom cc1, Chrom cc2)
    {
        c1 = cc1;
        c2 = cc2;
        z1 = c1.getZygotes();
        z2 = c2.getZygotes();
        board = new Chrom[z1.length][z2.length];
        cross();
    }
    public Chrom[][] getBoard()
    {
        return board;
    }
    private void cross()
    {
        for(int i=0; i<z1.length; i++)
        {   for(int j=0; j<z2.length; j++)
            {   board[i][j] = new Chrom(z1[i], z2[j]);   }
        }
    }
    private boolean isInPheneList(ArrayList<Phene> list, Phene p)
    {
        boolean is = false;
        for(Phene ph : list)
        {   
            if(ph.equals(p))
            {   is = true;   }   }
        return is;
    }
    private void pheneList()
    {
        ArrayList<Phene> list = new ArrayList<Phene>();
        Phene[][] pgrid= new Phene[board.length][board[0].length];
        for(int i=0; i<pgrid.length; i++)
        {   for(int j=0; j<pgrid[0].length; j++)
            {   pgrid[i][j] = new Phene(board[i][j].pheno);   }
        }
        
        for(int i=0; i<pgrid.length; i++)
        {   for(int j=0; j<pgrid[0].length; j++)
            {   list.add(pgrid[i][j]);   }
        }
        
        for(int i=0; i<list.size(); i++)
        {
            for(int j=1; j<list.size(); j++)
            {
                if(list.get(i).pheno.equals(list.get(j).pheno))
                {
                }
            }
        }
    }
    public String toString()
    {
        int length = 2 * ((z1[0].toString()).length());
        
        String sidespace = "";
        for(int i=0; i<length/2; i++){sidespace += " ";}
        
        String unit = "+";
        String horiz = " ";
        String verti = " | ";
        String lab = "";
        
        String topspace = "   ";
        for(int i=0; i<length/2; i++){topspace += " ";}
        
        String header = sidespace + "  ";
        for(Zyg z : z1)
        {   header += (z.toString() + topspace);   }
        
        
        for(int i=0; i<length+2; i++){unit+="-";}
        for(int i=0; i<z1.length; i++){horiz+=unit;}
        horiz += "+";
        horiz = sidespace + horiz;
        lab += (" " + header);
        lab += "\n";
        for(int i=0; i<z1.length; i++)
        {   
            lab += (horiz + "\n");
            lab += (z2[i].toString());
            for(int j=0; j<z2.length; j++)
            {   lab+=(verti + board[i][j].toString());   }
            lab += " |\n";
        }
        lab += horiz;
        
        return lab;
    }
}