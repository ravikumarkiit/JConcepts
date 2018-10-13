package samplePrograms;

public class ConnectedElement {

	public static void main(String[] args) {
		int[][] arr = {
	            {0,0,1,0},
	            {0,1,1,1},
	            {0,1,1,0},
	            {0,1,1,0}
	    };
		

	for(int i=0; i<arr.length; i++) {
	    for (int j = 0; j<arr[i].length; j++) {
	       /* if(arr[i][j] == 0) {
	        break;
	        }*/
	        if(j> 0 && i >0 && i< arr.length-1 && j < arr[i].length-1)
	        	{
	        	if(arr[i][j] != 0 && arr[i][j] == 1 && arr[i][j-1] == 1 && arr[i][j+1] == 1 && arr[i-1][j] ==1 && arr[i+1][j] == 1) {
	        		System.out.println("element found at row "+ i+ " col "+ j);
	        	}
	        }
	    }
	}
	
	for(int i=0; i<arr.length; i++) {
	    for (int j = 0; j<arr[i].length; j++) {
	    	System.out.println(arr[i][j]);
	    	if(i==1 && j==1) {
	    		break;
	    	}
	    }
	    System.out.println(" ");
	}

}
}
