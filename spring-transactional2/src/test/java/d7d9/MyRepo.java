package d7d9;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
 class MyRepo
{
    void foo(){
        throw new org.hibernate.exception.ConstraintViolationException("dsa", new SQLException(), "a constraint");
    }
}
