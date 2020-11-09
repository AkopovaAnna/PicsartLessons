package Exams.Test1.model;

public class Plane {

    private String model;
    private String country;
    private int year;
    private int hours;
    private boolean isMilitary;
    private String engineType;
    private int weight;
    private int wingspan;
    private float topSpeed;
    private int seats;
    private double cost;

    public Plane(String model, String country, String engineType, double cost) {
        this.model = model;
        this.country = country;
        this.engineType = engineType;
        this.cost = cost;
        this.year = 2020;
        this.hours = 0;
        this.isMilitary = false;
        this.weight = 1000;
        this.wingspan = 10;
        this.topSpeed = 1000;
        this.seats = 160;
        this.cost = 5_999_999.0;

    }

    public String getModel() {
        return model;
    }

    /*Any not empty string*/
    public void setModel(String model) {
        if (model != null && model.length() != 0) {
            this.model = model;
        } else {
            System.out.println("invalid model");
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country != null && country.length() != 0) {
            this.country = country;
        } else {
            System.out.println("invalid country");
        }

    }

    public int getYear() {
        return year;
    }

    //    year of publishing  (from 1903 to 2020)
    public void setYear(int year) {
        if (year >= 1903 && year <= 2020) {
            this.year = year;
        } else {
            System.out.println("invalid year");
        }
    }

    public int getHours() {
        return hours;
    }

    //hours in air (from 0 to 10000)
    public void setHours(int hours) {
        if (hours >= 0 && hours <= 10000) {
            this.hours = hours;
        } else {
            System.out.println("invalid hours");
        }
    }

    public boolean isMilitary() {
        return isMilitary;
    }


    public void setMilitary(boolean military) {
        isMilitary = military;
    }

    public String getEngineType() {
        return engineType;
    }

    //Any not empty string
    public void setEngineType(String engineType) {
        if (engineType != null && engineType.length() != 0) {
            this.engineType = engineType;
        } else {
            System.out.println("invalid engineType");
        }

    }

    public int getWeight() {
        return weight;
    }

    //weight of plane (from 1000 KG to 160000 KG)
    public void setWeight(int weight) {
        if (weight >= 1000 && weight <= 160000) {
            this.weight = weight;
        } else {
            System.out.println("invalid weight");
        }
    }

    public int getWingspan() {
        return wingspan;
    }

    //    the maximum extent across the wings of an aircraft (from 10 - 45)
    public void setWingspan(int wingspan) {
        if (wingspan >= 10 && wingspan <= 45) {
            this.wingspan = wingspan;
        } else {
            System.out.println("invalid wingspan");
        }

    }

    public float getTopSpeed() {
        return topSpeed;
    }

    //    maximal speed per hour (1000 km/h) (any not negative value)
    public void setTopSpeed(float topSpeed) {
        if (topSpeed > 0 && topSpeed <= 1000) {
            this.topSpeed = topSpeed;
        } else {
            System.out.println("invalid topSpeed");
        }
    }

    public int getSeats() {
        return seats;
    }

    //    any not negative value
    public void setSeats(int seats) {
        if (seats > 0) {
            this.seats = seats;
        } else {
            System.out.println("invalid seats");
        }
    }

    public double getCost() {
        return cost;
    }

    //any not negative value
    public void setCost(double cost) {
        if (cost > 0) {
            this.cost = cost;
        } else {
            System.out.println("invalid cost");
        }
    }

}
