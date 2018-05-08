//Tetris.java
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tetris extends JFrame implements ActionListener, KeyListener{
	/*
	 * 7�ֲ�ͬ�ķ��飬ÿ�ַ�������״̬
	 */
	 private final int block[][][] = new int[][][]{
         // I
         {{0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
          {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}},
         // S
         {{0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
          {0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}},
         // Z
         {{1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
          {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}},
         // J
         {{0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
          {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
          {1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
         // O
         {{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
         // L
         {{1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
          {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
          {0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
         // T
         {{0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
          {1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0}}};
          
    int Map[][] = new int[23][13];  //��¼��ͼ���������
    int ColorMap[][] = new int[23][13];    //��¼��ͼ�������ɫ
    Color ColorType[] = {Color.pink, Color.orange, Color.green,
    		             Color.gray, new Color(10, 14, 41)};   //5�ֲ�ͬ����ɫ
    int Speed = 800;  //����������ٶ�
    int Side = 25;    //С���������
    Timer timer;     //һ���߳�
    boolean YON = false; //�ж���Ϸ�Ƿ��ڽ�����
    /*
     * ��Ϸ������
     */
    int GType;   //���ͣ���7��
    int GState;  //һ�����͵�״̬��һ��������4��״̬
    int GColor;  //�������ɫ
    int X;       //�����X����
    int Y;       //�����Y����
    Board Gboard; //��Ϸ���
    /*
     * ��ʾ������
     */
    int TType;   //���ͣ���7��
    int TState;  //һ�����͵�״̬��һ��������4��״̬
    int TColor;  //��һ���������ɫ
    TBoard Tboard;  //��ʾ���
    
    JLabel LLevel;  //�ȼ���ǩ
    JLabel LScore;  //�÷ֱ�ǩ
    JButton Start; //��ʼ����ͣ��ť
    JButton Stop;  //ֹͣ��ť
    JButton Up;    //������εİ�ť
    JButton Down;  //�������°�ť
    JButton Left;  //��������ť
    JButton Right; //�������Ұ�ť
    int Level = 0;
    int Score = 0;
    
    public Tetris(){
    	Gboard = new Board();
    	Tboard = new TBoard();
    	Start = new JButton("开始");
    	Stop = new JButton("停止");
    	Up = new JButton("上");
    	Down = new JButton("下");
    	Left = new JButton("左");
    	Right = new JButton("右");
    	LLevel = new JLabel("等级: 0");
    	LScore = new JLabel("分数: 0");
    	timer = new Timer(Speed, new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
                if (isCan(X, Y + 1)) {
                    //����һ��
                    Y++; 
                    Gboard.repaint();
                } else {
                    SaveBlock(X, Y);
                    DeleteLine();
                    CreateBlock();
                    Tboard.repaint();
                }
            }
    	});
    }
    
    /*
     * ��Ϸ�����ʼ��
     */
    public void InitView(){
    	this.setLayout(null); //����ֲ�
        Gboard.setBounds(0, 0, 300, 550);     //��Ϸ����λ�úʹ�С
        Tboard.setBounds(425, 30, 100, 100);  //��ʾ����λ�úʹ�С
        LLevel.setBounds(650, 40, 100, 30);   //�ȼ���ǩλ�úʹ�С
        LScore.setBounds(650, 80, 100, 30);   //�÷ֱ�ǩλ�úʹ�С
        Start.setBounds(650, 370, 100, 40);   //��ʼ����ͣ��ťλ�úʹ�С
        Stop.setBounds(650, 445, 100, 40);    //ֹͣ��ťλ�úʹ�С
        Up.setBounds(445,360,65,65);
        Down.setBounds(445,425,65,65);
        Left.setBounds(380,425,65,65);
        Right.setBounds(510,425,65,65);
        Up.addActionListener(this);
        Down.addActionListener(this);
        Left.addActionListener(this);
        Right.addActionListener(this);
        Start.addActionListener(this);
        Stop.addActionListener(this);
        Gboard.addKeyListener(this);
        Gboard.setFocusable(true);
        this.add(Gboard);
        this.add(Tboard);
        this.add(LLevel);
        this.add(LScore);
        this.add(Start);
        this.add(Stop);
        this.add(Up);
        this.add(Down);
        this.add(Right);
        this.add(Left);
        InitMapData(); //��ʼ����Ϸ��ͼ������
    }
    
    /*
     * ��Ϸ��ͼһЩ���ݵĳ�ʼ��
     */
    public void InitMapData(){
        for(int i = 0; i < 22; i++)
        	for(int j = 0; j < 12; j++)
        	{
        		Map[i][j] = 0;
        		ColorMap[i][j] = 4;
        	}
        for(int i = 0; i < 12; i++)
        {
        	Map[21][i] = 2;
        	ColorMap[0][i] = 3;
        	ColorMap[21][i] = 3;
        }
        for(int i = 0; i < 22; i++)
        {
        	Map[i][0] = 2;
        	Map[i][11] = 2;
        	ColorMap[i][0] = 3;
        	ColorMap[i][11] = 3;
        }
    }
    /*
     * �жϷ����Ƿ񵽴�߽��ѻ���
     */
    public boolean isCan(int x, int y){
    	for(int i = 0; i < 4; i++)
    		for(int j = 0; j < 4; j++)
    		{
    			if(block[GType][GState][i*4+j] == 1 && 
    			  (Map[y+i][x+j+1] == 1 || Map[y+i][x+j+1] == 2)){
    				return false;}
    		}
    	return true;
    }
    
    /*
     * ��Ϸ���
     */
    class Board extends JPanel{
	    public void paint(Graphics g){
	    	for(int i = 0; i < 22; i++)
	    		for(int j = 0; j < 12; j++)
	    			switch(Map[i][j])
	    			{
	    			case 0:g.setColor(ColorType[4]);
	    				   g.fill3DRect(j * Side, i * Side, Side, Side, true);
	    				   break;
	    			case 1:g.setColor(ColorType[ColorMap[i][j]]);
	    			       g.fill3DRect(j * Side, i * Side, Side, Side, true);
	    			       break;
	    			case 2:g.setColor(ColorType[3]);
	    			       g.fill3DRect(j * Side, i * Side, Side, Side, true);
	    			       break;
	    			}
	    	if(YON)
	    	{
	    		for(int i = 0; i < 16; i++)
	    			if(block[GType][GState][i] == 1){
	    			g.setColor(ColorType[GColor]);
	    			g.fill3DRect((i % 4 + X + 1) * Side, (i / 4 + Y) * Side, Side, Side, true);
	    		}
	    	}
	    	for(int i = 0; i < 12; i++){
	    	g.setColor(ColorType[3]);
	    	g.fill3DRect(i * Side, 0, Side, Side, true);
	    	}
	    }
    }
    
    /*
     * ��ʾ���
     */
    class TBoard extends JPanel{
    	public void paint(Graphics g){
    		for(int i = 0; i < 16; i++)
    			{
    				if(block[TType][TState][i] == 1 && YON){
    					g.setColor(ColorType[TColor]);
    				    g.fill3DRect((i % 4) * Side, (i / 4) * Side, Side, Side, true);
    				}
    				else{
    				g.setColor(ColorType[3]);
    				g.fill3DRect((i % 4) * Side, (i / 4) * Side, Side, Side, true);
    				}
    			}
    	}
    }
    
    /*
     * (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     * �������԰�ť�Ĳ���ʵ�ִ���
     */
    @Override
	public void actionPerformed(ActionEvent e) {
    	JButton button = (JButton)e.getSource();
		if(button == Start)
		{
			if(YON)
			{
				if(button.getText().equals("开始"))
				{
					Start.setText("暂停");
			        timer.start();
				}
				else{
					Start.setText("开始");
					timer.stop();
				}
			}
			else
			{
				Start.setText("暂停");
				TType = (int)((Math.random() * 1000) % 7);
				TState = (int)((Math.random() * 1000) % 4);
				TColor = (int)((Math.random() * 1000) % 3);
				YON = true;
				InitMapData();
				CreateBlock();
				this.repaint();
				timer.start();
			}
		}
		else if(button == Up)
		{
			int state = GState;
            GState = (GState + 1) % 4;
            if(!isCan(X, Y))
            	GState = state;
		}
		else if(button == Down)
		{
			if(isCan(X, Y+1))
                Y++;
                else{
              	  SaveBlock(X, Y);
              	  DeleteLine();
              	  CreateBlock();
                }
		}
		else if(button == Left)
		{
			if(isCan(X-1, Y)){
                X--;}
		}
		else if(button == Right)
		{
			if(isCan(X+1, Y))
                X++;
		}
		else{
			Start.setText("开始");
			LLevel.setText("等级:0");
			LScore.setText("分数:0");
			Score = 0;
			Level = 0;
			timer.stop();
			YON = false;
		}
		Up.setFocusable(false);
		Down.setFocusable(false);
		Left.setFocusable(false);
		Right.setFocusable(false);
		Start.setFocusable(false);
		Stop.setFocusable(false);
		Gboard.setFocusable(true);
	}
    
	/*
	 * �����ϵĲ�����ʵ��
	 */
	public void keyPressed(KeyEvent e) {
		if(Start.getText().equals("暂停"))
		{
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_DOWN:if(isCan(X, Y+1))
				                  Y++;
			                      else{
			                    	  SaveBlock(X, Y);
			                    	  DeleteLine();
			                    	  CreateBlock();
			                      }
			                      break;
			case KeyEvent.VK_LEFT:if(isCan(X-1, Y)){
				                  X--;}
			                      break;
			case KeyEvent.VK_RIGHT:if(isCan(X+1, Y))
				                   X++;
			                       break;
			case KeyEvent.VK_UP:int state = GState;
			                    GState = (GState + 1) % 4;
			                    if(!isCan(X, Y))
			                    	GState = state;
			                    break;
			}
		}
		Gboard.repaint();
	}
	/*
	 * �����µķ���
	 */
	public void CreateBlock(){
		if(!isOver(4, 0)){
		GType = TType;
		GState = TState;
		GColor = TColor;
		TType = (int)((Math.random() * 1000) % 7);
		TState = (int)((Math.random() * 1000) % 4);
		TColor = (int)((Math.random() * 1000) % 3);
		X = 4;
		Y = 0;
		this.repaint();
		}
		else
		{
			Start.setText("��ʼ");
			timer.stop();
            YON = false;
            JOptionPane.showMessageDialog(null, "GAME OVER");
		}
	}
	
	/*
	 * ��������ķ���
	 */
	public void SaveBlock(int x, int y){
		int k = 0;
		for(int i = 0; i < 4; i++)
		   for(int j = 0; j < 4; j++){
			   if(Map[y+i][x+j+1] == 0)
			   {
				   Map[y+i][x+j+1] = block[GType][GState][k];
				   ColorMap[y+i][x+j+1] = GColor;
			   }
			   k++;
		   }
	}
    
	/*
	 * ���к͵÷�
	 */
	public void DeleteLine(){
		int i,j,k=0;
		for(i = 20; i > 0; i--){
			for(j = 1; j < 12; j++)
			{
				if(Map[i][j] == 1)
					k++;
				else
					break;
			}
			if(k == 10)
			{
				Score = 10 + Score;
                Level = Score / 100 + 1;
                timer.setDelay(Speed - Level * 20);
                LScore.setText("分数：" + Score);
                LLevel.setText("等级：" + Level);
				for(int a = i; a > 0; a--)
					for(int b = 1; b < 11; b++)
					{
						Map[a][b] = Map[a-1][b];
						ColorMap[a][b] = ColorMap[a-1][b]; 
					}
				i++;
			}
			k = 0;
		}
	}
	
	/*
	 * �ж���Ϸ�Ƿ����
	 */
	public boolean isOver(int x,int y){
		if(isCan(x,y))
			return false;
		return true;
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
