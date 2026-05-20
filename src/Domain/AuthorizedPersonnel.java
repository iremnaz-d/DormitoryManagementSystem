package Domain;

public class AuthorizedPersonnel extends User{

    private String name;
    private String title;

    public AuthorizedPersonnel(String username, String password, String role, String name, String title){
        super(username, password, role);
        this.name = name;
        this.title = title;
    }

    public String getAdminDetails(){
        return "Admin: " + name + "    Title: " + title;
    }

  /*  public void updateTitle(String newTitle){
        this.title = new
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
