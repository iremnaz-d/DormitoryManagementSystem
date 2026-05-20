package Infrastructure;

import Application.Interfaces.IAnnouncementRepository;
import Domain.Announcement;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementRepository implements IAnnouncementRepository {

    private static AnnouncementRepository instance;
    private List<Announcement> announcementList;

    private AnnouncementRepository(){
        this.announcementList = new ArrayList<>();
    }

    public static AnnouncementRepository getInstance(){
        if(instance == null){
            instance =  new AnnouncementRepository();
        }
        return instance;
    }

    @Override
    public void save(Announcement announcement) {
        this.announcementList.add(announcement);
    }

    @Override
    public void delete(Announcement announcement) {
        this.announcementList.remove(announcement);
    }

    @Override
    public List<Announcement> findAll() {
        return this.announcementList;
    }
}
