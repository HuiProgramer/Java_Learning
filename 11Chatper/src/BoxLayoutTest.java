import javax.swing.*;
import java.awt.*;

public class BoxLayoutTest {
    private Frame f = new Frame("测试");
    public void init(){
        f.setLayout(new BoxLayout(f,BoxLayout.Y_AXIS));
        //下面的按钮将会垂直排列
        f.add(new Button("第一个按钮"));
        f.add(new Button("第二个按钮"));
        f.pack();
        f.setVisible(true);
    }
    public static void main(String [] args){
        new BoxLayoutTest().init();
    }
}
