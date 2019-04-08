import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.applet.*;

public class SwingTest extends JFrame implements ActionListener{
  JLabel label;
  AudioClip test2 = Applet.newAudioClip(getClass().getResource("test.wav"));

  public static void main(String[] args){
    SwingTest test = new SwingTest("SwingTest");
    test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    test.setVisible(true);
  }

  SwingTest(String title){
    setTitle(title);
    setBounds( 10, 10, 300, 200);

    label = new JLabel("");
    label.setHorizontalAlignment(JLabel.CENTER);

    JButton btn1 = new JButton("Button 1");
    btn1.addActionListener(this);
    btn1.setActionCommand("Button 1");

    JButton btn2 = new JButton("Button 2");
    btn2.addActionListener(this);
    btn2.setActionCommand("Button 2");

    JPanel p = new JPanel();
    p.add(btn1);
    p.add(btn2);

    getContentPane().add(p, BorderLayout.CENTER);
    getContentPane().add(label, BorderLayout.PAGE_END);
  }

  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();

    if (cmd.equals("Button 1")){
      test2.play();
    }else if (cmd.equals("Button 2")){
      label.setText("ボタン2が押されました");
    }
  }
}
