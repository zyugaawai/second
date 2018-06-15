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
		jl1=new JLabel("������Ա����(����  ��  ְλ):    ");
		jtf=new JTextField(20);
		jb1=new JButton("���Ҵ�Ա��");
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
		jb2=new JButton("ˢ�¼�¼");
		jb3=new JButton("�������");
		jb4=new JButton("�޸�����");
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
		String sql="select r.empid Ա����,r.empname ����,r.zhiwei ְλ,l.passwd ���� from rszl r,login l where r.empid=l.empid and 1=?";
		String paras[]= {"1"};
		lmm=new LoginMaModel();
		lmm.queryLogin(sql,paras);
		jt.setModel(lmm);
		jsp=new JScrollPane(jt);
		this.add(jsp, BorderLayout.CENTER);
		
		row=jt.getRowCount();
		jl2.setText("��ǰ���ݿ�����  "+row +"  ����¼");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1)
		{
			String s=jtf.getText().trim();
			String sql="select r.empid Ա����,r.empname ����,r.zhiwei ְλ,l.passwd ���� from rszl r,login l where r.empid=l.empid and"
					+ "(r.empid=? or r.empname=? or r.zhiwei=?)";
			String paras[]= {s,s,s};
			lmm=new LoginMaModel();
			lmm.queryLogin(sql, paras);
			jt.setModel(lmm);
			row=jt.getRowCount();
			jl2.setText("��ǰ���ݿ�����  "+row +"  ����¼");
		}else if(arg0.getSource()==jb2)
		{
			String sql="select r.empid Ա����,r.empname ����,r.zhiwei ְλ,l.passwd ���� from rszl r,login l where r.empid=l.empid and 1=?";
			String paras[]= {"1"};
			lmm=new LoginMaModel();
			lmm.queryLogin(sql,paras);
			jt.setModel(lmm);
			row=jt.getRowCount();
			jl2.setText("��ǰ���ݿ�����  "+row +"  ����¼");
		}
	}
}
