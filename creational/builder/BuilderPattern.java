package creational.builder;

public class BuilderPattern {
    public static void main(String[] args) {
        Application.makeCar();
    }
}

class Car {
}

class Manual {
}

interface Builder {
    public void reset();

    public void setSeats(int seatCount);

    public void setEngine(String engineType);

    public void setTripComputer(boolean isTripComputer);

    public void setGPS(boolean isGPS);
}

class CarBuilder implements Builder {
    private Car car;

    CarBuilder() {
        // this.reset();
        reset();
    }

    @Override
    public void reset() {
        // this.car = new Car();
        car = new Car();
    }

    @Override
    public void setSeats(int seatCount) {
        System.out.println("Setting " + seatCount + " seats");
    }

    @Override
    public void setEngine(String engineType) {
        System.out.println("Setting " + engineType);
    }

    @Override
    public void setTripComputer(boolean isTripComputer) {
        System.out.println("Setting trip computer to " + isTripComputer);
    }

    @Override
    public void setGPS(boolean isGPS) {
        System.out.println("Setting GPS to " + isGPS);
    }

    public Car getProduct() {
        // Car product = this.car;
        Car product = car;
        // this.reset();
        reset();
        return product;
    }
}

class CarManualBuilder implements Builder {
    private Manual manual;

    CarManualBuilder() {
        // this.reset();
        reset();
    }

    @Override
    public void reset() {
        // this.car = new Car();
        manual = new Manual();
    }

    @Override
    public void setSeats(int seatCount) {
        System.out.println("Doc for Setting " + seatCount + " seats");
    }

    @Override
    public void setEngine(String engineType) {
        System.out.println("Doc for Setting " + engineType);
    }

    @Override
    public void setTripComputer(boolean isTripComputer) {
        System.out.println("Doc for Setting trip computer to " + isTripComputer);
    }

    @Override
    public void setGPS(boolean isGPS) {
        System.out.println("Doc for Setting GPS to " + isGPS);
    }

    public Manual getProduct() {
        // Car product = this.car;
        Manual product = manual;
        // this.reset();
        reset();
        return product;
    }
}

class Director {
    // private Builder builder;

    // public void setBuilder(Builder builder) {
    // this.builder = builder;
    // }

    public void constructSportsCar(Builder builder) {
        builder.reset();
        builder.setSeats(2);
        builder.setEngine("Sports Engine");
        builder.setTripComputer(true);
        builder.setGPS(true);
    }

    public void constructSUVCar(Builder builder) {
        builder.reset();
        builder.setSeats(8);
        builder.setEngine("SUV Engine");
        builder.setTripComputer(true);
        builder.setGPS(true);
    }
}

// The client code creates a builder object, passes it to the
// director and then initiates the construction process. The end
// result is retrieved from the builder object.
class Application {
    public static void makeCar() {
        Director director = new Director();

        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);
        Car car = carBuilder.getProduct();

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);

        Manual manual = manualBuilder.getProduct();
    }
}
