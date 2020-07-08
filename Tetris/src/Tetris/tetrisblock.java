package Tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class tetrisblock extends JPanel implements KeyListener {

  int[][] map = new int[13][23];//��ŵ�ͼ��Ϣ
    private int score = 0;
 
  //������״���ͺ���״״̬
    private int shapeType = -1;
    private int shapeState = -1;
    private int nextShapeType = -1;
    private int nextShapeState = -1;
    
    //int mark = 0;
    //������Ϣ
    private int posx = 0;
    private int posy = 0;
    
    private Timer timer;//��ʱ����
    Random random = new Random();
    
    int i = 0;
    int j = 0;
    int flag = 0;
   //�Ѵ洢��ͼ�񿴳���һ��4X4�Ķ�ά����
    private int rowRect = 4;
    private int colRect = 4;
    // �������״ ��һ�������������S��Z��L��J��I��O��T 7�� �ڶ��� ������ת���� ��������Ϊ �������
    private final int shapes[][][] = new int[][][] {
      //����ʱ��˳��洢
    // i
            {       { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
                    { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } },
            // s
            { 
                    { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } },
            // z
            { 
                    { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } },
            // j
            { 
                    { 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                    { 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
            // o
            { 
                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
            // l
            { 
                    { 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
            // t
            { 
                    { 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 } } 
};


public tetrisblock(){//���캯����������ͼ
  createBlock();
  newmap();
  //drawWall();
    timer = new Timer(1000, new TimerListener());//ÿ��1s��ʱһ��
  timer.start();
}
    
  //��Ԥ��Ƶ�ʴ���ActionEvent�¼���ʵ�ֶ�̬Ч��
class TimerListener implements ActionListener{
  public void actionPerformed(ActionEvent e)
   {
   down();
   }
}
     
public void newmap() {
  for(i=0;i<12;i++) {
    for(j=0;j<22;j++) {
      if(i==11||i==0) {
      map[11][j] = 2;
      map[0][j] = 2;
      }
      else
      map[i][j]=0;
    }
    map[i][21] = 2;
  }
}
/*
public void newmap() {
  for(i=0;i<12;i++) {
    for(j=0;j<22;j++) {
      map[i][j]=0;
    }
  }
}
   
public void drawWall() {
  for (i = 0; i < 12; i++) {
      map[i][21] = 2;
   }
   for (j = 0; j < 22; j++) {
      map[11][j] = 2;
      map[0][j] = 2;
   }
}
*/
public void createBlock()//��������---�����ǰ�ķ������ͺ�״̬�����ھ�������һ�εģ���������ھ����õ�ǰ�Ĳ���������һ�ε�״̬������
{
  if(shapeType == -1 && shapeState == -1)//��ǰ�ķ���״̬��Ϊ-1����ʾ��Ϸ�ſ�ʼ
  {
  shapeType = random.nextInt(shapes.length);
  shapeState = random.nextInt(shapes[0].length);
  }
  else
  {
  shapeType = random.nextInt(shapes.length);
  shapeState = random.nextInt(shapes[0].length);
  }
  //nextShapeType = random.nextInt(shapes.length);
  //nextShapeState = random.nextInt(shapes[0].length);
  posx = 4; 
  posy = 0;//����Ϸ�����м䴴������
  
  if(GameOver(posx,posy,shapeType,shapeState))
  {
    int value=JOptionPane.showConfirmDialog(null, "�����ˣ�����һ����?", "��ʾ", JOptionPane.OK_OPTION);//��Ϣ��ʾ��
//    System.exit(0);
    if(value==JOptionPane.YES_OPTION) {
      NewGame();
//      newmap();
//      drawWall();
//      score = 0;
    }
    else 
      System.exit(0);
  } 

}
     
//�ж��Ƿ�����ƶ�
public boolean judgeMove(int x, int y, int shapeType, int shapeState) {
  for (int a = 0; a < rowRect; a++) {
    for (int b = 0; b < colRect; b++) {
            if (((shapes[shapeType][shapeState][a * 4 + b] == 1) && (map[x + b + 1][y + a] == 1))
                    || ((shapes[shapeType][shapeState][a * 4 + b] == 1) && (map[x + b + 1][y + a] == 2))) {
              return false;
            }                   
        }
    }
    return true;
}
  

public boolean GameOver(int x, int y, int ShapeType, int ShapeState)//�ж���Ϸ�Ƿ����
{
  if(judgeMove(x,y,ShapeType,ShapeState))
  return false;
  
  return true;
}

public void turn() {
  int temshapeState=shapeState;//���浱ǰ״̬
  shapeState=(shapeState+1)%4;//��һ��״̬
  //�ж��Ƿ���Ա���
  if(!judgeMove(posx,posy,shapeType,shapeState)) {
    shapeState=temshapeState;//���ܱ���
  }
  repaint();
}

public void left() {
  if(judgeMove(posx-1,posy,shapeType,shapeState))
      posx--;
  repaint();
}
public void right() {
    if (judgeMove(posx + 1, posy, shapeType, shapeState)) {
        posx++;
    }
    ;
    repaint();
}
//ɾ��
public void delline() {
    int count = 0;
    for (int j = 0; j < 22; j++) {
        for (int i = 0; i < 12; i++) 
            if (map[i][j] == 1) 
                count++;
                if (count == 10) {
                    score += 10;
                    for (int p = j; p>0 ;p--) {
                        for (int k = 0; k < 11; k++) {
                            map[k][p] = map[k][p-1];
                        }
                    }
                }
        count = 0;
    }
    //mark =2;
}
//ͼ�ε���
public void add(int x, int y, int shapeType, int shapeState) {
    int k = 0;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if (map[x + j + 1][y + i] == 0) {
                map[x + j + 1][y + i] = shapes[shapeType][shapeState][k];
            }
            k++;
        }
    }
}

//ͼ������
public void down() {
    if (judgeMove(posx, posy + 1, shapeType, shapeState)) {
        posy++;
    }
    if (!judgeMove(posx, posy + 1, shapeType, shapeState)) {
      
        add(posx, posy, shapeType, shapeState);
        delline();
        createBlock();
    }
    repaint();
}  


public void paintComponent(Graphics g) {
  super.paintComponent(g);
  g.setColor(new Color(135, 206, 235));
  g.fillRect(0, 0, 500, 500);
  for(j=0;j<16;j++) {
        for (i = 0; i < 16; i++) {
            if (shapes[shapeType][shapeState][j] == 1) {
              g.setColor(Color.cyan);
                g.fillRect((j % 4 + posx + 1) * 20, (j / 4 + posy) * 20, 20, 20);
              g.setColor(Color.black);
                g.drawRect((j % 4 + posx + 1) * 20, (j / 4 + posy) * 20, 20, 20);
                
            }
        }
  }
   for (j = 0; j < 22; j++) {
         for (i = 0; i < 12; i++) {
             if (map[i][j] == 1) {
               g.setColor(Color.ORANGE);
                 g.fillRect(i * 20, j * 20, 20, 20);//x,y,width,height
                 g.setColor(Color.BLACK);
                 g.drawRect(i * 20, j * 20, 20, 20);//x,y,width,height
             }
             if (map[i][j] == 2) {
               g.setColor(new Color(240, 128, 128));
                 g.fillRect(i * 20, j * 20, 20, 20);

             }
         }
     }
   g.setFont(new Font("����Ͱ��ջ��� B", Font.BOLD, 40));
   g.setColor(new Color(30, 144, 255));
     g.drawString("����˹����", 250, 40);
     g.setFont(new Font("ROSEWOODSTD-REGULAR", Font.ITALIC, 35));
   g.setColor(new Color(255, 0, 255));
   g.drawString("score", 310, 150);
   g.drawString(""+score, 340, 200);
   g.setFont(new Font("��ͼС����", Font.PLAIN, 30));
   g.setColor(new Color(255, 69, 0));
   g.drawString("Designed by", 290, 300);
   g.drawString("��Ԫ�� ��С��", 270, 350);

}

public void NewGame()//��Ϸ���¿�ʼ
{
  score = 0;
  newmap();
  //drawWall();
  createBlock();
  repaint();
}

public void pauseGame()//��Ϸ��ͣ
{
  timer.stop();
}

public void continueGame()//��Ϸ����
{
  timer.start();
}

public void keyPressed(KeyEvent e) {//���̲���
    switch (e.getKeyCode()) {
    case KeyEvent.VK_DOWN:
        down();
        break;
    case KeyEvent.VK_UP:
        turn();
        break;
    case KeyEvent.VK_RIGHT:
        right();
        break;
    case KeyEvent.VK_LEFT:
        left();
        break;
    }
      
}

@Override
public void keyTyped(KeyEvent e) {
  // TODO �Զ����ɵķ������
  
}

@Override
public void keyReleased(KeyEvent e) {
  // TODO �Զ����ɵķ������
  
}


public void clear() {
  int score = 0;
  int mark = 0;
  int shapeState = -1;
  int shapeType = -1;
  int nextShapeState = -1;
  int nextShapeType = -1;
  
  int posx= 0,posy=0 ;
  int i = 0;
  int j = 0;
  
  int falg = 0;
}


/*
//ÿ��1s�Զ�����
class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (judgeMove(posx, posy + 1, shapeType, shapeState)) {
            posy++;
            delline();
        }
        
        if (!judgeMove(posx, posy + 1, shapeType, shapeState)) {
            if (flag == 1) {
                add(posx, posy, shapeType, shapeState);
                delline();
                createBlock();
                flag = 0;
            }
            flag = 1;
        }
        
    }
}*/
}