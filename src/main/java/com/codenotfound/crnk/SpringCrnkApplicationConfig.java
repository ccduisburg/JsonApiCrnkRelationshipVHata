//package com.codenotfound.crnk;
//
//import javax.annotation.PostConstruct;
//
//import com.codenotfound.crnk.domain.model.*;
//import com.codenotfound.crnk.domain.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureOrder;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Configuration
//public class SpringCrnkApplicationConfig {
//
//  @Autowired
//  ArticleRepository articleRepository;
//
//  @Autowired
//  PersonRepository personRepository;
//
//  @Autowired
//  private StudentRepository studentRepository;
//  @Autowired
//  private UniversityRepository universityRepository;
//
//  @Autowired
//  private WorkerRepository workerRepository;
//
//  @Autowired
//  private AdressRepository adressRepository;
//
//  @Autowired
//  private PersondepartmentRepository persondepartmentRepository;
//
//  @PostConstruct
//  public void init() {
//    Article article1 = new Article(1L, "JSON API paints my bikeshed!");
//    Article article2 = new Article(2L, "Rails is Omakase");
//
//    Person person1 = new Person("John");
//
//    article1.setAuthor(person1);
//    article2.setAuthor(person1);
//
////    person1.getArticles().add(article1);
////    person1.getArticles().add(article2);
//
//    articleRepository.save(article1);
//    articleRepository.save(article2);
//
//    personRepository.save(person1);
//
//    Student s1 = new Student(1L, "foo", "bar", 10, 100.0, true);
//    Student s2 = new Student(2L, "edu", "tilos", 20, 200.0, false);
//    Student s3 = new Student(3L, "pako", "deko", 30, 300.0, true);
//    // public University(Long id, String name, String country, String city, String plz, String rector)
//    University u1 = new University(1L, "RUB", "Germany", "Bochum", "44801", "cristiano ronaldo");
//    s1.setUniversity(u1);
//    s2.setUniversity(u1);
//    s3.setUniversity(u1);
//    u1.getStudents().addAll(Arrays.asList(s1, s2, s3));
//    universityRepository.save(u1);
//    studentRepository.save(s1);
//    studentRepository.save(s2);
//    studentRepository.save(s3);
//
//    Persondepartment pd1=null,pd2=null,pd3=null;
//    Worker w1, w2, w3;
//    w1 = new Worker("cemil","Miterbeite",new Double(120));
//    w2 = new Worker("cemil","Miterbeite",new Double(120));
//    w3 = new Worker("cemil","Miterbeite",new Double(120));
////    workerRepository.save(w1);
////    workerRepository.save(w2);
////    workerRepository.save(w3);
//
//
//    pd1= new Persondepartment("IT","IT-Leiter");
//    pd2=new Persondepartment("IT","IT-Leiter");
////    pd3=new Persondepartment("IT","IT-Leiter");
//
//    pd1.setWorkers(Stream.of(w1, w2).collect(Collectors.toList()));
//    pd2.setWorkers(Stream.of(w3).collect(Collectors.toList()));
//    w1.setDepartment(pd1);
//    w2.setDepartment(pd1);
//    w3.setDepartment(pd2);
//    persondepartmentRepository.save(pd1);
//    persondepartmentRepository.save(pd2);
//      workerRepository.save(w1);
//    workerRepository.save(w2);
//    workerRepository.save(w3);
//
//    Adress adr1,adr2,adr3;
//    adr1=new Adress(1L,"foostr",30,"3333","Ordu");
//    adr2=new Adress(2L,"foostr2",20,"3333","Ordu2");
//    adr3=new Adress(3L,"foostr3",40,"3333","Ordu3");
//
//    adressRepository.save(adr1);
//    adressRepository.save(adr2);
//    adressRepository.save(adr3);
//  }
//}
