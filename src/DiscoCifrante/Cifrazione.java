package DiscoCifrante;

public class Cifrazione {

    private final char[] caratteriChiaro = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'I', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Z', '1', '2', '3', '4'};
    private final char[] caratteriCriptati = {'m', 'o', 'e', 'b', 'k', 'x', 'i', 'h', 'c', 'n', 'z', 'u', 'r', 'y', 'p', 'a', 'g', 'q', 'l', 'd', 'f', 't', 's', '&'};
    private int indx;

    public Cifrazione(){
        indx = 0;
    }

    public void setIndx(int indx){
        this.indx = indx;
    }

    public char getChiaro(char carattere){
        char r = '0';

        for (int i = 0; i < 24; i++)
            if (caratteriCriptati[i] == carattere)
                r = caratteriChiaro[getPosChiaro(i)];

        return r;
    }

    public char getCript(char carattere){
        char r = '0';

        for (int i = 0; i < 24; i++)
            if (caratteriChiaro[i] == carattere)
                r = caratteriCriptati[getPosCript(i)];

        return r;
    }

    private int getPosCript(int pos){
        int r = pos + indx;

        if (r >= 24) r = r%24;

        return r;
    }

    private int getPosChiaro(int pos){
        int r = pos - indx;

        if (r < 0) r = 24 + r;

        return r;
    }

}
