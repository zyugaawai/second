package com.mhl.view;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import com.mhl.tools.*;
public class OrderIndex extends JPanel{
	JSplitPane jsp;
	Image im1,im2;
	ImagePanel imjp1,imjp2;
	JLabel jl0,jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16,jl17,jl18,jl19,jl20,jl21,jl22,jl23,jl24,jl25;
	JButton jb1,jb2,jb3,jb4;
	public OrderIndex()
	{
		try {
			im1=ImageIO.read(new File("image/Orderindex/orderindex.jpg"));
			im2=ImageIO.read(new File("image/Orderindex/manage.jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imjp1=new ImagePanel(im1);
		imjp2=new ImagePanel(im2);
		
		//jp2
		imjp2.setLayout(null);
		jl0=new JLabel(new ImageIcon("image/Orderindex/label_1.gif"));
		jl0.setBounds(200, 100, 150, 65);
		imjp2.add(jl0);
		jb1=new JButton("‘§∂®");
		jb2=new JButton("ÕÀ∂©");
		jb3=new JButton("µ„≤À");
		jb4=new JButton("Ω·’À");
		jb1.setBounds(100, 600, 100, 50);
		imjp2.add(jb1);
		jb2.setBounds(365, 600, 100, 50);
		imjp2.add(jb2);
		jb3.setBounds(100, 700, 100, 50);
		imjp2.add(jb3);
		jb4.setBounds(365, 700, 100, 50);
		imjp2.add(jb4);
		
		//jp1
		imjp1.setLayout(null);
		jl1=new JLabel(new ImageIcon("image/Orderindex/1.jpg"));
		jl1.setBounds(300, 280, 150,108);
		imjp1.add(jl1);
		
		
		
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,imjp1,imjp2);
		jsp.setDividerLocation(1350);
		jsp.setDividerSize(0);
		
		
		this.setLayout(new BorderLayout());
		this.add(jsp,BorderLayout.CENTER);
	}
}
