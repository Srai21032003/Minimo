package journalentry;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
class EntryToDB {
    /**
     * @param entry
     */
    public static void InsertToDB(JournalEntry entry) {
        try {
            Connection con = CP.createConnection();
            String sql = "INSERT INTO journal_entries (date, title, content) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(entry.getDate().getTime()));
            statement.setString(2, entry.getTitle());
            statement.setString(3, entry.getContent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}