package samplePrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 tt = new Test1();
		List<List<Integer>> allLocations = new ArrayList();
		allLocations.add(Arrays.asList(1,2));
		allLocations.add(Arrays.asList(3,4));
		allLocations.add(Arrays.asList(1,-1));
		System.out.println(tt.nearestXsteakHouses(3, allLocations, 2));
	}

	List<List<Integer>> nearestXsteakHouses(int totalSteakhouses,
			List<List<Integer>> allLocations, 
			int numSteakhouses)
	{
		List<LocationDistance> data = new ArrayList<LocationDistance>();
		/*for(int i = 0; i < allLocations.size(); i++) {
			data.add(new LocationDistance(allLocations.get(i)));
		}*/
		allLocations.stream().forEach(location -> data.add(new LocationDistance(location)));
		
		data.sort(Comparator.naturalOrder());
		
		System.out.println(data);
		List<List<Integer>> locations = new ArrayList(); 
		for(int i = 0; i<numSteakhouses; i++) {
			locations.add(data.get(i).location);
		}
		return locations;
	}
	
	class LocationDistance implements Comparable<LocationDistance>{
		double distance;
		List<Integer> location;
		
		public LocationDistance(List location) {
			this.location = location;
			distance = Math.sqrt(Math.pow((Integer) location.get(0),2) + Math.pow((Integer) location.get(1),2));
		}

		@Override
		public int compareTo(LocationDistance loc) {
			if(distance == loc.distance) {
				return 0;
			} else if(distance > loc.distance) {
				return 1;
			} else {
				return -1;
			}
		}

		/*public double getDistance() {
			return distance;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}

		public List<Integer> getLocation() {
			return location;
		}

		public void setLocation(List<Integer> location) {
			this.location = location;
		}*/

		/*@Override
		public String toString() {
			return "LocationDistance [distance=" + distance + ", location=" + location + "]";
		}*/
	}
	
	public static void doS() {
		System.out.println(Math.sqrt(Math.pow(3,2) + Math.pow(5,2)));
	}
}
