// com.example.MyRepository.java
package d7d7;

import org.hibernate.exception.SQLGrammarException;
import org.jspecify.annotations.Nullable;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
class MyRepository
{
    void foo() {
        throw new SQLGrammarException("qwe", new SQLException(), "das");
    }


}