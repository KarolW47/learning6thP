import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class DBTransactions  {

    DBConnector dbConnector = new DBConnector();
    SessionFactory actualSessionFactory = dbConnector.sessionFactory();
    Session actualSession = actualSessionFactory.openSession();

    protected List<QuizQA> get5RandomQuestions (AvailableCategories availableCategories){
        List<QuizQA> result = (List<QuizQA>) actualSession.createQuery("SELECT " +
                "quiz_qa_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3 " +
                "FROM category " +
                "LEFT JOIN quiz_qa ON category.category_id = quiz_qa.category_id " +
                "WHERE category_name = '" + availableCategories.name() + "' " +
                "ORDER BY RAND()").list();
        return result;
    }

    protected String qetAnswerToCompareWithUsersChoice (AvailableCategories availableCategories, String questionId){
        List<String> correctQuestionFromDB = (List<String>) actualSession.createQuery("SELECT correct_answer " +
                "FROM category" +
                "LEFT JOIN quiz_qa ON category.category_id = quiz_qa.category_id " +
                "WHERE category_name = '" + availableCategories.name() + "' " +
                "AND correct_answer = '" + questionId + "'").list();

        String result = correctQuestionFromDB.stream().findFirst().toString();
        return result;
    }

}
