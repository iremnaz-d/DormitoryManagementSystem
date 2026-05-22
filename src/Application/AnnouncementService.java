package Application;

import Application.Interfaces.IAnnouncementRepository;
import Application.Interfaces.IObserver;
import Application.Interfaces.ISubject;
import Domain.Announcement;
import Infrastructure.AnnouncementRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementService implements ISubject {

    private IAnnouncementRepository repository;
    private List<IObserver> observerList;

    public AnnouncementService(){
        this.repository = AnnouncementRepository.getInstance();
        this.observerList = new ArrayList<>();
    }

    public void publishAnnouncement(String title, String content){

        Announcement announcement = new Announcement(title, content, LocalDate.now());
        repository.save(announcement);
        notifyObservers(announcement);
    }

    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(Announcement announcement) {
        for (IObserver observer : observerList) {
            observer.update(announcement);
        }
    }

    public List<Announcement> getAnnouncementList(){
        return this.repository.findAll();
    }
}
