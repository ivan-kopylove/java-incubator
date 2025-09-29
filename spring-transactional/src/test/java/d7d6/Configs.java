package d7d6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // why Spring silently allow startup when there is at least one `@Transactional`, but no `@EnableTransactionManagement`?
 class TxEnabled
{

    @Bean
    MyTransactionalService myTransactionalService() {
        return new MyTransactionalService();
    }

    @Bean
    MyService myService() {
        return new MyService();
    }
}

@Configuration
class TxDisabled
{
    @Bean
    MyTransactionalService myTransactionalService() {
        return new MyTransactionalService();
    }

}