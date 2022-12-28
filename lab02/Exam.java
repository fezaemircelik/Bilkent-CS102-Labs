import java.util.*;

public class Exam {
    ArrayList<Question> exam;
    boolean completed;
    int score;
    ArrayList<Question> mistakenQuestions;

    public Exam(){
        mistakenQuestions = new ArrayList<Question>();
        completed = false;

        exam = new ArrayList<Question>();
        //**first, adding the basic questions */
        exam.add(new Question("An array the same as an ArrayList (true/false)", "false"));
        exam.add(new Question("Strings are immutable? (true/false)", "true"));
        exam.add(new Question("You must use the new keyword to create a String object (true/false)", "false"));
        exam.add(new Question("What kind of inheritance is not allowed in java (one word)", "multiple"));
        exam.add(new Question("Does a subclass inherit both member variables and methods?(Yes/No)", "yes"));

        //**then adding the multiple choice ones */
        MultipleChoice m1 = new MultipleChoice("A class Animal has a subclass Mammal. Which of the following is true: ", "b");
        m1.setChoices("a. Because of single inheritance, Mammal can have no subclasses.");
        m1.setChoices("b. Because of single inheritance, Mammal can have no other parent than Animal. ");
        m1.setChoices("c. Because of single inheritance, Animal can have only one subclass. ");
        exam.add(m1);

        MultipleChoice m2 = new MultipleChoice("What does immutable mean? ", "b");
        m2.setChoices("a)A String is an instance of an object.");
        m2.setChoices("b)Once created the object's data cannot be changed");
        m2.setChoices("c)String class objects can be used in any application");
        exam.add(m2);

        //**then adding the short answer ones */
        ShortAnswer s1 = new ShortAnswer("What is a static data member", "A variable that belong to the class and not the object");
        s1.setKeywords("variable");
        s1.setKeywords("class");
        s1.setKeywords("object");
        exam.add(s1);

        ShortAnswer s2 = new ShortAnswer("What is the purpose of a constructor? ", "To create objects and initialize their data");
        s2.setKeywords("create");
        s2.setKeywords("initialize");
        s2.setKeywords("object");
        exam.add(s2);

    }
    public Exam(ArrayList<Question> exam){
        this.exam = exam;
        completed = false;
    }

    public void takeExam(){
        score = 0;
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < exam.size(); i++){
            System.out.println(exam.get(i).displayQuestion());
            
            String userAnswer = in.nextLine();
            exam.get(i).setStudentAnswer(userAnswer);

            if (exam.get(i).isAnswerCorrect()){
                score++;
                System.out.println("Correct!!");
            }
            else {
                System.out.println("False!");
                mistakenQuestions.add(exam.get(i));
            }
        }

        completed = true;
    }

    public double gradeExam(){
        if (completed){
            int avg = score*100/9;
            return avg;
        }
        else return 0.0;
    }

    public String displayMistakes(){
        String mQ = "";

        if(completed){
            for (int i = 0; i < mistakenQuestions.size(); i++){
                mQ += "\n" + mistakenQuestions.get(i).displayQuestion();
            }
        }
        return mQ;
    }

}
