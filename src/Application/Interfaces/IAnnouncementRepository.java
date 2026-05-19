package Application.Interfaces;

import Domain.Announcement;

import java.util.List;

public interface IAnnouncementRepository {

    void save(Announcement announcement);

    void delete(Announcement announcement);

    List<Announcement> findAll();

}
