package Table_Db;

import org.json.JSONArray;
import org.json.JSONObject;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.ConnectionPendingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.DropMode.INSERT;

public class Table_2 {
    private JButton Submit;
    private JTextField textName;
    private JTextField textId;
    private JPanel Panel_1;
    private JTextField studentName;
    private JButton Update;
    private JTextField marksEarned;
    private JLabel Marks;


    public Table_2() {
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String Name = textName.getText();
                String School_ID = textId.getText();
                String Student_Name = studentName.getText();
                int Marks = marksEarned.getComponentCount();

                Connection connection = null;
                String host="localhost";
                String port="5432";
                String db_name="Marie";
                String username="postgres";
                String password="root";
                try {
                    Class.forName("org.postgresql.Driver") ;
                    connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
                    if (connection != null)
                    {
                        String sql = "insert into table2 values ('"+Name+"','"+School_ID+"', '"+Student_Name+"','"+Marks+"')";
                        Statement statement = connection.createStatement();
                        int x = statement.executeUpdate(sql);
                        if(x==0)
                        {

                            JOptionPane.showMessageDialog(Submit,"Try Again");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(Submit,"Successful");
                        }
                        connection.close();

                    }} catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        Update.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String Name = textName.getText();
                String School_ID = textId.getText();
                String Student_Name = studentName.getText();
                int Marks = marksEarned.getComponentCount();



                Connection connection = null;
                String host="localhost";
                String port="5432";
                String db_name="Marie";
                String username="postgres";
                String password="root";
                try {
                    Class.forName("org.postgresql.Driver") ;
                    connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
                    if (connection != null)
                    {
                        String sql = "update into table2 values ('"+Name+"','"+School_ID+"','"+Marks+"','"+Student_Name+"',)";
                        Statement statement = connection.createStatement();
                        int x = statement.executeUpdate(sql);
                        if(x==0)
                        {

                            JOptionPane.showMessageDialog(Update,"Try Again");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(Update,"Successful");
                        }
                        connection.close();

                    }} catch (Exception e1) {
                    e1.printStackTrace();
                }
        }
    });}
    public static <JSONParser> void main(String[] args)
    {
        JFrame frame = new JFrame("Saves");
        frame.setContentPane(new Table_2().Panel_1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);

        //Trial Creation of a JSONParser object

       // JSONParser jsonParser = new JSONParser();
       // try {



            //Parsing the contents of the JSON file
            //JSONObject jsonObject = (JSONObject) jsonParser.getClass());
            //Retrieving the array
            //JSONArray jsonArray = (JSONArray) jsonObject.get("table2");

            //Insert a row into the table2 UI
            //PreparedStatement stmt = null;
            //String sql = "INSERT INTO nameTable (table2) values (?)";
            //for(Object object : jsonArray) {
               // JSONObject record = (JSONObject) object;
               // String Name = (String) record.get("StudentName");
              //  String School_ID = (String) record.get("SchoolID");
               // String Student_Name = (String) record.get("School Name");
              //  int marks  = (int) record.get("marks");

              //  stmt.setInt(1, marks);
              //  stmt.setString(2, Name);
               // stmt.setString(3, School_ID);
               // stmt.setString(6, Student_Name);
               // stmt.executeUpdate();


            //System.out.println("Records inserted.....");
         //catch (FileNotFoundException e) {
           // e.printStackTrace();
        // catch (IOException e) {
         //   e.printStackTrace();

    }

}
