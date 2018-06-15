package com.mhl.view;
import javax.swing.*;

import com.mhl.tools.Tools;
import com.mhl.model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Calendar;
import java.text.*;

public class AddEmpDialog extends JDialog implements ActionListener{
	JLabel jl0,jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16;
	JTextField jtf0,jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
	JRadioButton jrb1,jrb2,jrb3,jrb4;
	JComboBox jcb1,jcb2,jcb3,jcb4,jcb5;
	JPanel jp0,jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp10,jp11,jp12,jp13,jp14;
	ButtonGroup bg1,bg2;
	JScrollPane jsp;
	JButton jb1,jb2;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	HRManagerModel hmm=null;
	public static void main(String[] s)
	{
		AddEmpDialog add=new AddEmpDialog(null,"增加",true);
	}
	
	public AddEmpDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
		
		jp1=new JPanel(new GridLayout(12,1));
		jl0=new JLabel("     员工号：");
		jl1=new JLabel("     姓名：");
		jl2=new JLabel("     性别：");
		jl3=new JLabel("     出生日期：");
		jl4=new JLabel("     身份证号：");
		jl5=new JLabel("     学历：");
		jl6=new JLabel("     婚否：");
		jl7=new JLabel("     住址：");
		jl8=new JLabel("     联系电话：");
		jl9=new JLabel("     邮箱：");
		jl10=new JLabel("     职位：");
		jl11=new JLabel("     备注：");
		/*jl1.setFont(Tools.f1);
		jl2.setFont(Tools.f1);
		jl3.setFont(Tools.f1);
		jl4.setFont(Tools.f1);
		jl5.setFont(Tools.f1);
		jl6.setFont(Tools.f1);
		jl7.setFont(Tools.f1);
		jl8.setFont(Tools.f1);
		jl9.setFont(Tools.f1);
		jl10.setFont(Tools.f1);
		jl11.setFont(Tools.f1);*/
		jp1.add(jl0);
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jp1.add(jl8);
		jp1.add(jl9);
		jp1.add(jl10);
		jp1.add(jl11);
		
		jp2=new JPanel(new GridLayout(12,1));
		
		jtf0=new JTextField(10);
		jp0=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp0.add(jtf0);
		jp2.add(jp0);
		
		jp3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jtf1=new JTextField(10);
		//jtf1.setFont(Tools.f1);
		jl12=new JLabel("添加照片:");
		//jl12.setFont(Tools.f1);
		jtf2=new JTextField(10);
		//jtf2.setFont(Tools.f1);
		jtf2.setEditable(false);
		jp3.add(jtf1);
		jp3.add(jl12);
		jp3.add(jtf2);
		jp2.add(jp3);
		
		jp4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jrb1=new JRadioButton("男");
		jrb1.setSelected(true);
		jrb2=new JRadioButton("女");
		bg1=new ButtonGroup();
		bg1.add(jrb1);
		bg1.add(jrb2);
		jp4.add(jrb1);
		jp4.add(jrb2);
		jp2.add(jp4);
		
		jp5=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jl13=new JLabel("年");
		jl14=new JLabel("月");
		jl15=new JLabel("日");
		jcb1=new JComboBox();
		for(int i=1950;i<=2018;i++)
		{
			jcb1.addItem(i);
		}
		jcb2=new JComboBox();
		for(int i=1;i<=12;i++)
		{
			jcb2.addItem(i);
		}
		jcb3=new JComboBox();
		for(int i=1;i<=31;i++)
		{
			jcb3.addItem(i);
		}
		jp5.add(jcb1);
		jp5.add(jl13);
		jp5.add(jcb2);
		jp5.add(jl14);
		jp5.add(jcb3);
		jp5.add(jl15);
		jp2.add(jp5);
		
		jtf3=new JTextField(20);
		jp6=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp6.add(jtf3);
		jp2.add(jp6);
		
		jp7=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jcb4=new JComboBox();
		jcb4.addItem("大专以下");
		jcb4.addItem("大专");
		jcb4.addItem("本科");
		jcb4.addItem("硕士");
		jcb4.addItem("博士");
		jp7.add(jcb4);
		jp2.add(jp7);
		
		jp8=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jrb3=new JRadioButton("未婚");
		jrb3.setSelected(true);
		jrb4=new JRadioButton("已婚");
		bg2=new ButtonGroup();
		bg2.add(jrb3);
		bg2.add(jrb4);
		jp8.add(jrb3);
		jp8.add(jrb4);
		jp2.add(jp8);
		
		jtf4=new JTextField(100);
		jp2.add(jtf4);
		
		jp9=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jtf5=new JTextField(11);
		jl16=new JLabel("  手机：");
		jtf6=new JTextField(15);
		jp9.add(jtf5);
		jp9.add(jl16);
		jp9.add(jtf6);
		jp2.add(jp9);
		
		jp10=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jtf7=new JTextField(25);
		jp10.add(jtf7);
		jp2.add(jp10);
		
		jp11=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jcb5=new JComboBox();
		jcb5.addItem("经理");
		jcb5.addItem("厨师");
		jcb5.addItem("收银");
		jcb5.addItem("领班");
		jcb5.addItem("老板");
		jp11.add(jcb5);
		jp2.add(jp11);
		
		jtf8=new JTextField(100);
		jsp=new JScrollPane(jtf8);
		jp2.add(jsp);
		
		jp12=new JPanel(new GridLayout(1,2));
		jp13=new JPanel();
		jp14=new JPanel();
		jb1=new JButton("添加");
		jb1.addActionListener(this);
		jb2=new JButton("退出");
		jb2.addActionListener(this);
		jp13.add(jb1);
		jp14.add(jb2);
		jp12.add(jp13);
		jp12.add(jp14);
			
		
		
	
		
		
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp12, BorderLayout.SOUTH);
		this.setSize(500, 600);		
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-250, Toolkit.getDefaultToolkit().getScreenSize().height/2-300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1) {
			String s1=jtf0.getText().toString().trim();
			String s2=jtf1.getText().toString().trim();
			String s3=jtf2.getText().trim();
			String s4="";
			if(jrb1.isSelected())
			{
				s4=jrb1.getText().trim();
			}else if(jrb2.isSelected())
			{
				s4=jrb2.getText().trim();
			}
			String s5=jtf4.getText().trim();
			//String s6=jcb1.getSelectedItem().toString().trim()+"-"+jcb2.getSelectedItem().toString().trim()+
					//"-"+jcb3.getSelectedItem().toString().trim();
			String s6="";
			String s7=jtf3.getText().trim();
			String s8=jcb4.getSelectedItem().toString().trim();
			String s9=jcb5.getSelectedItem().toString().trim();
			String s10="";
			if(jrb3.isSelected())
			{
				s10=jrb3.getText().toString().trim();
			}else if(jrb4.isSelected())
			{
				s10=jrb4.getText().toString().trim();
			}
			String s11=jtf5.getText().trim();
			String s12=jtf6.getText().trim();
			String s13=jtf7.getText().toString().trim();
			//String s14=Calendar.getInstance().getTime().toString();
			String s14="";
			String s15="经理";
			
			String d1=jcb1.getSelectedItem().toString().trim()+"-"+jcb2.getSelectedItem().toString().trim()+
					"-"+jcb3.getSelectedItem().toString().trim();
			//String d2=Calendar.getInstance().getTime().getYear()+"-"+Calendar.getInstance().getTime().getMonth()+"-"+Calendar.getInstance().getTime().getDay();
			java.util.Date date1=null;
			try {
				date1=sdf.parse(d1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.util.Date date2=Calendar.getInstance().getTime();
			String paras[]= {s1,s2,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15};
			hmm=new HRManagerModel();
			if(hmm.addemp(paras,date1,date2))
			{
				JOptionPane.showMessageDialog(this, "添加成功");
			}else {
				JOptionPane.showConfirmDialog(this, "添加失败");
			}
			this.dispose();
		}else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
	}
	

	
}
