package ballEscaping;



import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by mersanuzun on 01/01/2016.
 */
public class GameView extends JFrame implements KeyListener{
    private JPanel contentPane;
    private Ball ball;
    private Barrier barrier;
    private DrawingPane drawingPane;
    private GameStatus gameStatus;
    private JLabel lblPoint;
    private int point = 0;
    private JButton btnRestart;
    private JPanel buttonPanel;
    private GameLoopThread gameLoopThread;
    public GameView(){
        gameLoopThread = new GameLoopThread(this);
        gameLoopThread.start();
        ball = new Ball();
        barrier = new Barrier();
        gameStatus = GameStatus.RUNNING;
        drawingPane = new DrawingPane(ball, barrier);
        System.out.println(Thread.currentThread().getName());
        setTitle("Ball Escaping");
        setMinimumSize(new Dimension(500,500));
        setVisible(true);
        setFocusable(true);

        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(drawingPane, BorderLayout.CENTER);

        JPanel gameInfoPanel = new JPanel();
        contentPane.add(gameInfoPanel, BorderLayout.SOUTH);
        gameInfoPanel.setLayout(new BorderLayout());
        gameInfoPanel.setPreferredSize(new Dimension(500, 50));


        JPanel pointPanel = new JPanel();
        gameInfoPanel.add(pointPanel, BorderLayout.CENTER);
        pointPanel.setPreferredSize(new Dimension(250,50));
        pointPanel.setLayout(new FlowLayout());
        pointPanel.setBackground(new Color(204,255,229));

        lblPoint = new JLabel("Point : 0");
        lblPoint.setFont(new Font("Arial", Font.BOLD, 40));
        lblPoint.setForeground(new Color(0,102,102));
        pointPanel.add(lblPoint);

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(250, 50));
        buttonPanel.setLayout(new BorderLayout());
        gameInfoPanel.add(buttonPanel, BorderLayout.EAST);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setVisible(false);

        btnRestart = new JButton("Play Again");
        buttonPanel.add(btnRestart, BorderLayout.CENTER);

                btnRestart.addActionListener(e -> {
                            gameStatus = GameStatus.RUNNING;
                            buttonPanel.setVisible(false);
                            barrier.resetWallStep();
                            barrier.generateWalls();
                            setFocusable(true);
                            gameLoopThread = new GameLoopThread(GameView.this);
                            gameLoopThread.start();
                        }
                );

        addKeyListener(this);
        repaint();
    }

    public void update(){
        repaint();
        drawingPane.repaint();
        ball.update();
        barrier.update();

        if (isCollision()){
            gameStatus = GameStatus.DEAD;
            buttonPanel.setVisible(true);
            try {
                gameLoopThread.getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            if (isPass()) {
                barrier.generateWalls();
                barrier.calculateWallStep();
                lblPoint.setText("Point : " + ++point);
            }
        }
    }

    public Boolean isCollision(){
        return barrier.isCollision(ball);
    }

    public Boolean isPass(){
        return barrier.isPass(ball);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                ball.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                ball.moveRight();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                ball.stop();
                break;
            case KeyEvent.VK_RIGHT:
                ball.stop();
                break;
        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
