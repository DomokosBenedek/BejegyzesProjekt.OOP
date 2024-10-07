import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Feladatok {
    List<Bejegyzes> bejegyzesek = new ArrayList<Bejegyzes>();
    Random rn = new Random();

    public void ketbejegyzes(){
        bejegyzesek.add(new Bejegyzes("Kiss Béla", "Fogalmam sincsen"));
        bejegyzesek.add(new Bejegyzes("Nagy Antal", "Esélytelen"));
    }

    public void bekeres(){
        Scanner scanner = new Scanner(System.in);
        int darabSzam = 0;
        String szerzo = "";
        String tartalom = "";

        while (darabSzam <= 0){
            System.out.println("Adjon meg egy darabszámot");
            darabSzam = Integer.parseInt(scanner.nextLine());
            //if ()
        }
        for (int i = 0; i < darabSzam; i++) {
            System.out.println("Írjon be egy bejegyzést (szerzo):");
            szerzo = scanner.nextLine();
            System.out.println("Írjon be egy bejegyzést (tartalom):");
            tartalom = scanner.nextLine();
            bejegyzesek.add(new Bejegyzes( szerzo,tartalom));
        }
    }

    public void beolvasas(String fileName){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String sor = bufferedReader.readLine();
            while (sor != null && !sor.isEmpty()){
                String[] adatok = sor.split(";");
                bejegyzesek.add(new Bejegyzes(adatok[0], adatok[1]));
                sor = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Beolvasas sikeres.");
    }

    public void likeKiosztas(){
        int likeokSzama = bejegyzesek.size()*20;

        for (Bejegyzes element:bejegyzesek){
            int itemLike = rn.nextInt(likeokSzama);
            for (int i = 0; i < itemLike; i++) {
                element.like();
            }
            likeokSzama = likeokSzama -itemLike;
        }
    }

    public void szerkeszt(int index, String tartalom){
        bejegyzesek.get(index-1).setTartalom(tartalom);
        System.out.println("Szerkesztés kész");
    }

    public void kiiras(){
        for (Bejegyzes element : bejegyzesek){
            System.out.println(element);
        }
    }

    public Bejegyzes legNepszerubb(){
        Bejegyzes nepszeru = bejegyzesek.get(0);
        for (Bejegyzes element : bejegyzesek){
            if (element.getLikeok() > nepszeru.getLikeok()){
                nepszeru = element;
            }
        }
        return nepszeru;
    }

    public boolean overXLike(int number){
        for (Bejegyzes element : bejegyzesek){
            if (element.getLikeok() > number){
                return true;
            }
        }
        return false;
    }

    public int lessXlike(int number){
        int szamlalo = 0;
        for (Bejegyzes element : bejegyzesek){
            if (element.getLikeok() < number){
                szamlalo++;
            }
        }
        return szamlalo;
    }

    public void FileKiiras(String fileName){
        //List<Bejegyzes> sortBejegyzesek = bejegyzesek.sort();

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for (Bejegyzes element : bejegyzesek){
                bufferedWriter.write(element.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Beolvasas sikeres.");
    }


}
