package pms;

import java.util.InputMismatchException;

import java.util.Scanner;

class InvalidGroupNumberException extends Exception{
	String msg;
	public InvalidGroupNumberException(String msg) {
		this.msg = msg;
	}
	public String getMessage() {
		return msg;
	}
}

public class ProjectGroup extends User {
	String[] stdName = new String[3];
	String[] stdUsn  = new String[3];
	String gpLeadName, gpLeadUsn;
	int gpNumber;
	
	Scanner in = new Scanner(System.in);
	
	void getGroupOperation() throws InvalidGroupNumberException {			/*Determines which method to be called in this class*/
		String usn;
		int choice = 0, n;
		
		System.out.println("Select operation : ");
		System.out.println("1.Add Group   2.Edit Group   3.Display Group Details	4.EXIT");
		try {
		choice = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Enter an Integer");
			System.out.println();
			getOperation();
		}
		switch(choice) {
		case 1 : group[++grpCount] = new ProjectGroup();
				 group[grpCount].addGroup();
				 System.out.println();
				 getOperation();
				 break;
		case 2 : try {
				 System.out.println("Enter the group number : ");
				 n = in.nextInt();
				 if(n<0)throw new InvalidGroupNumberException("Invalid Group Number");
				 group[n].addGroup();
				 getOperation();
				}catch(NullPointerException e) {
					System.out.println("Group is not added yet");
					System.out.println();
					getOperation();
				}catch(ArrayIndexOutOfBoundsException e) {
					 System.out.println("Invalid Group Number");
					 System.out.println();
					 getOperation();
				 }catch(InputMismatchException e) {
        				System.out.println("Enter an Integer");
        				System.out.println();
        				getOperation();
        			}
				 break;
				 
		case 3 : try {
				 System.out.println("Enter group number : ");
				 n = in.nextInt();
				 if(n<0)throw new InvalidGroupNumberException("Invalid Group Number");
				 group[n].displayGroup();
				 }catch(NullPointerException e) {
						System.out.println("Group is not added yet");
						System.out.println();
						getOperation();
				}catch(ArrayIndexOutOfBoundsException e) {
						 System.out.println("Invalid Group Number");
						 System.out.println();
						 getOperation();
				 }catch(InputMismatchException e) {
        				System.out.println("Enter an Integer");
        				System.out.println();
        				getOperation();
        			}
				 break;
				 
		case 4 : System.out.println("Exited Successfully!!");
				 System.exit(0);
		default : System.out.println("Invalid choice...Program Exited!!");
 		   		  break;
		}
	}
	
	void addGroup() {		/*Adds new group*/
		System.out.println("Enter Group Leader Details : ");
		System.out.println("Enter Name : ");
		gpLeadName = in.nextLine();
		System.out.println("Enter USN : ");
		gpLeadUsn = in.nextLine();
		System.out.println("Enter the names of 3 students in a Group : ");
		for(int i=0 ; i<stdName.length ; i++) {
			stdName[i] = in.nextLine();
		}
		System.out.println("Enter the USN's of 3 students in a Group : ");
		for(int i=0 ; i<stdName.length ; i++) {
			stdUsn[i] = in.nextLine();
		}
		gpNumberCt+= 1 ;
		gpNumber = gpNumberCt;
		System.out.println("Group "+gpNumber+" added successfully...");
	}
	
	void displayGroup() {
		System.out.println("Group Number : "+gpNumber);
		System.out.println("Group Leader Details : ");
		System.out.println("Name : "+gpLeadName);
		System.out.println("USN  : "+gpLeadUsn);
		System.out.println();
		System.out.println("Names of Students : ");
		for(int i=0 ; i<stdName.length ; i++) {
			System.out.println(stdName[i]);
		}
		System.out.println();
		System.out.println("USN's of Students : ");
		for(int i=0 ; i<stdName.length ; i++) {
			System.out.println(stdUsn[i]);
		}
		System.out.println();
		getOperation();						/*Calls method in the User class to determine further operation*/
	}
	

}
