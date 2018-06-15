package com.mhl.view;
import javax.swing.*;

import com.mhl.model.*;
import com.mhl.tools.Tools;

import java.awt.*;
import java.awt.event.*;

public class MenuJPanel extends JPanel implements ActionListener{
	JLabel jl1,jl2;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTable jt;
	JTextField jtf;
	JPanel jp1,jp2,jp3,jp4,jp5;
	JScrollPane jsp;
	JComboBox jcb;
	MenuModel mmd;
	int Row;
	
	
	public MenuJPanel()
	{
		jp1=new JPanel();
		jl1=new JLabel("请输入查询条件：");
		jl1.setFont(Tools.f1);
		jtf=new JTextField(20);
		jtf.setFont(Tools.f1);
		jcb=new JComboBox();
		jcb.addItem("foodid");
		jcb.addItem("foodname");
		jcb.addItem("chief");
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jcb.setFont(Tools.f1);
		jb1.setFont(Tools.f1);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jcb);
		jp1.add(jb1);
		
		jp2=new JPanel(new BorderLayout());
		jp3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jl2=new JLabel();
		jp3.add(jl2);
		jb2=new JButton("刷新");
		jb2.addActionListener(this);
		jb3=new JButton("添加");
		jb4=new JButton("修改");
		jb5=new JButton("删除");
		jp4.add(jb2);
		jp4.add(jb3);
		jp4.add(jb4);
		jp4.add(jb5);
		jp2.add(jp3,BorderLayout.WEST);
		jp2.add(jp4, BorderLayout.EAST);
		
		jp5=new JPanel(new BorderLayout());
		jt=new JTable();
		String sql="select foodid,foodname,chief from menu where 1=?";
		String paras[]= {"1"};
		mmd=new MenuModel();
		mmd.queryMenu(sql, paras);
		jt.setModel(mmd);
		jsp=new JScrollPane(jt);
		jp5.add(jsp,BorderLayout.CENTER);
		
		Row=jt.getRowCount();
		jl2.setText("共有  "+Row+"  条记录");
		
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2, BorderLayout.SOUTH);
		this.add(jp5, BorderLayout.CENTER);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1)
		{
			String s1=jtf.getText().trim();
			String sql="select foodid,foodname,chief from menu where foodid=? or foodname=? or chief=?";
			String paras[]= {"*","*","*"};
			for(int i=0;i<3;i++)
			{
				if(i==jcb.getSelectedIndex())
				{
					paras[i]=s1;
				}
			}
			mmd=new MenuModel();
			mmd.queryMenu(sql, paras);
			jt.setModel(mmd);
			Row=jt.getRowCount();
			jl2.setText("共有  "+Row+"  条记录");
		}else if(arg0.getSource()==jb2)
		{
			this.updatejt();;
		}
	}
	
	public void updatejt()
	{
		String sql="select foodid,foodname,chief from menu where 1=?";
		String paras[]= {"1"};
		mmd=new MenuModel();
		mmd.queryMenu(sql, paras);
		jt.setModel(mmd);
		Row=jt.getRowCount();
		jl2.setText("共有  "+Row+"  条记录");
	}
}
