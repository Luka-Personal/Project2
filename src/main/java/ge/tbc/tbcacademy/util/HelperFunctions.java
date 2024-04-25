package ge.tbc.tbcacademy.util;

public class HelperFunctions {
    public static int getNumbersFromMixedString(String str) {
        System.out.println("CONFLICT 4");
        return Integer.parseInt(str.replaceAll("[^\\d.%]", "").replace("%", ""));
    }
}
