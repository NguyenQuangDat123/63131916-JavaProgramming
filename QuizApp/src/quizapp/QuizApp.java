package quizapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizApp {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private String selectedSubject;
    private List<Question> questions;
    private int currentScore;
    
    public QuizApp() {
        frame = new JFrame("Ứng dụng trắc nghiệm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        createMainMenu();
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    private void createMainMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        
        JButton btnMath = new JButton("Toán");
        JButton btnPhysics = new JButton("Lý");
        JButton btnChemistry = new JButton("Hóa");
        
        btnMath.addActionListener(e -> startQuiz("Toán"));
        btnPhysics.addActionListener(e -> startQuiz("Lý"));
        btnChemistry.addActionListener(e -> startQuiz("Hóa"));
        
        panel.add(btnMath);
        panel.add(btnPhysics);
        panel.add(btnChemistry);
        
        mainPanel.add(panel, "MainMenu");
        cardLayout.show(mainPanel, "MainMenu");
    }
    
    private void startQuiz(String subject) {
        this.selectedSubject = subject;
        this.questions = generateQuestions(subject);
        this.currentScore = 0;
        
        JPanel quizPanel = new JPanel(new GridLayout(12, 1));
        ButtonGroup[] buttonGroups = new ButtonGroup[10];
        JRadioButton[][] options = new JRadioButton[10][4];
        
        for (int i = 0; i < 10; i++) {
            Question q = questions.get(i);
            JLabel questionLabel = new JLabel((i + 1) + ". " + q.getQuestion());
            quizPanel.add(questionLabel);
            buttonGroups[i] = new ButtonGroup();
            
            for (int j = 0; j < 4; j++) {
                options[i][j] = new JRadioButton(q.getOptions()[j]);
                buttonGroups[i].add(options[i][j]);
                quizPanel.add(options[i][j]);
            }
        }
        
        JButton submitBtn = new JButton("Nộp bài");
        submitBtn.addActionListener(e -> {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 4; j++) {
                    if (options[i][j].isSelected() && options[i][j].getText().equals(questions.get(i).getAnswer())) {
                        currentScore++;
                    }
                }
            }
            showResult();
        });
        
        quizPanel.add(submitBtn);
        mainPanel.add(quizPanel, "Quiz");
        cardLayout.show(mainPanel, "Quiz");
    }
    
    private void showResult() {
        JPanel resultPanel = new JPanel(new GridLayout(4, 1));
        JLabel scoreLabel = new JLabel("Điểm của bạn: " + currentScore + "/10");
        
        JButton backToMenu = new JButton("Về màn hình chính");
        backToMenu.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        
        JButton viewAnswers = new JButton("Xem đáp án");
        viewAnswers.addActionListener(e -> showAnswers());
        
        JButton retryQuiz = new JButton("Làm tiếp 10 câu khác");
        retryQuiz.addActionListener(e -> startQuiz(selectedSubject));
        
        resultPanel.add(scoreLabel);
        resultPanel.add(backToMenu);
        resultPanel.add(viewAnswers);
        resultPanel.add(retryQuiz);
        
        mainPanel.add(resultPanel, "Result");
        cardLayout.show(mainPanel, "Result");
    }
    
    private void showAnswers() {
        JPanel answerPanel = new JPanel(new GridLayout(11, 1));
        for (Question q : questions) {
            answerPanel.add(new JLabel(q.getQuestion() + " - Đáp án: " + q.getAnswer() + " (" + q.getExplanation() + ")"));
        }
        
        JButton backToMenu = new JButton("Về màn hình chính");
        backToMenu.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        
        answerPanel.add(backToMenu);
        mainPanel.add(answerPanel, "Answers");
        cardLayout.show(mainPanel, "Answers");
    }
    
    private List<Question> generateQuestions(String subject) {
        List<Question> questionList = new ArrayList<>();
        
        // Câu hỏi mẫu
        if (subject.equals("Toán")) {
            questionList.add(new Question("2 + 2 = ?", new String[]{"3", "4", "5", "6"}, "4", "Phép cộng cơ bản."));
        } else if (subject.equals("Lý")) {
            questionList.add(new Question("Đơn vị của lực?", new String[]{"kg", "N", "m", "s"}, "N", "Đơn vị của lực là Newton (N)."));
        } else {
            questionList.add(new Question("Hóa trị của Oxi?", new String[]{"1", "2", "3", "4"}, "2", "Oxi có hóa trị 2."));
        }
        
        while (questionList.size() < 10) {
            questionList.addAll(questionList);
        }
        Collections.shuffle(questionList);
        return questionList.subList(0, 10);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizApp::new);
    }
}

class Question {
    private String question;
    private String[] options;
    private String answer;
    private String explanation;
    
    public Question(String question, String[] options, String answer, String explanation) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.explanation = explanation;
    }
    public String getQuestion() { return question; }
    public String[] getOptions() { return options; }
    public String getAnswer() { return answer; }
    public String getExplanation() { return explanation; }
}
