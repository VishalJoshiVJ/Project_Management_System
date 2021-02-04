package pms;

import java.util.InputMismatchException;

import java.util.Scanner;

public class ReportEvaluation extends EvaluationReport {
	String reportRemarks;
	Scanner in = new Scanner(System.in);
	
	void getReportOperation() throws InvalidGroupNumberException{
		int choice=0, n;
		String usn;
		
		System.out.println("Enter the operation : ");
		System.out.println("1.Assign report remarks & marks		2.Edit report marks    3.Display report marks    4.Exit");
		try {
		choice = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Enter an Integer");
			System.out.println();
			getOperation();
		}
		switch(choice) {
		case 1 : try {
				 System.out.println("Enter Group number : ");
		         n = in.nextInt();
		         if(n<0 || n>gpNumberCt)throw new InvalidGroupNumberException("Invalid Group Number or Group Not Added Yet");
		        		 if(present[n] == null) {
		        		 present[n] = new PresentationEvaluation();
		        		 }
		        		 present[n].assignReportRemarks();
		        		 present[n].assignReportMarks();
		        		 System.out.println();
		        		 getOperation();
				}catch(InvalidMarksException ime) {
					System.out.println(ime.getMessage());
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
		        		 
		case 2 : try {
		    	 	System.out.println("Enter Group number : ");
		    	 	n = in.nextInt();
		    	 	if(n<0)throw new InvalidGroupNumberException("Invalid Group Number");
		    	 	present[n].assignReportMarks();
		    	 	getOperation();
		        		break;
		            		 }catch(ArrayIndexOutOfBoundsException e) {
		            			 System.out.println("Invalid Group number");
		    		        	 getOperation();
		            		 }catch(NullPointerException e) {
		            			 System.out.println("Report Marks not assigned yet for this group, try again...");
		    		        	 getOperation();
		            		 }catch(InvalidMarksException ime) {
		            			 System.out.println(ime.getMessage());
		            			 getOperation();
		            		 }catch(InputMismatchException e) {
		         				System.out.println("Enter an Integer");
		         				System.out.println();
		         				getOperation();
		         			}
		        		 
		case 3 : try {
				 System.out.println("Enter Group number : ");
				 n = in.nextInt();
				 if(n<0)throw new InvalidGroupNumberException("Invalid Group Number");
		         present[n].displayReportMarks();
				 }catch(NullPointerException e) {
					 System.out.println("Invalid Group Number");
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
		         
		case 4 : System.out.println("Exitted Successfully...");
				 System.exit(0);
				 
		default : System.out.println("Invalid choice, Program Exitted...");
		          System.exit(0);
		}
	}
	
	void assignReportRemarks() {
		System.out.println("Give remarks for report : ");
		reportRemarks = in.nextLine();
	}
	void assignReportMarks() throws InvalidMarksException {
		System.out.println("Enter Marks for Report : ");
		for(int i=0 ; i<4 ; i++) {
		reMarks[i] = in.nextFloat();
		if(reMarks[i]<0) throw new InvalidMarksException("Invalid Marks Entered");
		}
	}
	void displayReportMarks() {
		System.out.println("Remarks : "+reportRemarks);
		System.out.println("Report Marks : ");
		for(int i = 0 ; i<4 ; i++) {
			System.out.println(reMarks[i]);
		}
		System.out.println();
		getOperation();
	}

}
