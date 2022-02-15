package src;
import java.sql.*;

public class Main {

    public static Integer gamesPlayed() {
        Integer result = -1;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql:Wordle");
            PreparedStatement st = connection.prepareStatement(
                    "SELECT COUNT(*) FROM words_of_the_day WHERE (SELECT COUNT(*) FROM guess WHERE guess.day = words_of_the_day.day) > ?"
            );
            st.setInt(1, 0);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                result = rs.getInt(1);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        return result;
    }


    public static void showStatistics() {
	    System.out.println("STATISTICS");
        System.out.print("Played: ");
        System.out.println(gamesPlayed());
    }

    public static void main(String[] args){
        showStatistics();
    }
}
