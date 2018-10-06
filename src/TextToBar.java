import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JPanel;

public class TextToBar extends JPanel {

    public TextToBar(String file) throws IOException {

        setLayout(new GridLayout(0, 1, 0, 0));
        setBackground(Color.BLACK);
        // Open the file
        FileInputStream fstream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            String[] data = strLine.split(",");

            String name= data[0];
            String[] valName=new String[data.length-1];
            int[] value=new int[data.length-1];

            for (int i = 1; i < data.length; i++) {
                String[] dict=data[i].split(":");
                valName[i-1]=dict[0];
                value[i-1]=Integer.parseInt(dict[1]);
            }
            Bar b =new Bar(name, valName, value);
            add(b);

        }

        //Close the input stream
        br.close();


    }
}
