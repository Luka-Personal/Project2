package ge.tbc.tbcacademy.util;

public class HelperFunctions {
    public static int getNumbersFromMixedString(String str) {
        return Integer.parseInt(str.replaceAll("[^\\d.%]", "").replace("%", ""));
    }
}
