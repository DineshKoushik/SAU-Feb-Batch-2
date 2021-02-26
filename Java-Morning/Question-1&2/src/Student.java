import java.io.Serializable;

public class Student implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int roll;
    public int marks;
    public Student(int roll,int marks){
        this.roll=roll;
        this.marks=marks;
    }
}