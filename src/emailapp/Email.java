package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultpasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "xyz.com";
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
//		System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
		
		this.department = setDepartment();
//		System.out.println("Department: " + this.department);
		
		this.password = randomPassword(defaultpasswordLength);
//		System.out.println("Your password is: " + this.password);
		
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
//		System.out.println("Your Email is: " + email);
	}
	
	private String setDepartment() {
		System.out.println("Choose Department for New User:\nDepartment Codes:\n1 for Sales\n2 for developement\n3 for Accounting\n0 for none\nEnter Department Code: ");
		Scanner sc = new Scanner(System.in);
		int Choice = sc.nextInt();
		if (Choice == 1) { return "sales";}
		else if (Choice == 2) { return "deevelopment";}
		else if (Choice == 3) { return "accounting";}
		else { return "";}

	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String ShowInfo() {
		return "\nDISPLAY NAME: " + firstName + " " + lastName +
			   "\nCOMPANY EMAIL: " + email +
			   "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
