package cn.edu.bit.cs;

import java.awt.Font;
import java.util.*;

import javax.swing.*;

import javafx.scene.paint.Color;

//坦克类（父类）
class Tank{
	int x;//坦克的横坐标
	int y;//坦克的纵坐标
	int speed=5;//坦克速度
	int direction =0;//0表示向上，1表示向下，2表示向右，3表示向左
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public Tank(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}

//我方坦克类
class Me extends Tank{
	
	boolean live = true;
	
	int lifeNum = 3;
	
	boolean kingLive = true;
	
	boolean vectory = false;
	
	//定义一个向量，用来访问别的坦克
	Vector<Enemy> enemys = new Vector<Enemy>();
		
	//定义一个向量，用来访问围墙
	Vector<Wall> walls = new Vector<Wall>();
	
	//定义我方另一只坦克
	Me anMe = null;
	
	Vector<Bullet> bullets = new Vector<Bullet>();
	Bullet bullet=null;
	
	public Me(int x,int y) {
		super(x,y);
	}
	//发射子弹的方法
	public void shot() {
		
		switch(this.direction)
		{
			case 0://上
				//创建子弹对象
				bullet = new Bullet(x,y-25,0);
				//把子弹加入Vector向量
				bullets.add(bullet);
				break;
			case 1://下
				bullet = new Bullet(x,y+25,1);
				bullets.add(bullet);
				break;
			case 2://右
				bullet = new Bullet(x+25,y,2);
				bullets.add(bullet);
				break;
			case 3://左
				bullet = new Bullet(x-25,y,3);
				bullets.add(bullet);
				break;
		}
		//启动子弹线程
		Thread bullet2=new Thread(bullet);
		bullet2.start();
	}
	
	//获取Panel中的坦克放入向量中
		public void getTank(Vector<Enemy> eny) {
			this.enemys=eny;
		}
		//获取Panel中的围墙放入向量中
		public void getWall(Vector<Wall> wl) {
			this.walls=wl;
		}
		
		//获取我方另一只坦克
		public void getAnotherMe(Me anMe) {
			this.anMe=anMe;
		}
		
		//判断是否碰到了我方另一只坦克
		public boolean hitanMe() {
			boolean hit = false;
			//0表示向上，1表示向下，2表示向右，3表示向左
			switch(this.direction) {
			case 0:
				if((this.x-anMe.x>-50)&&(this.x-anMe.x<50)&&(this.y-anMe.y==50))
					return true;
				break;
			case 1:
				if((this.x-anMe.x>-50)&&(this.x-anMe.x<50)&&(this.y-anMe.y==-50))
					return true;
				break;
			case 2:
				if((this.y-anMe.y>-50)&&(this.y-anMe.y<50)&&(this.x-anMe.x==-50))
					return true;
				break;
			case 3:
				if((this.y-anMe.y>-50)&&(this.y-anMe.y<50)&&(this.x-anMe.x==50))
					return true;
				break;
			}
			return hit;
		}
		
		//判断是否碰到了别的坦克
		public boolean hitTank() {
			boolean hit = false;
			//0表示向上，1表示向下，2表示向右，3表示向左
			switch(this.direction) {
			case 0:
				for(int i=0;i<enemys.size();i++) {
					Enemy et = enemys.get(i);
					if((this.x-et.x>-50)&&(this.x-et.x<50)&&(this.y-et.y==50))
						return true;
				}
				break;
			case 1:
				for(int i=0;i<enemys.size();i++) {
					Enemy et = enemys.get(i);
					if((this.x-et.x>-50)&&(this.x-et.x<50)&&(this.y-et.y==-50))
						return true;
				}
				break;
			case 2:
				for(int i=0;i<enemys.size();i++) {
					Enemy et = enemys.get(i);
					if((this.y-et.y>-50)&&(this.y-et.y<50)&&(this.x-et.x==-50))
						return true;
				}
				break;
			case 3:
				for(int i=0;i<enemys.size();i++) {
					Enemy et = enemys.get(i);
					if((this.y-et.y>-50)&&(this.y-et.y<50)&&(this.x-et.x==50))
						return true;
				}
				break;
			}
			return hit;
		}
		
		//判断是否碰到了围墙
		public boolean hitWall() {
			boolean hit = false;
			//0表示向上，1表示向下，2表示向右，3表示向左
			switch(this.direction) {
			case 0:
				for(int i=0;i<walls.size();i++) {
					Wall wl = walls.get(i);
					if((this.x-wl.x>-25)&&(this.x-wl.x<75)&&(this.y-wl.y==50))
						return true;
				}
				break;
			case 1:
				for(int i=0;i<walls.size();i++) {
					Wall wl = walls.get(i);
					if((this.x-wl.x>-25)&&(this.x-wl.x<75)&&(this.y-wl.y==-25))
						return true;
				}
				break;
			case 2:
				for(int i=0;i<walls.size();i++) {
					Wall wl = walls.get(i);
					if((this.y-wl.y>-25)&&(this.y-wl.y<50)&&(this.x-wl.x==-25))
						return true;
				}
				break;
			case 3:
				for(int i=0;i<walls.size();i++) {
					Wall wl = walls.get(i);
					if((this.y-wl.y>-25)&&(this.y-wl.y<50)&&(this.x-wl.x==75))
						return true;
				}
				break;
			}
			return hit;
		}
	
	public void moveDown() {
		if(y<=870 && this.hitTank()==false && this.hitWall()==false) {
			if(this.anMe==null) {
				y+=speed;	
			}else if(this.anMe!=null && this.hitanMe()==false) {
				y+=speed;
			}		
		}
	}
	public void moveUp() {
		if(y>=30 && this.hitTank()==false && this.hitWall()==false) {
			if(this.anMe==null) {
				y-=speed;	
			}else if(this.anMe!=null && this.hitanMe()==false) {
				y-=speed;
			}
		}
	}
	public void moveRight() {
		if(x<=1170 && this.hitTank()==false && this.hitWall()==false) {
			if(this.anMe==null) {
				x+=speed;	
			}else if(this.anMe!=null && this.hitanMe()==false) {
				x+=speed;
			}
		}
	}
	public void moveLeft() {
		if(x>=30 && this.hitTank()==false && this.hitWall()==false) {
			if(this.anMe==null) {
				x-=speed;	
			}else if(this.anMe!=null && this.hitanMe()==false) {
				x-=speed;
			}
		}
	}
}

//敌方坦克类，做成线程
class Enemy extends Tank implements Runnable{
	
	boolean live=true;
	
	//定义一个向量，用来访问别的坦克
	Vector<Enemy> enemys = new Vector<Enemy>();
	
	//定义一个向量，用来访问围墙
	Vector<Wall> walls = new Vector<Wall>();
	
	//子弹向量
	Vector<Bullet> bullets = new Vector<Bullet>();
	Bullet bullet=null;
	//发射子弹的方法
		public void shot() {
			
			switch(this.direction)
			{
				case 0://上
					//创建子弹对象
					bullet = new Bullet(x,y-25,0);
					//把子弹加入Vector向量
					bullets.add(bullet);
					break;
				case 1://下
					bullet = new Bullet(x,y+25,1);
					bullets.add(bullet);
					break;
				case 2://右
					bullet = new Bullet(x+25,y,2);
					bullets.add(bullet);
					break;
				case 3://左
					bullet = new Bullet(x-25,y,3);
					bullets.add(bullet);
					break;
			}
			//启动子弹线程
			Thread bullet2=new Thread(bullet);
			bullet2.start();
		}
	
	public Enemy(int x,int y) {
		super(x,y);
	}
	//获取Panel中的坦克放入向量中
	public void getTank(Vector<Enemy> eny) {
		this.enemys=eny;
	}
	//获取Panel中的围墙放入向量中
	public void getWall(Vector<Wall> wl) {
		this.walls=wl;
	}

	//判断是否碰到了别的坦克
	public boolean hitTank() {
		boolean hit = false;
		//0表示向上，1表示向下，2表示向右，3表示向左
		switch(this.direction) {
		case 0:
			for(int i=0;i<enemys.size();i++) {
				Enemy et = enemys.get(i);
				if(et!=this) {
					if((this.x-et.x>-50)&&(this.x-et.x<50)&&(this.y-et.y==50))
						return true;
				}
			}
			break;
		case 1:
			for(int i=0;i<enemys.size();i++) {
				Enemy et = enemys.get(i);
				if(et!=this) {
					if((this.x-et.x>-50)&&(this.x-et.x<50)&&(this.y-et.y==-50))
						return true;
				}
			}
			break;
		case 2:
			for(int i=0;i<enemys.size();i++) {
				Enemy et = enemys.get(i);
				if(et!=this) {
					if((this.y-et.y>-50)&&(this.y-et.y<50)&&(this.x-et.x==-50))
						return true;
				}
			}
			break;
		case 3:
			for(int i=0;i<enemys.size();i++) {
				Enemy et = enemys.get(i);
				if(et!=this) {
					if((this.y-et.y>-50)&&(this.y-et.y<50)&&(this.x-et.x==50))
						return true;
				}
			}
			break;
		}
		return hit;
	}
	
	//判断是否碰到了围墙
	public boolean hitWall() {
		boolean hit = false;
		//0表示向上，1表示向下，2表示向右，3表示向左
		switch(this.direction) {
		case 0:
			for(int i=0;i<walls.size();i++) {
				Wall wl = walls.get(i);
				if((this.x-wl.x>-25)&&(this.x-wl.x<75)&&(this.y-wl.y==50))
					return true;
			}
			break;
		case 1:
			for(int i=0;i<walls.size();i++) {
				Wall wl = walls.get(i);
				if((this.x-wl.x>-25)&&(this.x-wl.x<75)&&(this.y-wl.y==-25))
					return true;
			}
			break;
		case 2:
			for(int i=0;i<walls.size();i++) {
				Wall wl = walls.get(i);
				if((this.y-wl.y>-25)&&(this.y-wl.y<50)&&(this.x-wl.x==-25))
					return true;
			}
			break;
		case 3:
			for(int i=0;i<walls.size();i++) {
				Wall wl = walls.get(i);
				if((this.y-wl.y>-25)&&(this.y-wl.y<50)&&(this.x-wl.x==75))
					return true;
			}
			break;
		}
		return hit;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			if(this.bullets.size()==0) {
				this.shot();			
			}
			
			switch(this.direction) {
				case 0:for(int i=0;i<50;i++){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(y>=30 && this.hitTank()==false && this.hitWall()==false) {
						y-=speed;
					}
				}break;
				case 1:for(int i=0;i<50;i++){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(y<=870 && this.hitTank()==false && this.hitWall()==false) {
						y+=speed;
					}
				}break;
				case 2:for(int i=0;i<50;i++){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(x<=1170 && this.hitTank()==false && this.hitWall()==false) {
						x+=speed;
					}
				}break;
				case 3:for(int i=0;i<50;i++){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(x>=30 && this.hitTank()==false && this.hitWall()==false) {
						x-=speed;
					}
				}break;
			}
			//让敌方坦克产生一个随机方向
			this.direction = (int)(Math.random()*4);
			//如果敌方坦克死亡
			if(this.live == false) {
				break;
			}
		}
	}
}

//子弹类，做成线程
class Bullet implements Runnable{
	int x,y,direction;
	int speed = 25;//子弹速度
	boolean live=true;//判断子弹是否还存活
	public Bullet(int x,int y,int direction) {
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(50);//休息50毫秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(direction) {
				case 0:
					y-=speed;
					break;
				case 1:
					y+=speed;
					break;
				case 2:
					x+=speed;
					break;
				case 3:
					x-=speed;
					break;
			}
			if(x<0||x>1200||y<0||y>900) {
				live=false;
				break;
			}
		}
	}
}

//爆炸类，坦克爆炸效果
class Bomb{
	int x,y;
	int life=9;//子弹刚开始的寿命是9，根据寿命来觉得播放哪张图
	boolean live=true;
	public Bomb(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void lifReduce(){
		if(life>0) {
			life--;
		}else {
			this.live=false;
		}
	}
}
//围墙类
class Wall{
	int x,y;
	int type;//围墙的种类
	boolean live=true;
	public Wall(int x,int y,int type) {
		this.x=x;
		this.y=y;
		this.type=type;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}

//游戏说明消息框
class mesgDialog extends JDialog{
    //在这里定义实例变量
    public mesgDialog(JFrame parent){     //构造方法
	
	    super(parent,"游戏说明",true);    //实现超类的方法
	
	    //现在就可以自己添加代码了，想弄什么上去都可以，设置字体当然也可以啦！
	    JPanel panel=new JPanel();
	    Font font = new Font("微软雅黑",Font.BOLD,30);
	    JLabel jlb05 = new JLabel("我方坦克生命：3");
	    JLabel jlb04 = new JLabel(" ");
	    JLabel jlb03 = new JLabel("敌方坦克数量：18");
	    JLabel jlb02 = new JLabel(" ");
	    JLabel jlb01 = new JLabel("总关卡数：2");
	    JLabel jlb00 = new JLabel(" ");
	    JLabel jlb0 = new JLabel("玩家1：");
	    JLabel jlb1 = new JLabel("                      W：上");
	    JLabel jlb2 = new JLabel("          A：左    S：下    D：右");
	    JLabel jlb3 = new JLabel(" ");
	    JLabel jlb4 = new JLabel("                   F：发射子弹");
	    JLabel jlb5 = new JLabel(" ");
	    JLabel jlb6 = new JLabel("玩家2：");
	    JLabel jlb7 = new JLabel("                        ↑：上");
	    JLabel jlb8 = new JLabel("          ←：左    ↓：下    →：右");
	    JLabel jlb9 = new JLabel(" ");
	    JLabel jlb10 = new JLabel("                   L：发射子弹");
	    jlb05.setFont(font);
	    jlb03.setFont(font);
	    jlb01.setFont(font);
	    jlb0.setFont(font);
	    jlb1.setFont(font);
	    jlb2.setFont(font);
	    jlb4.setFont(font);
	    jlb6.setFont(font);
	    jlb7.setFont(font);
	    jlb8.setFont(font);
	    jlb10.setFont(font);
	    BoxLayout blt = new BoxLayout(panel, BoxLayout.Y_AXIS);
	    panel.setLayout(blt);
	    panel.add(jlb05);
	    panel.add(jlb04);
	    panel.add(jlb03);
	    panel.add(jlb02);
	    panel.add(jlb01);
	    panel.add(jlb00);
	    panel.add(jlb0);
	    panel.add(jlb1);
	    panel.add(jlb2);
	    panel.add(jlb3);
	    panel.add(jlb4);
	    panel.add(jlb5);
	    panel.add(jlb6);
	    panel.add(jlb7);
	    panel.add(jlb8);
	    panel.add(jlb9);
	    panel.add(jlb10);
	    this.add(panel);
	    this.setSize(550, 650);
	    this.setVisible(true);
    }
}