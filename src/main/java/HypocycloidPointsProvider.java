import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.List;

@RequiredArgsConstructor
public class HypocycloidPointsProvider implements PointProvider {

    private static final int START_DEGREE = 0;
    private static final int FINAL_DEGREE = 360;

    private final int r;
    private final int R;

    @Override
    public List<Point> providePoints() {
        val calculator = new HypoPointsCalculator(START_DEGREE, FINAL_DEGREE);
        val algorithm = new HypoPointBiCalcAlgorithm();
        return calculator.calculate(r, R, algorithm::calcPoint);
    }
}
