
public class Person {
		public int id;
		public String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	}
/* 	 class Student extends Person{
		public String branch;
		public int semester;
	}
	 class MyStack {
public static void main() { 
	Student student1 =new Student(); //here we can access id,name,branch and semester
	Person person1 = new Person(); // here we can access only id,name
	Person person2 = new Student(); //implement is the inheritance and the reference of the parent type holds the object of the child type
	//Student student2 = new Person(); //it defines as all the persons are students
    //the object refernce variable can hold the object of the same type or child type and the parent type
	Object object1 = new Student();
	Object object2 = new Person();
	Object object3 = new Object();
	//Person person3 = new Object();

	student1.semester =4; 
//	student2.semester=2;
	//person3.name="nithin";
	//object1.name="harish"; 
    //we cant get the access the name using object1 because no reference is available in object1so use it as
    student1.name="John";
	//object2.branch="ece";
	*/




