package Tetris;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements ActionListener{
	
    private JMenu game = new JMenu("��Ϸ");//�����˵�����
    private JMenuItem newGame = game.add("����Ϸ");//�����˵������
    private JMenuItem pauseGame = game.add("��ͣ");
    private JMenuItem continueGame = game.add("����");
    private JMenuItem exitGame = game.add("�˳�");
    
    
    
    private JMenu help = new JMenu("����");
    private JMenuItem about = help.add("����");
    tetrisblock gamePanel = new tetrisblock();
    
    public GameFrame()//���캯��
    {
    	addKeyListener(gamePanel);
    	newGame.addActionListener(this);
    	exitGame.addActionListener(this);
    	pauseGame.addActionListener(this);
    	continueGame.addActionListener(this);
    	about.addActionListener(this);
    	
    	this.add(gamePanel);
    	
    	JMenuBar menu = new JMenuBar();//�����˵���
    	menu.add(game);
    	menu.add(help);
    	this.setJMenuBar(menu);
    	
    	this.setTitle("Tetris�ڲ��");
    	this.setBounds(50,10,500,500);
    	this.setVisible(true);//�ɼ�
    	this.setLocation(650,200);//���ô��������ָ�������λ�ã���Ļ���룩
    	this.setResizable(false);//���ô��ڿ��Ա��û�������С
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    		

public void actionPerformed(ActionEvent e)
{
	if(e.getSource() == newGame)//��Ϸ���¿�ʼ
	{
	gamePanel.NewGame();
	}
	if(e.getSource() == exitGame)//��Ϸ�˳�
	{
	System.exit(0);
	}
	if(e.getSource() == pauseGame)//��Ϸ��ͣ
	{
	gamePanel.pauseGame();
	}
	if(e.getSource() == continueGame)//��Ϸ����
	{
	gamePanel.continueGame();
	}
	if(e.getSource() == about)//������Ϸ��Ϣ
	{
	JOptionPane.showMessageDialog(null, "���Ҽ��ƶ���������ת", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
	}
}
    public static void main(String[] args) {
    new GameFrame();
    }
}
    
    
    
