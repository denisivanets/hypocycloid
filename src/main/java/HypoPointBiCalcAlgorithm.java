import lombok.RequiredArgsConstructor;
import lombok.val;

@RequiredArgsConstructor
public class HypoPointBiCalcAlgorithm implements PointBiCalcAlgorithm {

    private double teta = 0;

    @Override
    public Point calcPoint(double firstArg, double secondArg) {
        val point =  new Point(
                calcX(firstArg, secondArg),
                calcY(firstArg, secondArg)
        );
        teta += 1;
        return point;
    }

    private double calcX(final double r, final double R) {
        double k = R / r;
        double secondPart = cos(teta) + (cos((k -1) * teta))/(k - 1);
        double X = r * (k - 1) * secondPart;
        return X;
    }

    private double calcY(final double r, final double R) {
        double k = R / r;
        double secondPart = sin(teta) - (sin((k -1)*teta))/(k - 1);
        double Y = r * (k - 1) * secondPart;
        return Y;
    }

    private double cos(final double arg) {
        return Math.cos(arg * 3.14 / 180);
    }

    private double sin(final double arg) {
        return Math.sin(arg * 3.14 / 180);
    }
}
