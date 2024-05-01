import java.util.Scanner;

public class StudentGradeCalculator {
	int total_marks=0;
	float avgPercent;
	String grade;
	String name;

	public void display() {
		System.out.println("*******CONGRATULATIONS "+name.toUpperCase()+" *******");
		System.out.println("\nYour Total Marks:"+total_marks);
		System.out.println("\nYour Average Percentage:"+avgPercent);
		System.out.println("\nyou PASSED with GRADE:"+grade);
		
	}
	public void studentDetails() {
		 Scanner sc=new Scanner(System.in);
		System.out.println("enter student name:");
		 name=sc.nextLine();
		System.out.println("\nEnter number of subjects");
		int no_subject=sc.nextInt();
		for(int i=0;i<no_subject;i++) {
			System.out.println("Enter Subject "+(i+1)+" Marks");
			int marks=sc.nextInt();
			total_marks+=marks;
		}
		avgPercent=total_marks/no_subject;
		
		if(avgPercent>=90)
		{
			grade="A+";
		}
		else if (avgPercent>=80) {
			grade="A";
		}
		else if(avgPercent>=70)
		{
			grade="B";
		}
		else if(avgPercent>=60)
		{
			grade="C";
		}
		else if(avgPercent>=50)
		{
			grade="D";
		}
		else {
			grade="E";
		}
		
	}
	
	public static void main(String[] args) {
		StudentGradeCalculator s=new StudentGradeCalculator();
		System.out.println("*****STUDENT GRADE CALCULATOR*********");
		s.studentDetails();
		s.display();
	}

}
