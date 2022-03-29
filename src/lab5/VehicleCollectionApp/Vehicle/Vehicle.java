package lab5.VehicleCollectionApp.Vehicle;

import lab5.VehicleCollectionApp.Exceptions.NegativeValueException;
import lab5.VehicleCollectionApp.Exceptions.NullException;
import lab5.VehicleCollectionApp.UserInput.UserInput;
import java.util.Set;
import java.time.ZonedDateTime;

public class Vehicle
{
    private long id;
    private String name;
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    private Double enginePower;
    private Long numberOfWheels;
    private Double capacity;
    private VehicleType type;

    public Vehicle(Set<Long> IDList) {
        generateID(IDList);
        setCreationTime();
        setVehicleParams();
    }

    public void update() {
        setVehicleParams();
    }

    private void setVehicleParams() {

        System.out.println("Enter vehicle parameters:");

        boolean flag = false;
        while (!flag) {
            try {
                this.setName(UserInput.getString("vehicle name"));
                flag = true;
            }
            catch (Exception e) {
                System.out.println(e.getMessage() + ". Impossible name. Please, enter valid value.");
            }
        }

        flag = false;
        final Coordinates coordinates = new Coordinates();
        while (!flag) {
            try {
                coordinates.setXCoordinate(UserInput.getInteger("x coordinate"));
                flag = true;
            }
            catch (Exception e2) {
                System.out.println(e2.getMessage() + ". Impossible x. Please, enter valid value.");
            }
        }

        flag = false;
        while (!flag) {
            try {
                coordinates.setYCoordinate(UserInput.getInteger("y coordinate"));
                flag = true;
            }
            catch (Exception e2) {
                System.out.println(e2.getMessage() + ". Impossible y. Please, enter valid value.");
            }
        }

        this.setCoordinates(coordinates);
        flag = false;
        while (!flag) {
            try {
                setEnginePower(UserInput.getDouble("engine power"));
                flag = true;
            }
            catch (Exception e2) {
                System.out.println(e2.getMessage() + ". Impossible engine power. Please, enter valid value.");
            }
        }

        flag = false;
        while (!flag) {
            try {
                setNumberOfWheels(UserInput.getLong("number of wheels"));
                flag = true;
            }
            catch (Exception e2) {
                System.out.println(e2.getMessage() + ". Impossible number of wheels. Please, enter valid value.");
            }
        }

        flag = false;
        while (!flag) {
            try {
                setCapacity(UserInput.getDouble("capacity"));
                flag = true;
            }
            catch (Exception e2) {
                System.out.println(e2.getMessage() + ". Impossible capacity. Please, enter valid value.");
            }
        }

        flag = false;
        while (!flag) {
            try {
                System.out.println("Possible vehicle types:");
                System.out.println(VehicleType.convertToString());
                setVehicleType(UserInput.getString("type"));
                flag = true;
            }
            catch (Exception e2) {
                System.out.println(e2.getMessage() + ". Wrong type. Please, enter valid value.");
            }
        }

        System.out.println("Done!");
    }

    private void generateID(Set<Long> IDList) {
        boolean flag = true;
        long id = 0;

        while (flag) {
            id = (long)(Math.random() * 10000.0);
            flag = false;
            for (Long existingID : IDList) {
                if (existingID.equals(id)) {
                    flag = true;
                }
            }
        }
        this.id = id;
    }

    private void setName(String name) throws NullException {
        if (name == null || name.equals("")) throw new NullException("Name can not be NULL or empty");
        this.name = name;
    }

    private void setCreationTime() {
        this.creationDate = ZonedDateTime.now();
    }

    private void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    private void setEnginePower(Double enginePower) throws NegativeValueException {
        if (enginePower != null && enginePower <= 0.0) throw new NegativeValueException("Power can not be negative");
        this.enginePower = enginePower;
    }

    private void setNumberOfWheels(Long numberOfWheels) throws NegativeValueException {
        if (numberOfWheels != null && numberOfWheels <= 0) throw new NegativeValueException("Number of wheels can not be negative");
        this.numberOfWheels = numberOfWheels;
    }

    private void setCapacity(Double capacity) throws NegativeValueException, NullException {
        if (capacity == null) throw new NullException("Capacity can not be NULL");
        if (capacity <= 0.0) throw new NegativeValueException("Capacity can not be negative");
        this.capacity = capacity;
    }

    private void setVehicleType(String type) throws NullException, IllegalArgumentException {
        if (type == null) throw new NullException("Vehicle type can not be NULL");
        this.type = VehicleType.valueOf(type);
    }

    public long getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return this.creationDate;
    }

    public Double getEnginePower() {
        return this.enginePower;
    }

    public Double getCapacity() {
        return this.capacity;
    }

    public Long getNumberOfWheels() {
        return this.numberOfWheels;
    }

    public VehicleType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Vehicle{id=" + this.id +
                ", name=" + this.name +
                ", coordinates=" + this.coordinates.toString() +
                ", creation=" + this.creationDate.toString() +
                ", enginePower=" + this.enginePower +
                ", numberOfWheels=" + this.numberOfWheels +
                ", capacity=" + this.capacity +
                ", type=" + this.type.toString() + "};";
    }

    @Override
    public int hashCode() {
        int result = (int)(this.id ^ this.id >>> 32);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.coordinates.hashCode();
        result = 31 * result + this.enginePower.hashCode();
        result = 31 * result + this.numberOfWheels.hashCode();
        result = 31 * result + this.capacity.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle)obj;
        return this.id == other.id &&
                this.name.equals(other.name) &&
                this.coordinates.equals(other.coordinates) &&
                this.enginePower.equals(other.enginePower) &&
                this.numberOfWheels.equals(other.numberOfWheels) &&
                this.capacity.equals(other.capacity) &&
                this.type.equals(other.type);
    }
}