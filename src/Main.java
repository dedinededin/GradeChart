
import java.io.IOException;
import javax.swing.JFrame;

public class Main extends JFrame {

    public Main() throws IOException {
        setVisible(true);
        setSize(1600, 500);
        setTitle("GradeChart");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        TextToBar t=new TextToBar("data.txt");
        getContentPane().add(t);
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
