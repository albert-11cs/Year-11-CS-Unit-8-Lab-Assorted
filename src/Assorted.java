import java.util.ArrayList;
import java.util.List;

public class Assorted {

    // Challenge 1
    public static int findSum(List<?> list) {
        int sum = 0;
        for (Object element:list) {
            if (element instanceof Integer) {
                sum += (Integer) element;
            } else if (element instanceof String) {
                sum += Integer.parseInt((String) element);
            }
        }
        return sum;
    }

    // Challenge 2
    public static List<Integer> filterStrings(List<?> list) {
        List<Integer> result = new ArrayList<>();
        for (Object element:list) {
            if (element instanceof Integer) {
                result.add((Integer) element);
            }
        }
        return result;
    }

    // Challenge 3
    public static List<String> lineNumbering(List<String> list) {
        List<String> result = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            result.add((i+1) + ": " + list.get(i));
        }
        return result;
    }

    // Challenge 4
    public static int busStop(List<Integer[]> list) {
        int passengers = 0;
        for (Integer[] stop:list) {
            passengers += stop[0] - stop[1];
        }
        return passengers;
    }

    // Challenge 5
    public static int toBinary(List<Integer> list) {
        int result = 0;
        for (int i = 0; i<list.size(); i++) {
            result += list.get(i) * Math.pow(2, list.size()-i-1);
        }
        return result;
    }

    // Challenge 6
    public static List<Integer> subtractList(List<Integer> listA, List<Integer> listB) {
        List<Integer> result = new ArrayList<>();
        for (Integer num:listA) {
            if (!listB.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    // Challenge 7
    public static List<Integer> sortOdd(List<Integer> list) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer num:list) {
            if (num%2 != 0) {
                oddNumbers.add(num);
            }
        }
        oddNumbers.sort(Integer::compareTo);
        int oddIndex = 0;
        List<Integer> result = new ArrayList<>(list);
        for (int i=0;i<result.size();i++) {
            if (result.get(i)%2 != 0) {
                result.set(i, oddNumbers.get(oddIndex++));
            }
        }
        return result;
    }

    // Challenge 8

    private static boolean isUniqueNumber(int number) {
        String numStr = Integer.toString(number);
        int sum = 0;
        for (int i=0;i<numStr.length();i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += Math.pow(digit, i + 1);
        }
        return sum == number;
    }
    public static List<Integer> uniqueNumber(int lowerBound, int upperBound) {
        List<Integer> result = new ArrayList<>();
        for (int i=lowerBound;i<=upperBound;i++) {
            if (isUniqueNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    // Challenge 9

    private static int countOccurrences(List<Integer> list, int num) {
        int count = 0;
        for (Integer element:list) {
            if (element == num) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> filterNTimes(List<Integer> list, int n) {
        List<Integer> result = new ArrayList<>();
        for (Integer num:list) {
            if (countOccurrences(result, num) < n) {
                result.add(num);
            }
        }
        return result;
    }

    // Challenge 10

    private static boolean isOpposite(String dir1, String dir2) {
        return (dir1.equals("NORTH") && dir2.equals("SOUTH")) ||
                (dir1.equals("SOUTH") && dir2.equals("NORTH")) ||
                (dir1.equals("EAST") && dir2.equals("WEST")) ||
                (dir1.equals("WEST") && dir2.equals("EAST"));
    }

    public static List<String> wildWest(List<String> directions) {
        List<String> result = new ArrayList<>();
        for (String direction:directions) {
            if (!result.isEmpty() && isOpposite(result.get(result.size() - 1), direction)) {
                result.remove(result.size() - 1);
            } else {
                result.add(direction);
            }
        }
        return result;
    }

    // Challenge 11
    public static int queueTime(List<Integer> queue, int tillsOpen) {
        int[] tills = new int[tillsOpen];
        for (Integer time:queue) {
            int minIndex = 0;
            for (int i=1;i<tills.length;i++) {
                if (tills[i] < tills[minIndex]) {
                    minIndex = i;
                }
            }
            tills[minIndex] += time;
        }
        int maxTime = 0;
        for (int time:tills) {
            if (time > maxTime) {
                maxTime = time;
            }
        }
        return maxTime;
    }
}
