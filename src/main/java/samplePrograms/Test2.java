package samplePrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 tt = new Test2();
		List<List<Integer>> lot = new ArrayList();
		lot.add(Arrays.asList(1,0,0));
		lot.add(Arrays.asList(1,0,0));
		lot.add(Arrays.asList(1,9,1));
		tt.removeObstacle(3, 3, lot);
	}
	
	int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        // WRITE YOUR CODE HERE
		int distance = 0;
		int[][] arr = new int[numRows][numColumns];
		int[] obstacleIndex = new int[2];
		for(int i=0; i<numRows; i++) {
			List<Integer> row = lot.get(i);
			for(int j=0; j<numColumns; j++) {
				arr[i][j] = row.get(j);
				if(row.get(j) == 9) {
					obstacleIndex[0] = i;
					obstacleIndex[1] = j;
				}
			}
		}
		System.out.println(obstacleIndex[0] + " "+obstacleIndex[1] );
		
		for(int i=0; i<numRows; i++) {
			for(int j=0; j<numColumns; j++) {
				if(arr[i][j]==0) {
					distance = distance + 1;
					break;
				}else {
					distance = distance + 1;
				}
			}
		}
		
		return distance;
    }

}
