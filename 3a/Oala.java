public class Oala {
    int numarTotalPortii;
    int numarCurentPortii;

    public Oala(int portii) {
        this.numarTotalPortii = portii;
        this.numarCurentPortii = portii;
    }

    synchronized public int getNumarCurentPortii() {
        return this.numarCurentPortii;
    }

    synchronized public void hraneste() {
        if(this.numarCurentPortii > 0) {
            this.numarCurentPortii--;
        }
    }

    synchronized public int umple(int count) {
        if(this.numarCurentPortii == 0) {
            numarCurentPortii = numarTotalPortii;
            count++;
        }
        return count;
    }
}