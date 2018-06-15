package com.mhl.view;
import javax.swing.*;

import com.mhl.tools.Tools;
import com.mhl.model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Calendar;
import java.text.*;
public class UpdateDialog extends JDialog implements ActionListener{
	
	JLabel jl0,jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16;
	JTextField jtf0,jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
	JRadioButton jrb1,jrb2,jrb3,jrb4;
	JComboBox jcb1,jcb2,jcb3,jcb4,jcb5;
	JPanel jp0,jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp10,jp11,jp12,jp13,jp14;
	ButtonGroup bg1,bg2;
	JScrollPane jsp;
	JButton jb1,jb2;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	HRManagerModel temp;
	String updid;
	
	public UpdateDialog(Frame arg0, String arg1, boolean arg2,HRManagerModel hmm,int Rownum) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
		
		
		jp1=new JPanel(new GridLayout(12,1));
		jl0=new JLabel("     Ա���ţ�");
		jl1=new JLabel("     ������");
		jl2=new JLabel("     �Ա�");
		jl3=new JLabel("     �������ڣ�");
		jl4=new JLabel("     ���֤�ţ�");
		jl5=new JLabel("     ѧ����");
		jl6=new JLabel("     ���");
		jl7=new JLabel("     סַ��");
		jl8=new JLabel("     ��ϵ�绰��");
		jl9=new JLabel("     ���䣺");
		jl10=new JLabel("     ְλ��");
		jl11=new JLabel("     ��ע��");
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
		jl12=new JLabel("�����Ƭ:");
		//jl12.setFont(Tools.f1);
		jtf2=new JTextField(10);
		//jtf2.setFont(Tools.f1);
		jtf2.setEditable(false);
		jp3.add(jtf1);
		jp3.add(jl12);
		jp3.add(jtf2);
		jp2.add(jp3);
		
		jp4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jrb1=new JRadioButton("��");
		jrb1.setSelected(true);
		jrb2=new JRadioButton("Ů");
		bg1=new ButtonGroup();
		bg1.add(jrb1);
		bg1.add(jrb2);
		jp4.add(jrb1);
		jp4.add(jrb2);
		jp2.add(jp4);
		
		jp5=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField jtftemp=new JTextField(20);
		/*jl13=new JLabel("��");
		jl14=new JLabel("��");
		jl15=new JLabel("��");
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
		jp5.add(jl15);*/
		jp2.add(jp5);
		
		jtf3=new JTextField(20);
		jp6=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp6.add(jtf3);
		jp2.add(jp6);
		
		jp7=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jcb4=new JComboBox();
		jcb4.addItem("��ר����");
		jcb4.addItem("��ר");
		jcb4.addItem("����");
		jcb4.addItem("˶ʿ");
		jcb4.addItem("��ʿ");
		jp7.add(jcb4);
		jp2.add(jp7);
		
		jp8=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jrb3=new JRadioButton("δ��");
		jrb3.setSelected(true);
		jrb4=new JRadioButton("�ѻ�");
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
		jl16=new JLabel("  �ֻ���");
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
		jcb5.addItem("����");
		jcb5.addItem("��ʦ");
		jcb5.addItem("����");
		jcb5.addItem("���");
		jcb5.addItem("�ϰ�");
		jp11.add(jcb5);
		jp2.add(jp11);
		
		jtf8=new JTextField(100);
		jsp=new JScrollPane(jtf8);
		jp2.add(jsp);
		
		jp12=new JPanel(new GridLayout(1,2));
		jp13=new JPanel();
		jp14=new JPanel();
		jb1=new JButton("�޸�");
		jb1.addActionListener(this);
		jb2=new JButton("�˳�");
		jb2.addActionListener(this);
		jp13.add(jb1);
		jp14.add(jb2);
		jp12.add(jp13);
		jp12.add(jp14);
		
		String empid=hmm.getValueAt(Rownum, 0).toString();
		this.updid=empid;
		temp=new HRManagerModel();
		String paras[]= {empid};
		temp.queryHRManger("select * from rszl where empid=?", paras);
		jtf0.setText(empid);
		jtf0.setEditable(false);
		jtf1.setText(temp.getValueAt(0, 1).toString());
		if(temp.getValueAt(0, 3)!=null)
		{
			if(jrb1.getText().equals(temp.getValueAt(0, 3).toString()))
			{
				jrb1.setSelected(true);
			}else if(jrb2.getText().equals(temp.getValueAt(0, 3).toString()))
			{
				jrb2.setSelected(true);
			}
		}
		if(temp.getValueAt(0, 5)!=null)
		{
			jtftemp.setText(temp.getValueAt(0, 5).toString());
		}
		jtftemp.setEditable(false);
		jp5.add(jtftemp);
		/*jcb1.setEditable(false);
		jcb2.setEditable(false);
		jcb3.setEditable(false);*/
		if(temp.getValueAt(0, 6)!=null)
		{
			jtf3.setText(temp.getValueAt(0, 6).toString().trim());
		}
		if(temp.getValueAt(0, 7)!=null)
		{
			for(int i=0;i<jcb4.getItemCount();i++)
			{
				if((jcb4.getItemAt(i).toString()).equals(temp.getValueAt(0, 7).toString().trim()))
				{
					jcb4.setSelectedIndex(i);
					break;
				}
			}
		}
		if(temp.getValueAt(0, 9)!=null)
		{
			if(jrb3.getText().equals(temp.getValueAt(0, 9).toString().trim()))
			{
				jrb3.setSelected(true);
			}else if(jrb4.getText().equals(temp.getValueAt(0, 9).toString().trim()))
			{
				jrb4.setSelected(true);
			}
		}
		if(temp.getValueAt(0, 4)!=null)
		{
			jtf4.setText(temp.getValueAt(0, 4).toString());
		}
		if(temp.getValueAt(0, 10)!=null)
		{
			jtf5.setText(temp.getValueAt(0, 10).toString());
		}
		if(temp.getValueAt(0, 11)!=null)
		{
			jtf6.setText(temp.getValueAt(0, 11).toString());
		}
		if(temp.getValueAt(0, 12)!=null)
		{
			jtf7.setText(temp.getValueAt(0, 12).toString());
		}
		if(temp.getValueAt(0, 8)!=null)
		{
			for(int i=0;i<jcb5.getItemCount();i++)
			{
				if((jcb5.getItemAt(i).toString()).equals(temp.getValueAt(0, 8).toString().trim()))
				{
					jcb5.setSelectedIndex(i);
					break;
				}
			}
		}
		
		if(temp.getValueAt(0, 14)!=null)
		{
			jtf8.setText(temp.getValueAt(0,14).toString());
		}
		
		
		
		
		
		
	
		
		
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp12, BorderLayout.SOUTH);
		this.setSize(500, 600);		
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-250, Toolkit.getDefaultToolkit().getScreenSize().height/2-300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateDialog upd=new UpdateDialog(null,"�����޸�",true,new HRManagerModel(),1);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1)
		{
			String s1=jtf1.getText();
			String s2="";
			if(jrb1.isSelected())
			{
				s2=jrb1.getText();
			}else if(jrb2.isSelected())
			{
				s2=jrb2.getText();
			}
			String s3=jtf4.getText();
			String s4=jtf3.getText();
			String s5=jcb4.getSelectedItem().toString();
			String s6=jcb5.getSelectedItem().toString();
			String s7="";
			if(jrb3.isSelected())
			{
				s7=jrb3.getText();
			}else if(jrb4.isSelected())
			{
				s7=jrb4.getText();
			}
			String s8=jtf5.getText();
			String s9=jtf6.getText();
			String s10=jtf7.getText();
			String s11=jtf8.getText();
			String s12=this.updid;
			String paras[]= {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12};
			if(temp.updateemp(paras))
			{
				JOptionPane.showMessageDialog(this, "�޸ĳɹ�");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "�޸�ʧ��");
			}

		}else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
	}
	
}
