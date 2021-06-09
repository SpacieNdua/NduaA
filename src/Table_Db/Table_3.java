package Table_Db;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;


public class Table_3 {
    private static Object Json;
    private JTextField SchoolName;
    private JTextField StudentName;
    private JTextField StudentID;
    private JTextField MarksAttained;
    private JButton Submit;
    private JLabel schoolName;
    private JLabel studentName;
    private JLabel studentId;
    private JLabel marks;
    private JPanel Panel_3;
    private JTable VectorTable;

    public Table_3() {
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SchoolName = schoolName.getText();
                String Student_Name = studentName.getText();
                String Student_ID = studentId.getText();
                String Marks = marks.getText();


                Connection connection = null;
                String host = "localhost";
                String port = "5432";
                String db_name = "Marie";
                String username = "postgres";
                String password = "root";
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");
                    if (connection != null) {
                        String sql = "insert into Table_3 values ('" + SchoolName + "','" + Student_Name + "', '" + Student_ID + "','" + Marks + "')";
                        Statement statement = connection.createStatement();
                        int x = statement.executeUpdate(sql);
                        if (x == 0) {

                            JOptionPane.showMessageDialog(Submit, "Try Again");
                            System.out.println("Records NOT  inserted.....");
                        } else {
                            JOptionPane.showMessageDialog(Submit, "Successful");
                            System.out.println("Records inserted.....");
                        }
                        connection.close();

                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void readStudent(){}


    public static void main(String[] args) {

        Vector<Vector<Integer>> list = new Vector<Vector<Integer>>(100);
        Vector[] vectors = new Vector[100];



        JFrame frame = new JFrame("Saves");
        frame.setContentPane(new Table_3().Panel_3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}



