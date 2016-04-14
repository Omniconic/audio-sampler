

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.jidesoft.swing.RangeSlider;

public class SamplerUI {

	public static void main(String[] args)
	   {
	      EventQueue.invokeLater(new Runnable()
	         {
	            public void run()
	            {
	               JFrame frame = new DrawFrame();
	               frame.setTitle("DrawTest");
	               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	               frame.setVisible(true);
	            }
	         });
	   }

/**
 * A frame that contains a panel with drawings
 */
class DrawFrame extends JFrame
{
   public DrawFrame()
   {      
      add(new DrawComponent());
      pack();
   }
}
	
class DrawComponent extends JComponent
{
   private static final int DEFAULT_WIDTH = 500;
   private static final int DEFAULT_HEIGHT = 400;

   public void paintComponent(Graphics g)
   {	

		
		RangeSlider slider1 = new RangeSlider(0, 100, 0, 100);
		slider1.setBounds(6, 6, 351, 63);
		slider1.setPaintTicks(true);
	
		
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
}