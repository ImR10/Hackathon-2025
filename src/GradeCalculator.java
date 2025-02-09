import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class is responsible for making the different components
 * of the GradeCalculator.
 */

public class GradeCalculator {
	// instance variables
    private Scanner scanner = new Scanner(System.in);
    
    private GradeCategory[] cat;
	
	private String nameCourse;	// name of the course
	private int numCat; 		// number of categories
	private String nameCat;		// name of category
	private double currentAvg;	// category average
	private double catWeight;	// current category weight
	
	private int totalWeight;
	private double finalGrade;
	
	private String pickScale;
	boolean validInput = false;
	private String yn;
	private int Ap, A, Am, Bp, B, Bm, Cp, C, Cm, Dp, D, Dm;
	private int pass;
	
	/*
	 * Initializes a GradeCalculator object to default values. 
	 */
	public GradeCalculator() {
		nameCourse = "";
		numCat = 0;
		nameCat = "";
		currentAvg = 0.0;
		catWeight = 0.0;
	}

	/*
	 * Asks the user to pick a grading scale to use for choosing their grade.
	 */
	public void getScale() {
		validInput = false;
		while (!validInput) {
			System.out.print("Pick grading scale, default or custom: ");
			pickScale = scanner.nextLine();
			
			if (pickScale.equalsIgnoreCase("default") || pickScale.equalsIgnoreCase("d")) {
				pickScale = "default";
				validInput = true;
				
			} else if (pickScale.equalsIgnoreCase("custom") || pickScale.equalsIgnoreCase("c")) {
				pickScale = "custom";
				validInput = true;
			} else {
				System.err.println("Error: Enter a valid command.");
			}
		}
	}
	
	/*
	 * Asks the user what grade they need to pass.
	 */
	public void gradeToPass() {
		validInput = false;
		
		while (!validInput) {
			System.out.print("\nEnter grade needed to pass: ");
			try {
				pass = scanner.nextInt();
				
				if (pass >= 70 && pass <= 100) {
					validInput = true;
					scanner.nextLine();
				} else if (pass <= 70) {
					System.err.println("Error: No class is passing you with anything less than a 70. "
							+ "Enter a valid grade. ");
				} else {
					System.err.println("Error: Max integer 100. Re-enter the grade.");
				}
			} catch (InputMismatchException ime) {
				System.err.println("\nError: Enter an int; " + ime.getMessage());
				scanner.nextLine();
			}
				
		}
	}
	
	/*
	 * Lets user assign values for the scale. 
	 */
	public void setScale() {
		// custom scale
		if (pickScale.equals("custom")) {
			validInput = false;
			
			while (!validInput) {
				System.out.print("+/- scale? (Enter yes or no): ");
				yn = scanner.nextLine();
				if (yn.equalsIgnoreCase("yes") || yn.equalsIgnoreCase("y")) {
					validInput = true;
					
					System.out.print("\nMin 'A+' value:\t ");
					Ap = scanner.nextInt();
					System.out.print("Min 'A' value:\t ");
					A = scanner.nextInt();
					System.out.print("Min 'A-' value:\t ");
					Am = scanner.nextInt();
					System.out.print("Min 'B+' value:\t ");
					Bp = scanner.nextInt();
					System.out.print("Min 'B' value:\t ");
					B = scanner.nextInt();
					System.out.print("Min 'B-' value:\t ");
					Bm = scanner.nextInt();
					System.out.print("Min 'C+' value:\t ");
					Cp = scanner.nextInt();
					System.out.print("Min 'C' value:\t ");
					C = scanner.nextInt();
					System.out.print("Min 'C-' value:\t ");
					Cm = scanner.nextInt();
					System.out.print("Min 'D+' value:\t ");
					Dp = scanner.nextInt();
					System.out.print("Min 'D' value:\t ");
					D = scanner.nextInt();
					System.out.print("Min 'D-' value:\t ");
					Dm = scanner.nextInt();
					scanner.nextLine();
					

				} else if (yn.equalsIgnoreCase("no") || yn.equalsIgnoreCase("n")) {
					validInput = true;
					
					System.out.print("\nMin 'A' value:\t ");
					A = scanner.nextInt();
					System.out.print("Min 'B' value:\t ");
					B = scanner.nextInt();
					System.out.print("Min 'C' value:\t ");
					C = scanner.nextInt();
					System.out.print("Min 'D' value:\t ");
					D = scanner.nextInt();
					
				} else {
					System.err.println("Error: Enter a valid command. ");
				}
			}
		}
	}
	
	/*
	 * Receives the information about the name of the course and the number
	 * of categories in the course.
	 */
	public void getInfo() {
		validInput = false;

		while (!validInput) {
			// Checks for valid course name
			
			System.out.print("\nEnter name of the course: ");
			try {
				nameCourse = scanner.nextLine();
			} catch (InputMismatchException ime) {
				System.err.println("\nError: Enter a valid name; " + ime.getMessage());
			}
			
			// Checks for valid number of grade categories
			System.out.print("Enter number of grade categories: ");
			try {
				numCat = scanner.nextInt();
			} catch (InputMismatchException ime) {
				System.err.println("Error: Enter a valid number; " + ime.getMessage());
			}
			validInput = true;
		}
	}
	
	/*
	 * Creates a new object for each category, and calculates user's course 
	 * grade.
	 */
	public void setCatInfo() {
		// creates a new object for each category
		cat = new GradeCategory[numCat];
		double result = 0;
		double x = 0;
		
		for (int i=0; i<numCat; i++) {
			cat[i] = new GradeCategory();

			cat[i].setName();
			cat[i].setWeight();
			totalWeight += cat[i].getWeight();
			cat[i].setGrade();
			x += (cat[i].getWeight() * cat[i].getGrade());
		}
		result = x/100;
		finalGrade = result;
	}

	/*
	 * Displays the user's final grade if total grade weight equals 100.
	 */
	public void currentGrade() {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println();
		for (int i=0; i<cat.length; i++) {
			System.out.println("Current grade in " + cat[i].getName() + " category (" +
					cat[i].getWeight() + "%): " + cat[i].getGrade());
		}
		
		if (totalWeight == 100) {
			System.out.println("-----------------------------------------------------------------------");
			System.out.printf("\nCourse Grade: %.2f%% in %s.\n", finalGrade, nameCourse);
		} else {
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("Error: Your category weights don't add up to 100."
					+ "\nQuitting program...");
			System.exit(0);
		}
	}
	
	/*
	 * Displays the user's final letter grade.
	 */
	public void getLetterGrade() {
		if (pickScale.equals("default")) {
			// default cases
			if (finalGrade >= 90) {
				System.out.print("You hava an A in the class.");
			} else if (finalGrade < 90 && finalGrade >= 80){
				System.out.print("You have a B in the class.");
			} else if (finalGrade < 80 && finalGrade >= 75){
				System.out.print("You hava a C in the class.");
			} else if (finalGrade < 75 && finalGrade >= 70){
				System.out.print("You have a D in the class.");
			} else {
				System.out.println("You hava an F in the class.");
			}
		} else if (pickScale.equals("custom")) {
			// regular cases
			if (yn.equalsIgnoreCase("no") || yn.equalsIgnoreCase("n")) {
				if (finalGrade >= A) {
					System.out.print("You got an A in the class.");
				} else if (finalGrade < A && finalGrade >= B){
					System.out.print("You got a B in the class.");
				} else if (finalGrade < B && finalGrade >= C){
					System.out.print("You got a C in the class.");
				} else if (finalGrade < C && finalGrade >= D){
					System.out.print("You got a D in the class.");
				} else {
					System.out.println("You got an F in the class.");
				}
			// +/- cases
			} else if (yn.equalsIgnoreCase("yes") || yn.equalsIgnoreCase("y")) {
				if (finalGrade >= Ap) {
					System.out.print("You got an A+ in the class.");
				} else if (finalGrade < Ap && finalGrade >= A){
					System.out.print("You got a A in the class.");
				} else if (finalGrade < A && finalGrade >= Am){
					System.out.print("You got a A- in the class");
				} else if (finalGrade < Am && finalGrade >= Bp){
					System.out.print("You got a B+ in the class.");
				} else if (finalGrade < Bp && finalGrade >= B){
					System.out.print("You got a B in the class.");
				} else if (finalGrade < B && finalGrade >= Bm){
					System.out.print("You got a B- in the class");
				} else if (finalGrade < Bm && finalGrade >= Cp){
					System.out.print("You got a C+ in the class.");
				} else if (finalGrade < Cp && finalGrade >= C){
					System.out.print("You got a C in the class.");
				} else if (finalGrade < C && finalGrade >= Cm){
					System.out.print("You got a C- in the class");
				} else if (finalGrade < Cm && finalGrade >= Dp){
					System.out.print("You got a D+ in the class.");
				} else if (finalGrade < Dp && finalGrade >= D){
					System.out.print("You got a D in the class.");
				} else if (finalGrade < D && finalGrade >= Dm){
					System.out.print("You got a D- in the class");
				} else {
					System.out.println("You got an F in the class.");
				}
			}
		}
	}
	
	public void printPass() {
		if (finalGrade >= pass) {
			System.out.println(" You passed the class.");
		} else {
			System.out.println(" You did not pass the class.");
		}
	}

}
