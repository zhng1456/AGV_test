package com.wang.core;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Client extends Frame{
	//����
		int x=50;
		int y=50;
		//ÿ��һ��ʱ���ػ�һ�Σ���tank�ƶ�,���߳���ʵ��
		private class PaintThread implements Runnable{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//���õ����ⲿ��װ���repaint
				while(true){
					repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		@Override
		public void paint(Graphics g) {
			//ȡ��ԭ�ȵ���ɫ
			Color c=g.getColor();
			g.setColor(Color.RED);
			//ָ������,������Բ
			g.fillOval(x,y,30,30);
			//�ָ�
			g.setColor(c);
			y+=5;
		}
	public void lauchFrame(){
		this.setLocation(400,300);//�������Ͻǵ�λ��
		this.setSize(1600,1200);//���ڴ�С
		this.setTitle("AGV Client");
		//���ü����¼�������������ʵ��
		this.addWindowListener(new WindowAdapter(){
			//��д�رմ��ڵ�ʱ��
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//ֱ���˳� 
			}

		});
		//������ı䴰�ڴ�С
		this.setResizable(false);
		setVisible(true);
		initSystemMenu(this);//����ϵͳ�˵�
		//�����߳�
		new Thread(new PaintThread()).start();
	}
private void initSystemMenu(Client client) {
		// TODO Auto-generated method stub
		MenuBar mBar = new MenuBar();
		//����operation��
		Menu file = new Menu("operation");
		//��ȡ��ͼ��item
		MenuItem newItem = new MenuItem("read map");
		//���е�item
	    MenuItem saveItem = new MenuItem("run");
	    //��ÿ��item��ӽ�ȥ
	    file.add(newItem);
	    file.add(saveItem);
	    mBar.add(file);
	    //���˵�����ӽ�frame
	    client.setMenuBar(mBar);
	}
public static void main(String[] args) {
	Client c = new Client();
	c.lauchFrame();
}
}
