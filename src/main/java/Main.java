import lombok.val;

import javax.swing.*;
import java.awt.*;

public class Main {

    private JFrame frame;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        frame = new JFrame("Hypocycloid");
        frame.setSize(1000, 700);
        frame.setVisible(true);
        JTextField rField = new JTextField("r", 10);
        JTextField RField = new JTextField("R", 10);
        JButton button = new JButton("Make");
        JPanel utilPanel = new JPanel();
        utilPanel.add(rField);
        utilPanel.add(RField);
        utilPanel.add(button);
        frame.getContentPane().add(BorderLayout.EAST, utilPanel);
        val drawer = new Drawer();
        frame.getContentPane().add(drawer);
        button.addActionListener((event) -> {
            final int r = Integer.parseInt(rField.getText());
            final int R = Integer.parseInt(RField.getText());
            val pointsProvider = new HypocycloidPointsProvider(r, R);
            drawer.setProvider(pointsProvider);
            drawer.clearAndRepaint(drawer.getGraphics());
            frame.setVisible(false);
            frame.setVisible(true);
        });
    }

}
