package ID1.services;


import ID1.model.oneToMany.uni.AccountEntity;
import ID1.model.oneToMany.uni.EmployeeEntity;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class OneToManyUnidirectionalService {
    private SessionFactory sessionFactory;

    @Autowired
    public OneToManyUnidirectionalService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }

    public void saveEmployeeAndAccounts() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();


        AccountEntity account1 = new AccountEntity("Account detail 1",600);

        AccountEntity account2 = new AccountEntity("Account detail 2",400);

        AccountEntity account3 = new AccountEntity("Account detail 3",500);

        AccountEntity account4 = new AccountEntity("Account detail 4",400);

        AccountEntity account5 = new AccountEntity("Account detail 5",600);


        //Add new Employee object
        EmployeeEntity firstEmployee = new EmployeeEntity("demo-user-first@mail.com","demo-one","user-one",23);

        EmployeeEntity secondEmployee = new EmployeeEntity("demo-user-second@mail.com","demo-two","user-two",28);

        EmployeeEntity thirdEmployee = new EmployeeEntity("demo-user-third@mail.com","demo-third","user-third",35);

        Set<AccountEntity> accountsOfFirstEmployee = new HashSet<AccountEntity>();
        accountsOfFirstEmployee.add(account1);
        accountsOfFirstEmployee.add(account2);

        Set<AccountEntity> accountsOfSecondEmployee = new HashSet<AccountEntity>();
        accountsOfSecondEmployee.add(account3);

        Set<AccountEntity> accountsOfThirdEmployee = new HashSet<AccountEntity>();
        accountsOfThirdEmployee.add(account4);
        accountsOfThirdEmployee.add(account5);

        firstEmployee.setAccounts(accountsOfFirstEmployee);
        secondEmployee.setAccounts(accountsOfSecondEmployee);
        thirdEmployee.setAccounts(accountsOfThirdEmployee);
        //Save Employee

        session.save(firstEmployee);
        session.save(secondEmployee);
        session.save(thirdEmployee);

        transaction.commit();
        session.close();

    }


}
