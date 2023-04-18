package com.niit.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame3 extends JFrame implements KeyListener {
    public MyFrame3(){
        this.setSize(600,600);
        this.setTitle("拼图游戏");
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        //给整个窗体添加键盘监听
        //调用这this:表示本类对象,当前的界面对象,表示要给整个界面添加键盘监听
        //参数this:当事件被触发后,会执行本类中的对应代码
        this.addKeyListener(this);



        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下按键");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");

        //获取键盘上每个按键的编号
        int code = e.getKeyCode();
        System.out.println(code);
    }
}
