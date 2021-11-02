import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class DBTransactions  {

    DBConnector dbConnector = new DBConnector();
    SessionFactory actualSessionFactory = dbConnector.sessionFactory();
    Session actualSession = actualSessionFactory.openSession();

    private List<Category> get5RandomQuestions (AvailableCategories availableCategories){
        List<Category> result = (List<Category>) actualSession.createQuery("SELECT * FROM category " +
                "LEFT JOIN quiz_qa ON category.category_id = quiz_qa.category_id " +
                "WHERE category_name = '" + availableCategories.name() + "' " +
                "ORDER BY RAND() " +
                "LIMIT 5").list();
        Optional<Category> cat = result.stream().filter(c -> c.getQuizQAFromCategory().getQuizQAId() == 5).findFirst();
        QuizQA quizQA = cat.get().getQuizQAFromCategory();
        System.out.println(quizQA.getCorrectAnswer());

        return result;
    }

    private String qetAnswerToCompareWithUsersChoice (AvailableCategories availableCategories, String questionId){
        List<String> correctQuestionFromDB = (List<String>) actualSession.createQuery("SELECT correct_answer FROM category" +
                "LEFT JOIN quiz_qa ON category.category_id = quiz_qa.category_id " +
                "WHERE category_name = '" + availableCategories.name() + "' " +
                "AND correct_answer = '" + questionId + "'").list();

        String result = correctQuestionFromDB.stream().findFirst().toString();
        return result;
    }

}
