package com.mhl.view;
import com.mhl.tools.*;
import com.mhl.model.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class UserLogin extends JDialog implements ActionListener{
	JLabel jl1,jl2,jl3;
	JTextField juser;
	JPasswordField jpasswd;
	JButton jb1,jb2;
	Login_Model lm;
	
	public static void main(String[] arg) {
		UserLogin temp=new UserLogin();
	}
	
	public UserLogin()
	{
		this.setLayout(null);
		BackImage bi=new BackImage();
		bi.setBounds(0, 0, 360, 360);

		
		
		jl1=new JLabel("请输入用户名:");
		jl1.setFont(Tools.f1);	
		jl1.setBounds(60,190, 150, 30);
		this.add(jl1);
		
		
		jl2=new JLabel("请输入密码:");
		jl2.setFont(Tools.f1);
		jl2.setBounds(76, 240, 150, 30);
		this.add(jl2);
		
		jl3=new JLabel("（员工号）");
		jl3.setFont(Tools.f2);
		jl3.setForeground(Color.RED);
		jl3.setBounds(100, 210, 100, 30);
		this.add(jl3);
		
		
		juser=new JTextField(20);
		juser.setBounds(180, 190, 120, 30);
		juser.setBorder(BorderFactory.createLoweredBevelBorder());//设置下凹
		juser.setFocusable(true);
		this.add(juser);
		
		jpasswd=new JPasswordField(20);
		jpasswd.setBounds(180, 240, 120, 30);
		jpasswd.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(jpasswd);
		
		jb1=new JButton("确定");
		jb1.addActionListener(this);
		jb1.setBounds(110, 300, 70, 30);
		jb1.setFont(Tools.f1);
		jb1.setForeground(new Color(0,0,255));
		this.add(jb1);
		
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jb2.setBounds(200, 300, 70, 30);
		jb2.setFont(Tools.f1);
		jb2.setForeground(new Color(0,0,255));
		this.add(jb2);
		

		this.add(bi);
		this.setUndecorated(true);
		this.setSize(360, 360);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-180, height/2-180);
		this.setVisible(true);
	}
	
	class BackImage extends JPanel
	{
		Image im;
		public BackImage()
		{
			try {
				im=ImageIO.read(new File("image/view/UserLogin.JPG"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g)
		{
			g.drawImage(im,0,0,360,360,this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==this.jb1)
		{
			String user=this.juser.getText().trim();
			String password=new String(this.jpasswd.getPassword());
			String sql="select r.zhiwei from login l,rszl r where l.empid=? and l.passwd=? and r.empid=l.empid";
			String paras[]= {user,password};
			lm=new Login_Model();
			String job=lm.checklogin(sql, paras).trim();
			if(job.equals("经理")||job.equals("领班")||job.equals("管理员"))
			{
				this.dispose();
				Windows1 w1=new Windows1(job);
			}else {
				JOptionPane.showMessageDialog(this, "您无权限登录或用户名密码错误", "登录提示", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}else if(arg0.getSource()==this.jb2)
		{
			this.dispose();
		}
	}
}
