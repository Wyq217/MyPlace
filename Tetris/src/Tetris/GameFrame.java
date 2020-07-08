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
	
    private JMenu game = new JMenu("游戏");//创建菜单对象
    private JMenuItem newGame = game.add("新游戏");//创建菜单项对象
    private JMenuItem pauseGame = game.add("暂停");
    private JMenuItem continueGame = game.add("继续");
    private JMenuItem exitGame = game.add("退出");
    
    
    
    private JMenu help = new JMenu("帮助");
    private JMenuItem about = help.add("关于");
    tetrisblock gamePanel = new tetrisblock();
    
    public GameFrame()//构造函数
    {
    	addKeyListener(gamePanel);
    	newGame.addActionListener(this);
    	exitGame.addActionListener(this);
    	pauseGame.addActionListener(this);
    	continueGame.addActionListener(this);
    	about.addActionListener(this);
    	
    	this.add(gamePanel);
    	
    	JMenuBar menu = new JMenuBar();//创建菜单栏
    	menu.add(game);
    	menu.add(help);
    	this.setJMenuBar(menu);
    	
    	this.setTitle("Tetris内测版");
    	this.setBounds(50,10,500,500);
    	this.setVisible(true);//可见
    	this.setLocation(650,200);//设置窗口相对于指定组件的位置（屏幕中央）
    	this.setResizable(false);//设置窗口可以被用户调整大小
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    		

public void actionPerformed(ActionEvent e)
{
	if(e.getSource() == newGame)//游戏重新开始
	{
	gamePanel.NewGame();
	}
	if(e.getSource() == exitGame)//游戏退出
	{
	System.exit(0);
	}
	if(e.getSource() == pauseGame)//游戏暂停
	{
	gamePanel.pauseGame();
	}
	if(e.getSource() == continueGame)//游戏继续
	{
	gamePanel.continueGame();
	}
	if(e.getSource() == about)//关于游戏信息
	{
	JOptionPane.showMessageDialog(null, "左右键移动，向上旋转", "提示", JOptionPane.INFORMATION_MESSAGE);
	}
}
    public static void main(String[] args) {
    new GameFrame();
    }
}
    
    
    
