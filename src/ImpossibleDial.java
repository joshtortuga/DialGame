import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class ImpossibleDial extends JPanel implements ActionListener  {

	public static int centerX1 = 250;
	public static int centerY1 = 273;
	public static int topCenterX2 = 250;
	public static int topCenterY2 = 130;
	static ImpossibleDial ID = new ImpossibleDial();
	private double angle = centerX1;

	Timer timer;

	public ImpossibleDial() {
		timer = new Timer(10, this);
		timer.start();
	}


	static String myString = "0";

	static int score = Integer.parseInt(myString);

	Color blue = new Color(28,144,255);
	Color green = new Color(69,174,112);
	Color yellow = new Color(237,228,29);
	Color red = new Color(240,51,93);

	int k = 225;

	static boolean right = true;
	static boolean left = false;

	public void paint (Graphics g)  {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(10));
		super.paint(g);
		int h = getHeight();
		int w = getWidth();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Bebas Neue", Font.PLAIN, 80));



		g2d.setColor(green);
		g2d.drawArc(100,110, 300,300,90-k,90) ;
		// green arc
		
				

		g2d.setColor(blue);
		g2d.drawArc(100,110,300,300,0-k,90);
		//blue arc

		g2d.setColor(yellow);
		g2d.drawArc(100,110,300,300,180-k,90) ;
		//yellow arc

		g2d.setColor(red);
		g2d.drawArc(100,110,300,300,270-k,90) ;
		//red arc

		g2d.setColor(Color.black);
		g2d.drawString(myString, 235, 75);
		//score

		g2d.setStroke(new BasicStroke(11.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.setColor(red);
		g2d.drawLine((int)(centerX1+143*Math.sin(Math.toRadians(angle))), 
				(int)(centerY1+143*Math.cos(Math.toRadians(angle))),
				centerX1, centerY1);
		//g2d.translate(w / 2, h / 2);
		g2d.rotate(angle);
		//gameline
	}

	public void gameLoop(){

		ID.repaint();

	}


	public static void main(String[] args) throws InterruptedException {

		JFrame frame = new JFrame ("Impossible Dial");
		frame.setVisible(true);
		frame.setSize(500,490);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(ID);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {	
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_R) {

				}

				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					System.out.println("works");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		angle += .1;
	    repaint();
	    
	    if (angle>0 && angle<100) {
	    	
	    }
	 
	}

}


