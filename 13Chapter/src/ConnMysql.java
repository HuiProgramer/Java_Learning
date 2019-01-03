import java.sql.*;

public class ConnMysql {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.加载驱动，使用反射知识，现在记住这么写
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.使用DriverManager获取数据库连接
            //其中返回的Connection就代表了Java程序和数据库的连接
            //不同不同数据库的URL写法需要查驱动文档，用户名、密码由DBA分配
           Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?serverTimezone = GMT%2B8","root","1712817197");
           //3.使用Connection来创建一个Statement对象
            Statement stmt = conn.createStatement();
            //4.执行SQL语句
            /*
            * Statement有三种执行SQL语句的方法；
            * 1.execute（）可执行如何SQL语句-返回一个boolean值
            * 如果执行后第一个结果是ResultSet，则返回true，否则返回false
            * 2.executeQuery（）执行select语句-返回查询到的结果集
            * 3.executeUpdate（）用于执行DML语句-返回一个整数
            * 代表被SQL语句影响的记录条数*/
            ResultSet rs = stmt.executeQuery("select * from user");
            while(rs.next())
                System.out.println(rs.getString(1)+"\t" + rs.getString(2)+"\t"+ rs.getString(3)+"\t"+ rs.getString(4));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
