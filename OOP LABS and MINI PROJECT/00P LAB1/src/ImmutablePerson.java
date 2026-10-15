public class ImmutablePerson {
    //private final fields :assigned once in the constructor,never changed
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age){
        this.name = name;
        this.age = age;
    }
    //Getters only,no setters

    public String getName() {
            return name;
    }

    public int getAge() {
        return age;
    }
    public static void main(String[] args){
        ImmutablePerson p = new ImmutablePerson("Merit", 21);
        System.out.println(p.getName() + " , " + p.getAge()); //Merit 21
    }
}
