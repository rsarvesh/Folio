import com.sun.tools.javac.file.SymbolArchive;

import java.util.ArrayList;

public class FolioCalculate {
    ArrayList<Folio> folios;
    ArrayList<String> values;
    int offset;
    String testcaseName;

    public FolioCalculate(ArrayList<Folio> f, String s) {
        this.folios = f;
        int min = this.calculateMin();
        int max = this.calculateMax();
        this.values = new ArrayList<>();
        for(int i=min;i<=max+1;i++)
            values.add("0");
        this.offset = min;
        this.testcaseName = s;
    }

    private int calculateMin() {
        int min = this.folios.get(0).startFolio;
        for(Folio f: this.folios) {
            if(f.startFolio < min)
                min = f.startFolio;
        }
        return min;
    }

    private int calculateMax() {
        int max = this.folios.get(0).endFolio;
        for(Folio f: this.folios) {
            if(f.endFolio > max)
                max = f.endFolio;
        }
        return max;
    }

    public void calcFolios() {
        for(Folio f: this.folios) {
            String value = f.statusCode + f.transferCode;
            for(int i=f.startFolio - this.offset;i<=f.endFolio - this.offset;i++)  {
                this.values.set(i, value);
            }
        }
    }

    public void printFolios() {
        int startIndex = this.offset;
        String currFolio = this.values.get(0);
        System.out.println(this.testcaseName);
        for(int i=1;i<this.values.size();i++) {
            String s = this.values.get(i);
            if(s.equals(currFolio))
                continue;
            if(!currFolio.equals("0"))
                System.out.println(startIndex + " " + (i+this.offset-1) + " " + currFolio.substring(0,1) + " " + currFolio.substring(1));
            startIndex = i + this.offset;
            currFolio = s;
        }
    }
}
