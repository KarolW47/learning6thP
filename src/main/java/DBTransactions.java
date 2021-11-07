import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DBTransactions  {

    DBConnector dbConnector = new DBConnector();
    SessionFactory actualSessionFactory = dbConnector.sessionFactory();
    Session actualSession = actualSessionFactory.openSession();

    protected List<QuizQA> get5RandomQuestions (AvailableCategories availableCategories){
        String queryToGetAllQ = "SELECT q " +
                "FROM Category c, QuizQA q " +
                "LEFT JOIN c.quizQAFromCategory " +
                "WHERE c.categoryName = '"+ availableCategories.name() + "' " +
                "ORDER BY RAND()";

        Query query = actualSession.createQuery(queryToGetAllQ);

        List<QuizQA> result = query.list();

        return result;
    }

    protected String qetAnswerToCompareWithUsersChoice (AvailableCategories availableCategories, String questionId){
        String queryToGetAllQ = "SELECT q " +
                "FROM Category c, QuizQA q " +
                "LEFT JOIN c.quizQAFromCategory " +
                "WHERE c.categoryName = '"+ availableCategories.name() + "' " +
                "AND q.quizQAId ='"+ questionId +"'";

        Query query = actualSession.createQuery(queryToGetAllQ);
        List<String> list = query.list();

        String result = list.stream().findFirst().toString();
        return result;
    }

}
