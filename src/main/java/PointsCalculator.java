import java.util.List;
import java.util.function.BiFunction;

public interface PointsCalculator {

    List<Point> calculate(
            final double firstArg,
            final double secondArg,
            final BiFunction<Double, Double, Point> calculationFunction
    );
}
