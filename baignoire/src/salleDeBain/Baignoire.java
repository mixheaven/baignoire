package salleDeBain;

public class Baignoire implements Runnable {

    public static final int VOLUME_MAX = 1000;
    private int volume;
    public static int volumeFuite;



    public Baignoire(int volume){
        this.volume = volume;
    }
    public Baignoire(int volume, int volumeFuite){
        this.volume = volume;
        this.volumeFuite = volumeFuite;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume < 0 || volume > VOLUME_MAX){
            System.out.println("erreur de remplissage");
        }else {
            this.volume = volume;
        }
    }
    public void fuite() throws InterruptedException {
        while(volumeFuite > 0 ){
            if(volume > 0) {
                synchronized (this) {
                    volume = this.volume - volumeFuite;
                    System.out.println("la baignoire fuit de " + volumeFuite + "son volume de remplissage est de : " + volume + "L");
                }
                Thread.sleep(1);
            }
        }
    }

    @Override
    public void run() {
        try {
            this.fuite();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
