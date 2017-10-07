import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public class HypoPointsCalculator implements PointsCalculator {

    private final int fromDegree;
    private final int toDegree;

    @Override
    public List<Point> calculate(
            final double firstArg,
            final double secondArg,
            final BiFunction<Double, Double, Point> calculationFunction
    ) {
        val points = new ArrayList<Point>();
        for (int t = fromDegree; t < toDegree; t++) {
            points.add(calculationFunction.apply(firstArg, secondArg));
        }
        return points;
    }

}
