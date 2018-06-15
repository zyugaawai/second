package com.mhl.view;
import javax.swing.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.mhl.tools.Tools;
import java.awt.*;
import java.awt.event.*;

import com.mhl.model.*;
public class DetailsDia extends JDialog implements ActionListener{
	JButton jb1,jb2;
	JLabel jl1,jl2,jl3,jl5,jl4,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11,jtf12,jtf13;
	JPanel jp1,jp2,jp3;
	UpdateDialog upd;
	HRManagerModel temp;
	int temprow;
	public DetailsDia(Frame owner, String title, boolean modal,HRManagerModel hmm,int Rownum) {
		super(owner, title, modal);
		this.temp=hmm;
		this.temprow=Rownum;
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		jb1=new JButton("返回");
		jb1.addActionListener(this);
		jb2=new JButton("修改");
		jb2.addActionListener(this);
		//jb1.setFont(Tools.f1);
		//jb2.setFont(Tools.f1);
		jp1=new JPanel();
		jp1.add(jb1);
		jp1.add(jb2);
		this.add(jp1,BorderLayout.SOUTH);
		
		jl1=new JLabel("员工号：");
		jl2=new JLabel("姓名：");
		jl3=new JLabel("性别：");
		jl4=new JLabel("籍贯：");
		jl5=new JLabel("生日：");
		jl6=new JLabel("sfzid：");
		jl7=new JLabel("学历：");
		jl8=new JLabel("职位：");
		jl9=new JLabel("婚姻状况：");
		jl10=new JLabel("固定电话：");
		jl11=new JLabel("移动电话：");
		jl12=new JLabel("邮箱");
		jl13=new JLabel("入职时间：");
		jp2=new JPanel();
		jp2.setLayout(new GridLayout(13,1));
		jp2.add(jl1);
		jp2.add(jl2);
		jp2.add(jl3);
		jp2.add(jl4);
		jp2.add(jl5);
		jp2.add(jl6);
		jp2.add(jl7);
		jp2.add(jl8);
		jp2.add(jl9);
		jp2.add(jl10);
		jp2.add(jl11);
		jp2.add(jl12);
		jp2.add(jl13);
		this.add(jp2, BorderLayout.WEST);
		
		jtf1=new JTextField(20);
		jtf2=new JTextField(20);
		jtf3=new JTextField(20);
		jtf4=new JTextField(20);
		jtf5=new JTextField(20);
		jtf6=new JTextField(20);
		jtf7=new JTextField(20);
		jtf8=new JTextField(20);
		jtf9=new JTextField(20);
		jtf10=new JTextField(20);
		jtf11=new JTextField(20);
		jtf12=new JTextField(20);
		jtf13=new JTextField(20);
		jtf1.setText((String)hmm.getValueAt(Rownum, 0));
		jtf2.setText((String)hmm.getValueAt(Rownum, 1));
		jtf3.setText((String)hmm.getValueAt(Rownum, 3));
		jtf4.setText((String)hmm.getValueAt(Rownum, 4));
		jtf5.setText((String)hmm.getValueAt(Rownum, 5));
		jtf6.setText((String)hmm.getValueAt(Rownum, 6));
		jtf7.setText((String)hmm.getValueAt(Rownum, 7));
		jtf8.setText((String)hmm.getValueAt(Rownum, 8));
		jtf9.setText((String)hmm.getValueAt(Rownum, 9));
		jtf10.setText((String)hmm.getValueAt(Rownum,10));
		jtf11.setText((String)hmm.getValueAt(Rownum, 11));
		jtf12.setText((String)hmm.getValueAt(Rownum, 12));
		jtf13.setText((String)hmm.getValueAt(Rownum, 13));
		jtf1.setEditable(false);
		jtf2.setEditable(false);
		jtf3.setEditable(false);
		jtf4.setEditable(false);
		jtf5.setEditable(false);
		jtf6.setEditable(false);
		jtf7.setEditable(false);
		jtf8.setEditable(false);
		jtf9.setEditable(false);
		jtf10.setEditable(false);
		jtf11.setEditable(false);
		jtf12.setEditable(false);
		jtf13.setEditable(false);
		jp3=new JPanel();
		jp3.setLayout(new GridLayout(13,1));
		jp3.add(jtf1);
		jp3.add(jtf2);
		jp3.add(jtf3);
		jp3.add(jtf4);
		jp3.add(jtf5);
		jp3.add(jtf6);
		jp3.add(jtf7);
		jp3.add(jtf8);
		jp3.add(jtf9);
		jp3.add(jtf10);
		jp3.add(jtf11);
		jp3.add(jtf12);
		jp3.add(jtf13);
		this.add(jp3, BorderLayout.CENTER);
		
		
		
		
		
		
		this.setSize(400, 800);
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-200,Toolkit.getDefaultToolkit().getScreenSize().height/2-400);
		this.setVisible(true);

		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1)
		{
			this.dispose();
		}else if(arg0.getSource()==jb2)
		{
			this.dispose();
			upd=new UpdateDialog(JOptionPane.getFrameForComponent(this),"修改信息",true,temp,temprow);
		}
	}
	
	


	
}
