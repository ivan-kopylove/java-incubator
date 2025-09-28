//package dasdas;
//
//import javax.security.auth.login.AccountNotFoundException;
//import java.math.BigDecimal;
//
//// в неск. подах
//
//@Service
//@RequiredArgsConstructor
//public class MoneyTransferService {
//
//    private final AccountRepository accountRepository;
//
//    public void transferMoney(Long fromAccountId, Long toAccountId, BigDecimal amount) {
//        if (amount <= BigDecimal.ZERO) {
//            throw new IllegalArgumentException("Amount must be positive");
//        }
//
//        Account fromAccount = accountRepository.findById(fromAccountId)
//            .orElseThrow(() -> new AccountNotFoundException("From account not found"));
//
//        Account toAccount = accountRepository.findById(toAccountId)
//            .orElseThrow(() -> new AccountNotFoundException("To account not found"));
//
//        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
//        accountRepository.save(fromAccount);
//
//        toAccount.setBalance(toAccount.getBalance().add(amount));
//        accountRepository.save(toAccount);
//    }
//}
//
//@Entity
//public class Account {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private BigDecimal balance;
//}
//
//@Repository
//public interface AccountRepository extends JpaRepository<Account, Long> {
//}