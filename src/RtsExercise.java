import java.util.*;


public class RtsExercise {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList();
        numbers.add(1);
        numbers.add(5);
        numbers.add(2);
        numbers.add(1);
        numbers.add(10);
        numbers.add(13);
        numbers.add(9);
        numbers.add(76);
        numbers.add(10);
        numbers.add(35);
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(6);
        numbers.add(7);

        // 1,1,2,5,10
        Map output = aboveBelow(numbers, 6);
        Map output2 = aboveBelow(new ArrayList<Integer>(), 6);
        System.out.println("above:" + output.get("above"));
        System.out.println("below:" + output.get("below"));
        System.out.println(output2);

        System.out.println(stringRotation("MyString",2));
        System.out.println(stringRotation("Tahirshah",5));
        System.out.println(stringRotation("",5));
        System.out.println(stringRotation("There",5));

    }

    /**
     * This method returns the number of integers above and below the number given.
     * @param listOfNumbers Unsorted list of numbers.
     * @param number Number to compare the list elements to.
     * @return the number of integers above and below the number given.
     */
    public static Map aboveBelow(List<Integer> listOfNumbers, int number) {
        Collections.sort(listOfNumbers);
        if (listOfNumbers.size() == 0 || listOfNumbers.isEmpty()) {
            return null;
        }
        String above = "above";
        String below = "below";
        Map<String, Integer> outputMap = new HashMap<>(){{
            put(above,0);
            put(below,0);
        }};
        int ctr;
        for (ctr = 0; ctr < listOfNumbers.size(); ctr++) {
            if (listOfNumbers.get(ctr) < number) {
                outputMap.replace(below,outputMap.get(below).intValue(),outputMap.get(below).intValue() + 1);
            } else if (listOfNumbers.get(ctr) == number) {
                continue;
            } else {
                break;
            }
        }
        outputMap.replace(above,outputMap.get(above).intValue(),listOfNumbers.size() - ctr);
        return outputMap;
    }

    /**
     * This method rotates a string to the right by the given amount.
     * @param original Original string to be rotated.
     * @param number Number or spots to rotate each character.
     * @return The rotated string.
     */
    public static String stringRotation (String original, int number) {
        String outputString = "";
        if (original.isEmpty()) {
            return null;
        }
        for (int ctr = original.length() - number; ctr < original.length(); ctr++){
            outputString += original.charAt(ctr);
        }
        for (int ctr2 = 0; ctr2 < original.length() - number; ctr2++){
            outputString += original.charAt(ctr2);
        }
        return outputString;
    }
}
