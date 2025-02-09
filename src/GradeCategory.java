import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class holds the values of the grade category for 
 * the weight and the current grade of each of the classes category.
 */
public class GradeCategory {
	// instance variables
	Scanner scanner = new Scanner(System.in);
	
	private String catName;
	private int catWeight;
	private double currentAvg;
	
	private boolean validInput = false;

	
	/*
	 * initializes GradeCategory objects to default values. 
	 */
	public GradeCategory() {
		catName = " ";
		catWeight = 0;
		currentAvg = 0.0;
	}
	
	/*
	 * returns the name of the category.
	 * @return catName name of category 
	 */
	public String getName() {
		return catName;
	}
	
	/*
	 * sets the name of the different categories from user input.
	 */
	public void setName() {
		System.out.print("\nEnter category name: ");
		catName = scanner.nextLine();
	}
	
	/*
	 * returns the weight of a category object.
	 * @return catWeight weight of category object
	 */
	public int getWeight() {
		return catWeight;
	}
	
	/*
	 * sets the weight of the different category objects from user input.
	 */
	public void setWeight() {
		validInput = false;
		while (!validInput) {
			System.out.print("Enter category weight (in number format): ");
			try {
				catWeight = scanner.nextInt();
				validInput = true;
			} catch (InputMismatchException ime) {
				System.err.println("Error: Enter a valid number; " + ime.getMessage());
			}
		}
	}
	
	/*
	 * returns the weight of the current grade average for a category
	 * @return currentAvg returns current grade average for a category 
	 */
	public double getGrade() {
		return currentAvg;
	}
	
	/*
	 * sets the grade for a category from user input 
	 */
	public void setGrade() {
		validInput = false;
		while (!validInput) {
			System.out.print("Enter current grade in category (in number format): ");
			try {
				currentAvg = scanner.nextDouble();
				validInput = true;
			} catch (InputMismatchException ime) {
				System.err.println("Error: Enter a valid number; " + ime.getMessage());
			}
		}
	}
	
}
