package com.niit.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(603, 680);
        jFrame.setTitle("事件演示");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setAlwaysOnTop(true);
        jFrame.setLayout(null);


        //创建一个按钮对象
        JButton jButton = new JButton("点击");
        jButton.setBounds(0, 0, 100, 50);
        //给按钮添加动作监听(动作监听包含两部分:鼠标左键点击,和键盘空格按键)
        //传递的参数表示事件发生时要执行的代码
//        jButton.addActionListener(new MyActionListener());
//        使用匿名内部类简化代码,可以不用创建那些只需要使用一次的类或接口
        jButton.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          Random r = new Random();
                                          jButton.setLocation(r.nextInt(500),r.nextInt(500));
                                      }
                                  }
        );


        jFrame.getContentPane().add(jButton);


        jFrame.setVisible(true);
    }
}
