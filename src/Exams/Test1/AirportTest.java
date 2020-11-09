package Exams.Test1;

import Exams.Test1.model.Plane;
import Exams.Test1.service.PlaneService;

public class AirportTest {


    public static void main(String[] args) {

        PlaneService ps = new PlaneService();
        Plane plane1 = ps.create();

        ps.printPlaneInfo(plane1);

        System.out.println("print plane info by military");
        ps.printInfoByMilitary(plane1);
        System.out.println("============================");

        System.out.println("plane which is newer");
        Plane plane2 = ps.create();
        Plane newer = ps.newerPlane(plane1, plane2);
        ps.printPlaneInfo(newer);
        System.out.println("============================");

        System.out.println("plane with bigger wingspan");
        Plane biggerWingspanPlane = ps.planeWithBiggerWingspan(plane1, plane2);
        ps.printPlaneInfo(biggerWingspanPlane);
        System.out.println("============================");

        System.out.println("plane with highest cost");
        Plane highestCostPlane = ps.planeWithHighestCost(plane1, plane2);
        ps.printPlaneInfo(highestCostPlane);
        System.out.println("============================");

        System.out.println("plane with smallest seats count");
        Plane plane3 = ps.create();
        ps.planeWithLowestSeats(plane1, plane2, plane3);
        System.out.println("============================");

        System.out.println("plane with not military");
        Plane[] planes = ps.createArray(2);
        ps.printPlanesNotMilitary(planes);
        System.out.println("============================");

        System.out.println("plane with military higher 100 hours");
        ps.getPlanesHoursGreater100(planes);
        System.out.println("============================");

        System.out.println("plane with minimal weight");
        Plane minWeightPlane = ps.getPlaneWithMinWeight(planes);
        ps.printPlaneInfo(minWeightPlane);
        System.out.println("============================");

        System.out.println("plane with minimal cost from all military");
        Plane minCostPlane = ps.getPlaneWithMinCost(planes);
        ps.printPlaneInfo(minCostPlane);
        System.out.println("============================");

        System.out.println("plane in ascending from by year");
        ps.getPlaneAscByYear(planes);
        System.out.println("============================");

        System.out.println("plane in descending from by seats not military");
        ps.getPlaneDescBySeats(planes);
        System.out.println("============================");
    }
}
