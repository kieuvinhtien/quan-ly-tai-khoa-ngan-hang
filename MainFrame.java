package bankapp_project.src.ui;

import javax.swing.*;
import java.awt.*;
import bankapp_project.src.dao.*;
import bankapp_project.src.model.*;

public class MainFrame extends JFrame {
    private AccountDao dao=new AccountDaoJdbc();

    public MainFrame(){
        setTitle("Bank App");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(new JLabel("Bank Account Manager (JDBC Demo)"));
        setVisible(true);
    }
}