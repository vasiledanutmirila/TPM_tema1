import sun.font.TrueTypeFont;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();
        Oala oala = new Oala(16);
        final int[] hraniri = {0};
        final int[] umpleri = {0};
        Thread bucatar = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    umpleri[0] = oala.umple(umpleri[0]);
                }
            }
        });

        int numarPersoane = 16;
        bucatar.start();

        for (int i = 0; i < numarPersoane; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    oala.hraneste();
                    hraniri[0]++;
                }
            });
            thread.start();
            thread.join();
        }

        bucatar.stop();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("Au fost " + hraniri[0] + " hraniri");
        System.out.println("Au fost " + umpleri[0] + " umpleri");
        System.out.println("Programul a rulat " + (timeElapsed / 1000000) + " milisecunde");

    }
}
