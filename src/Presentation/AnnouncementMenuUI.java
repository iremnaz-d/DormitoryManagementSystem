package Presentation;

import Application.Facade.DormitoryFacade;
import Domain.Announcement;
import Domain.AuthorizedPersonnel;
import Domain.User;

import java.util.List;
import java.util.Scanner;

public class AnnouncementMenuUI extends BaseMenuUI{

    public AnnouncementMenuUI(DormitoryFacade facade, Scanner scan, User currentUser) {
        super(facade, scan, currentUser);
    }

    @Override
    protected String getMenuTitle() {
        return "-----ANNOUNCEMENT MENU-----";
    }

    @Override
    protected void showOptions() {
        System.out.println("1. View announcements");

        if(this.currentUser instanceof AuthorizedPersonnel)
            System.out.println("2. Publish new announcement");

    }

    @Override
    protected boolean handleChoice(int choice) {
        switch (choice){
            case 1: //view announcements
               List<Announcement> announcementList =  this.facade.getAnnouncementList();
               for (Announcement announcement: announcementList){
                   System.out.println(announcement.getTitle() + ": " + announcement.getContent());
               } return true;

            case 2: //publish new announcement
                if(this.currentUser instanceof AuthorizedPersonnel){
                    System.out.print("\nTitle: "); String title = scan.nextLine();
                    System.out.print("\nContent: "); String content = scan.nextLine();
                    this.facade.publishAnnouncement(title, content);
                }else{
                    System.out.println("Option '2' is invalid.");
                }return true;

            default:
                System.out.println("Invalid option."); return true;
        }
    }
}
