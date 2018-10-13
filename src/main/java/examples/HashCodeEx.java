package examples;

import java.util.Objects;

public class HashCodeEx {

	String s;
	int j;
	Object k;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		HashCodeEx other = (HashCodeEx) obj;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}*/

	public int hashCode() {
		return Objects.hash(s,j,k); //Objects is an java.util utility class
	}
	
	/*public int hashCode() {
		return new HashCodeBuilder(17, 37).
				append(s).hashCode();
	}*/

	/*public int hashCode() {	
		// Start with a non-zero constant. Prime is preferred
		int result = 17;

		// Include a hash for each field.

		// Primatives
		result = 31 * result + (booleanField ? 1 : 0);                   // 1 bit   » 32-bit
		result = 31 * result + byteField;                                // 8 bits  » 32-bit 
		result = 31 * result + charField;                                // 16 bits » 32-bit
		result = 31 * result + shortField;                               // 16 bits » 32-bit
		result = 31 * result + intField;                                 // 32 bits » 32-bit

		result = 31 * result + (int)(longField ^ (longField >>> 32));    // 64 bits » 32-bit

		result = 31 * result + Float.floatToIntBits(floatField);         // 32 bits » 32-bit

		long doubleFieldBits = Double.doubleToLongBits(doubleField);     // 64 bits (double) » 64-bit (long) » 32-bit (int)
		result = 31 * result + (int)(doubleFieldBits ^ (doubleFieldBits >>> 32));

		// Objects
		result = 31 * result + Arrays.hashCode(arrayField);              // var bits » 32-bit
		result = 31 * result + referenceField.hashCode();                // var bits » 32-bit (non-nullable)   
		result = 31 * result +                                           // var bits » 32-bit (nullable)   
				(nullableReferenceField == null
				? 0
						: nullableReferenceField.hashCode());

		return result;
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
