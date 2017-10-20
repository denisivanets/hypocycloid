import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.List;

public class HypocycloidPointsProvider implements PointProvider {
    private final int r;
    private final int R;
    private int startDegree;
    private int finalDegree;

    public HypocycloidPointsProvider(final int r, final int R) {
        this.r = r;
        this.R = R;
        startDegree = 0;
        finalDegree = r * 360;
    }

    @Override
    public List<Point> providePoints() {
        val calculator = new HypoPointsCalculator(startDegree, finalDegree);
        val algorithm = new HypoPointBiCalcAlgorithm();
        return calculator.calculate(r, R, algorithm::calcPoint);
    }
}
