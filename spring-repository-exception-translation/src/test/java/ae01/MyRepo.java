package ae01;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
 class MyRepo
{
    void foo1(){
        throw new org.hibernate.exception.ConstraintViolationException("dsa", new SQLException(), "a constraint");
    }

    void foo2(){
        throw new Configs.CustomPersistenceException("abc");
    }
}
