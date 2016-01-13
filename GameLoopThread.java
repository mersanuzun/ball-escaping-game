package ballEscaping;

/**
 * Created by mersanuzun on 14/01/2016.
 */
public class GameLoopThread implements Runnable {

    private GameView gameView;
    private Thread thread;

    public GameLoopThread(GameView view){
        this.gameView = view;
    }

    public void run(){

        while(true){
            System.out.println("run");
            try {
                thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gameView.update();
        }

    }

    public void start(){
        if (thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }

    public Thread getThread(){
        return thread;
    }
}
