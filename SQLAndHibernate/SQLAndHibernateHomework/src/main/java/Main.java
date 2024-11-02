import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main
{


    public static void main( String[] args ) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        try (Session session = sessionFactory.openSession()) {

            String hql1 = "SELECT pl.coursesName, COUNT(pl.coursesName) as salesCount, MIN(MONTH(pl.subscriptionDate)) as firstMonth, MAX(MONTH(pl.subscriptionDate)) as lastMonth " +
                    "FROM PurchaseLists pl " +
                    "WHERE YEAR(pl.subscriptionDate) = :year " +
                    "GROUP BY pl.coursesName";

            int year = 2018;

            List<Object[]> results = session.createQuery(hql1)
                    .setParameter("year", year)
                    .getResultList();

            Map<String, Double> averageMonthlySales = new HashMap<>();

            for (Object[] row : results) {
                String courseName = (String) row[0];
                long totalSalesValue = ((Number) row[1]).longValue();
                int firstMonth = ((Number) row[2]).intValue();
                int lastMonth = ((Number) row[3]).intValue();

                // Рассчитаем количество месяцев, в которых были продажи
                long monthsBetween = ChronoUnit.MONTHS.between(LocalDate.of(year, Month.of(firstMonth), 1),
                        LocalDate.of(year, Month.of(lastMonth), 1).plusMonths(1));

                if (monthsBetween > 0) {
                    double averageMonthlySale = (double) totalSalesValue / monthsBetween;
                    averageMonthlySales.put(courseName, averageMonthlySale);
                }
            }

            for (Map.Entry<String, Double> entry : averageMonthlySales.entrySet()) {
                System.out.println("Курс: " + entry.getKey());
                System.out.format("Среднее количество продаж за месяц: %.2f%n", entry.getValue());
            }
        }


        sessionFactory.close();
    }
        }



