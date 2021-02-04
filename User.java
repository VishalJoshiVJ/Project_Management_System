package pms;

import java.util.InputMismatchException;

import java.util.Scanner;

public class User {
	int stdCount=-1, grpCount=0;
	static int gpNumberCt=0;
	Student[] student = new Student[50];
	ProjectGroup[] group = new ProjectGroup[20];
	ProjectGuide[] guide = new ProjectGuide[20];
	Project[] project = new Project[20];
	PresentationEvaluation[] present = new PresentationEvaluation[20];
	
	static Student st = new Student();
	static ProjectGroup pg = new ProjectGroup();
	static ProjectGuide gd = new ProjectGuide();
	static Project pj = new Project();
	static PresentationEvaluation pe = new PresentationEvaluation();
	
	
	 static void getOperation() {		/*Determines which class to be used*/
		
			int choice = 0;
			Scanner in = new Scanner(System.in);
			System.out.println("Select the type of operation :");
			System.out.println("1.Student  2.Group  3.Guide  4.Project  5.Presentation  6.Report  7.Final Marks  8.EXIT");
			try {
			choice = in.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Enter an Integer");
				System.out.println();
				getOperation();
			}
			switch(choice) {
			case 1 :try {
					 st.getStudentOperation();
					}catch(StudentNotAssignedYetException sne) {
						System.out.println(sne.getMessage());
						getOperation();
					}
					 break;
			case 2 : try {
					 pg.getGroupOperation();
					}catch(InvalidGroupNumberException ige) {
						System.out.println(ige.getMessage());
						getOperation();
					}
			 		 break;
			case 3 : try {
					 gd.getGuideOperation();
					}catch(NoGuideFoundException nge) {
						System.out.println(nge.getMessage());
						getOperation();
					}
					 break;
			case 4 : try {
					 pj.getProjectOperation();
					}catch(InvalidGroupNumberException ige) {
						System.out.println(ige.getMessage());
						getOperation();
					}
					 break;
			case 5 : try {
					 pe.getPresentOperation();
					}catch(InvalidGroupNumberException ige) {
						System.out.println(ige.getMessage());
						getOperation();
					}
					 break;
			case 6 : try {
					 pe.getReportOperation();
					}catch(InvalidGroupNumberException ige) {
						System.out.println(ige.getMessage());
						getOperation();
					}
					 break;
			case 7 : try {
					 pe.getMarksOperation();
					}catch(InvalidGroupNumberException ige) {
						System.out.println(ige.getMessage());
						getOperation();
					}
					 break;
			case 8 : System.out.println("Exited Successfully!!");
					 System.exit(0);
			default : System.out.println("Invalid choice...Program Exited!!");
					  break;
			}
			
		}
		
		
		 
		 
		 
	public static void main(String[] args) {
		 
		getOperation();

	}

}
