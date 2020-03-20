package utilities;

public class WaitSecond {

    public static void wait(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
