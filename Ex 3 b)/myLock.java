import java.util.ArrayList;
import java.util.Arrays;

public class myLock {
    volatile int[] level;
    volatile int[] victim;
    volatile int n;

    public myLock(int n){
        this.n = n;
        this.level = new int[n+5];
        this.victim = new int[n+5];
        Arrays.fill(level, -1);
        Arrays.fill(victim, -1);
    }

    public boolean exists_k1 (int i, int L){
        boolean exists_k = false;
        for (int k = 0; k < n; k++){
            if (k != i && level[k] >= L){
                exists_k = true;
                break;
            }
        }
        return exists_k;
    }

    public boolean exists_k2 (int i) {
        boolean exists_k = false;
        for (int k = 0; k < n; k++){
            if (level[k] >= 0 && level[k] < victim.length) {
                if (k != i && victim[level[k]] != k){
                    exists_k = true;
                    break;
                }
            }
        }
        return exists_k;
    }

    public void lock(int i) {
        for (int L = 0; L < n; L++) {
            level[i] = L;
            victim[L] = i;

            while (exists_k1(i, L) && victim[L] == i) {}

                            //  while (( exists k != i with level[k] >= L ) && victim[L] == i ) {};
        }

        //while (exists_k2(i)) {}

        System.out.println("Am obtinut lockul pt threadul: " + i);
    }

    public void unlock(int i) {
        level[i] = -1;
    }
}
