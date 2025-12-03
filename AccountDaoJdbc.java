package bankapp_project.src.dao;

import bankapp_project.src.model.*;
import bankapp_project.src.util.DBConnection;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.time.LocalDate;

public class AccountDaoJdbc implements AccountDao {
    @Override
    public List<BankAccount> getAll(){
        List<BankAccount> list=new ArrayList<>();
        String sql="SELECT a.account_number,a.balance,a.opened_date,a.active,c.id,c.name,c.id_number,c.phone FROM account a JOIN customer c ON a.customer_id=c.id";
        try(Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){
            while(rs.next()){
                Customer c=new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("id_number"),rs.getString("phone"));
                BankAccount acc=new BankAccount(rs.getString("account_number"),c,rs.getDouble("balance"));
                acc.setOpenedDate(rs.getDate("opened_date").toLocalDate());
                acc.setActive(rs.getBoolean("active"));
                list.add(acc);
            }
        }catch(Exception e){e.printStackTrace();}
        return list;
    }

    @Override
    public Optional<BankAccount> findByAccountNumber(String accNo){
        String sql="SELECT a.account_number,a.balance,a.opened_date,a.active,c.id,c.name,c.id_number,c.phone FROM account a JOIN customer c ON a.customer_id=c.id WHERE a.account_number=?";
        try(Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,accNo);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Customer c=new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("id_number"),rs.getString("phone"));
                BankAccount acc=new BankAccount(rs.getString("account_number"),c,rs.getDouble("balance"));
                acc.setOpenedDate(rs.getDate("opened_date").toLocalDate());
                acc.setActive(rs.getBoolean("active"));
                return Optional.of(acc);
            }
        }catch(Exception e){e.printStackTrace();}
        return Optional.empty();
    }

    @Override
    public void add(BankAccount account){
        String insertC="INSERT INTO customer(name,id_number,phone) VALUES(?,?,?)";
        String insertA="INSERT INTO account(account_number,customer_id,balance,opened_date,active) VALUES(?,?,?,?,?)";
        try(Connection conn=DBConnection.getConnection()){
            conn.setAutoCommit(false);
            PreparedStatement pc=conn.prepareStatement(insertC,Statement.RETURN_GENERATED_KEYS);
            pc.setString(1,account.getOwner().getName());
            pc.setString(2,account.getOwner().getIdNumber());
            pc.setString(3,account.getOwner().getPhone());
            pc.executeUpdate();
            ResultSet k=pc.getGeneratedKeys();k.next();int cid=k.getInt(1);

            PreparedStatement pa=conn.prepareStatement(insertA);
            pa.setString(1,account.getAccountNumber());
            pa.setInt(2,cid);
            pa.setDouble(3,account.getBalance());
            pa.setDate(4,Date.valueOf(account.getOpenedDate()));
            pa.setBoolean(5,account.isActive());
            pa.executeUpdate();

            conn.commit();
        }catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void update(BankAccount a){
        String cu="UPDATE customer SET name=?,id_number=?,phone=? WHERE id=?";
        String au="UPDATE account SET balance=?,active=? WHERE account_number=?";
        try(Connection conn=DBConnection.getConnection()){
            PreparedStatement pc=conn.prepareStatement(cu);
            pc.setString(1,a.getOwner().getName());
            pc.setString(2,a.getOwner().getIdNumber());
            pc.setString(3,a.getOwner().getPhone());
            pc.setInt(4,a.getOwner().getId());
            pc.executeUpdate();

            PreparedStatement pa=conn.prepareStatement(au);
            pa.setDouble(1,a.getBalance());
            pa.setBoolean(2,a.isActive());
            pa.setString(3,a.getAccountNumber());
            pa.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void delete(String acc){
        try(Connection conn=DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("DELETE FROM account WHERE account_number=?")){
            ps.setString(1,acc);
            ps.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }
}