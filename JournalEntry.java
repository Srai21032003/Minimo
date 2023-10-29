package journalentry;

import java.util.Date;
import java.util.List;
class JournalEntry
 {
    private Date date;
    private String title;
    private String content;

    public JournalEntry(Date date, String title, String content) {
        this.date = date;
        this.title = title;
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}