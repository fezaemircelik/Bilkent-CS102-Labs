public class MultipleChoice extends Question{

    String choices;

    public MultipleChoice(String question, String correctAnswer) {
        super(question, correctAnswer);
        choices = "";
        //TODO Auto-generated constructor stub
    }
    
    public String getChoices(){
        return choices;
    }
    public void setChoices(String x){
        choices += "\n" + x;
    }

    public String displayQuestion(){
        String output = "";
        output += "Here is the question : " + super.getQuestion() + "\n";
        output += choices;
        
        return output;
    }
}
