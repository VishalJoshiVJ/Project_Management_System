package pms;

import java.util.InputMismatchException;

import java.util.Scanner;

class NoGuideFoundException extends Exception{
	String msg;
	public NoGuideFoundException(String msg) {
		super();
		this.msg = msg;
	}
	public String getMessage() {
		return msg;
	}
}

public class ProjectGuide extends User {
    
    
    
    String gdName,gdId,gdAddress,gdEmailId;
    
    Scanner in=new Scanner(System.in);
    
    void getGuideOperation() throws NoGuideFoundException{
        int choice=0, flag=0;
        String id;
        int n = 0;
        
        
        System.out.println("Select operation :");
        System.out.println("1.Assign Guide   2.Edit Guide   3.Display Guide Details		4.EXIT");
        try {
        choice=in.nextInt();
        }catch(InputMismatchException e) {
			System.out.println("Enter an Integer");
			System.out.println();
			getOperation();
		}
       
        switch(choice)
        {
            case 1 : try {
            		 System.out.println("Enter the group number : ");
            		 n = in.nextInt();
            		 if(n<=gpNumberCt) {
            		 guide[n] = new ProjectGuide();
            		 guide[n].assignGuide();
            		 System.out.println();
            		 getOperation();
            		}
            		else {
            			System.out.println("Group Not Added Yet");
            			System.out.println();
            			getOperation();
            		}
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
                         
                           
            case 2 :  try {
            			   System.out.println("Enter the Group Number : ");
                           n = in.nextInt();
                           guide[n].editGuide();
                           System.out.println();
                           getOperation();
                           }catch(NullPointerException e) {
                        	   System.out.println("Guide not added yet...");
                        	   System.out.println();
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
                           
            case 3 : System.out.println("Enter the Group Number : ");
            		 try {
            			n = in.nextInt();
            		 
            			 guide[n].displayDetails();
            			 System.out.println();
            			 getOperation();
            		 }catch(NullPointerException e) {
            			 System.out.println("Guide not added yet...");
            			 System.out.println();
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
                           
            case 4  :  System.out.println("Exited Successfully!!");
                            System.exit(0);
                            
            default : System.out.println("Invalid choice.....Program Exited");
                            break;
                           
        }
        
    }
    
    
    void assignGuide(){
        System.out.println("Enter Name of the Guide   : ");
        gdName = in.nextLine();
        System.out.println("Enter ID of the Guide   : ");
        gdId = in.nextLine();
        System.out.println("Enter Address of Guide   :  ");
        gdAddress = in.nextLine();
        System.out.println("Enter Email ID of Guide  :");
        gdEmailId = in.next();
        System.out.println("Guide assiged successfully...");
    }
    
    void editGuide(){
        int choice;
        
        System.out.println("Select the information to be edited :");
        System.out.println("1.Name	    2.USN	   3.Address        4.Email ID");
        choice = in.nextInt();
        switch(choice) {
            case 1 : System.out.println("Enter the Name : ");
            		 in.nextLine();
            		 gdName = in.nextLine();
                          System.out.println("Name edited successfully...");
                          break;
            case 2 : System.out.println("Enter the ID : ");
                          gdId = in.next();
                          System.out.println("ID edited successfully...");
                          break;
            case 3 : System.out.println("Enter the Address : ");
            		 in.nextLine();
                          gdAddress = in.next();
                          System.out.println("Address edited successfully...");
                          break;
            case 4 : System.out.println("Enter Email ID : ");
                          gdEmailId = in.next();
                          System.out.println("Email ID edited successfully...");
                          break;
            default : System.out.println("Invalid choice...");
                            break;
        }
    }
    
    void displayDetails() {			
		
            System.out.println("Name 	     : "+gdName);
            System.out.println("ID           : "+gdId);
            System.out.println("Address      : "+gdAddress);
            System.out.println("Email ID     :"+gdEmailId);
            System.out.println();
            getOperation();
            	
    }

}
