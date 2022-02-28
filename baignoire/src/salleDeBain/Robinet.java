package salleDeBain;



public class Robinet implements Runnable{
    protected Baignoire baignoire;
    public static int volumeDebite;



    public Robinet(Baignoire baignoire, int volumeDebite ) {
        this.baignoire = baignoire;
        this.volumeDebite = volumeDebite;
    }

    public void debite() throws InterruptedException {
        while(baignoire.getVolume() < baignoire.VOLUME_MAX) {
            synchronized (baignoire) {
                baignoire.setVolume(baignoire.getVolume() + volumeDebite);
                System.out.println("Le niveau de la baigneoire est de : " + baignoire.getVolume() + "L");
            }
            Thread.sleep(1);
        }
    }


    @Override
    public void run() {
        try {
            this.debite();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
