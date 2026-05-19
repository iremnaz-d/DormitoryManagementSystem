package Domain;

import java.time.LocalDate;

public class Announcement {

    private String title;
    private String content;
    private LocalDate publishDate;
    private boolean requiresResponse;

    public Announcement(String title, String content, LocalDate publishDate, boolean requiresResponse) {
        this.title = title;
        this.content = content;
        this.publishDate = publishDate;
        this.requiresResponse = requiresResponse;
    }

    public String getAnnouncementContent(){
        return "ğ";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRequiresResponse() {
        return requiresResponse;
    }

    public void setRequiresResponse(boolean requiresResponse) {
        this.requiresResponse = requiresResponse;
    }

}
