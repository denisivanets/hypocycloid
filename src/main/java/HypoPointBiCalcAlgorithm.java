import lombok.RequiredArgsConstructor;
import lombok.val;

//import static java.lang.Math.cos;
//import static java.lang.Math.sin;

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

    private double calcX(double r, double R) {
        double k = r / R;
        double X = (R - r) * cos(teta) + r * (cos((R - r) * teta / r));
        System.out.println("X: " + X);
        return X;
    }

    private double calcY(double r, double R) {
        double k = r / R;
        double Y = (R - r) * sin(teta) + r * (sin((R - r) * teta / r));
        System.out.println("Y:" + Y);
        return Y;
    }

    private double cos(final double arg) {
        return Math.cos(arg * 3.14 / 180);
    }

    private double sin(final double arg) {
        return Math.sin(arg);
    }
}
