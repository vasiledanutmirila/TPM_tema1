import java.util.ArrayList;
import java.util.List;

public class main2 {
    public static void main(String[] args) throws InterruptedException {
        int numarPersoane = 16;
        int numarPortii = 16;
        Oala oala = new Oala(numarPortii, numarPersoane);

        List<Thread> threadList = new ArrayList<>();
        Thread bucatar = new Thread(new Runnable() {
            int index = 0;

            @Override
            public void run() {
                while (true) {
                    oala.umple(index);
                }
            }
        });

        for (int i = 1; i < numarPersoane; i++) {
            Persoana persoana = new Persoana(oala, i);
            threadList.add(persoana);
        }

        long startTime = System.nanoTime();

        bucatar.start();
        for (int i = 0; i < threadList.size(); i++) {
            threadList.get(i).start();
        }

        Thread.sleep(10000);


        for (int i = 0; i < threadList.size(); i++){
            threadList.get(i).stop();
        }
        bucatar.stop();

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        int[] result = oala.getHistory();
        int mancatTotal = 0;
        for (int i = 0; i < result.length; i++) {
            System.out.println("Thread-ul " + i + " a mancat de " + result[i] + " ori.");
            if (i != 0){
                mancatTotal += result[i];
            }
        }
        System.out.println("Au fost mancate " + mancatTotal + " portii.");
        System.out.println("Au fost umplute " + (result[0] * numarPortii) + " portii.");
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
}