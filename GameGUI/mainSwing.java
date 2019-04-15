package GameGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;


public class mainSwing {

	private JFrame frmRgbGame;
	public RGB rgb;
	private circle c1;
	private circle c2;
	private circle c3;
	private int highestScore;
	private int winScore;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainSwing window = new mainSwing();
					window.frmRgbGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rgb = new RGB();
		Random r = new Random();
		int nextPick = r.nextInt(3);
		
		highestScore = 0;
		frmRgbGame = new JFrame();
		frmRgbGame.setTitle("RGB Game");
		frmRgbGame.setResizable(false);
		frmRgbGame.setBounds(100, 100, 725, 502);
		frmRgbGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRgbGame.getContentPane().setLayout(null);
		frmRgbGame.getContentPane().setBackground(new Color(64, 115, 158));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 114, 719, 359);
		frmRgbGame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelStart = new JPanel();
		layeredPane.add(panelStart, "name_60144805314597");
		panelStart.setBackground(new Color(53, 59, 72));
		panelStart.setLayout(null);

		
		
		JPanel panelGame = new JPanel();
		
		layeredPane.add(panelGame, "name_60167423657356");
		panelGame.setBackground(new Color(53,59,72));
		panelGame.setLayout(null);
		
		JLabel lblHighestScore = new JLabel();
		JLabel lblRGB = new JLabel();
		JLabel lblEnd = new JLabel();
		
		c1 = new circle();
		c2 = new circle();
		c3 = new circle();
		
		JLabel lblScore = new JLabel("");
		
		JButton btnAgain = new JButton("Again");
		btnAgain.setVisible(false);
		btnAgain.setBackground(Color.DARK_GRAY);
		btnAgain.setForeground(Color.BLACK);
		btnAgain.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		
		rgb = randPick();
		
		c1.setBounds(184, 70, 100, 100);
		c1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
               
            if(c1.rgb == rgb) 
            {
            	WinLose(lblScore,"Score: "+(++winScore));
             	WinLose(lblEnd,"WIN");
             	highestScore = (winScore>highestScore) ? winScore : highestScore;
             	lblHighestScore.setText("Best Record: "+highestScore);
                System.out.println("Correct");
            }
            else
            {
            	winScore=0;
            	WinLose(lblScore,"Score: "+winScore);
    			WinLose(lblEnd,"LOOOSE");
            	System.out.println("WRONG");

            	c1.setVisible(false);
            	
            	if(c2.rgb == rgb)
            	{
            		c3.setVisible(false);
            	}
            	else
            	{
            		c2.setVisible(false);
            	}
            }
                
            btnAgain.setVisible(true);
            
            }
        });
		
		
		
		c2.setBounds(307, 70, 100, 100);
		c2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(c2.rgb == rgb)
                {
                	WinLose(lblScore,"Score: "+(++winScore));
                	WinLose(lblEnd,"WIN");
                	highestScore = (winScore>highestScore) ? winScore : highestScore;
                 	lblHighestScore.setText("Best Record: "+highestScore);
                	System.out.println("Correct");
		        }
		        else 
		        {
		        	winScore=0;
		        	WinLose(lblScore,"Score: "+winScore);
					WinLose(lblEnd,"LOOOSE");
		        	System.out.println("WRONG");
		        		
		        	c2.setVisible(false);
		        	
		        	if(c1.rgb == rgb)
	            	{
	            		c3.setVisible(false);
	            	}
	            	else
	            	{
	            		c1.setVisible(false);
	            	}
		        }
                
                btnAgain.setVisible(true);
            }
        });
		
		
		c3.setBounds(430, 70, 100, 100);
		c3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(c3.rgb == rgb)
                {
                	WinLose(lblScore,"Score: "+(++winScore));
                	WinLose(lblEnd,"WIN");
                	highestScore = (winScore>highestScore) ? winScore : highestScore;
                 	lblHighestScore.setText("Best Record: "+highestScore);
                  	System.out.println("Correct");
	            }
	            else 
	            {
	            	winScore=0;
	            	WinLose(lblScore,"Score: "+winScore);
	    			WinLose(lblEnd,"LOOOSE");
	            	System.out.println("WRONG");
	            	
	            	c3.setVisible(false);
	            	if(c1.rgb == rgb)
	            	{
	            		c2.setVisible(false);
	            	}
	            	else
	            	{
	            		c1.setVisible(false);
	            	}
	            }
                
                btnAgain.setVisible(true);
            }
        });
		
		
		
		panelGame.add(c1);
		panelGame.add(c2);
		panelGame.add(c3);
		
		lblRGB.setHorizontalAlignment(SwingConstants.CENTER);
		lblRGB.setForeground(Color.WHITE);
		lblRGB.setFont(new Font("Tempus Sans ITC", Font.BOLD, 27));
		lblRGB.setBounds(228, 11, 260, 48);
		
		panelGame.add(lblRGB);
		
		
		lblEnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnd.setForeground(Color.WHITE);
		lblEnd.setFont(new Font("Tempus Sans ITC", Font.BOLD, 27));
		lblEnd.setBounds(264, 220, 176, 71);
		panelGame.add(lblEnd);
		
		
		btnAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c1.circleRand();
				c2.circleRand();
				c3.circleRand();
				
				c1.setVisible(true);
				c2.setVisible(true);
				c3.setVisible(true);
				
				lblEnd.setText("");
				
				rgb = randPick();
				lblRGB.setText(rgb.toString());
				layeredPane.removeAll();
				layeredPane.add(panelGame);
				layeredPane.repaint();
				layeredPane.revalidate();
				btnAgain.setVisible(false);
			}
		});
		btnAgain.setBounds(264, 289, 176, 48);
		panelGame.add(btnAgain);
		
		
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblScore.setBounds(10, 11, 150, 48);
		panelGame.add(lblScore);
		
		
		lblHighestScore.setForeground(Color.WHITE);
		lblHighestScore.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblHighestScore.setBounds(559, 11, 150, 48);
		panelGame.add(lblHighestScore);
		
		
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rgb = randPick();
				lblRGB.setText(rgb.toString());
				layeredPane.removeAll();
				layeredPane.add(panelGame);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				
			}
		});
		
		btnStart.setBounds(215, 77, 256, 84);
		panelStart.add(btnStart);
		
		JLabel lblRgb = new JLabel("RGB challenge",SwingConstants.CENTER);
		lblRgb.setFont(new Font("Trebuchet MS", Font.PLAIN, 29));
		lblRgb.setForeground(Color.white);
		lblRgb.setBounds(220, 40, 266, 63);
		frmRgbGame.getContentPane().add(lblRgb);
	    

	    
		
	}
	
	private RGB randPick()
	{
		Random r = new Random();
		switch(r.nextInt(2)+1)
		{
		case 1:
		{
			return c1.rgb;
		}
		case 2:
		{
			return c2.rgb;
		}
		case 3:
		{
			return c3.rgb;
		}
		default:
		{
			return new RGB();
		}
		}
	}
	
	void WinLose(JLabel jl,String str)
	{
		jl.setText(str);
	}
}

class RGB
{
	public int Red;
	public int Green;
	public int Blue;
	
	
	public String toString()
	{
		return "("+Red+","+Green+","+Blue+")";
	}
}