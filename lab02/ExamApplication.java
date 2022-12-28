import java.util.Scanner;

public class ExamApplication {
    public static void main(String[] args) {
        Exam exam = new Exam();
        
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome, whatcha wanna do?");

        int checker = 1;
        while (checker > 0){
            System.out.println("-----------------------------------------");
            System.out.println("1-) Take the exam");
            System.out.println("2-) Grade the exam");
            System.out.println("3-) See the mistakes");
            System.out.println("4-) Quit");
            System.out.println("-----------------------------------------");

            int choice = in.nextInt();

            if (choice == 1){
                exam.takeExam();
            }
            if (choice == 2){
                System.out.println(exam.gradeExam());
            }
            if (choice == 3){
                System.out.println(exam.displayMistakes());
            }
            if (choice == 4){
                System.out.println("Cya!");
                checker = -1;
            }
        }
    }
}
