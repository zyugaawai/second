package com.mhl.view;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.util.Calendar;

import com.mhl.tools.*;
public class Windows1 extends JFrame implements ActionListener,MouseListener{
	Image image1,Timebg;
	JMenuBar jmb;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	JMenuItem jmt1,jmt2,jmt3,jmt4,jmt5,jmt6,jmt7,jmt8,jmt9,jmt10,jmt11,jmt12;
	ImageIcon jmt1_icon,jmt2_icon,jmt3_icon,jmt4_icon,jmt5_icon,jmt6_icon,jmt7_icon,jmt8_icon,jmt9_icon,jmt10_icon,jmt11_icon,jmt12_icon;
	//工具栏组件
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	//最下方状态栏组件
	JPanel jp1,jp2,jp3,jp4,jp5,jpcenter;
	JLabel TimeNow;
	javax.swing.Timer t;
	//jp1面板
	ImagePanel p1_bgjp;
	Image p1_bgim;
	JLabel p1_jl1,p1_jl2,p1_jl3,p1_jl4,p1_jl5,p1_jl6,p1_jl7,p1_jl8;
	//jp4面板（jp2+jp3）
	ImagePanel p3_zhup;
	Image p3_zhubg;

	JSplitPane jsp1;
	//卡片布局
	CardLayout jp3card,jp2card,centercard;
	//jp2两个卡片组件
	JLabel jp2_1,jp2_2;
	//jp3卡片组件
	HRJPanel hr;
	LoginMJPanel lgm;
	MenuJPanel mjp;
	public static void main(String[] args) {
		// TODO Auto- generated method stub
		Windows1 w1=new Windows1("经理");
	}
	
	//初始化菜单
	public void initMenu()
	{
		
		jmt1_icon=new ImageIcon("image/view/qhyh.jpg");
		jmt2_icon=new ImageIcon("image/view/qhsy.jpg");
		jmt3_icon=new ImageIcon("image/view/login.jpg");
		jmt4_icon=new ImageIcon("image/view/wnl.jpg");
		jmt5_icon=new ImageIcon("image/view/exit.jpg");
		jmt6_icon=new ImageIcon("image/view/p1_rsgl.jpg");
		jmt7_icon=new ImageIcon("image/view/p1_cpjg.jpg");
		jmt8_icon=new ImageIcon("image/view/p1_bbtj.jpg");
		jmt9_icon=new ImageIcon("image/view/p1_cb.jpg");
		jmt10_icon=new ImageIcon("image/view/p1_dhbz.jpg");
		jmt11_icon=new ImageIcon("image/view/exit.jpg");
		jmt12_icon=new ImageIcon("image/view/p1_dlgl.jpg");


		jmb=new JMenuBar();
		
		jm1=new JMenu("系统管理");
		jm1.setFont(Tools.f1);
		
		jmt1=new JMenuItem("切换用户",jmt1_icon);
		jmt1.setFont(Tools.f2);
		jm1.add(jmt1);
		
		jmt2=new JMenuItem("切换到收款界面",jmt2_icon);
		jmt2.addActionListener(this);
		jmt2.setFont(Tools.f2);
		jm1.add(jmt2);
		
		jmt3=new JMenuItem("登录管理",jmt3_icon);
		jmt3.setFont(Tools.f2);
		jm1.add(jmt3);
		
		jmt4=new JMenuItem("万年历",jmt4_icon);
		jmt4.setFont(Tools.f2);
		jm1.add(jmt4);
		
		jmt5=new JMenuItem("退出",jmt5_icon);
		jmt5.setFont(Tools.f2);
		jm1.add(jmt5);
		
		
		jm2=new JMenu("人事管理");
		jm2.setFont(Tools.f1);
		
		jmt6=new JMenuItem("人事管理",jmt6_icon);
		jmt6.addActionListener(this);
		jmt6.setFont(Tools.f2);
		jm2.add(jmt6);
		
		
		jm3=new JMenu("菜单服务");
		jm3.setFont(Tools.f1);
		jmt7=new JMenuItem("菜谱及价格录入",jmt7_icon);
		jmt7.setFont(Tools.f2);
		jm3.add(jmt7);
		
		
		jm4=new JMenu("报表统计");
		jm4.setFont(Tools.f1);
		jmt8=new JMenuItem("报表统计",jmt8_icon);
		jmt8.setFont(Tools.f2);
		jm4.add(jmt8);
		
		
		jm5=new JMenu("成本及库房");
		jm5.setFont(Tools.f1);
		jmt9=new JMenuItem("成本控制",jmt9_icon);
		jmt9.setFont(Tools.f2);;
		jm5.add(jmt9);
		
		
		jm6=new JMenu("帮助");
		jm6.setFont(Tools.f1);
		jmt10=new JMenuItem("动画帮助",jmt10_icon);
		jmt10.setFont(Tools.f2);
		jm6.add(jmt10);
		
		jmt11=new JMenuItem("文本帮助",jmt11_icon);
		jmt11.setFont(Tools.f2);
		jm6.add(jmt11);
		
		jmt12=new JMenuItem("关于",jmt12_icon);
		jmt12.setFont(Tools.f2);
		jm6.add(jmt12);
		
		
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		this.setJMenuBar(jmb);
	}
	
	//初始化工具栏
	public void initToolBar()
	{
		//创建工具栏组件
				jtb=new JToolBar();
				jtb.setFloatable(false);
				jb1=new JButton(new ImageIcon("image/view/jt1.jpg"));
				jb1.setToolTipText("切换用户");
				jb2=new JButton(new ImageIcon("image/view/jt2.jpg"));
				jb2.setToolTipText("切换界面");
				jb3=new JButton(new ImageIcon("image/view/jt3.jpg"));
				jb3.setToolTipText("登录管理");
				jb4=new JButton(new ImageIcon("image/view/jt4.jpg"));
				jb4.setToolTipText("万年历");
				jb5=new JButton(new ImageIcon("image/view/jt5.jpg"));
				jb5.setToolTipText("人事管理");
				jb6=new JButton(new ImageIcon("image/view/jt6.jpg"));
				jb6.setToolTipText("菜谱及价格录入");
				jb7=new JButton(new ImageIcon("image/view/jt7.jpg"));
				jb7.setToolTipText("报表统计");
				jb8=new JButton(new ImageIcon("image/view/jt8.jpg"));
				jb8.setToolTipText("成本控制");
				jb9=new JButton(new ImageIcon("image/view/jt9.jpg"));
				jb9.setToolTipText("帮助");
				jb10=new JButton(new ImageIcon("image/view/jt10.jpg"));
				jb10.setToolTipText("退出系统");
				jtb.add(jb1);
				jtb.add(jb2);
				jtb.add(jb3);
				jtb.add(jb4);
				jtb.add(jb5);
				jtb.add(jb6);
				jtb.add(jb7);
				jtb.add(jb8);
				jtb.add(jb9);
				jtb.add(jb10);
	}
	
	//初始化状态栏
	public void initStatusBar()
	{
		//状态栏p5
		jp5=new JPanel(new BorderLayout());
		t=new Timer(1000,this);//每隔一秒触发ActionEvent
		//启动计时器
		t.start();
		try {
			Timebg=ImageIO.read(new File("image/view/bj.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImagePanel ip=new ImagePanel(Timebg);
		ip.setLayout(new BorderLayout());
		TimeNow=new JLabel("当前时间："+Calendar.getInstance().getTime().toString()+"     ");
		TimeNow.setFont(Tools.f1);
		ip.add(TimeNow,BorderLayout.EAST);
		jp5.add(ip);
		
	}
	
	
	public Windows1(String job)
	{
		
		//创建菜单
		this.initMenu();
		//创建工具栏
		this.initToolBar();
		//创建状态栏
		this.initStatusBar();
		
		
		//p1面板
		try {
			p1_bgim=ImageIO.read(new File("image/view/p1.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Cursor Mycursor=new Cursor(Cursor.HAND_CURSOR);
		p1_bgjp=new ImagePanel(p1_bgim);
		p1_bgjp.setLayout(new GridLayout(8,1));
		jp1=new JPanel(new BorderLayout());
		p1_jl1=new JLabel(new ImageIcon("image/view/p1_mhl.jpg"));
		p1_jl1.addMouseListener(this);
		p1_jl1.setCursor(Mycursor);
		p1_jl2=new JLabel("人 事 登 记",new ImageIcon("image/view/p1_rsgl.jpg"),0);
		p1_jl2.setFont(Tools.f3);
		p1_jl2.setCursor(Mycursor);
		p1_jl2.setEnabled(false);
		p1_jl2.addMouseListener(this);
		p1_jl3=new JLabel("登 录 管 理",new ImageIcon("image/view/p1_dlgl.jpg"),0);
		p1_jl3.setFont(Tools.f3);
		p1_jl3.setCursor(Mycursor);
		p1_jl3.setEnabled(false);
		p1_jl3.addMouseListener(this);
		p1_jl4=new JLabel("菜 谱 价 格",new ImageIcon("image/view/p1_cpjg.jpg"),0);
		p1_jl4.setFont(Tools.f3);
		p1_jl4.setCursor(Mycursor);
		p1_jl4.setEnabled(false);
		p1_jl4.addMouseListener(this);
		p1_jl5=new JLabel("报 表 统 计",new ImageIcon("image/view/p1_bbtj.jpg"),0);
		p1_jl5.setFont(Tools.f3);
		p1_jl5.setCursor(Mycursor);
		p1_jl5.setEnabled(false);
		p1_jl5.addMouseListener(this);
		p1_jl6=new JLabel("成本及库房",new ImageIcon("image/view/p1_cb.jpg"),0);
		p1_jl6.setFont(Tools.f3);
		p1_jl6.setCursor(Mycursor);
		p1_jl6.setEnabled(false);
		p1_jl6.addMouseListener(this);
		p1_jl7=new JLabel("系 统 设 置",new ImageIcon("image/view/p1_xtsz.jpg"),0);
		p1_jl7.setFont(Tools.f3);
		p1_jl7.setCursor(Mycursor);
		p1_jl7.setEnabled(false);
		p1_jl7.addMouseListener(this);
		p1_jl8=new JLabel("动 画 帮 助",new ImageIcon("image/view/p1_dhbz.jpg"),0);
		p1_jl8.setFont(Tools.f3);
		p1_jl8.setCursor(Mycursor);
		p1_jl8.setEnabled(false);
		p1_jl8.addMouseListener(this);
		p1_bgjp.add(p1_jl1);
		p1_bgjp.add(p1_jl2);
		p1_bgjp.add(p1_jl3);
		p1_bgjp.add(p1_jl4);
		p1_bgjp.add(p1_jl5);
		p1_bgjp.add(p1_jl6);
		p1_bgjp.add(p1_jl7);
		p1_bgjp.add(p1_jl8);
		jp1.add(p1_bgjp);
		//处理jp2,jp3,jp4
		jp2card=new CardLayout();
		jp2=new JPanel(jp2card);
		jp2_1=new JLabel(new ImageIcon("image/view/p2_zuo.jpg"));
		jp2_1.setCursor(Mycursor);
		jp2_1.addMouseListener(this);
		jp2_2=new JLabel(new ImageIcon("image/view/p2_you.jpg"));
		jp2_2.setCursor(Mycursor);
		jp2_2.addMouseListener(this);
		jp2.add(jp2_1,"0");
		jp2.add(jp2_2,"1");
		
		jp3card=new CardLayout();
		jp3=new JPanel(jp3card);
		try {
			p3_zhubg=ImageIO.read(new File("image/view/p3_bj.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		p3_zhup=new ImagePanel(p3_zhubg);
		Border b1=BorderFactory.createEtchedBorder();
		Border b2=BorderFactory.createTitledBorder(b1, "人事管理");
		jp3.add(p3_zhup,"0");
		hr=new HRJPanel();
		hr.setBorder(b2);
		jp3.add(hr,"1");
		lgm=new LoginMJPanel();
		jp3.add(lgm,"2");
		mjp=new MenuJPanel();
		jp3.add(mjp,"3");
		
		
		
		jp4=new JPanel(new BorderLayout());
		jp4.add(jp2,BorderLayout.WEST);
		jp4.add(jp3,BorderLayout.CENTER);

		
		jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jp1,jp4);
		jsp1.setDividerLocation(Toolkit.getDefaultToolkit().getScreenSize().width);
		jsp1.setDividerSize(0);//取消分界线
		centercard=new CardLayout();
		jpcenter=new JPanel(centercard);
		jpcenter.add(jsp1,"0");
		OrderIndex odi=new OrderIndex();
		jpcenter.add(odi,"1");
		
		
		try {
			image1=ImageIO.read(new File("image/view/jb.jpg"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Container ct=this.getContentPane();
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		ct.add(jtb,BorderLayout.NORTH);
		ct.add(jp5,BorderLayout.SOUTH);
		ct.add(jpcenter,BorderLayout.CENTER);
		this.setIconImage(image1);
		this.setTitle("满汉楼管理系统");
		this.setSize(width,height-60);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//JOptionPane.showMessageDialog(this, "欢迎您，"+job+"!");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.TimeNow.setText("当前时间："+Calendar.getInstance().getTime().toString()+"     ");
		
		if(arg0.getSource()==jmt2)
		{
			this.centercard.show(jpcenter, "1");
		}else if(arg0.getSource()==jmt6)
		{
			this.centercard.show(jpcenter,"0");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jp2_1)
		{
			this.jp2card.show(jp2, "1");
			jsp1.setDividerLocation(0);
		}else if(arg0.getSource()==jp2_2)
		{
			this.jp2card.show(jp2,"0");
			jsp1.setDividerLocation(120);
		}else if(arg0.getSource()==p1_jl1)
		{
			this.jp3card.show(jp3, "0");
			jsp1.setDividerLocation(Toolkit.getDefaultToolkit().getScreenSize().width);
		}else if(arg0.getSource()==p1_jl2)
		{
			this.jp3card.show(jp3, "1");
			jsp1.setDividerLocation(150);
		}else if(arg0.getSource()==p1_jl3)
		{
			this.jp3card.show(jp3, "2");
			jsp1.setDividerLocation(150);
		}else if(arg0.getSource()==p1_jl4)
		{
			this.jp3card.show(jp3, "3");
			jsp1.setDividerLocation(150);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==this.p1_jl2)
		{
			this.p1_jl2.setEnabled(true);
		}else if(arg0.getSource()==this.p1_jl3)
		{
			this.p1_jl3.setEnabled(true);
		}else if(arg0.getSource()==this.p1_jl4)
		{
			this.p1_jl4.setEnabled(true);
		}else if(arg0.getSource()==this.p1_jl5)
		{
			this.p1_jl5.setEnabled(true);
		}else if(arg0.getSource()==this.p1_jl6)
		{
			this.p1_jl6.setEnabled(true);
		}else if(arg0.getSource()==this.p1_jl7)
		{
			this.p1_jl7.setEnabled(true);
		}else if(arg0.getSource()==this.p1_jl8)
		{
			this.p1_jl8.setEnabled(true);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==this.p1_jl2)
		{
			this.p1_jl2.setEnabled(false);
		}else if(arg0.getSource()==this.p1_jl3)
		{
			this.p1_jl3.setEnabled(false);
		}else if(arg0.getSource()==this.p1_jl4)
		{
			this.p1_jl4.setEnabled(false);
		}else if(arg0.getSource()==this.p1_jl5)
		{
			this.p1_jl5.setEnabled(false);
		}else if(arg0.getSource()==this.p1_jl6)
		{
			this.p1_jl6.setEnabled(false);
		}else if(arg0.getSource()==this.p1_jl7)
		{
			this.p1_jl7.setEnabled(false);
		}else if(arg0.getSource()==this.p1_jl8)
		{
			this.p1_jl8.setEnabled(false);
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
