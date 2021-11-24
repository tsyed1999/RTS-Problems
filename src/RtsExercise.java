import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains the methods aboveBelow and stringRotation
 */
public class RtsExercise {
    /**
     * This method returns the number of integers above and below the number given.
     * @param listOfNumbers Unsorted list of numbers.
     * @param number Number to compare the list elements to.
     * @return the number of integers above and below the number given.
     */
    public static Map aboveBelow(List<Integer> listOfNumbers, int number) {
        Collections.sort(listOfNumbers);
        //Checking if the list is null or empty
        if (listOfNumbers.size() == 0 || listOfNumbers.isEmpty()) {
            return null;
        }
        //Creating the Map to return
        String above = "above";
        String below = "below";
        Map<String, Integer> outputMap = new HashMap<>(){{
            put(above,0);
            put(below,0);
        }};
        int ctr;
        //Iterating through the list until the first element greater than the target number
        for (ctr = 0; ctr < listOfNumbers.size(); ctr++) {
            if (listOfNumbers.get(ctr) < number) {
                outputMap.replace(below,outputMap.get(below).intValue(),outputMap.get(below).intValue() + 1);
            } else if (listOfNumbers.get(ctr) == number) {
                continue;
            } else {
                break;
            }
        }
        //Adding the rest of the elements to the "above" key in the map
        outputMap.replace(above,outputMap.get(above).intValue(),listOfNumbers.size() - ctr);
        return outputMap;
    }

    /**
     * This method rotates a string to the right by the given amount.
     * @param original Original string to be rotated.
     * @param rotationNumber Number of spots to rotate each character.
     * @return The rotated string.
     */
    public static String stringRotation(String original, int rotationNumber) {
        String outputString = "";
        //Checking if the original string is empty or if the rotation number is greater than the string length
        if (original.isEmpty() || (rotationNumber > original.length())) {
            return null;
        }
        //Adding the last 'rotationNumber' characters of the string to the output string.
        for (int ctr = original.length() - rotationNumber; ctr < original.length(); ctr++){
            outputString += original.charAt(ctr);
        }
        //Adding the remaining characters from the beginning to the output string.
        for (int ctr2 = 0; ctr2 < original.length() - rotationNumber; ctr2++){
            outputString += original.charAt(ctr2);
        }
        return outputString;
    }
}
