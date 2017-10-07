import lombok.val;

import javax.swing.*;

public class Main {

    private JFrame frame;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        frame = new JFrame("Hypocycloid");
        frame.setSize(700, 700);
        frame.setVisible(true);
        val pointsProvider = new HypocycloidPointsProvider(1, 4);
        val drawer = new Drawer(pointsProvider);
        frame.getContentPane().add(drawer);
    }

}
