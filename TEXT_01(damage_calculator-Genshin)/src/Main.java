import com.hezekiah.ui.MainJFrame;

public class Main {
    public static void main(String[] args) {
        try {
            new MainJFrame();  // 创建主界面
        } catch (Exception e) {
            e.printStackTrace();  // 错误处理
        }
    }
}
