package lab5.VehicleCollectionApp.UserInput;

import lab5.VehicleCollectionApp.Exceptions.EOFInputException;
import lab5.VehicleCollectionApp.Exceptions.InputException;

import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class UserInput
{
    static BufferedReader activeReader;
    static public ArrayList<String> callList = new ArrayList<>();

    public static void setActiveReader(BufferedReader activeReader) {
        UserInput.activeReader = activeReader;
    }

    public static BufferedReader getActiveReader(){
        return activeReader;
    }

    public static void closeReader() {
        try {
            UserInput.activeReader.close();
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    public static String readLine() throws IOException, EOFInputException {
        String str = UserInput.activeReader.readLine();
        if(str == null){
            throw new EOFInputException("End of file");
        }
        return str;
    }

    public static String getString(String inputName) throws IOException, EOFInputException {
        System.out.print("\tEnter " + inputName + ": ");
        return readLine();
    }

    public static String getWord(String inputName) throws IOException, EOFInputException {
        return getString(inputName).split(" +")[0];
    }

    public static Integer getInteger(String inputName) throws IOException, InputException, EOFInputException {
        String input = getWord(inputName);
        if (input.equals("")) return null;

        Integer i = null;
        try {
            i = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new InputException("Input is not integer");
        }

        return i;
    }

    public static Double getDouble(String inputName) throws IOException, InputException, EOFInputException {
        String input = getWord(inputName);
        if (input.equals("")) return null;

        Double d = null;
        try {
            d = Double.parseDouble(input);
        }
        catch (NumberFormatException e) {
            throw new InputException("Input is not double");
        }

        return d;
    }

    public static Long getLong(String inputName) throws IOException, InputException, EOFInputException {
        String input = getWord(inputName);
        if (input.equals("")) return null;

        Long l = null;
        try {
            l = Long.parseLong(input);
        }
        catch (NumberFormatException e) {
            throw new InputException("Input is not long");
        }

        return l;
    }
}