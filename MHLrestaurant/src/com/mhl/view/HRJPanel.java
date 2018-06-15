package com.mhl.view;
import javax.swing.*;


import com.mhl.tools.Tools;

import java.awt.*;
import java.awt.event.*;
import com.mhl.model.*;
public class HRJPanel extends JPanel implements ActionListener,MouseListener{
	JLabel jl1,jl2;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTable jt;
	JTextField jtf;
	JPanel jp1,jp2,jp3,jp4,jp5;
	JScrollPane jsp;
	HRManagerModel hmm=null;
	int Row;
	public static void main(String[] arg0)
	{
		HRJPanel hr=new HRJPanel();
	}
	
	
	public HRJPanel()
	{
		this.setLayout(new BorderLayout());
		
		
		jl1=new JLabel("请输入姓名（员工号或职位）: ");
		jl1.setFont(Tools.f1);
		jtf=new JTextField(20);
		jtf.setFont(Tools.f1);
		jb1=new JButton("刷新");
		jb1.addActionListener(this);
		jb1.setFont(Tools.f1);
		jp1=new JPanel();
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		this.add(jp1,BorderLayout.NORTH);
		
		jb2=new JButton("详细信息");
		jb2.addActionListener(this);
		jb2.setEnabled(false);
		jb3=new JButton("添加");
		jb3.addActionListener(this);
		jb4=new JButton("修改");
		jb4.addActionListener(this);
		jb4.setEnabled(false);
		jb5=new JButton("删除");
		jb5.addActionListener(this);
		jb5.setEnabled(false);
		jb2.setFont(Tools.f1);
		jb3.setFont(Tools.f1);
		jb4.setFont(Tools.f1);
		jb5.setFont(Tools.f1);
		jp2=new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		
		jp3=new JPanel();
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		jl2=new JLabel();
		jl2.setFont(Tools.f1);
		jp3.add(jl2);
		
		jp4=new JPanel();
		jp4.setLayout(new BorderLayout());
		jp4.add(jp2,BorderLayout.EAST);
		jp4.add(jp3,BorderLayout.WEST);
		this.add(jp4, BorderLayout.SOUTH);
		
		jp5=new JPanel();
		jp5.setLayout(new BorderLayout());
		hmm=new HRManagerModel();
		String sql="select empid,empname,sex,zhiwei from rszl where 1=?";
		String paras[]= {"1"};
		hmm.queryHRManger(sql, paras);
		Row=hmm.getRowCount();
		jl2.setText("共有 "+Row+" 条记录");
		jt=new JTable(hmm);
		jt.setFont(Tools.f1);
		jt.addMouseListener(this);
		jsp=new JScrollPane(jt);
		jsp.setBorder(BorderFactory.createLoweredBevelBorder());
		jp5.add(jsp,BorderLayout.CENTER);
		this.add(jp5, BorderLayout.CENTER);
		//jt.setModel(arg0);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==this.jb1)
		{
			this.setenabled();
			String s=jtf.getText().trim();
			hmm=new HRManagerModel();			
			if(s.length()==0)
			{
				String paras[]= {"1"};
				hmm.queryHRManger("select empid,empname,sex,zhiwei from rszl where 1=?", paras);
			}else {
				String sql="select empid,empname,sex,zhiwei from rszl where empid=? or empname=? or zhiwei=?";
				String paras[]= {s,s,s};
				hmm.queryHRManger(sql, paras);
			}
			Row=hmm.getRowCount();
			jl2.setText("共有 "+Row+" 条记录");
			jt.setModel(hmm);
		}else if(arg0.getSource()==this.jb2)
		{
			int Rownum=jt.getSelectedRow();
			if(Rownum==-1)
			{
				JOptionPane.showMessageDialog(this, "请选择一行");
				return ;
			}
			String paras[]= {"1"};
			hmm=new HRManagerModel();
			hmm.queryHRManger("select * from rszl where 1=?", paras);
			DetailsDia dtd=new DetailsDia(JOptionPane.getFrameForComponent(this),"详细信息",true,hmm,Rownum);
			this.setenabled();
			this.Updatejt();
		}else if(arg0.getSource()==this.jb3)
		{
			AddEmpDialog aed=new AddEmpDialog(JOptionPane.getFrameForComponent(this),"新员工登记",true);
			hmm=new HRManagerModel();
			this.Updatejt();
		}else if(arg0.getSource()==this.jb4)
		{
			int Rownum=jt.getSelectedRow();
			UpdateDialog upd=new UpdateDialog(JOptionPane.getFrameForComponent(this),"修改信息",true,hmm,Rownum);
			this.Updatejt();
		}else if(arg0.getSource()==this.jb5)
		{
			int Rownum=jt.getSelectedRow();
			String empid=hmm.getValueAt(Rownum, 0).toString();
			hmm=new HRManagerModel();
			if(hmm.deleteemp(empid))
			{
				JOptionPane.showMessageDialog(this, "删除成功");
			}else {
				JOptionPane.showMessageDialog(this, "删除失败");
			}
			this.Updatejt();
			this.setenabled();
		}
	}
	
	public void Updatejt()
	{
		String paras[]= {"1"};
		hmm.queryHRManger("select empid,empname,sex,zhiwei from rszl where 1=?", paras);
		jt.setModel(hmm);
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		jb2.setEnabled(true);
		jb4.setEnabled(true);
		jb5.setEnabled(true);
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setenabled()
	{
		jb2.setEnabled(false);
		jb4.setEnabled(false);
		jb5.setEnabled(false);
	}
}
