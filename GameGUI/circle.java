package GameGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JComponent;

public class circle extends JComponent {
	
	public RGB rgb;
	private Graphics2D g2;
	
	public circle()
	{
		rgb = new RGB();
		this.circleRand();
	}
	
	public void circleRand()
	{
		Random r = new Random();
		rgb.Red = r.nextInt(254)+1;
        rgb.Green = r.nextInt(254)+1;
        rgb.Blue = r.nextInt(254)+1;
	}
    protected void paintComponent(Graphics g){
    	
    	super.paintComponent(g);
        
    	g2 = (Graphics2D) g;        
        g2.setColor(new Color(rgb.Red,rgb.Green,rgb.Blue));
        g2.fillOval(0, 0, 100, 100);
      
    }
  
    public Graphics2D getGraphics()
    {
    	return this.g2;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

}

//public static RGB mainRGB = new RGB();
