package cn.edu.bit.cs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
//import java.io.IOException;
//import javax.imageio.ImageIO;

public class TankBattle extends JFrame implements ActionListener{

	MyPanel mypanel1 = null;
	MyPanel mypanel2 = null;
	MyPanel2 mypanel21 = null;
	MyPanel2 mypanel22 = null;
	StartPanel startpanel = null;
	//菜单
	JMenuBar jmb = null;
	JMenu jm1 = null;
	JMenuItem jmi1 = null;
	JMenuItem jmi11 = null;
	JMenuItem jmi2 = null;
	JMenu jm2 = null;
	JMenuItem jm2i1 = null;
	JMenuItem jmi111 = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TankBattle tankgame=new TankBattle();
	}
	public TankBattle(){//构造函数
		
		//创建菜单和菜单选项
		Font font = new Font("微软雅黑",Font.BOLD,16);
		jmb = new JMenuBar();
		jm1 = new JMenu("开始");
		jm1.setFont(font);
		jmi1 = new JMenuItem("单人游戏");
		jmi11 = new JMenuItem("双人游戏");
		jmi111 = new JMenuItem("下一关");
		jmi1.setFont(font);
		jmi11.setFont(font);
		jmi111.setFont(font);
		//对jmi1注册监听
		jmi1.addActionListener(this);
		jmi1.setActionCommand("单人游戏");
		jmi11.addActionListener(this);
		jmi11.setActionCommand("双人游戏");
		jmi111.addActionListener(this);
		jmi111.setActionCommand("下一关");
		jmi2 = new JMenuItem("退出游戏");
		jmi2.setFont(font);
		jmi2.addActionListener(this);
		jmi2.setActionCommand("退出游戏");
		jm2 = new JMenu("帮助");
		jm2.setFont(font);
		jm2i1 = new JMenuItem("游戏说明");
		jm2i1.setFont(font);
		jm2i1.addActionListener(this);
		jm2i1.setActionCommand("游戏说明");
		jm2.add(jm2i1);
		jm1.add(jmi1);
		jm1.add(jmi11);
		jm1.add(jmi111);
		jm1.add(jmi2);
		jmb.add(jm1);
		jmb.add(jm2);
		
		startpanel = new StartPanel();
		this.add(startpanel);
		Thread startPanel = new Thread(startpanel);
		startPanel.start();
		
		this.setJMenuBar(jmb);
		//this.setSize(1500,947);
		this.setSize(1218,976);
		this.setTitle("坦克大战");
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("单人游戏")){// && mypanel1==null
			if(mypanel1!=null) {
				this.remove(mypanel1);
				mypanel1=null;
				//System.out.println("remove 11");
			}
			if(mypanel2!=null) {
				this.remove(mypanel2);
				mypanel2=null;
				//System.out.println("remove 12");
			}
			if(mypanel21!=null) {
				this.remove(mypanel21);
				mypanel21=null;
				//System.out.println("remove 21");
			}
			if(mypanel22!=null) {
				this.remove(mypanel22);
				mypanel22=null;
				//System.out.println("remove 22");
			}
			mypanel1 =new MyPanel(1);
			Thread myPanel1 = new Thread(mypanel1);
			myPanel1.start();//启动面板线程
			//删除旧的面板
			this.remove(startpanel);
			//System.out.println("旧面板已被删除");
			this.add(mypanel1);
			this.addKeyListener(mypanel1);//注册监听
			//显示，刷新面板
			this.setVisible(true);
		}else if(arg0.getActionCommand().equals("双人游戏")){
			if(mypanel2!=null) {
				this.remove(mypanel2);
				mypanel2=null;
				//System.out.println("remove 12");
			}
			if(mypanel1!=null) {
				this.remove(mypanel1);
				mypanel1=null;
				//System.out.println("remove 11");
			}
			if(mypanel21!=null) {
				this.remove(mypanel21);
				mypanel21=null;
				//System.out.println("remove 21");
			}
			if(mypanel22!=null) {
				this.remove(mypanel22);
				mypanel22=null;
				//System.out.println("remove 22");
			}
			mypanel2 =new MyPanel(2);
			Thread myPanel2 = new Thread(mypanel2);
			myPanel2.start();//启动面板线程
			//删除旧的面板
			this.remove(startpanel);
			//System.out.println("旧面板已被删除");
			this.add(mypanel2);
			this.addKeyListener(mypanel2);//注册监听
			//显示，刷新面板
			this.setVisible(true);
		}else if(arg0.getActionCommand().equals("下一关")) {
			if(mypanel1!=null) {
				this.remove(mypanel1);
				mypanel1=null;
				//System.out.println("remove 1");
				mypanel21 =new MyPanel2(1);
				Thread myPanel21 = new Thread(mypanel21);
				myPanel21.start();//启动面板线程
				//删除旧的面板
				this.remove(startpanel);
				//System.out.println("旧面板已被删除");
				this.add(mypanel21);
				this.addKeyListener(mypanel21);//注册监听
				//显示，刷新面板
				this.setVisible(true);
			}else if(mypanel2!=null) {
				this.remove(mypanel2);
				mypanel2=null;
				//System.out.println("remove 2");
				mypanel22=new MyPanel2(2);
				Thread myPanel22 = new Thread(mypanel22);
				myPanel22.start();//启动面板线程
				//删除旧的面板
				this.remove(startpanel);
				//System.out.println("旧面板已被删除");
				this.add(mypanel22);
				this.addKeyListener(mypanel22);//注册监听
				//显示，刷新面板
				this.setVisible(true);
			}
		}else if(arg0.getActionCommand().equals("退出游戏")){
			
			System.exit(0);
		}else if(arg0.getActionCommand().equals("游戏说明")){
			//JOptionPane.showMessageDialog(null,"W:向上\nS:向下\nA:向左\nD:向右\nJ:发射子弹");
			mesgDialog MD=new mesgDialog(this);
//			if(MD==null){
//				MD=new mesgDialog(this);
//			}
			MD.show();
		}
	}
}

//启动面板
class StartPanel extends JPanel implements Runnable {
	int times=0;
	int x=1200;
	int x1=-50;
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 1200, 900);
		
		Font font = new Font("宋体",Font.BOLD,150);
		Font font2 = new Font("宋体",Font.BOLD,100);
		g.setFont(font);
		g.setColor(Color.orange);
		g.drawString("TankBattle", x, 350);
		g.setFont(font2);
		g.drawString("2017", x+280, 500);
		
		if(x1<640){
			g.setColor(Color.green);
			drawtank(x1-120,600,g,1);
			g.setColor(Color.CYAN);
			drawtank(x1+30,600,g,1);
		}else{
			g.setColor(Color.green);
			drawtank(x1-120,600,g,0);
			g.setColor(Color.CYAN);
			drawtank(x1+30,600,g,0);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(x>200){
				x-=10;
			}
			if(x1<640){
				x1+=7;
			}
			times++;
			this.repaint();
		}
	}
	
	public void drawtank(int x,int y,Graphics g,int direct){
		switch(direct){
		case 0:
			g.fill3DRect(x-25, y-25, 10, 50,false);//左履带
			g.fill3DRect(x+15, y-25, 10, 50,false);//右履带
			g.fill3DRect(x-15, y-15, 30, 30,false);//中间矩形
			g.fillOval(x-10, y-10, 20, 20);//圆
			g.drawLine(x, y-10,x, y-25);//炮筒
			break;
		case 1:
			g.fill3DRect(x-25, y-25, 50, 10,false);//左履带
			g.fill3DRect(x-25, y+15, 50, 10,false);//右履带
			g.fill3DRect(x-15, y-15, 30, 30,false);//中间矩形
			g.fillOval(x-10, y-10, 20, 20);//圆
			g.drawLine(x+10, y,x+25, y);//炮筒
			break;
		}
	}
}

//我的面板，关卡1
class MyPanel extends JPanel implements Runnable,KeyListener{
	
	int number;//我方坦克数量
	//定义我的坦克
	Me me =null;
	Me me2 =null;
	//敌方新加入坦克的最大数量，为15只
	int enemyNum=0;
	//定义敌方的坦克组
	Vector<Enemy> Enemys =new Vector<Enemy>();
	
	//定义围墙组
	Vector<Wall> Walls = new Vector<Wall>();
	
	//定义爆炸组
	Vector<Bomb> bombs = new Vector<Bomb>();
	//定义爆炸的连续三张图片
	Image bombImage1 = null;
	Image bombImage2 = null;
	Image bombImage3 = null;
	//老王
	Image king = null;
	
	//构造函数
	public MyPanel(int number) {
		
		this.number=number;
		//初始化我方坦克
		me = new Me(425,875);
		me.getTank(Enemys);
		me.getWall(Walls);
		if(number==2) {
			me2 = new Me(775,875);
			me2.getTank(Enemys);
			me2.getWall(Walls);
			me.getAnotherMe(me2);
			me2.getAnotherMe(me);
		}
		//初始化敌方坦克组
		for(int i=0;i<3;i++) {  //敌方坦克一次出来三辆
			Enemy enemy = new Enemy(25+i*575,25);
			//Enemy enemy = new Enemy(25+(i%24)*50,(i/24)*50+25);
			//将敌人坦克向量赋给刚创建的敌人
			enemy.getTank(Enemys);
			enemy.getWall(Walls);
			//将该敌人添加到地方坦克组里
			Enemys.add(enemy);
			enemy.setDirection(1);
			Thread enTank = new Thread(enemy);
			enTank.start();
		}
		//初始化围墙
		for(int i = 0; i < 13 ; i++){//左一
			Wall wall = new Wall(50,50+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(100,50+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(50,525+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(100,525+i*25,0);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 13 ; i++){//右一
			Wall wall = new Wall(1050,50+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(1100,50+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(1050,525+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(1100,525+i*25,0);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 13 ; i++){//左二
			Wall wall = new Wall(250,50+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(300,50+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(250,525+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(300,525+i*25,0);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 13 ; i++){//右二
			Wall wall = new Wall(850,50+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(900,50+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(850,525+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 13 ; i++){
			Wall wall = new Wall(900,525+i*25,0);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 10 ; i++){//左三
			Wall wall = new Wall(450,50+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 10 ; i++){
			Wall wall = new Wall(500,50+i*25,0);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 10 ; i++){//右三
			Wall wall = new Wall(650,50+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 10 ; i++){
			Wall wall = new Wall(700,50+i*25,0);
			Walls.add(wall);
		}
		
		for(int i=0;i<3;i++) {//中间第一层
			for(int j=0;j<6;j++) {
				Wall wall = new Wall(450+j*50,450+i*25,0);
				Walls.add(wall);
			}
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				Wall wall = new Wall(450+j*50,375+i*25,0);
				Walls.add(wall);
			}
		}for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				Wall wall = new Wall(650+j*50,375+i*25,0);
				Walls.add(wall);
			}
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				Wall wall = new Wall(550+j*50,525+i*25,0);
				Walls.add(wall);
			}
		}
		
		for(int i=0;i<3;i++) {//中间第二层
			for(int j=0;j<6;j++) {
				Wall wall = new Wall(450+j*50,600+i*25,0);
				Walls.add(wall);
			}
		}
		
		for(int i = 0; i < 6 ; i++){//老巢左
			Wall wall = new Wall(500,750+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 6 ; i++){//老巢右
			Wall wall = new Wall(650,750+i*25,0);
			Walls.add(wall);
		}

		for(int i = 0; i < 2 ; i++){//老巢上左
			Wall wall = new Wall(550,750+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 2 ; i++){//老巢上右
			Wall wall = new Wall(600,750+i*25,0);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 7 ; i++){//左边铁块
			Wall wall = new Wall(i*50,425,1);
			Walls.add(wall);
		}for(int i = 0; i < 7 ; i++){//左边铁块
			Wall wall = new Wall(i*50,450,1);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 7 ; i++){//右边铁块
			Wall wall = new Wall(850+i*50,425,1);
			Walls.add(wall);
		}for(int i = 0; i < 7 ; i++){//左边铁块
			Wall wall = new Wall(850+i*50,450,1);
			Walls.add(wall);
		}
		
		for(int j=0;j<3;j++) {
			for(int i = 0; i < 6 ; i++){//中间铁块
				Wall wall = new Wall(450+i*50,300+j*25,1);
				Walls.add(wall);
			}
		}
		
//		try {
//			bombImage1 = ImageIO.read(new File("bomb_1.gif"));
//			bombImage2 = ImageIO.read(new File("bomb_2.gif"));
//			bombImage3 = ImageIO.read(new File("bomb_3.gif"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//播放开战声音
		AePlayWave apw=new AePlayWave("./背景音乐.wav");
		apw.start();
		
		//初始化三张图片
		bombImage1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
		bombImage2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
		bombImage3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
	
		king = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/老巢.jpg"));
	}
	
	//重写paint方法
	public void paint(Graphics g) {
		super.paint(g);
		
		//定下活动区域
		g.fillRect(0, 0, 1200, 900);
		
		//画出老巢
		if(me.kingLive) {
			g.drawImage(king, 550, 800, 100, 100, this);
		}
		
		//画出我方坦克
		if(me.live) {
			this.drawtank(me.getX(), me.getY(), me.getDirection(), 0, g);
			//画出我的坦克的Bullets中每颗子弹
			if(me.live) {
				for(int i=0;i<this.me.bullets.size();i++) {
					Bullet bulleti = me.bullets.get(i);
					//判断子弹不为空且子弹存活的时候，画子弹
					if(bulleti!=null && bulleti.live==true) {
						//g.draw3DRect(bulleti.x,bulleti.y,4,4,false);
						g.fillOval(bulleti.x, bulleti.y, 6, 6);//圆
					}
					if(bulleti.live==false) {
						//若子弹已经死亡，则从向量中删除
						me.bullets.remove(bulleti);
					}
				}
			}
		}
		if(this.number==2){
			if(me2.live) {
				this.drawtank(me2.getX(), me2.getY(), me2.getDirection(), 2, g);
				for(int i=0;i<this.me2.bullets.size();i++) {
					Bullet bulleti = me2.bullets.get(i);
					//判断子弹不为空且子弹存活的时候，画子弹
					if(bulleti!=null && bulleti.live==true) {
						//g.draw3DRect(bulleti.x,bulleti.y,4,4,false);
						g.fillOval(bulleti.x, bulleti.y, 6, 6);//圆
					}
					if(bulleti.live==false) {
						//若子弹已经死亡，则从向量中删除
						me2.bullets.remove(bulleti);
					}
				}
			}	
		}
		
		//画出敌方坦克的Bullets中每颗子弹
		g.setColor(Color.lightGray);
		for(int j=0;j<this.Enemys.size();j++) {
			Enemy enemy1 = Enemys.get(j);
			for(int i=0;i<enemy1.bullets.size();i++) {
				Bullet bulleti = enemy1.bullets.get(i);
				//判断子弹不为空且子弹存活的时候，画子弹
				if(bulleti!=null && bulleti.live==true) {
					//g.draw3DRect(bulleti.x,bulleti.y,4,4,false);
					g.fillOval(bulleti.x, bulleti.y, 6, 6);//圆
				}
				if(bulleti.live==false) {
					//若子弹已经死亡，则从向量中删除
					enemy1.bullets.remove(bulleti);
				}
			}
		}
		
		//画出爆炸效果
		for(int i=0;i<bombs.size();i++) {
			Bomb bomb = bombs.get(i);
			if(bomb.life>6) {
				g.drawImage(bombImage1, bomb.x, bomb.y, 50, 50, this);
			}else if(bomb.life>3) {
				g.drawImage(bombImage2, bomb.x, bomb.y, 50, 50, this);
			}else if(bomb.life>0) {
				g.drawImage(bombImage3, bomb.x, bomb.y, 50, 50, this);
			}
			bomb.lifReduce();
			if(bomb.life==0) {
				bombs.remove(bomb);
			}
			
		}
		
		//画出敌方坦克
		for(int i=0;i<Enemys.size();i++){
			Enemy enemyi = Enemys.get(i);
			if(enemyi.live == false) {
				Enemys.remove(enemyi);
			}else {
				this.drawtank(enemyi.getX(), enemyi.getY(), enemyi.getDirection(), 1, g);
			}
		}
		
		//画出围墙
		for(int i=0;i<Walls.size();i++){
			Wall walli = Walls.get(i);
			if(walli.live == false) {
				Walls.remove(walli);
			}else {
				this.drawWall(walli.getX(),walli.getY(),walli.getType(),g);
			}
		}
		//画出Game over
		if(me.kingLive==false && Enemys.size()>0) {
			Font font = new Font("宋体",Font.BOLD,180);
			g.setFont(font);
			g.setColor(Color.RED);
			g.drawString("Game over", 160, 500);
		}
		if(number==2) {
			if(me.lifeNum==0 && me2.lifeNum==0 && Enemys.size()>0) {
				Font font = new Font("宋体",Font.BOLD,180);
				g.setFont(font);
				g.setColor(Color.RED);
				g.drawString("Game over", 160, 500);
			}
		}else {
			if(me.lifeNum==0 && Enemys.size()>0) {
				Font font = new Font("宋体",Font.BOLD,180);
				g.setFont(font);
				g.setColor(Color.RED);
				g.drawString("Game over", 160, 500);
			}
		}
		//画出you win
		if(me.vectory) {
			Font font = new Font("宋体",Font.BOLD,180);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("You win!", 200, 500);
		}
	}
	//画围墙的方法
	public void drawWall(int x,int y,int type,Graphics g) {
		switch(type) {
		case 0:
			g.setColor(Color.ORANGE);//砖块
			break;
		case 1:
			g.setColor(Color.LIGHT_GRAY);//铁块
			break;
		case 2:
			g.setColor(Color.BLUE);//河流
			break;
		case 3:
			g.setColor(Color.GREEN);//草丛
			break;
		}
		g.fill3DRect(x, y, 50, 25, false);
	}
	
	
	//将画坦克封装成一个方法，传入画笔，方向，坦克类型（敌方我方）等
	public void drawtank(int x,int y,int direction,int type,Graphics g) {
		switch(type) {//判断坦克类型
			case 0://我方
				g.setColor(Color.GREEN);//设置画笔颜色
				break;
			case 1://敌方
				g.setColor(Color.MAGENTA);
				break;	
			case 2://我方2
				g.setColor(Color.CYAN);
				break;
		}
		switch(direction) {//判断方向
			case 0://方向向上
				g.fill3DRect(x-25, y-25, 10, 50,false);//左履带
				g.fill3DRect(x+15, y-25, 10, 50,false);//右履带
				g.fill3DRect(x-15, y-15, 30, 30,false);//中间矩形
				g.fillOval(x-10, y-10, 20, 20);//圆
				g.drawLine(x, y-10,x, y-25);//炮筒
				break;
			case 1://方向向下
				g.fill3DRect(x-25, y-25, 10, 50,false);//左履带
				g.fill3DRect(x+15, y-25, 10, 50,false);//右履带
				g.fill3DRect(x-15, y-15, 30, 30,false);//中间矩形
				g.fillOval(x-10, y-10, 20, 20);//圆
				g.drawLine(x, y+10,x, y+25);//炮筒
				break;
			case 2://方向向右
				g.fill3DRect(x-25, y-25, 50, 10,false);//左履带
				g.fill3DRect(x-25, y+15, 50, 10,false);//右履带
				g.fill3DRect(x-15, y-15, 30, 30,false);//中间矩形
				g.fillOval(x-10, y-10, 20, 20);//圆
				g.drawLine(x+10, y,x+25, y);//炮筒
				break;
			case 3://方向向左
				g.fill3DRect(x-25, y-25, 50, 10,false);//左履带
				g.fill3DRect(x-25, y+15, 50, 10,false);//右履带
				g.fill3DRect(x-15, y-15, 30, 30,false);//中间矩形
				g.fillOval(x-10, y-10, 20, 20);//圆
				g.drawLine(x-10, y,x-25, y);//炮筒
				break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W) {
			this.me.setDirection(0);
			this.me.moveUp();
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			this.me.setDirection(1);
			this.me.moveDown();
		}else if(e.getKeyCode()==KeyEvent.VK_D) {
			this.me.setDirection(2);
			this.me.moveRight();
		}else if(e.getKeyCode()==KeyEvent.VK_A) {
			this.me.setDirection(3);
			this.me.moveLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_F) {
			if(me.bullets.size()==0) {
				this.me.shot();			
			}
		}
		if(number==2){
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				this.me2.setDirection(0);
				this.me2.moveUp();
			}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
				this.me2.setDirection(1);
				this.me2.moveDown();
			}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				this.me2.setDirection(2);
				this.me2.moveRight();
			}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				this.me2.setDirection(3);
				this.me2.moveLeft();
			}
			if(e.getKeyCode()==KeyEvent.VK_L) {
				if(me2.bullets.size()==0) {
					this.me2.shot();			
				}
			}
		}

		//调用repaint()函数，来重绘界面
		this.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//判断敌方子弹是否击中围墙
			for(int j=0;j<this.Enemys.size();j++) {
				Enemy enemy1 = Enemys.get(j);
				for(int i=0;i<enemy1.bullets.size();i++) {
					Bullet bulleti = enemy1.bullets.get(i);
					for(int k=0;k<this.Walls.size();k++) {
						Wall walli = Walls.get(k);
						if(bulleti.x >= walli.x && bulleti.x <= walli.x+50 && bulleti.y >= walli.y && bulleti.y <= walli.y+25) {
							if(walli.type==0) {//砖块类型的墙
								bulleti.live = false;
								walli.live = false;
							}else if(walli.type==1) {//铁块类型的墙
								bulleti.live = false;
							}
						}
					}
				}
			}
			if(me.kingLive) {
				//判断敌方子弹是否击中老王///////////
				for(int j=0;j<this.Enemys.size();j++) {
					Enemy enemy1 = Enemys.get(j);
					for(int i=0;i<enemy1.bullets.size();i++) {
						Bullet bulleti = enemy1.bullets.get(i);
						if(bulleti.x >= 550 && bulleti.x <= 650 && bulleti.y >= 800 && bulleti.y <= 900) {
							bulleti.live = false;
							me.kingLive = false;
							Bomb bomb = new Bomb(575,825);
							bombs.add(bomb);
							me.live=false;
							Bomb bomb2 = new Bomb(me.x-25,me.y-25);
							bombs.add(bomb2);
							if(number==2) {
								me2.live=false;
								Bomb bomb3 = new Bomb(me2.x-25,me2.y-25);
								bombs.add(bomb3);
							}
							me.lifeNum=0;
							if(number==2) {
								me2.lifeNum=0;
							}
						}
					}
				}
			}
			if(me.live) {//我方坦克还活着的时候
				//判断敌方子弹是否击中我方坦克
				for(int j=0;j<this.Enemys.size();j++) {
					Enemy enemy1 = Enemys.get(j);
					for(int i=0;i<enemy1.bullets.size();i++) {
						Bullet bulleti = enemy1.bullets.get(i);
						if(bulleti.x >= me.x-25 && bulleti.x <= me.x+25 && bulleti.y >= me.y-25 && bulleti.y <= me.y+25) {
							bulleti.live = false;
							me.live = false;
							me.lifeNum--;
							
							//System.gc();
							Bomb bomb = new Bomb(me.x-25,me.y-25);
							bombs.add(bomb);
						}
					}
				}
				//判断子弹是否击中敌方坦克
				for(int i=0;i<me.bullets.size();i++) {
					//取出当前子弹
					Bullet bulleti = me.bullets.get(i);
					if(bulleti.live == true) {
						//对每辆敌方坦克进行判断
						for(int j=0;j<Enemys.size();j++) {
							//取出当前坦克
							Enemy enemyi = Enemys.get(j);
							if(enemyi.live == true) {
								if(bulleti.x >= enemyi.x-25 && bulleti.x <= enemyi.x+25 && bulleti.y >= enemyi.y-25 && bulleti.y <= enemyi.y+25) {
									bulleti.live = false;
									enemyi.live = false;
									Bomb bomb = new Bomb(enemyi.x-25,enemyi.y-25);
									bombs.add(bomb);
								}
							}
						}
					}
				}
				//判断子弹是否击中围墙
				for(int i=0;i<me.bullets.size();i++) {
					//取出当前子弹
					Bullet bulleti = me.bullets.get(i);
					if(bulleti.live == true) {
						//对每个围墙进行判断
						for(int j=0;j<Walls.size();j++) {
							//取出当前坦克
							Wall walli = Walls.get(j);
							if(walli.live == true) {
								if(bulleti.x >= walli.x && bulleti.x <= walli.x+50 && bulleti.y >= walli.y && bulleti.y <= walli.y+25) {
									if(walli.type==0) {//砖块类型的墙
										bulleti.live = false;
										walli.live = false;
									}else if(walli.type==1) {//铁块类型的墙
										bulleti.live = false;
									}
								}
							}
						}
					}
				}
				if(me.kingLive) {
					//判断子弹是否击中老王
					for(int i=0;i<me.bullets.size();i++) {
						//取出当前子弹
						Bullet bulleti = me.bullets.get(i);
						if(bulleti.live == true) {
							if(bulleti.x >= 550 && bulleti.x <= 650 && bulleti.y >= 800 && bulleti.y <= 900) {
								bulleti.live = false;
								me.kingLive = false;
								Bomb bomb = new Bomb(575,825);
								bombs.add(bomb);
								me.live=false;
								Bomb bomb2 = new Bomb(me.x-25,me.y-25);
								bombs.add(bomb2);
								if(number==2) {
									me2.live=false;
									Bomb bomb3 = new Bomb(me2.x-25,me2.y-25);
									bombs.add(bomb3);
								}
								me.lifeNum=0;
								if(number==2) {
									me2.lifeNum=0;
								}
							}
						}
					}
				}
			}
			if(number==2) {
				for(int i=0;i<me2.bullets.size();i++) {
					//取出当前子弹
					Bullet bulleti = me2.bullets.get(i);
					if(bulleti.live == true) {
						//对每辆敌方坦克进行判断
						for(int j=0;j<Enemys.size();j++) {
							//取出当前坦克
							Enemy enemyi = Enemys.get(j);
							if(enemyi.live == true) {
								if(bulleti.x >= enemyi.x-25 && bulleti.x <= enemyi.x+25 && bulleti.y >= enemyi.y-25 && bulleti.y <= enemyi.y+25) {
									bulleti.live = false;
									enemyi.live = false;
									Bomb bomb = new Bomb(enemyi.x-25,enemyi.y-25);
									bombs.add(bomb);
								}
							}
						}
					}
				}
				if(me2.live) {//我方坦克还活着的时候
					//判断敌方子弹是否击中我方坦克
					for(int j=0;j<this.Enemys.size();j++) {
						Enemy enemy1 = Enemys.get(j);
						for(int i=0;i<enemy1.bullets.size();i++) {
							Bullet bulleti = enemy1.bullets.get(i);
							if(bulleti.x >= me2.x-25 && bulleti.x <= me2.x+25 && bulleti.y >= me2.y-25 && bulleti.y <= me2.y+25) {
								bulleti.live = false;
								me2.live = false;
								me2.lifeNum--;
								//me=null;
								//System.gc();
								Bomb bomb = new Bomb(me2.x-25,me2.y-25);
								bombs.add(bomb);
							}
						}
					}
					//判断子弹是否击中敌方坦克
					for(int i=0;i<me2.bullets.size();i++) {
						//取出当前子弹
						Bullet bulleti = me2.bullets.get(i);
						if(bulleti.live == true) {
							//对每辆敌方坦克进行判断
							for(int j=0;j<Enemys.size();j++) {
								//取出当前坦克
								Enemy enemyi = Enemys.get(j);
								if(enemyi.live == true) {
									if(bulleti.x >= enemyi.x-25 && bulleti.x <= enemyi.x+25 && bulleti.y >= enemyi.y-25 && bulleti.y <= enemyi.y+25) {
										bulleti.live = false;
										enemyi.live = false;
										Bomb bomb = new Bomb(enemyi.x-25,enemyi.y-25);
										bombs.add(bomb);
									}
								}
							}
						}
					}
					//判断子弹是否击中围墙
					for(int i=0;i<me2.bullets.size();i++) {
						//取出当前子弹
						Bullet bulleti = me2.bullets.get(i);
						if(bulleti.live == true) {
							//对每个围墙进行判断
							for(int j=0;j<Walls.size();j++) {
								//取出当前坦克
								Wall walli = Walls.get(j);
								if(walli.live == true) {
									if(bulleti.x >= walli.x && bulleti.x <= walli.x+50 && bulleti.y >= walli.y && bulleti.y <= walli.y+25) {
										if(walli.type==0) {//砖块类型的墙
											bulleti.live = false;
											walli.live = false;
										}else if(walli.type==1) {//铁块类型的墙
											bulleti.live = false;
										}
									}
								}
							}
						}
					}
					if(me.kingLive) {
						//判断子弹是否击中老王
						for(int i=0;i<me2.bullets.size();i++) {
							//取出当前子弹
							Bullet bulleti = me2.bullets.get(i);
							if(bulleti.live == true) {
								if(bulleti.x >= 550 && bulleti.x <= 650 && bulleti.y >= 800 && bulleti.y <= 900) {
									bulleti.live = false;
									me.kingLive = false;
									Bomb bomb = new Bomb(575,825);
									bombs.add(bomb);
									me.live=false;
									Bomb bomb2 = new Bomb(me.x-25,me.y-25);
									bombs.add(bomb2);
									me2.live=false;
									Bomb bomb3 = new Bomb(me2.x-25,me2.y-25);
									bombs.add(bomb3);
									me.lifeNum=0;
									me2.lifeNum=0;
								}
							}
						}
					}
				}
			}
			if(Enemys.size()<3 && enemyNum<15) {
				Enemy enemy = new Enemy(25+(enemyNum%3)*575,25);
				//Enemy enemy = new Enemy(25+(i%24)*50,(i/24)*50+25);
				//将敌人坦克向量赋给刚创建的敌人
				enemy.getTank(Enemys);
				enemy.getWall(Walls);
				//将该敌人添加到地方坦克组里
				Enemys.add(enemy);
				enemy.setDirection(1);
				Thread enTank = new Thread(enemy);
				enTank.start();
				enemyNum++;
			}
			if(Enemys.size()==0) {
				me.vectory=true;
			}
			if(me.live==false && me.lifeNum > 0) {
				me.live=true;
				me.x=425;
				me.y=875;
			}
			if(number==2) {
				if(me2.live==false && me2.lifeNum > 0) {
					me2.live=true;
					me2.x=775;
					me2.y=875;
				}
			}
			//重绘面板
			this.repaint();
		}
	}
}

//我的面板，关卡2
class MyPanel2 extends JPanel implements Runnable,KeyListener{
	
	int number;//我方坦克数量
	//定义我的坦克
	Me me =null;
	Me me2 =null;
	//敌方新加入坦克的最大数量，为15只
	int enemyNum=0;
	//定义敌方的坦克组
	Vector<Enemy> Enemys =new Vector<Enemy>();
	
	//定义围墙组
	Vector<Wall> Walls = new Vector<Wall>();
	
	//定义爆炸组
	Vector<Bomb> bombs = new Vector<Bomb>();
	//定义爆炸的连续三张图片
	Image bombImage1 = null;
	Image bombImage2 = null;
	Image bombImage3 = null;
	//老王
	Image king = null;
	
	//构造函数
	public MyPanel2(int number) {
		
		this.number=number;
		//初始化我方坦克
		me = new Me(425,875);
		me.getTank(Enemys);
		me.getWall(Walls);
		if(number==2) {
			me2 = new Me(775,875);
			me2.getTank(Enemys);
			me2.getWall(Walls);
			me.getAnotherMe(me2);
			me2.getAnotherMe(me);
		}
		//初始化敌方坦克组
		for(int i=0;i<3;i++) {  //敌方坦克一次出来三辆
			Enemy enemy = new Enemy(25+i*575,25);
			//Enemy enemy = new Enemy(25+(i%24)*50,(i/24)*50+25);
			//将敌人坦克向量赋给刚创建的敌人
			enemy.getTank(Enemys);
			enemy.getWall(Walls);
			//将该敌人添加到地方坦克组里
			Enemys.add(enemy);
			enemy.setDirection(1);
			Thread enTank = new Thread(enemy);
			enTank.start();
		}
		//初始化围墙
		for(int i = 0; i < 11 ; i++){//左一
		Wall wall = new Wall(150,100+i*25,1);
		Walls.add(wall);
		}for(int i = 0; i < 11 ; i++){
			Wall wall = new Wall(200,100+i*25,1);
			Walls.add(wall);
		}
		for(int i = 0; i < 8 ; i++){
		Wall wall = new Wall(150,550+i*25,0);
		Walls.add(wall);
		}for(int i = 0; i < 8 ; i++){
			Wall wall = new Wall(200,550+i*25,0);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 11 ; i++){//右一
		Wall wall = new Wall(950,100+i*25,1);
		Walls.add(wall);
		}for(int i = 0; i < 11 ; i++){
			Wall wall = new Wall(1000,100+i*25,1);
			Walls.add(wall);
		}
		for(int i = 0; i < 8 ; i++){
			Wall wall = new Wall(950,550+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 8 ; i++){
			Wall wall = new Wall(1000,550+i*25,0);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 9 ; i++){//左二
			Wall wall = new Wall(350,i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 9 ; i++){
			Wall wall = new Wall(400,i*25,0);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 9 ; i++){//右二
			Wall wall = new Wall(750,i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 9 ; i++){
			Wall wall = new Wall(800,i*25,0);
			Walls.add(wall);
		}
		
		for(int i=0;i<4;i++) {//中间第一层左
			for(int j=0;j<2;j++) {
				Wall wall = new Wall(250+j*50,375+i*25,0);
				Walls.add(wall);
			}
		}
		
		for(int i=0;i<4;i++) {//中间第一层右
			for(int j=0;j<2;j++) {
				Wall wall = new Wall(850+j*50,375+i*25,0);
				Walls.add(wall);
			}
		}
		
		for(int i=0;i<3;i++) {//中间第二层
			for(int j=0;j<4;j++) {
				Wall wall = new Wall(500+j*50,475+i*25,1);
				Walls.add(wall);
			}
		}
		
		for(int i = 0; i < 6 ; i++){//老巢左
			Wall wall = new Wall(500,750+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 6 ; i++){//老巢右
			Wall wall = new Wall(650,750+i*25,0);
			Walls.add(wall);
		}

		for(int i = 0; i < 2 ; i++){//老巢上左
			Wall wall = new Wall(550,750+i*25,0);
			Walls.add(wall);
		}for(int i = 0; i < 2 ; i++){//老巢上右
			Wall wall = new Wall(600,750+i*25,0);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 5 ; i++){//左边河流
			Wall wall = new Wall(i*50,475,2);
			Walls.add(wall);
		}for(int i = 0; i < 5 ; i++){//左边河流
			Wall wall = new Wall(i*50,500,2);
			Walls.add(wall);
		}for(int i = 0; i < 5 ; i++){//左边河流
			Wall wall = new Wall(i*50,525,2);
			Walls.add(wall);
		}
		
		for(int i = 0; i < 5 ; i++){//右边河流
			Wall wall = new Wall(950+i*50,475,2);
			Walls.add(wall);
		}for(int i = 0; i < 5 ; i++){//右边河流
			Wall wall = new Wall(950+i*50,500,2);
			Walls.add(wall);
		}for(int i = 0; i < 5 ; i++){//右边河流
			Wall wall = new Wall(950+i*50,525,2);
			Walls.add(wall);
		}
		
		for(int j=0;j<3;j++) {
			for(int i = 0; i < 10 ; i++){//中间河流
				Wall wall = new Wall(350+i*50,300+j*25,2);
				Walls.add(wall);
			}
		}
		
		//播放开战声音
		AePlayWave apw=new AePlayWave("./背景音乐.wav");
		apw.start();
		
		//初始化三张图片
		bombImage1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
		bombImage2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
		bombImage3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
	
		king = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/老巢.jpg"));
	}
	
	//重写paint方法
	public void paint(Graphics g) {
		super.paint(g);
		
		//定下活动区域
		g.fillRect(0, 0, 1200, 900);
		
		//画出老巢
		if(me.kingLive) {
			g.drawImage(king, 550, 800, 100, 100, this);
		}
		
		//画出我方坦克
		if(me.live) {
			this.drawtank(me.getX(), me.getY(), me.getDirection(), 0, g);
			//画出我的坦克的Bullets中每颗子弹
			if(me.live) {
				for(int i=0;i<this.me.bullets.size();i++) {
					Bullet bulleti = me.bullets.get(i);
					//判断子弹不为空且子弹存活的时候，画子弹
					if(bulleti!=null && bulleti.live==true) {
						//g.draw3DRect(bulleti.x,bulleti.y,4,4,false);
						g.fillOval(bulleti.x, bulleti.y, 6, 6);//圆
					}
					if(bulleti.live==false) {
						//若子弹已经死亡，则从向量中删除
						me.bullets.remove(bulleti);
					}
				}
			}
		}
		if(this.number==2){
			if(me2.live) {
				this.drawtank(me2.getX(), me2.getY(), me2.getDirection(), 2, g);
				for(int i=0;i<this.me2.bullets.size();i++) {
					Bullet bulleti = me2.bullets.get(i);
					//判断子弹不为空且子弹存活的时候，画子弹
					if(bulleti!=null && bulleti.live==true) {
						//g.draw3DRect(bulleti.x,bulleti.y,4,4,false);
						g.fillOval(bulleti.x, bulleti.y, 6, 6);//圆
					}
					if(bulleti.live==false) {
						//若子弹已经死亡，则从向量中删除
						me2.bullets.remove(bulleti);
					}
				}
			}	
		}
		
		//画出敌方坦克的Bullets中每颗子弹
		g.setColor(Color.lightGray);
		for(int j=0;j<this.Enemys.size();j++) {
			Enemy enemy1 = Enemys.get(j);
			for(int i=0;i<enemy1.bullets.size();i++) {
				Bullet bulleti = enemy1.bullets.get(i);
				//判断子弹不为空且子弹存活的时候，画子弹
				if(bulleti!=null && bulleti.live==true) {
					//g.draw3DRect(bulleti.x,bulleti.y,4,4,false);
					g.fillOval(bulleti.x, bulleti.y, 6, 6);//圆
				}
				if(bulleti.live==false) {
					//若子弹已经死亡，则从向量中删除
					enemy1.bullets.remove(bulleti);
				}
			}
		}
		
		//画出爆炸效果
		for(int i=0;i<bombs.size();i++) {
			Bomb bomb = bombs.get(i);
			if(bomb.life>6) {
				g.drawImage(bombImage1, bomb.x, bomb.y, 50, 50, this);
			}else if(bomb.life>3) {
				g.drawImage(bombImage2, bomb.x, bomb.y, 50, 50, this);
			}else if(bomb.life>0) {
				g.drawImage(bombImage3, bomb.x, bomb.y, 50, 50, this);
			}
			bomb.lifReduce();
			if(bomb.life==0) {
				bombs.remove(bomb);
			}
			
		}
		
		//画出敌方坦克
		for(int i=0;i<Enemys.size();i++){
			Enemy enemyi = Enemys.get(i);
			if(enemyi.live == false) {
				Enemys.remove(enemyi);
			}else {
				this.drawtank(enemyi.getX(), enemyi.getY(), enemyi.getDirection(), 1, g);
			}
		}
		
		//画出围墙
		for(int i=0;i<Walls.size();i++){
			Wall walli = Walls.get(i);
			if(walli.live == false) {
				Walls.remove(walli);
			}else {
				this.drawWall(walli.getX(),walli.getY(),walli.getType(),g);
			}
		}
		//画出Game over
		if(me.kingLive==false && Enemys.size()>0) {
			Font font = new Font("宋体",Font.BOLD,180);
			g.setFont(font);
			g.setColor(Color.RED);
			g.drawString("Game over", 160, 500);
		}
		if(number==2) {
			if(me.lifeNum==0 && me2.lifeNum==0 && Enemys.size()>0) {
				Font font = new Font("宋体",Font.BOLD,180);
				g.setFont(font);
				g.setColor(Color.RED);
				g.drawString("Game over", 160, 500);
			}
		}else {
			if(me.lifeNum==0 && Enemys.size()>0) {
				Font font = new Font("宋体",Font.BOLD,180);
				g.setFont(font);
				g.setColor(Color.RED);
				g.drawString("Game over", 160, 500);
			}
		}
		//画出you win
		if(me.vectory) {
			Font font = new Font("宋体",Font.BOLD,180);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("You win!", 200, 500);
		}
	}
	//画围墙的方法
	public void drawWall(int x,int y,int type,Graphics g) {
		switch(type) {
		case 0:
			g.setColor(Color.ORANGE);//砖块
			break;
		case 1:
			g.setColor(Color.LIGHT_GRAY);//铁块
			break;
		case 2:
			g.setColor(Color.BLUE);//河流
			break;
		case 3:
			g.setColor(Color.GREEN);//草丛
			break;
		}
		g.fill3DRect(x, y, 50, 25, false);
	}
	
	
	//将画坦克封装成一个方法，传入画笔，方向，坦克类型（敌方我方）等
	public void drawtank(int x,int y,int direction,int type,Graphics g) {
		switch(type) {//判断坦克类型
			case 0://我方
				g.setColor(Color.GREEN);//设置画笔颜色
				break;
			case 1://敌方
				g.setColor(Color.MAGENTA);
				break;	
			case 2://我方2
				g.setColor(Color.CYAN);
				break;
		}
		switch(direction) {//判断方向
			case 0://方向向上
				g.fill3DRect(x-25, y-25, 10, 50,false);//左履带
				g.fill3DRect(x+15, y-25, 10, 50,false);//右履带
				g.fill3DRect(x-15, y-15, 30, 30,false);//中间矩形
				g.fillOval(x-10, y-10, 20, 20);//圆
				g.drawLine(x, y-10,x, y-25);//炮筒
				break;
			case 1://方向向下
				g.fill3DRect(x-25, y-25, 10, 50,false);//左履带
				g.fill3DRect(x+15, y-25, 10, 50,false);//右履带
				g.fill3DRect(x-15, y-15, 30, 30,false);//中间矩形
				g.fillOval(x-10, y-10, 20, 20);//圆
				g.drawLine(x, y+10,x, y+25);//炮筒
				break;
			case 2://方向向右
				g.fill3DRect(x-25, y-25, 50, 10,false);//左履带
				g.fill3DRect(x-25, y+15, 50, 10,false);//右履带
				g.fill3DRect(x-15, y-15, 30, 30,false);//中间矩形
				g.fillOval(x-10, y-10, 20, 20);//圆
				g.drawLine(x+10, y,x+25, y);//炮筒
				break;
			case 3://方向向左
				g.fill3DRect(x-25, y-25, 50, 10,false);//左履带
				g.fill3DRect(x-25, y+15, 50, 10,false);//右履带
				g.fill3DRect(x-15, y-15, 30, 30,false);//中间矩形
				g.fillOval(x-10, y-10, 20, 20);//圆
				g.drawLine(x-10, y,x-25, y);//炮筒
				break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W) {
			this.me.setDirection(0);
			this.me.moveUp();
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			this.me.setDirection(1);
			this.me.moveDown();
		}else if(e.getKeyCode()==KeyEvent.VK_D) {
			this.me.setDirection(2);
			this.me.moveRight();
		}else if(e.getKeyCode()==KeyEvent.VK_A) {
			this.me.setDirection(3);
			this.me.moveLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_F) {
			if(me.bullets.size()==0) {
				this.me.shot();			
			}
		}
		if(number==2){
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				this.me2.setDirection(0);
				this.me2.moveUp();
			}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
				this.me2.setDirection(1);
				this.me2.moveDown();
			}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				this.me2.setDirection(2);
				this.me2.moveRight();
			}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				this.me2.setDirection(3);
				this.me2.moveLeft();
			}
			if(e.getKeyCode()==KeyEvent.VK_L) {
				if(me2.bullets.size()==0) {
					this.me2.shot();			
				}
			}
		}

		//调用repaint()函数，来重绘界面
		this.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//判断敌方子弹是否击中围墙
			for(int j=0;j<this.Enemys.size();j++) {
				Enemy enemy1 = Enemys.get(j);
				for(int i=0;i<enemy1.bullets.size();i++) {
					Bullet bulleti = enemy1.bullets.get(i);
					for(int k=0;k<this.Walls.size();k++) {
						Wall walli = Walls.get(k);
						if(bulleti.x >= walli.x && bulleti.x <= walli.x+50 && bulleti.y >= walli.y && bulleti.y <= walli.y+25) {
							if(walli.type==0) {//砖块类型的墙
								bulleti.live = false;
								walli.live = false;
							}else if(walli.type==1) {//铁块类型的墙
								bulleti.live = false;
							}
						}
					}
				}
			}
			if(me.kingLive) {
				//判断敌方子弹是否击中老王///////////
				for(int j=0;j<this.Enemys.size();j++) {
					Enemy enemy1 = Enemys.get(j);
					for(int i=0;i<enemy1.bullets.size();i++) {
						Bullet bulleti = enemy1.bullets.get(i);
						if(bulleti.x >= 550 && bulleti.x <= 650 && bulleti.y >= 800 && bulleti.y <= 900) {
							bulleti.live = false;
							me.kingLive = false;
							Bomb bomb = new Bomb(575,825);
							bombs.add(bomb);
							me.live=false;
							Bomb bomb2 = new Bomb(me.x-25,me.y-25);
							bombs.add(bomb2);
							if(number==2) {
								me2.live=false;
								Bomb bomb3 = new Bomb(me2.x-25,me2.y-25);
								bombs.add(bomb3);
							}
							me.lifeNum=0;
							if(number==2) {
								me2.lifeNum=0;
							}
						}
					}
				}
			}
			if(me.live) {//我方坦克还活着的时候
				//判断敌方子弹是否击中我方坦克
				for(int j=0;j<this.Enemys.size();j++) {
					Enemy enemy1 = Enemys.get(j);
					for(int i=0;i<enemy1.bullets.size();i++) {
						Bullet bulleti = enemy1.bullets.get(i);
						if(bulleti.x >= me.x-25 && bulleti.x <= me.x+25 && bulleti.y >= me.y-25 && bulleti.y <= me.y+25) {
							bulleti.live = false;
							me.live = false;
							me.lifeNum--;
							
							//System.gc();
							Bomb bomb = new Bomb(me.x-25,me.y-25);
							bombs.add(bomb);
						}
					}
				}
				//判断子弹是否击中敌方坦克
				for(int i=0;i<me.bullets.size();i++) {
					//取出当前子弹
					Bullet bulleti = me.bullets.get(i);
					if(bulleti.live == true) {
						//对每辆敌方坦克进行判断
						for(int j=0;j<Enemys.size();j++) {
							//取出当前坦克
							Enemy enemyi = Enemys.get(j);
							if(enemyi.live == true) {
								if(bulleti.x >= enemyi.x-25 && bulleti.x <= enemyi.x+25 && bulleti.y >= enemyi.y-25 && bulleti.y <= enemyi.y+25) {
									bulleti.live = false;
									enemyi.live = false;
									Bomb bomb = new Bomb(enemyi.x-25,enemyi.y-25);
									bombs.add(bomb);
								}
							}
						}
					}
				}
				//判断子弹是否击中围墙
				for(int i=0;i<me.bullets.size();i++) {
					//取出当前子弹
					Bullet bulleti = me.bullets.get(i);
					if(bulleti.live == true) {
						//对每个围墙进行判断
						for(int j=0;j<Walls.size();j++) {
							//取出当前坦克
							Wall walli = Walls.get(j);
							if(walli.live == true) {
								if(bulleti.x >= walli.x && bulleti.x <= walli.x+50 && bulleti.y >= walli.y && bulleti.y <= walli.y+25) {
									if(walli.type==0) {//砖块类型的墙
										bulleti.live = false;
										walli.live = false;
									}else if(walli.type==1) {//铁块类型的墙
										bulleti.live = false;
									}
								}
							}
						}
					}
				}
				if(me.kingLive) {
					//判断子弹是否击中老王
					for(int i=0;i<me.bullets.size();i++) {
						//取出当前子弹
						Bullet bulleti = me.bullets.get(i);
						if(bulleti.live == true) {
							if(bulleti.x >= 550 && bulleti.x <= 650 && bulleti.y >= 800 && bulleti.y <= 900) {
								bulleti.live = false;
								me.kingLive = false;
								Bomb bomb = new Bomb(575,825);
								bombs.add(bomb);
								me.live=false;
								Bomb bomb2 = new Bomb(me.x-25,me.y-25);
								bombs.add(bomb2);
								if(number==2) {
									me2.live=false;
									Bomb bomb3 = new Bomb(me2.x-25,me2.y-25);
									bombs.add(bomb3);
								}
								me.lifeNum=0;
								if(number==2) {
									me2.lifeNum=0;
								}
							}
						}
					}
				}
			}
			if(number==2) {
				for(int i=0;i<me2.bullets.size();i++) {
					//取出当前子弹
					Bullet bulleti = me2.bullets.get(i);
					if(bulleti.live == true) {
						//对每辆敌方坦克进行判断
						for(int j=0;j<Enemys.size();j++) {
							//取出当前坦克
							Enemy enemyi = Enemys.get(j);
							if(enemyi.live == true) {
								if(bulleti.x >= enemyi.x-25 && bulleti.x <= enemyi.x+25 && bulleti.y >= enemyi.y-25 && bulleti.y <= enemyi.y+25) {
									bulleti.live = false;
									enemyi.live = false;
									Bomb bomb = new Bomb(enemyi.x-25,enemyi.y-25);
									bombs.add(bomb);
								}
							}
						}
					}
				}
				if(me2.live) {//我方坦克还活着的时候
					//判断敌方子弹是否击中我方坦克
					for(int j=0;j<this.Enemys.size();j++) {
						Enemy enemy1 = Enemys.get(j);
						for(int i=0;i<enemy1.bullets.size();i++) {
							Bullet bulleti = enemy1.bullets.get(i);
							if(bulleti.x >= me2.x-25 && bulleti.x <= me2.x+25 && bulleti.y >= me2.y-25 && bulleti.y <= me2.y+25) {
								bulleti.live = false;
								me2.live = false;
								me2.lifeNum--;
								//me=null;
								//System.gc();
								Bomb bomb = new Bomb(me2.x-25,me2.y-25);
								bombs.add(bomb);
							}
						}
					}
					//判断子弹是否击中敌方坦克
					for(int i=0;i<me2.bullets.size();i++) {
						//取出当前子弹
						Bullet bulleti = me2.bullets.get(i);
						if(bulleti.live == true) {
							//对每辆敌方坦克进行判断
							for(int j=0;j<Enemys.size();j++) {
								//取出当前坦克
								Enemy enemyi = Enemys.get(j);
								if(enemyi.live == true) {
									if(bulleti.x >= enemyi.x-25 && bulleti.x <= enemyi.x+25 && bulleti.y >= enemyi.y-25 && bulleti.y <= enemyi.y+25) {
										bulleti.live = false;
										enemyi.live = false;
										Bomb bomb = new Bomb(enemyi.x-25,enemyi.y-25);
										bombs.add(bomb);
									}
								}
							}
						}
					}
					//判断子弹是否击中围墙
					for(int i=0;i<me2.bullets.size();i++) {
						//取出当前子弹
						Bullet bulleti = me2.bullets.get(i);
						if(bulleti.live == true) {
							//对每个围墙进行判断
							for(int j=0;j<Walls.size();j++) {
								//取出当前坦克
								Wall walli = Walls.get(j);
								if(walli.live == true) {
									if(bulleti.x >= walli.x && bulleti.x <= walli.x+50 && bulleti.y >= walli.y && bulleti.y <= walli.y+25) {
										if(walli.type==0) {//砖块类型的墙
											bulleti.live = false;
											walli.live = false;
										}else if(walli.type==1) {//铁块类型的墙
											bulleti.live = false;
										}
									}
								}
							}
						}
					}
					if(me.kingLive) {
						//判断子弹是否击中老王
						for(int i=0;i<me2.bullets.size();i++) {
							//取出当前子弹
							Bullet bulleti = me2.bullets.get(i);
							if(bulleti.live == true) {
								if(bulleti.x >= 550 && bulleti.x <= 650 && bulleti.y >= 800 && bulleti.y <= 900) {
									bulleti.live = false;
									me.kingLive = false;
									Bomb bomb = new Bomb(575,825);
									bombs.add(bomb);
									me.live=false;
									Bomb bomb2 = new Bomb(me.x-25,me.y-25);
									bombs.add(bomb2);
									me2.live=false;
									Bomb bomb3 = new Bomb(me2.x-25,me2.y-25);
									bombs.add(bomb3);
									me.lifeNum=0;
									me2.lifeNum=0;
								}
							}
						}
					}
				}
			}
			if(Enemys.size()<3 && enemyNum<15) {
				Enemy enemy = new Enemy(25+(enemyNum%3)*575,25);
				//Enemy enemy = new Enemy(25+(i%24)*50,(i/24)*50+25);
				//将敌人坦克向量赋给刚创建的敌人
				enemy.getTank(Enemys);
				enemy.getWall(Walls);
				//将该敌人添加到地方坦克组里
				Enemys.add(enemy);
				enemy.setDirection(1);
				Thread enTank = new Thread(enemy);
				enTank.start();
				enemyNum++;
			}
			if(Enemys.size()==0) {
				me.vectory=true;
			}
			if(me.live==false && me.lifeNum > 0) {
				me.live=true;
				me.x=425;
				me.y=875;
			}
			if(number==2) {
				if(me2.live==false && me2.lifeNum > 0) {
					me2.live=true;
					me2.x=775;
					me2.y=875;
				}
			}
			//重绘面板
			this.repaint();
		}
	}
}