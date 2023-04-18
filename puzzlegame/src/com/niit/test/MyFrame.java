package com.niit.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame implements MouseListener {


    public MyFrame(){
        this.setSize(600,600);
        this.setTitle("拼图游戏");
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setAlwaysOnTop(true);
        JButton jtb1 = new JButton("点击");
        JButton jtb2 = new JButton("click");
        jtb1.setBounds(0,0,100,50);
        jtb1.addMouseListener(this);
        this.getContentPane().add(jtb1);
        this.setVisible(true);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
