import java.util.ArrayList;

public class Folio {
    int startFolio;
    int endFolio;
    String statusCode;
    int transferCode;

    public Folio(String input) {

        String[] splitInput = input.split("\\s+");

        this.startFolio = Integer.parseInt(splitInput[0]);
        this.endFolio = Integer.parseInt(splitInput[1]);
        this.statusCode = splitInput[2];
        this.transferCode = Integer.parseInt(splitInput[3]);

//        System.out.println(this.startFolio + "   " + this.endFolio + "   " + this.statusCode + "   " + this.transferCode + "   ");
    }
}
