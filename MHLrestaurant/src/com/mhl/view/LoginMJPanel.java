package com.mhl.view;
import javax.swing.*;

import com.mhl.tools.Tools;
import com.mhl.model.*;
import java.awt.*;
import java.awt.event.*;

public class LoginMJPanel extends JPanel implements ActionListener{
	JLabel jl1,jl2;
	JButton jb1,jb2,jb3,jb4;
	JTable jt;
	JTextField jtf;
	JPanel jp1,jp2,jp3,jp4,jp5;
	JScrollPane jsp;
	LoginMaModel lmm;
	int row;
	
	public LoginMJPanel()
	{
		this.setLayout(new BorderLayout());
		
		
		jp1=new JPanel();
		jl1=new JLabel("请输入员工号(姓名  或  职位):    ");
		jtf=new JTextField(20);
		jb1=new JButton("查找此员工");
		jb1.addActionListener(this);
		jl1.setFont(Tools.f1);
		jtf.setFont(Tools.f1);
		jb1.setFont(Tools.f1);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		this.add(jp1,BorderLayout.NORTH);
		
		jp2=new JPanel(new BorderLayout());
		jp3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jl2=new JLabel();
		jb2=new JButton("刷新记录");
		jb3=new JButton("添加密码");
		jb4=new JButton("修改密码");
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jl2.setFont(Tools.f1);
		jb2.setFont(Tools.f1);
		jb3.setFont(Tools.f1);
		jb4.setFont(Tools.f1);
		jp3.add(jl2);
		jp4.add(jb2);
		jp4.add(jb3);
		jp4.add(jb4);
		jp2.add(jp3,BorderLayout.WEST);
		jp2.add(jp4,BorderLayout.EAST);
		this.add(jp2, BorderLayout.SOUTH);
		
		jt=new JTable();
		String sql="select r.empid 员工号,r.empname 姓名,r.zhiwei 职位,l.passwd 密码 from rszl r,login l where r.empid=l.empid and 1=?";
		String paras[]= {"1"};
		lmm=new LoginMaModel();
		lmm.queryLogin(sql,paras);
		jt.setModel(lmm);
		jsp=new JScrollPane(jt);
		this.add(jsp, BorderLayout.CENTER);
		
		row=jt.getRowCount();
		jl2.setText("当前数据库中有  "+row +"  条记录");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1)
		{
			String s=jtf.getText().trim();
			String sql="select r.empid 员工号,r.empname 姓名,r.zhiwei 职位,l.passwd 密码 from rszl r,login l where r.empid=l.empid and"
					+ "(r.empid=? or r.empname=? or r.zhiwei=?)";
			String paras[]= {s,s,s};
			lmm=new LoginMaModel();
			lmm.queryLogin(sql, paras);
			jt.setModel(lmm);
			row=jt.getRowCount();
			jl2.setText("当前数据库中有  "+row +"  条记录");
		}else if(arg0.getSource()==jb2)
		{
			String sql="select r.empid 员工号,r.empname 姓名,r.zhiwei 职位,l.passwd 密码 from rszl r,login l where r.empid=l.empid and 1=?";
			String paras[]= {"1"};
			lmm=new LoginMaModel();
			lmm.queryLogin(sql,paras);
			jt.setModel(lmm);
			row=jt.getRowCount();
			jl2.setText("当前数据库中有  "+row +"  条记录");
		}
	}
}
