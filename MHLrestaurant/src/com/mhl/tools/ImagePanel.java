/*
 * 可以动态加载一个图片做背景的JPanel  
 */
package com.mhl.tools;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
public class ImagePanel extends JPanel{
	Image im;
	public ImagePanel(Image im)
	{
		this.im=im;
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width, height);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(im, 0, 0,this.getWidth(), this.getHeight(), this);
	}
}
