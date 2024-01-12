import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findSubstring' function below.
     *
     * Given a string, return lowest index substring with length k that contains the most vowels 
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String findSubstring(String s, int k) {
    // Write your code here
        Character[] vowelsArr = {'a', 'e', 'i', 'o', 'u'};
        List<Character> vowels = Arrays.asList(vowelsArr);
        int currCount = 0;
        int lowestIndex = 0;
        
        for(int i = 0; i < k; i++){
            if(vowels.contains(s.charAt(i))){
                currCount++;
            }
        }
        int bestCount = currCount;
        
        for(int i = k; i < s.length(); i++){
            Character prev = s.charAt(i - k);
            Character curr = s.charAt(i);
            if(vowels.contains(prev)){
                currCount--;
            }
            if(vowels.contains(curr)){
                currCount++;
            }
            if(currCount > bestCount){
                bestCount = currCount;
                lowestIndex = i - k + 1;
            }
        }
        
        return bestCount == 0 ? "Not found!" : s.substring(lowestIndex, lowestIndex + k);
    }

}

public class Solution {