import java.time.LocalDate;

public class Bejegyzes {
    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDate getLetrejott() {
        return letrejott;
    }

    public LocalDate getSzerkesztve() {
        return szerkesztve;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDate.now();
    }

    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDate letrejott;
    private LocalDate szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDate.now();
        this.szerkesztve = this.letrejott;
    }

    public void like(){
        this.likeok = getLikeok()+1;
    }

    @Override
    public String toString() {
        if (getLetrejott() != getSzerkesztve()) {
            return getSzerzo() + " - " + getLikeok() + " - " + getLetrejott() + "\n" +
                    "Szerkesztve: " + getSzerkesztve() + "\n" +
                    getTartalom();
        }
        else {
            return getSzerzo() + " - " + getLikeok() + " - " + getLetrejott() + "\n" +
                    getTartalom();
        }
    }
}
