/** 
 * Keon Hee Park
 * Description:
 * Java program that determines the position of a given line on the plane, 
 * then solves the projection of the line onto plane or finds the distance between the line and plane
 */

import java.util.*;

public class vectorCalculus {
	public static final String divideLine = "\n-----------------------------------------------";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Vector<Double> lineVector = new Vector<Double>();
		Vector<Double> planeVector = new Vector<Double>();

		System.out.print("Type in the x-coordinate of points in the line: ");
		double xCoordinateLine = sc.nextDouble();
		System.out.print("Type in the y-coordinate of points in the line: ");
		double yCoordinateLine = sc.nextDouble();
		System.out.print("Type in the z-coordinate of points in the line: ");
		double zCoordinateLine = sc.nextDouble();

		System.out.printf("A line is given: (%f, %f, %f)", xCoordinateLine, yCoordinateLine, zCoordinateLine);

		System.out.println(divideLine);

		System.out.print("Type in the x-coordinate of vector for line: ");
		lineVector.add(sc.nextDouble());
		System.out.print("Type in the y-coordinate of vector for line: ");
		lineVector.add(sc.nextDouble());
		System.out.print("Type in the z-coordinate of vector for line: ");
		lineVector.add(sc.nextDouble());
		System.out.printf("The line vector, d, is given: [%f, %f, %f]", lineVector.get(0), lineVector.get(1),
				lineVector.get(2));

		System.out.println(divideLine);

		System.out.print("Type in the A coefficient value of the plane pi: ");
		planeVector.add(sc.nextDouble());
		System.out.print("Type in the B coefficient value of the plane pi: ");
		planeVector.add(sc.nextDouble());
		System.out.print("Type in the C coefficient value of the plane pi: ");
		planeVector.add(sc.nextDouble());
		System.out.print("Type in the D coefficient value of the plane pi: ");
		planeVector.add(sc.nextDouble());

		System.out.printf("A plane vector, n, is given: [%f, %f, %f]\n", planeVector.get(0), planeVector.get(1),
				planeVector.get(2));
		System.out.printf("Plane equation: %fx + %fy + %fz + %f", planeVector.get(0), planeVector.get(1),
				planeVector.get(2), planeVector.get(3));
		System.out.println(divideLine);

		// Parametric equations of line pass thru plane

		// formula set for dotProduct, planeEquation, and normOfPlane
		double dotProduct = (lineVector.get(0) * planeVector.get(0)) + (lineVector.get(1) * planeVector.get(1))
				+ (lineVector.get(2) * planeVector.get(2));

		double planeEquation = ((planeVector.get(0) * xCoordinateLine) + (planeVector.get(1) * yCoordinateLine)
				+ (planeVector.get(2) * zCoordinateLine) + (planeVector.get(3)));

		double normOfPlane = (Math.sqrt(
				Math.pow(planeVector.get(0), 2) + Math.pow(planeVector.get(1), 2) + Math.pow(planeVector.get(2), 2)));

		if (dotProduct != 0) {
			System.out.println("The dot product is not equal to 0. Therefore the line, l, intersects to plane pi.");
			System.out.println("The dot product: " + dotProduct);
			System.out.println("Creating a line parametric equations for D1.");
			System.out.println("For D1,\nx = " + xCoordinateLine + " + " + lineVector.get(0) + "t" + "\ny = "
					+ yCoordinateLine + " + " + lineVector.get(1) + "t" + "\nz = " + zCoordinateLine + " + "
					+ lineVector.get(2) + "t");
			System.out.print("Type in the value t for D1: ");
			double valueT1 = sc.nextDouble();
			double d1x = xCoordinateLine + lineVector.get(0) * valueT1;
			double d1y = yCoordinateLine + lineVector.get(1) * valueT1;
			double d1z = zCoordinateLine + lineVector.get(2) * valueT1;
			System.out.println("For D1,\nx = " + d1x + "\ny = " + d1y + "\nz = " + d1z);

			System.out.println(divideLine);
			System.out.println("Creating a line parametric equations for D2.");
			System.out.println("For D2,\nx = " + xCoordinateLine + " + " + lineVector.get(0) + "t" + "\ny = "
					+ yCoordinateLine + " + " + lineVector.get(1) + "t" + "\nz = " + zCoordinateLine + " + "
					+ lineVector.get(2) + "t");
			System.out.print("Type in the value t for D2: ");
			double valueT2 = sc.nextDouble();
			double d2x = xCoordinateLine + lineVector.get(0) * valueT2;
			double d2y = yCoordinateLine + lineVector.get(1) * valueT2;
			double d2z = zCoordinateLine + lineVector.get(2) * valueT2;
			System.out.println("For D2,\nx = " + d2x + "\ny = " + d2y + "\nz = " + d2z);

			System.out.println(divideLine);

			System.out.println("For P1,\nx = " + d1x + " + " + planeVector.get(0) + "t" + "\ny = " + d1y + " + "
					+ planeVector.get(1) + "t" + "\nz = " + d1z + " + " + planeVector.get(2) + "t\n");

			System.out.println("For P2,\nx = " + d2x + " + " + planeVector.get(0) + "t" + "\ny = " + d2y + " + "
					+ planeVector.get(1) + "t" + "\nz = " + d2z + " + " + planeVector.get(2) + "t");

			System.out.println(divideLine);

			// Find t

			double e1t = (-planeVector.get(3) - planeVector.get(0) * d1x - planeVector.get(1) * d1y
					- planeVector.get(2) * d1z)
					/ ((planeVector.get(0) * planeVector.get(0)) + (planeVector.get(1) * planeVector.get(1))
							+ (planeVector.get(2) * planeVector.get(2)));

			System.out.println("t = " + e1t);

			double e1x = d1x + planeVector.get(0) * e1t;
			double e1y = d1y + planeVector.get(1) * e1t;
			double e1z = d1z + planeVector.get(2) * e1t;

			System.out.println("E1 = (" + e1x + ", " + e1y + ", " + e1z + ")");

			// Find t

			double e2t = (-planeVector.get(3) - planeVector.get(0) * d2x - planeVector.get(1) * d2y
					- planeVector.get(2) * d2z)
					/ (planeVector.get(0) * planeVector.get(0) + planeVector.get(1) * planeVector.get(1)
							+ planeVector.get(2) * planeVector.get(2));

			System.out.println("t = " + e2t);

			double e2x = d2x + planeVector.get(0) * e2t;
			double e2y = d2y + planeVector.get(1) * e2t;
			double e2z = d2z + planeVector.get(2) * e2t;

			System.out.println("E2 = (" + e2x + ", " + e2y + ", " + e2z + ")");

			double projectionX = e2x - e1x;
			double projectionY = e2y - e1y;
			double projectionZ = e2z - e1z;

			System.out.println("The projection of line onto plane pi = J: [x, y, z] = [" + e1x + ", " + e1y + ", " + e1z
					+ "] + [" + projectionX + ", " + projectionY + ", " + projectionZ + "]t");
		}
		if (dotProduct == 0 && planeEquation == 0) {
			System.out.println(
					"The dot product is equal to 0, \nand the initial point of the line, l, satisfies the plane pi equation.");
			System.out.println("Therefore the line, l, is in the plane.");
			System.out.println("Plane equation: Ax + By + Cz + D = 0");
			System.out.println("Plane equation: " + planeVector.get(0) + "x + " + planeVector.get(1) + "y + "
					+ planeVector.get(2) + "z + " + planeVector.get(3) + " = 0");
			System.out.println("Plane equation: " + planeVector.get(0) + "(" + xCoordinateLine + ") + "
					+ planeVector.get(1) + "(" + yCoordinateLine + ") + " + planeVector.get(2) + "(" + zCoordinateLine
					+ ") + " + planeVector.get(3) + " = " + planeEquation);
			System.out.println(divideLine);

		}
		if (dotProduct == 0 && planeEquation != 0) {
			System.out.println(
					"The dot product is equal to 0,\nand the initial point of the line, l, does not satisfy the plane pi equation.");
			System.out.println("Therefore the line, l, is parallel to the plane pi.");
			System.out.println("Plane equation: Ax + By + Cz + D = 0");
			System.out.println("Plane equation: " + planeVector.get(0) + "x + " + planeVector.get(1) + "y + "
					+ planeVector.get(2) + "z + " + planeVector.get(3) + " = 0");
			System.out.println("Plane equation: " + planeVector.get(0) + "(" + xCoordinateLine + ") + "
					+ planeVector.get(1) + "(" + yCoordinateLine + ") + " + planeVector.get(2) + "(" + zCoordinateLine
					+ ") + " + planeVector.get(3) + " != 0" + " (" + planeEquation + ")");

			System.out.println(divideLine);

			System.out.println("Creating a line parametric equations for D1.");
			System.out.println("For D1,\nx = " + xCoordinateLine + " + " + lineVector.get(0) + "t" + "\ny = "
					+ yCoordinateLine + " + " + lineVector.get(1) + "t" + "\nz = " + zCoordinateLine + " + "
					+ lineVector.get(2) + "t");
			System.out.print("Type in the value t for D1: ");
			double valueT1 = sc.nextDouble();
			double d1x = xCoordinateLine + lineVector.get(0) * valueT1;
			double d1y = yCoordinateLine + lineVector.get(1) * valueT1;
			double d1z = zCoordinateLine + lineVector.get(2) * valueT1;
			System.out.println("For D1,\nx = " + d1x + "\ny = " + d1y + "\nz = " + d1z);

			System.out.println(divideLine);
			System.out.println("Creating a line parametric equations for D2.");
			System.out.println("For D2,\nx = " + xCoordinateLine + " + " + lineVector.get(0) + "t" + "\ny = "
					+ yCoordinateLine + " + " + lineVector.get(1) + "t" + "\nz = " + zCoordinateLine + " + "
					+ lineVector.get(2) + "t");
			System.out.print("Type in the value t for D2: ");
			double valueT2 = sc.nextDouble();
			double d2x = xCoordinateLine + lineVector.get(0) * valueT2;
			double d2y = yCoordinateLine + lineVector.get(1) * valueT2;
			double d2z = zCoordinateLine + lineVector.get(2) * valueT2;
			System.out.println("For D2,\nx = " + d2x + "\ny = " + d2y + "\nz = " + d2z);

			System.out.println(divideLine);

			System.out.println("For P1,\nx = " + d1x + " + " + planeVector.get(0) + "t" + "\ny = " + d1y + " + "
					+ planeVector.get(1) + "t" + "\nz = " + d1z + " + " + planeVector.get(2) + "t\n");

			System.out.println("For P2,\nx = " + d2x + " + " + planeVector.get(0) + "t" + "\ny = " + d2y + " + "
					+ planeVector.get(1) + "t" + "\nz = " + d2z + " + " + planeVector.get(2) + "t");

			System.out.println(divideLine);

			// Find t

			double e1t = (-planeVector.get(3) - planeVector.get(0) * d1x - planeVector.get(1) * d1y
					- planeVector.get(2) * d1z)
					/ ((planeVector.get(0) * planeVector.get(0)) + (planeVector.get(1) * planeVector.get(1))
							+ (planeVector.get(2) * planeVector.get(2)));

			System.out.println("t = " + e1t);

			double e1x = d1x + planeVector.get(0) * e1t;
			double e1y = d1y + planeVector.get(1) * e1t;
			double e1z = d1z + planeVector.get(2) * e1t;

			System.out.println("E1 = (" + e1x + ", " + e1y + ", " + e1z + ")");

			// Find t

			double e2t = (-planeVector.get(3) - planeVector.get(0) * d2x - planeVector.get(1) * d2y
					- planeVector.get(2) * d2z)
					/ (planeVector.get(0) * planeVector.get(0) + planeVector.get(1) * planeVector.get(1)
							+ planeVector.get(2) * planeVector.get(2));

			System.out.println("t = " + e2t);

			double e2x = d2x + planeVector.get(0) * e2t;
			double e2y = d2y + planeVector.get(1) * e2t;
			double e2z = d2z + planeVector.get(2) * e2t;

			System.out.println("E2 = (" + e2x + ", " + e2y + ", " + e2z + ")");

			double projectionX = e2x - e1x;
			double projectionY = e2y - e1y;
			double projectionZ = e2z - e1z;

			System.out.println("The projection of line onto plane pi = J: [x, y, z] = [" + e1x + ", " + e1y + ", " + e1z
					+ "] + [" + projectionX + ", " + projectionY + ", " + projectionZ + "]t");

			// distance

			double distance = Math.abs(((planeVector.get(0) * d1x) + (planeVector.get(1) * d1y)
					+ (planeVector.get(2) * d1z) + planeVector.get(3))) / normOfPlane;
			System.out.println("The distance between line and pi = " + distance);
		}
	}
}