package org.example;

import org.example.Key.LinkedPurchaseListKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {


    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).buildMetadata();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<PurchaseList> allPurchaseList = session.createQuery("From PurchaseList").getResultList();

        for (PurchaseList purchasesList : allPurchaseList) {
            Integer idStudent = purchasesList.getKey().getStudent().getId();
            Integer idCourse = purchasesList.getKey().getCourse().getId();

            LinkedPurchaseListKey linkedPurchaseListKey = new LinkedPurchaseListKey(idStudent, idCourse);
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(linkedPurchaseListKey);

            linkedPurchaseList.setStudentId(idStudent);
            linkedPurchaseList.setCourseId(idCourse);
            linkedPurchaseList.setStudentName(purchasesList.getKey().getStudent().getName());
            linkedPurchaseList.setCourseName(purchasesList.getKey().getCourse().getName());
            linkedPurchaseList.setPrice(purchasesList.getPrice());
            linkedPurchaseList.setSubscriptionDate(purchasesList.getSubscriptionDate());
            session.save(linkedPurchaseList);
        }
        session.getTransaction().commit();
        session.close();
    }
    }


