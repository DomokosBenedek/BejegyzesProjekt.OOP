import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Feladatok f = new Feladatok();
        f.ketbejegyzes();
        //f.kiiras();
        //f.bekeres();
        //f.beolvasas("bejegyzesek.csv");
        f.likeKiosztas();
        for (Bejegyzes element:f.bejegyzesek){
            System.out.println(element.getSzerzo() + ": " + element.getTartalom() + "\n"+
                    element.getLikeok());
        }
        //f.kiiras();
        //Szerkesztés
        /*
        System.out.println("mire változtassuk a 2. bejegyzés tartalmát?");
        String valtozas = scanner.nextLine();
        f.szerkeszt(2, valtozas);*/
        f.kiiras();
        System.out.println("A legnépszerübb bejegyzés." + f.legNepszerubb());
        if (f.overXLike(35)==true){
            System.out.println("Van olyan bejegyzés aminél több mint 35 like van");
        }
        else{
            System.out.println("Nincs olyan bejegyzés aminél több mint 35 like van.");
        }
        System.out.println("Összesen " + f.lessXlike(15) + " darabb bejegyzésnél van kevesebb mint 15 like");
        f.FileKiiras("bejegyzesek_rendszerezett.txt");
    }
}