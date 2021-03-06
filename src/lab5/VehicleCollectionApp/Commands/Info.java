package lab5.VehicleCollectionApp.Commands;

import lab5.VehicleCollectionApp.Exceptions.InputException;
import lab5.VehicleCollectionApp.VehicleCollection;

public class Info extends CollectionCommand
{
    public Info(VehicleCollection collection) {
        super(collection);
    }

    @Override
    public void execute(String[] params) throws InputException {
        System.out.println("Information about Vehicle collection:");
        System.out.println(collection.info());
    }

    @Override
    public String getHelp() {
        return "Prints information about collection.";
    }
}
