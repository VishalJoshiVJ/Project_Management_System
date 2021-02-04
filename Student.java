package pms;

import java.util.InputMismatchException;

import java.util.Scanner; 

class StudentNotAssignedYetException extends Exception{
	String msg;
	public StudentNotAssignedYetException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
}

class NegativeRollNumberException extends Exception{
	String msg;
	public NegativeRollNumberException(String msg) {
		super();
		this.msg = msg;
	}
	public String getMessage() {
		return msg;
	}
}

public class Student extends User {
	String stdName, stdUsn, stdAddress, stdEmailId;
	int rollNo, flag=0;
	
	Scanner in = new Scanner(System.in);
	
	
	
	 void getStudentOperation() throws StudentNotAssignedYetException {		/*Determines which method to be called in this class*/
			String usn;
			int choice =0;
			
			
			
			System.out.println("Select operation : ");
			System.out.println("1.Add Student   2.Edit Student   3.Display Student Details	4.EXIT");
			try {
			choice = in.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Enter an Integer");
				System.out.println();
				getOperation();
			}
			switch(choice) {
			case 1 : try {
					 student[++stdCount] = new Student();
					 student[stdCount].addStudent();
					 getOperation();
					 break;
					}catch(NegativeRollNumberException nre) {
						System.out.println(nre.getMessage());
						System.out.println();
						getOperation();
					}
			case 2 :try {
					 System.out.println("Enter USN of Student : ");
					 usn = in.next();
					 for(int j=0 ; j<=stdCount ; j++) {
						 if(student[j].stdUsn.equals(usn)) {
							 student[j].editStudent();
							 student[j].displayDetails();
							 flag = 1;
							 break;
						 }
					 }
					 if(flag==0)throw new StudentNotAssignedYetException("The Student has not been Added yet");
					 flag = 0;
					}catch(NegativeRollNumberException nre) {
						System.out.println(nre.getMessage());
						System.out.println();
						getOperation();
					}
					 break;
			case 3 :  System.out.println("Enter USN of Student : ");
			 		 usn = in.next();
			 		 for(int j=0 ; j<=stdCount ; j++) {
			 			 if(student[j].stdUsn.equals(usn)) {
			 				 student[j].displayDetails();
			 				 flag = 1;
			 				 break;
			 			 }
			 		 }if(flag==0)throw new StudentNotAssignedYetException("The Student has not been Added yet");
			 		 flag = 0;
			 		 break;
			case 4 : System.out.println("Exited Successfully!!");
					 System.exit(0);
			 default : System.out.println("Invalid choice...Program Exited!!");
			 		   break;
			}
		}
	
	void addStudent() throws NegativeRollNumberException {			/*Adds new student*/
		
		System.out.println("Enter Name of the Student	 : ");
		stdName = in.nextLine();
		System.out.println("Enter USN of the Student 	 : ");
		stdUsn = in.nextLine();
		System.out.println("Enter Address of Student 	 :  ");
		stdAddress = in.nextLine();
		System.out.println("Enter Roll number of Student : ");
		try {
		rollNo = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Roll number must be an Integer");
			System.out.println();
			getOperation();
		}
		if(rollNo<0)throw new NegativeRollNumberException("Cannot accept negative roll no.");
		
		System.out.println("Enter Email ID of Student 	 :");
		stdEmailId = in.next();
		System.out.println("Student added successfully...");
	}
	
	void editStudent() throws NegativeRollNumberException {		/*Edites student info*/
		int choice;
		Scanner in = new Scanner(System.in);
		System.out.println("Select the information to be edited :");
		System.out.println("1.Name		2.USN		3.Address		4.Roll Number		5.Email ID");
		choice = in.nextInt();
		switch(choice) {
		case 1 : System.out.println("Enter the Name : ");
				 in.nextLine();
				 stdName = in.nextLine();
				 System.out.println("Name edited successfully...");
				 break;
		case 2 : System.out.println("Enter the USN : ");
				 stdUsn = in.next();
				 System.out.println("USN edited successfully...");
				 break;
		case 3 : System.out.println("Enter the Address : ");
				 in.nextLine();
				 stdAddress = in.nextLine();
				 System.out.println("Address edited successfully...");
				 break;
		case 4 : System.out.println("Enter Roll Number : ");
				 try {
				 rollNo = in.nextInt();
				 }catch(InputMismatchException e) {
						System.out.println("Roll number must be an Integer");
						System.out.println();
						getOperation();
					}
				 if(rollNo<0)throw new NegativeRollNumberException("Cannot accept negative roll no.");
				 else System.out.println("Roll Number edited successfully...");
				 break;
		case 5 : System.out.println("Enter Email ID : ");
				 stdEmailId = in.next();
				 System.out.println("Email ID edited successfully...");
				 break;
		default : System.out.println("Invalid choice...");
				  break;
		}
		
	}
	
	void displayDetails() {			
		
		System.out.println("Name 		: "+stdName);
		System.out.println("USN  		: "+stdUsn);
		System.out.println("Address 	: "+stdAddress);
		System.out.println("Roll Number 	: "+rollNo);
		System.out.println("Email ID    	: "+stdEmailId);
		System.out.println();
		getOperation();		/*Calls method in the User class to determine further operation*/
	}

}
