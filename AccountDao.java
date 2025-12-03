package bankapp_project.src.dao;

import bankapp_project.src.model.BankAccount;
import java.util.*;

public interface AccountDao {
    List<BankAccount> getAll();
    Optional<BankAccount> findByAccountNumber(String acc);
    void add(BankAccount acc);
    void update(BankAccount acc);
    void delete(String acc);
}