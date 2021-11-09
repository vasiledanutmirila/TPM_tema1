public class Persoana extends Thread{
    int numarPortiMancate = 0;
    Oala oala;
    int index;

    public Persoana(Oala oala1, int index1) {
        this.oala = oala1;
        this.index = index1;
    }

    @Override
    public void run() {
        while (true) {
            this.oala.hraneste();
            this.numarPortiMancate++;
            System.out.println(this.oala.getNumarCurentPortii());
            if(this.numarPortiMancate == 1000){
                System.out.println(this.index + "am ajuns");
            }
        }
    }
}
