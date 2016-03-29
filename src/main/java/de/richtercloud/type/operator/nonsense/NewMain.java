package de.richtercloud.type.operator.nonsense;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Illustrates the problem/misunderstanding that storing an {@link A} and
 * querying it with a {@code WHERE TYPE([identifier]) = A} fails with
 * {@code org.hibernate.QueryException: could not resolve property:
 * class of: de.richtercloud.type.operator.nonsense.A}.
 * @author richter
 */
public class NewMain {
    private final static File DATABASE_DIR = new File("/tmp/type-operator-nonsense");
    private final static String DERBY_CONNECTION_URL = String.format("jdbc:derby:%s", DATABASE_DIR.getAbsolutePath());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        //setup database
        EntityManagerFactory entityManagerFactory = null;
        try {
            Map<Object, Object> entityManagerFactoryMap = new HashMap<>();
            entityManagerFactoryMap.put("javax.persistence.jdbc.url",
                    String.format("%s;create=%s", DERBY_CONNECTION_URL, !DATABASE_DIR.exists()));
            entityManagerFactory = Persistence.createEntityManagerFactory("type-operator-nonsense",
                    entityManagerFactoryMap);

            //show issue
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            B a = new B("b", "c");
            entityManager.getTransaction().begin();
            entityManager.persist(a);
            entityManager.flush();
            Query query = entityManager.createQuery("SELECT x from B x WHERE TYPE(x) = B"
//                    "SELECT b from A b WHERE b.class = A"
                    //"SELECT b from A b WHERE TYPE(b) = de.richtercloud.type.operator.nonsense.A"
                    //"SELECT a from A a WHERE TYPE(a) = A"
            );
            List<?> queryResult = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println(queryResult.size());
        }finally {
            if(entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
