import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Bar extends JPanel {

    String name;
    int[] value;
    String[] valName;
    int size=15;

    public Bar(String name, String[] valName, int[] value) {
        this.name = name;
        this.valName = valName;
        this.value = value;
        repaint();
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int startpoint=80;
        g.setColor(Color.WHITE);
        g.setFont(new Font("default", Font.PLAIN, 12));
        g.drawString(name, size, 25);
        for (int i=0;i<value.length;i++) {

            Color barColor=genColor(valName[i]);
            g.setColor(barColor);
            g.fillRect(startpoint, 0, size*value[i], 40);

            Color textColor =invertColor(barColor);
            g.setColor(textColor);
            g.setFont(new Font("default", Font.BOLD, 12));
            g.drawString(valName[i]+" %"+value[i], (startpoint+(size*value[i])/2)-(valName[i].length()*5), 25);
            startpoint+=size*value[i];
        }
    }

    private Color invertColor(Color c) {
        // TODO Auto-generated method stub
        int r=256-c.getRed();
        int g=256-c.getGreen();
        int b=256-c.getBlue();

        if ((c.getRed()*0.299 + c.getGreen()*0.587 + c.getBlue()*0.114)>186) {
            return Color.black;
        }
        else return Color.white;

//		return new Color(r, g, b);
    }

    private Color genColor(String string) {
        // TODO Auto-generated method stub
        int hash = string.hashCode();
        System.out.println(hash);
        int r = (hash & 0xFF0000) >> 16;
        int g = (hash & 0x00FF00) >> 8;
        int b = hash & 0x0000FF;

        return new Color(r, g, b);

    }




}
