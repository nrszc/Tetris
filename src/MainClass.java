import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

//MainClass.java
public class MainClass {
     public static void main(String[] args)
     {
    	 try
    	    {
    	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
    	    }
    	    catch(Exception e)
    	    {
    	    	 e.printStackTrace();
    	    }
    	 try
    	    {
    	        //���ñ����Խ��ı䴰�ڱ߿���ʽ����
    	        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
    	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
    	    }
    	    catch(Exception e)
    	    {
    	    	 e.printStackTrace();
    	    }
    	 UIManager.put("RootPane.setupButtonVisible", false);
    	 Tetris tetris = new Tetris();
    	 tetris.InitView();
    	 tetris.setResizable(false);
    	 tetris.setBounds(600,200,0,0);
    	 tetris.setPreferredSize(new Dimension(800 , 584));
    	 tetris.setTitle("俄罗斯方块");
    	 tetris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    	 tetris.pack();
    	 tetris.setVisible(true);
     }
}
