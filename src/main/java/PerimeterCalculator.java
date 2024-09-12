import org.talento.tech.*;

import java.net.URISyntaxException;
import java.util.List;

/**
 * Este codigo permite calcular el perimetro de figuras de N >= 3 lados
 * Figuras de ejemplo:
 * - square.txt - lado de 4
 * - triangle.txt - base de 4, altura de 4
 */

public class PerimeterCalculator {

    public PerimeterCalculator () {}

    public double calculatePerimeter(Shape s) {
        // Definir la variable que acumule el perimetro
        double perimeter = 0;

        List<Point> points = s.getPoints();
       // Point prevPoint = points.getLast();
        Point prevPoint = points.get(points.size() - 1);

        for (Point point : points) {
            // Obtener la distancia de los lados
            // Ayuda: prevPoint.distancia(point)
            double distance = prevPoint.distancia(point);
            perimeter += distance;

            prevPoint = point;
        }

        // Retornar la variable del perimetro
        return perimeter;
    }

    public int getTotalPoints(Shape s) {
        // Definir la variable para el total de puntos
        int totalPoints = 0;
        for(Point point: s.getPoints()) {
            // Acumular el total de puntos
            totalPoints++;
        }

        // Retornas el valor de puntos
        return totalPoints;
    }

    public static void main (String[] args) throws URISyntaxException {
        PerimeterCalculator perimeterCalculator = new PerimeterCalculator();
        // Definit el nombre del archivo
        String nombre_archivo = "square.txt";

        Shape shape = new Shape();

        shape.readPoints("nombre_archivo");
        // Mostrar el valor de calculatePerimeter y getTotalPoints
        System.out.println("Perímetro: " + perimeterCalculator.calculatePerimeter(shape));
        System.out.println("Total de puntos: " + perimeterCalculator.getTotalPoints(shape));

    }
}
