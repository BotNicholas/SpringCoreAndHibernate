package org.nicholas;

import org.nicholas.config.AppConfig;
import org.nicholas.model.Author;
import org.nicholas.repository.RepositoryImpl;
import org.nicholas.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AuthorService authorService = context.getBean("authorService", AuthorService.class);
        BookCategoryService bookCategoryService = context.getBean("bookCategoryService", BookCategoryService.class);
        BookService bookService = context.getBean("bookService", BookService.class);
        RefContactService refContactService = context.getBean("refContactService", RefContactService.class);
        ContactService contactService = context.getBean("contactService", ContactService.class);
        CustomerService customerService = context.getBean("customerService", CustomerService.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        OrderItemService orderItemService = context.getBean("orderItemService", OrderItemService.class);

    //Read all
//        System.out.println(authorService.findAll());
//        System.out.println();
//        System.out.println(bookCategoryService.findAll());
//        System.out.println();
//        System.out.println(bookService.findAll());
//        System.out.println();
//        System.out.println(refContactService.findAll());
//        System.out.println();
//        System.out.println(contactService.findAll());
//        System.out.println();
//        System.out.println(customerService.findAll());
//        System.out.println();
//        System.out.println(orderService.findAll());
//        System.out.println();
//        System.out.println(orderItemService.findAll());
//        System.out.println();



    //Read 1'st
//        System.out.println(authorService.findById(1));
//        System.out.println();
//        System.out.println(bookCategoryService.findById(1));
//        System.out.println();
//        System.out.println(bookService.findById(1));
//        System.out.println();
//        System.out.println(refContactService.findById(1));
//        System.out.println();
//        System.out.println(contactService.findById(1));
//        System.out.println();
//        System.out.println(customerService.findById(1));
//        System.out.println();
//        System.out.println(orderService.findById(1));
//        System.out.println();
//        System.out.println(orderItemService.findById(1));
//        System.out.println();




    //Save/update
//        Author author = new Author();
//        BookCategory category = new BookCategory();
//        Book book = new Book();
//        RefContactType refContactType = new RefContactType();
//        Contact contact = new Contact();
//        Customer customer = new Customer();
//        Order order = new Order();
//        OrderItem orderItem = new OrderItem();
//
//        authorService.save(author);
//        bookCategoryService.save(category);
//        bookService.save(book);
//        refContactService.save(refContactType);
//        contactService.save(contact);
//        customerService.save(customer);
//        orderService.save(order);
//        orderItemService.save(orderItem);



    //Delete by id
//        authorService.deleteById(28);
//        bookCategoryService.deleteById(11);
//        bookService.deleteById(16);
//        refContactService.deleteById(7);
//        contactService.deleteById(7);
//        customerService.deleteById(7);
//        orderService.deleteById(8);
//        orderItemService.deleteById(14);


    //Delete by object
//        authorService.delete(authorService.findById(29));
//        bookCategoryService.delete(bookCategoryService.findById(12));
//        bookService.delete(bookService.findById(17));
//        refContactService.delete(refContactService.findById(8));
//        contactService.delete(contactService.findById(8));
//        customerService.delete(customerService.findById(8));
//        orderService.delete(orderService.findById(9));
//        orderItemService.delete(orderItemService.findById(15));



        context.close();
    }
}