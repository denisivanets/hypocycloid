
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;

@NoArgsConstructor
public class Drawer extends JPanel {

    @Setter
    private PointProvider provider;

    @Override
    public void paint(Graphics g) {
        if (provider == null) {
            return;
        }
        int sizeCoeff = calculateCoeff();
        int transitionCoords = 300;
        val points = provider.providePoints();
        for (int i = 0; i < points.size() - 1; i++) {
            val firstPoint = points.get(i);
            val secondPoint = points.get(i + 1);
            int x1 = (int) (firstPoint.getX() * sizeCoeff) + transitionCoords;
            int x2 = (int) (secondPoint.getX() * sizeCoeff) + transitionCoords;
            int y1 = (int) (firstPoint.getY() * sizeCoeff) + transitionCoords;
            int y2 = (int) (secondPoint.getY() * sizeCoeff) + transitionCoords;
            g.drawLine(x1, y1, x2, y2);
        }
    }

    public void clearAndRepaint(final Graphics g) {
        g.clearRect(0,0,this.getWidth(),this.getHeight());
        repaint();
    }

    private int calculateCoeff() {
        double standardValue = 3;
        double defaultCoeff = 80;
        val firstPoint = this.provider.providePoints().get(0);
        double valuesRatio = firstPoint.getX() / standardValue;
        return (int) (Math.round(defaultCoeff / valuesRatio));
    }
}
