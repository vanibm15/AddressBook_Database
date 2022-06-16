import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressBookSQL {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/AddressBookServices?useSSL=false";
        String username = "root";
        String password = "123456789";
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");

        } catch (ClassNotFoundException e) {


            throw new IllegalStateException("cannot find the driver in the classpath!", e);
        }
        try {
            System.out.println("connecting to database:" + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connection done successful!!" + con);
            Statement statement = con.createStatement();
            statement.execute("insert into AddressBook(firstname,lastname,address,city,state,zip,phonenumber,email)values('vani','bm','heggeri','hubli','karnataka',580024,'987456','vani2123')\n" +
                    ",('amit','sood','gandhinagar','mumbai','maharastra',500021,'456123789','amit@123'),\n" +
                    "('varsha','bm','dollorcolony','rajajinagar','bangalore',580021,'9653214578','vars@123'),\n" +
                    "('dimpu','lm','sainagar','pune','maharastra',50021,'985631457','dimp@123'),\n" +
                    "('shreyas','cm','rudenagar','chennai','tamilnadu',560021,'32564789','shre@123');");
            ResultSet resultSet =statement.executeQuery("select * from AddressBook;");
            while (resultSet.next()){
                System.out.println("firstname" +resultSet.getString("firstname"));
                System.out.println("lastname" +resultSet.getString("lastname"));
                System.out.println("address" +resultSet.getString("address"));
                System.out.println("city" +resultSet.getString("city"));
                System.out.println("state" +resultSet.getString("state"));
                System.out.println("zip" +resultSet.getInt("zip"));
                System.out.println("phone-number" +resultSet.getString("phone-number"));
                System.out.println("email" +resultSet.getString("email"));


            }

        } catch (Exception e) {
            // e.printStackTrace();

        }
    }
}

