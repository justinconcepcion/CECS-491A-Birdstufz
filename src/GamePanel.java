import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class GamePanel extends JPanel{
	private static final String PATH_BANNER = "images/panel.png";
	protected static BufferedImage brand, banner;
	protected StatusBar statusBar;
	static
	{
		try
		{
			banner = ImageIO.read(new File(PATH_BANNER));
		} catch(IOException e)
		{
			System.out.println("Files for status bar not found");
		}
	}
	public void initializeStatusBar()
	{
		setLayout(new BorderLayout());
		statusBar = new StatusBar();
		add(BorderLayout.SOUTH, statusBar);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// Draws the status bar
		//g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f)); // Adjusts opacity;
		//g2.drawImage(brand, getWidth()-180, getHeight()-60, 180, 60, null);
		//g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
	}
	public abstract void reset();
	public abstract void addListener(ActionListener al);
	public abstract void removeListener(ActionListener al);
}
