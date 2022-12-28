public class ShortAnswer extends Question {

    String[] keywords = new String[3];
    int index;

    public ShortAnswer(String question, String correctAnswer) {
        super(question, correctAnswer);
        index = 0;
        //TODO Auto-generated constructor stub
    }
    
    public String[] getKeywords(){
        return keywords;
    }
    public void setKeywords(String x){
        keywords[index] = x;
        index++;
    }

    public boolean isAnswerCorrect(){
        boolean result = false;
        int count = 0;
        for (int i = 0; i < keywords.length; i++){
            if (studentAnswer.contains(keywords[i])){
                count++;
            }
        }
        if (count > (keywords.length/2)) result = true;

        return result;
    }
}
