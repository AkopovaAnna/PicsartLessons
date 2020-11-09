package Exams.Test1.service;

import Exams.Test1.model.Plane;
import com.picsart.model.Employee;
import com.picsart.model.Student;

import java.util.Scanner;

public class PlaneService {


    public Plane create() {
        System.out.println("Create Plane");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter model: ");
        String model = sc.nextLine();
        System.out.println("Enter country: ");
        String country = sc.nextLine();
        System.out.println("Enter year: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter hours: ");
        int hours = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter is military or not: input true or false");
        boolean isMilitary = sc.nextBoolean();
        sc.nextLine();
        System.out.println("Enter engine type: ");
        String engineType = sc.nextLine();
        System.out.println("Enter weight: ");
        int weight = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter wingspan: ");
        int wingspan = sc.nextInt();
        System.out.println("Enter topSpeed: ");
        float topSpeed = sc.nextFloat();
        sc.nextLine();
        System.out.println("Enter seats: ");
        int seats = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter cost: ");
        double cost = sc.nextDouble();

        Plane plane = new Plane(model, country, engineType, cost);
        setPlaneData(plane, year, hours, isMilitary, weight, wingspan, topSpeed, seats);
        return plane;
    }

    private void setPlaneData(Plane plane, int year, int hours, boolean isMilitary, int weight,
                              int wingspan, float topSpeed, int seats) {
        plane.setYear(year);
        plane.setHours(hours);
        plane.setMilitary(isMilitary);
        plane.setWeight(weight);
        plane.setWingspan(wingspan);
        plane.setTopSpeed(topSpeed);
        plane.setSeats(seats);

    }

//    Task 1. (score 5)
//    Create function:
//    Parameter one Plane
//    Result: print all information of the plane

    public void printPlaneInfo(Plane plane) {
        System.out.println("model " + plane.getModel());
        System.out.println("country " + plane.getCountry());
        System.out.println("year " + plane.getYear());
        System.out.println("hours " + plane.getHours());
        System.out.println("military " + plane.isMilitary());
        System.out.println("engineType " + plane.getEngineType());
        System.out.println("weight " + plane.getWeight());
        System.out.println("wingspan " + plane.getWingspan());
        System.out.println("topSpeed " + plane.getTopSpeed());
        System.out.println("seats  " + plane.getSeats());
        System.out.println("cost  " + plane.getCost() + "$");

    }

    public Plane[] createArray(int size) {
        Plane[] planes = new Plane[size];

        for (int i = 0; i < size; i++) {
            System.out.println("creating plane: " + (i + 1));
            planes[i] = create();
        }

        return planes;
    }

//    Task 2. (score 5)
//    Create function:
//    Parameter one Plane
//    Result: print cost and topSpeed if the plane is military otherwise print model and country

    public void printInfoByMilitary(Plane plane) {
        if (plane.isMilitary()) {
            System.out.print("cost: " + plane.getCost());
            System.out.print(" topSpeed: " + plane.getTopSpeed());
        } else {
            System.out.print("model: " + plane.getModel());
            System.out.print(" country: " + plane.getCountry());
        }
        System.out.println();
    }

//    Task 3. (score 5)
//    Create function:
//    Parameter two Planes
//    Result: return the plane which one is newer (if they have the same age return first one).

    public Plane newerPlane(Plane plane1, Plane plane2) {
        if (plane1.getYear() >= plane2.getYear()) {
            return plane1;
        }
        return plane2;
    }

//    Task 4. (score 5)
//    Create function:
//    Parameter two Planes
//    Result: return the model of the plane which has bigger wingspan (if they have the same - return second one).

    public Plane planeWithBiggerWingspan(Plane plane1, Plane plane2) {
        if (plane1.getWingspan() > plane2.getWingspan()) {
            return plane1;
        }
        return plane2;
    }

//    Task 5. (score 5)
//    Create function:
//    Parameter three Planes
//    Result: return the plane which has highest cost (if they have the same - return first plane).

    public Plane planeWithHighestCost(Plane plane1, Plane plane2) {
        if (plane1.getCost() >= plane2.getCost()) {
            return plane1;
        }
        return plane2;
    }

//    Task 6. (score 5)
//    Create function:
//    Parameter three Planes
//    Result: print country of the plane with smallest seats count (if they have the same - print first).

    public void planeWithLowestSeats(Plane plane1, Plane plane2, Plane plane3) {
        if (plane1.getSeats() <= plane2.getSeats() && plane1.getSeats() <= plane3.getSeats()) {
            printPlaneInfo(plane1);
        } else if (plane2.getSeats() <= plane1.getSeats() && plane2.getSeats() <= plane3.getSeats()) {
            printPlaneInfo(plane2);
        } else {
            printPlaneInfo(plane3);
        }

    }

//    Task 7. (score 5)
//    Create function:
//    Parameter array of Planes
//    Result: print all not military planes

    public void printPlanesNotMilitary(Plane[] planes) {
        for (Plane plane : planes) {
            if (!plane.isMilitary()) {
                printPlaneInfo(plane);
            }
        }
    }

//    Task 8. (score 5)
//    Create function:
//    Parameter array of Planes
//    Result: print all military planes which were in air more than 100 hours.

    public void getPlanesHoursGreater100(Plane[] planes) {
        for (Plane plane : planes) {
            if (plane.getHours() > 100) {
                printPlaneInfo(plane);
            }
        }
    }

//    Task 9. (score 7)
//    Create function:
//    Parameter array of Planes
//    Result: return the plane with minimal weight (if there are some of them return last one).

    public Plane getPlaneWithMinWeight(Plane[] planes) {
        int minWeight = planes[0].getWeight();
        int indexOfSmallest = 0;
        for (int i = 0; i < planes.length; i++) {
            if (planes[i].getWeight() < minWeight) {
                minWeight = planes[i].getWeight();
                indexOfSmallest = i;
            }
        }
        return planes[indexOfSmallest];
    }

//    Task 10. (score 7)
//    Create function:
//    Parameter array of Planes
//    Result: return the plane with minimal cost from all military planes
//    (if there are some of them return first one).

    public Plane getPlaneWithMinCost(Plane[] planes) {
        double minCost = planes[0].getCost();
        int indexOfSmallest = 0;
        for (int i = planes.length; i >= 0; i--) {
            if (planes[i].isMilitary() && planes[i].getCost() < minCost) {
                minCost = planes[i].getCost();
                indexOfSmallest = i;
            }
        }
        return planes[indexOfSmallest];
    }
//    Task 11. (score 12)
//    Create function:
//    Parameter array of Planes
//    Result: print planes in ascending form order by year

    public void getPlaneAscByYear(Plane[] planes) {
        for (int i = 0; i < planes.length - 1; i++) {
            for (int j = 0; j < planes.length - i - 1; j++) {
                if (planes[j + 1].getYear() < planes[j].getYear()) {
                    swap(planes, j, j + 1);
                }
            }

        }
        printArray(planes);
    }

//    Task 12. (score 14)
//    Create function:
//    Parameter array of Planes
//    Result: print not military planes in descending form order by number of seats.

    public void getPlaneDescBySeats(Plane[] planes) {
        for (int i = 0; i < planes.length - 1; i++) {
            for (int j = 0; j < planes.length - i - 1; j++) {
                if (!planes[j].isMilitary()) {
                    if (planes[j + 1].getSeats() > planes[j].getSeats()) {
                        swap(planes, j, j + 1);
                    }
                }

            }

        }
        printArray(planes);
    }


    public static void swap(Plane[] array, int i, int j) {
        Plane temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public void printArray(Plane[] planes) {
        for (Plane plane : planes) {
            System.out.println("*****");
            printPlaneInfo(plane);
        }
    }

}
