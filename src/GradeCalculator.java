import java.util.Scanner;

public class GradeCalculator {
	public static void main(String[] args) {

		


		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of classes: ");
		int numOfClasses = scanner.nextInt();
		
		for (int i = 0; i < numOfClasses; i++) {
			System.out.println("Enter grades for these classes " + i + ":");
		}
		

		System.out.println("Enter participation average: ");
		double partAvg = scanner.nextDouble();
		System.out.println("Enter participation percent: ");
		double partPercent = scanner.nextDouble();
	

		

		System.out.println("Enter quiz average: ");
		double quizAvg = scanner.nextDouble();
		System.out.println("Enter quiz percent: ");
		double quizPercent = scanner.nextDouble();
		


		System.out.println("Enter homework average:");
		double homeworkAvg = scanner.nextDouble();
		System.out.println("Enter homework percent");
		double homeworkPercent = scanner.nextDouble();
		


		System.out.println("Enter test average: ");
		double testAvg = scanner.nextDouble();
		System.out.println("Enter test percent: ");
		double testPercent = scanner.nextDouble();
		


		System.out.println("Enter final exam average: ");
		double examAvg = scanner.nextDouble();
		System.out.println("Enter final exam percent: ");
		double finalExamPercent = scanner.nextDouble();
		
		double totalScore = (partAvg * partPercent) + (quizAvg * quizPercent) + (homeworkAvg * homeworkPercent) + (testAvg * testPercent) + (examAvg * finalExamPercent);


		double totalWeight = partPercent + quizPercent + homeworkPercent + testPercent+ finalExamPercent;
			int i = 0;
			if (totalWeight != 1.0) {
			System.out.println("Error! Weight must accumulate to 1.0");
			i--;
		}

			System.out.printf("Your grade in Class %d: %.2f%n", i, totalScore);

		

		if (totalScore >= 90) {
			System.out.print("A");
		}
		else if (totalScore <= 89 && totalScore >= 85){
			System.out.print("B+");
		}
		else if (totalScore <= 84 && totalScore >= 79){
			System.out.print("B");
		}
		else if (totalScore <= 78 && totalScore >= 75){
			System.out.print("C+");
		}
		else if (totalScore <= 74 && totalScore >= 69){
			System.out.print("C");
		}
		else
		{
			System.out.println("F");
		}
	}

}




























