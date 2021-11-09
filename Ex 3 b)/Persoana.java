public class Persoana extends Thread{
    int numarPortiMancate = 0;
    Oala oala;
    int index;

    public Persoana(Oala oala1, int index1) {
        this.oala = oala1;
        this.index = index1;
    }

    public int getNumarPortiMancate(){
        return numarPortiMancate;
    }

    @Override
    public void run() {
        while (true) {
            if (this.oala.hraneste(index))
                this.numarPortiMancate++;
        }
    }
}