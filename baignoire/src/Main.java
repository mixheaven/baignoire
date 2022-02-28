import salleDeBain.Baignoire;
import salleDeBain.Robinet;

public class Main {
    public static void main(String[] args) {
        Baignoire baignoire = new Baignoire(0, 10);
        Robinet robinet = new Robinet(baignoire, 50);
        Thread threadBaignoire = new Thread(baignoire);
        Thread threadRobinet = new Thread(robinet);

        threadBaignoire.start();
        threadRobinet.start();
    }
}
