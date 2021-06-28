/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import com.sun.rowset.JdbcRowSetResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CrudStudent {
    public static List<Student> hienthi(){// lay toan bo danh sach sinh vien
        List<Student> listsv= new ArrayList<>();
        Connection connect=null;
        Statement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "select * from sinhvien";
            statement=connect.createStatement();
            ResultSet  resultset= statement.executeQuery(sql);//lay du lieu tra ve va bien resultset se la con tro tra ve cau truy van sql
            // doc du lieu tren tung ban ghi de dua ra listsv
            while (resultset.next()){//.next() co tac dung cho phep chuyen tren tung ban ghi va con tro resultset se doc du lieu
                Student sv= new Student(resultset.getInt("id"), resultset.getString("HotenSv"),  resultset.getString("Gioitinh"), 
                        resultset.getString("Email"), resultset.getString("SDT")); // khoi tao mot doi tuong sv
                listsv.add(sv); // add doi tuong vao list
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listsv;
    }
    
    // them sinh vien
    public static void add(Student sv){
        Connection connect=null;
        PreparedStatement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "insert into sinhvien(HotenSv,Gioitinh,Email,SDT) values(?,?,?,?)";
            statement = connect.prepareStatement(sql);
            //truyen du lieu vao cau truy van sql
            
            statement.setString(1, sv.getName());
            statement.setString(2, sv.getGender());
            statement.setString(3, sv.getEmail());
            statement.setString(4, sv.getNumber());
            
                statement.execute(); // thuc hien qua trinh them du lieu
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //update sinh vien
    public static void update(Student sv,int id){
        Connection connect=null;
        PreparedStatement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "update sinhvien set HotenSv=?, Gioitinh=?, Email=?, SDT=? where ID=?";
            
            statement = connect.prepareStatement(sql);
            //truyen du lieu vao cau truy van sql
            
            statement.setString(1, sv.getName());
            statement.setString(2, sv.getGender());
            statement.setString(3, sv.getEmail());
            statement.setString(4, sv.getNumber());
            statement.setInt(5, id);

            
                statement.execute(); // thuc hien qua trinh update du lieu
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    // xoa sinh vien
     public static void delete(int id){
        Connection connect=null;
        PreparedStatement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "delete from sinhvien where ID=?";
            
            statement = connect.prepareStatement(sql);
            //truyen du lieu vao cau truy van sql
            
            statement.setInt(1, id);

            
                statement.execute(); // thuc hien qua trinh update du lieu
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
 
     public static List<Student> timSV(String name){
        List<Student> listsv= new ArrayList<>();
        Connection connect=null;
        PreparedStatement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "select * from sinhvien where HotenSv like ?";
            statement=connect.prepareCall(sql);
            statement.setString(1,"%"+ name+"%");
            ResultSet  resultset= statement.executeQuery();//lay du lieu tra ve va bien resultset se la con tro tra ve cau truy van sql
            // doc du lieu tren tung ban ghi de dua ra listsv
            while (resultset.next()){//.next() co tac dung cho phep chuyen tren tung ban ghi va con tro resultset se doc du lieu
                Student sv= new Student(resultset.getInt("id"), resultset.getString("HotenSv"),  resultset.getString("Gioitinh"), 
                        resultset.getString("Email"), resultset.getString("SDT")); // khoi tao mot doi tuong sv
                listsv.add(sv); // add doi tuong vao list
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listsv;
    }
    
}
