package org.example;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static List<Customer> inAscOfLastName(List<Customer> customers){
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getLastName))
                .collect(Collectors.toList());
    }

    static List<Customer> platiniumAccount(List<Customer> customers){
        LocalDate date = LocalDate.now();
        LocalDate newDate = LocalDate.of(date.getYear()-10, date.getMonth(), date.getDayOfMonth());

        List<Customer> filteredSortedCustomers =  customers.stream()
                .filter(x->x.getAccount().getBalance()>=100000 && x.getAccount().dateOpened.isBefore(date))
                .collect(Collectors.toList());

        Collections.sort(filteredSortedCustomers, comparatorAccountBalance);
        Collections.sort(filteredSortedCustomers, comparatorAccountNo);

        return filteredSortedCustomers;
    }

        static Comparator<Customer> comparatorAccountBalance= new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getAccount().getBalance() > o2.getAccount().getBalance() ? 1 : -1;
            }
        };

        static Comparator<Customer> comparatorAccountNo= new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getAccount().getAccountNo() > o2.getAccount().getAccountNo() ? 1 : -1;
            }

        };


    static void printInJSON(List<Customer> customers){
        System.out.println("[");
        for (Customer customer: customers){
            System.out.println("customer {");
            System.out.println(" \"firstName\" :  \""+ customer.getFirstName() +"\"");
            System.out.println(" \"lastName\" : \""+customer.getLastName() +"\"");
            System.out.println(" \"DOB\" : \""+customer.getDateOfBirth() +"\"");
            System.out.println("Account {");
            System.out.println(" \"accountNo\" : \""+customer.getAccount().getAccountNo() +"\"");
            System.out.println(" \"DateOpened\" : \""+customer.getAccount().getDateOpened() +"\"");
            System.out.println(" \"balance\" : \""+customer.getAccount().getBalance() +"\"");
            System.out.println(" }");
            System.out.println(" }");

        }
    }
    public static void main(String[] args) {

        System.out.println("*******Bank APP ******");

        System.out.println("******* TASK 1 ******");
        List<Customer> customers = List.of(
                new Customer(1L, "Pooja", "Kumari", LocalDate.of(1998, 06, 02), new Account(112233L, LocalDate.of(1920, 02,02), 2000))
              , new Customer(1L, "ASDF", "gh", LocalDate.of(1980, 06, 02), new Account(112233L, LocalDate.of(2021, 12,02), 3000))
        );

        printInJSON(inAscOfLastName(customers));

        System.out.println("******* TASK 2 ******");

        printInJSON(platiniumAccount(customers));




    }
}