package pms;

import java.util.InputMismatchException;

import java.util.Scanner;



public class Project extends User {
	String title;
	String task;
	Scanner in = new Scanner(System.in);
	
	void getProjectOperation() throws InvalidGroupNumberException {
		int choice=0, n;
		
		System.out.println("Select the operation : ");
		System.out.println("1.Assign Project     2.Edit Project details     3.Display Project Details      4.Exit");
		try {
		choice = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Enter an Integer");
			System.out.println();
			getOperation();
		}
		switch(choice) {
		case 1 :
		case 2 : try {
				 System.out.println("Enter Group number : ");
		         n = in.nextInt();
		         if(n<0 || n>gpNumberCt) {throw new InvalidGroupNumberException("Invalid Group Number or Group Not Added Yet");}
		         if(project[n] == null) project[n] = new Project();
		         project[n].assignProject();
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
		         
		case 3 : try{
				 System.out.println("Enter Group number : ");
				 n = in.nextInt();
				 if(n<0)throw new InvalidGroupNumberException("Invalid Group Number");
				 project[n].displayProjectDetails();
				}catch(NullPointerException e) {
					System.out.println("Project not assigned to this group no.");
					getOperation();
				}catch(ArrayIndexOutOfBoundsException e) {
					 System.out.println("Invalid Group Number");
					 getOperation();
				}catch(InputMismatchException e) {
					System.out.println("Enter an Integer");
					System.out.println();
					getOperation();
				}
				 break;
				 
		case 4 : System.out.println("Exited successfully...");
		         System.exit(0);
		         
		default : System.out.println("Invalid choice...Program Exited!!");
		          System.exit(0);
		         
		}
	}
	
	void assignProject() {
		System.out.println("Enter Project title : ");
		title = in.nextLine();
		System.out.println("Enter the current task assigned : ");
		task = in.nextLine();
	}
	
	void displayProjectDetails() {
		System.out.println("Project Title : "+title);
		System.out.println("Current task  : "+task);
		getOperation();
	}
}
