package pms;

import java.util.InputMismatchException;

import java.util.Scanner;

class InvalidMarksException extends Exception{
	String msg;
	public InvalidMarksException(String msg) {
		super();
		this.msg = msg;
	}
	public String getMessage() {
		return msg;
	}
}

public class EvaluationReport extends User {
    float[] reMarks = new float[4];
    float[] prMarks = new float[4];
    float[] totalMarks = new float[4];
    String finalRemarks;
    
    Scanner in = new Scanner(System.in);
    
    void getMarksOperation() throws InvalidGroupNumberException {
		int choice=0, n;
		
		System.out.println("Enter the operation : ");
		System.out.println("1.Assign final remarks    2.Display Final marks    3.Exit");
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
		         if(present[n] == null) 
		         present[n] = new PresentationEvaluation();
		         present[n].assignRemarks();
		         getOperation();
				}catch(InputMismatchException e) {
					System.out.println("Enter an Integer");
					System.out.println();
					getOperation();
				}
		         break;
		         
		case 2 :try {
				 System.out.println("Enter Group number : ");
				 n = in.nextInt();
				 if(n<0 || n>gpNumberCt)throw new InvalidGroupNumberException("Invalid Group Number");
				 present[n].computeTotalMarks();
		         present[n].displayTotalMarks();
				}catch(InvalidMarksException ime) {
					System.out.println(ime.getMessage());
					getOperation();
				}catch(InputMismatchException e) {
					System.out.println("Enter an Integer");
					System.out.println();
					getOperation();
				}
		         break;
		         
		case 3 : System.out.println("Exitted Successfully...");
				 System.exit(0);
				 
		default : System.out.println("Invalid choice, Program Exitted...");
		          System.exit(0);
		}
	}
    
    void assignRemarks() {
    	System.out.println("Give overall remarks : ");
    	finalRemarks = in.nextLine();
    }
    void computeTotalMarks() throws InvalidMarksException {
    	for(int i=0 ; i<4 ; i++) {
    	totalMarks[i] = prMarks[i] + reMarks[i];
    	if(totalMarks[i]<0) throw new InvalidMarksException("Invalid Marks Entered");
    	}
    }
    void displayTotalMarks() {
    	System.out.println("Total Marks are : ");
    	for(int i=0 ; i<4 ; i++) {
    		System.out.println(totalMarks[i]);
    	}
    	System.out.println();
    	getOperation();
    }
}
