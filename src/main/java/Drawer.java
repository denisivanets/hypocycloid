import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.val;

import javax.swing.*;
import java.awt.*;

@RequiredArgsConstructor
public class Drawer extends JPanel {

    private final PointProvider provider;
    @Setter
    private int sizeCoeff;

    @Override
    @SneakyThrows
    public void paint(Graphics g) {
        val points = provider.providePoints();
        for (int i = 0; i < points.size() - 1; i++) {
            val firstPoint = points.get(i);
            val secondPoint = points.get(i + 1);
            int x1 = (int) (firstPoint.getX() * 50) + 300;
            int x2 = (int) (secondPoint.getX() * 50) + 300;
            int y1 = (int) (firstPoint.getY() * 50) + 300;
            int y2 = (int) (secondPoint.getY() * 50) + 300;
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
