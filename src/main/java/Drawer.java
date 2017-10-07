import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;

@RequiredArgsConstructor
public class Drawer extends JPanel {

    @Setter
    private final PointProvider provider;

    @Override
    public void paint(Graphics g) {
        val points = provider.providePoints();
        for (int i = 0; i < points.size() - 1; i++) {
            val firstPoint = points.get(i);
            val secondPoint = points.get(i + 1);
            int firstX = (int) (firstPoint.getX() * 100 + 500);
            int firstY = -(700 - ((int) (firstPoint.getY() * 100 + 500)));
            int secondX = (int) (secondPoint.getY() * 100 + 500);
            int secondY = (int) (secondPoint.getY() * 100 + 500);
            g.drawLine(firstX, firstY, secondX, secondY);
//            g.drawOval(firstX, firstY, 3, 3);
            System.out.println(firstX + ";" + firstY);
        }
    }
}
