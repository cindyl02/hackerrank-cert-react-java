/**
**/

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
     * Complete the 'getMinCost' function below.
     * Given a list crewId and jobId, each crew can only do one job, match each crew to each job
     * such that the distance that the crew has to travel is the min distance overall
     * ie: [1, 3, 5], [3, 5, 7]  => 6
     * 
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY crew_id
     *  2. INTEGER_ARRAY job_id
     */

    public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
    // Write your code here
        Integer[] crewArr = crew_id.toArray(new Integer[0]);
        Integer[] jobArr = job_id.toArray(new Integer[0]);
        Arrays.sort(crewArr);
        Arrays.sort(jobArr);

        int[][] matrix = new int[jobArr.length+1][crewArr.length+1];
        
        for(int i = 1; i < matrix.length; i++){
            matrix[i][1] = Math.abs(jobArr[i - 1] - crewArr[0]);
        }
        
        for(int j = 2; j < matrix[0].length; j++){
            matrix[1][j] = Math.abs(crewArr[j - 1] - jobArr[0]);
        }
        
        for(int i = 2; i < matrix.length; i++){
            for(int j = 2; j < matrix[0].length; j++){
                int distance = Math.abs(crewArr[j - 1] - jobArr[i - 1]);
                int prevDistance = Math.max(matrix[i][j - 1], matrix[i-1][j]);
                
                if(distance < prevDistance){
                    matrix[i][j] = distance + matrix[i-1][j-1];
                }else{
                    matrix[i][j] = prevDistance;
                }
            }
        }
        
        return matrix[matrix.length-1][matrix[0].length - 1];
    
    }

}

public class Solution {