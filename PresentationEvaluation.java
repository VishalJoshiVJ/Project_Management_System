package pms;

import java.util.InputMismatchException;

import java.util.Scanner;

public class PresentationEvaluation extends ReportEvaluation {
	String prRemarks;
	Scanner in = new Scanner(System.in);
	
	
	
	void getPresentOperation() throws InvalidGroupNumberException {
		int choice=0;
		int n;
	
		System.out.println("Enter the operation : ");
		System.out.println("1.Assign presentation remarks & marks    2.Edit Marks    3.Display presentation marks    4.Exit");
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
		         if(present[n] == null) present[n] = new PresentationEvaluation();
		         present[n].assignPreRemarks();
		         present[n].assignPreMarks();
		         System.out.println();
		         getOperation();
		         break;
		         }catch(ArrayIndexOutOfBoundsException e) {
		        	 System.out.println("Invalid Group number, try again...");
		        	 System.out.println();
		        	 getOperation();
		         }catch(InvalidMarksException ime) {
        			 System.out.println(ime.getMessage());
        			 System.out.println();
        			 getOperation();
        		 }catch(InputMismatchException e) {
     				System.out.println("Enter an Integer");
    				System.out.println();
    				getOperation();
    			}
		         
		case 2 : try {
				 System.out.println("Enter Group number : ");
        		 n = in.nextInt();
        		 if(n<0)throw new InvalidGroupNumberException("Invalid Group Number");
        		 present[n].assignPreMarks();
        		 System.out.println();
        		 getOperation();
        		 break;
        		 }catch(ArrayIndexOutOfBoundsException e) {
        			 System.out.println("Invalid Group number, try again...");
        			 System.out.println();
		        	 getOperation();
        		 }catch(NullPointerException e) {
        			 System.out.println("Presentation Marks not assigned yet for this group, try again...");
        			 System.out.println();
		        	 getOperation();
        		 }catch(InvalidMarksException ime) {
        			 System.out.println(ime.getMessage());
        			 System.out.println();
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
				present[n].displayPreMarks();
		         break;
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Invalid Group number, try again...");
					System.out.println();
		        	 getOperation();
				}catch(NullPointerException e) {
					System.out.println("Marks not assigned yet for this group, try again...");
					System.out.println();
		        	 getOperation();
				}catch(InputMismatchException e) {
					System.out.println("Enter an Integer");
					System.out.println();
					getOperation();
				}
				
		         
		case 4 : System.out.println("Exited Successfully...");
				 System.exit(0);
				 
		default : System.out.println("Invalid choice, Program Exited...");
		          System.exit(0);
		}
	}
	
	void assignPreRemarks() {
		System.out.println("Assign remarks for Presentation : ");
		prRemarks = in.next();
	}
	void assignPreMarks() throws InvalidMarksException {
		System.out.println("Enter marks of four students for Presentation : ");
		for(int i=0 ; i<4 ; i++) {
		prMarks[i] = in.nextFloat();
		if(prMarks[i]<0) throw new InvalidMarksException("Invalid Marks Entered");
		}
		}
	void displayPreMarks() {
		System.out.println("Remarks assigned : "+prRemarks);
		System.out.println("Presentation marks are : ");
		for(int i=0 ; i<4 ; i++) {
			System.out.println(prMarks[i]);
		}
		System.out.println();
		getOperation();
	}
}
