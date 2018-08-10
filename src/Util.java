import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Util {
    public static void main(String ar[]) throws IOException {
        File file = new File("./testcase.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<Folio> folioList = new ArrayList<>();
        String testcaseName = "";
        String st;
        boolean firstLine = true;
        while((st = br.readLine()) != null) {
            if(st.equals("0")) {
                FolioCalculate fc = new FolioCalculate(folioList, testcaseName);
                fc.calcFolios();
                fc.printFolios();
                System.out.println("");

                firstLine = true;
                continue;
            }
            if(firstLine) {
                testcaseName = st;
                folioList = new ArrayList<>();
                firstLine = false;
            }
            else {
                Folio f = new Folio(st);
                folioList.add(f);
            }
        }
    }
}
