package immutableClass;

/**
 * @author ravik
 * 1. Final Class: Ensure that the class can’t be extended
 * 2. All fields: private and final
 * 3. No methods that modify the object’s state
 * 4. While initializing mutable fields: set the clone of the input data.
 * 5. While getting mutable fields     : return clone of the field
 */
final class ImmutableStudent { //Immutable Class having mutable data type Age
    private final int id;
    private final String name;
    private final Age age; // Mutable data type, How to handle?? 
    int dsf;
    
    public ImmutableStudent(int id, String name, Age age) {
    this.name = name;
    this.id = id;
    
    Age cloneAge = new Age();
    cloneAge.setDay(age.getDay());
    cloneAge.setMonth(age.getMonth());
    cloneAge.setYear(age.getYear());
    this.age = cloneAge;
    }
    
    public int getId() {
    return id;
    }
    
    public String getName() {
    return name;
    }
    
    public Age getAge() {
        Age cloneAge = new Age();
        cloneAge.setDay(this.age.getDay());
        cloneAge.setMonth(this.age.getMonth());
        cloneAge.setYear(this.age.getYear());
        return cloneAge;
    }
    
}
