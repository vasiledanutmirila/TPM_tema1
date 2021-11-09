import java.util.Arrays;

public class Oala {
    int numarTotalPortii;
    volatile int numarCurentPortii;
    int[] history;
    volatile myLock mylock;

    public Oala(int portii, int nr_actori) {
        this.numarTotalPortii = portii;
        this.numarCurentPortii = portii;
        this.mylock = new myLock(nr_actori);
        this.history = new int[nr_actori];
        Arrays.fill(this.history, 0);
    }

    public int getNumarCurentPortii() {
        return this.numarCurentPortii;
    }

    public int[] getHistory() {
        return this.history;
    }

    public boolean hraneste(int index) {
        boolean result = false;
        if(this.numarCurentPortii > 0) {
            mylock.lock(index);
            if(this.numarCurentPortii > 0){
                this.numarCurentPortii --;
                this.history[index] ++;
                result = true;
            }
            mylock.unlock(index);
        }
        return result;
    }

    public void umple(int index) {
        if(this.numarCurentPortii == 0) {
            mylock.lock(index);
            if(this.numarCurentPortii == 0) {
                numarCurentPortii = numarTotalPortii;
                this.history[index]++;
            }
            mylock.unlock(index);
        }
    }
}