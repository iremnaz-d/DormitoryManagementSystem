package Application.Interfaces;

import Domain.Announcement;

public interface IObserver {

    void update(Announcement announcement);
}
