import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class DBTransactions  {

    DBConnector dbConnector = new DBConnector();
    SessionFactory actualSessionFactory = dbConnector.sessionFactory();
    Session actualSession = actualSessionFactory.openSession();

    protected List<QuizQA> get5RandomQuestions (AvailableCategories availableCategories){
        // TODO: 04.11.2021 fix this to get more records instead one
        String queryToGetAllQ = "SELECT c " +
                "FROM Category c " +
                "LEFT JOIN c.quizQAFromCategory " +
                "WHERE c.categoryName = '"+ availableCategories.name() + "' " +
                "ORDER BY RAND()";

        Query query = actualSession.createQuery(queryToGetAllQ);
        query.setMaxResults(5);

        List<Category> categoryListFromDB = query.list();

        List<QuizQA> result = categoryListFromDB.stream()
                .map(Category::getQuizQAFromCategory)
                        .collect(Collectors.toList());
        return result;
    }

    protected String qetAnswerToCompareWithUsersChoice (AvailableCategories availableCategories, String questionId){
        // TODO: 04.11.2021 change query, Entity references as above method
        List<String> correctQuestionFromDB = (List<String>) actualSession.createQuery("SELECT correct_answer " +
                "FROM category" +
                "LEFT JOIN quiz_qa ON category.category_id = quiz_qa.category_id " +
                "WHERE category_name = '" + availableCategories.name() + "' " +
                "AND correct_answer = '" + questionId + "'").list();

        String result = correctQuestionFromDB.stream().findFirst().toString();
        return result;
    }

}
