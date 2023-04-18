package com.niit.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //创建一个二维数组
    int[][] data = new int[4][4];
    //记录空白方块在二位数组中的位置
    int x = 0;
    int y = 0;
    int r = 1;
    //定义一个变量,记录当前展示的图片的路径
    String path = "puzzlegame\\image\\girl\\girl" + r + "\\";
    //定义一个变量用于统计游戏的步数
    int step = 0;
    //定义一个二位数组,存储正确的数据
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");

    JMenuItem accountItem = new JMenuItem("公众号");

    public GameJFrame() {
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据(打乱图片顺序)
        initData();

        //初始化图片(根据打乱顺序的图片加载页面)
        initImage();

        //界面默认是隐藏的,要调用visible方法
        this.setVisible(true);

    }

    private void initData() {
        int[] tmpArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //打乱数组顺序
        Random r = new Random();
        for (int i = 0; i < tmpArr.length; i++) {
            int index = r.nextInt(tmpArr.length);
            int temp = tmpArr[i];
            tmpArr[i] = tmpArr[index];
            tmpArr[index] = temp;
        }
        //将打乱后的数据依次添加到二维数组中
        for (int i = 0; i < tmpArr.length; i++) {
            if (tmpArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tmpArr[i];

        }
    }

    private void initImage() {
        this.getContentPane().removeAll();

        if (victory()) {
            JLabel win = new JLabel(new ImageIcon("\\image\\win.png"));
            win.setBounds(203, 238, 197, 73);
            this.getContentPane().add(win);
        }

        JLabel stepJlabel = new JLabel("步数" + step);
        stepJlabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepJlabel);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel jLabel = new JLabel(new ImageIcon(path + data[i][j] + ".jpg"));
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                //0:表示让图片突起
                //1:表示让图片凹陷
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jLabel);
            }
        }
        //先加载的图片会在最上方,把后加载的图片覆盖住
        ImageIcon background = new ImageIcon("puzzlegame\\image\\background.png");
        JLabel bg = new JLabel(background);
        bg.setBounds(40, 40, 508, 560);
        this.getContentPane().add(bg);

        this.getContentPane().repaint();

    }


    private void initJMenuBar() {
        //初始化菜单
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单上面的选项
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changeMenu = new JMenu("切换图片");
        //创建选项下面的条目对象

        //将每一个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        functionJMenu.add(changeMenu);

        changeMenu.add(girl);
        changeMenu.add(animal);
        changeMenu.add(sport);

        aboutJMenu.add(accountItem);


        //将菜单添中的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);


        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
    }

    private void initJFrame() {
        //设置界面宽高
        this.setSize(603, 680);
        //设置界面的标题
        this.setTitle("拼图单机版");
        //设置界面指定
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置游戏的关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认的布局居中放置,只有取消了,布局才能按照坐标轴的形式添加组件
        this.setLayout(null);
        //给整个页面添加一个键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();

            JLabel all = new JLabel(new ImageIcon(path + "\\all.jpg"));

            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            ImageIcon background = new ImageIcon("puzzlegame\\image\\background.png");
            JLabel bg = new JLabel(background);
            bg.setBounds(40, 40, 508, 560);
            this.getContentPane().add(bg);

            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //对上,下,左,右进行判断
        //左:37; 上:38; 右:39; 下:40

        if (victory()) {
            return;
        }

        int code = e.getKeyCode();
        if (code == 37) {
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            initImage();
        } else if (code == 38) {
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;

            initImage();
        } else if (code == 39) {
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;

            initImage();
        } else if (code == 40) {
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;

            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
        }


    }

    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前被点击的条目对象
        Object obj = e.getSource();
        if (obj == replayItem) {
            //计步器清零
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载数据
            initImage();

        } else if (obj == reLoginItem) {
            //关闭当前游戏界面
            this.setVisible(false);
            //打开登陆界面
            new LoginJFrame();
        } else if (obj == closeItem) {
            //直接关闭虚拟机即可
            System.exit(0);
        } else if (obj == accountItem) {
            //创建一个弹窗对象
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("puzzlegame\\image\\about.png"));
            jLabel.setBounds(0, 0, 258, 258);
            //把图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //给弹框设置大小
            jDialog.setSize(344, 344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            //弹窗不关闭,则无法使用其他功能
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if (obj == girl) {
            Random x = new Random();
//                String path = "puzzlegame\\image\\girl\\girl"+r+"\\";
            path = "puzzlegame\\image\\girl\\girl" + (x.nextInt(13) + 1) + "\\";
            //计步器清零
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载数据
            initImage();

        } else if (obj == animal) {
            Random x = new Random();
//                String path = "puzzlegame\\image\\girl\\girl"+r+"\\";
            path = "puzzlegame\\image\\animal\\animal" + (x.nextInt(13) + 1) + "\\";
            //计步器清零
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载数据
            initImage();
        } else if (obj == sport) {
            Random x = new Random();
//                String path = "puzzlegame\\image\\girl\\girl"+r+"\\";
            path = "puzzlegame\\image\\sport\\sport" + (x.nextInt(13) + 1) + "\\";
            //计步器清零
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载数据
            initImage();
        }
    }
}
