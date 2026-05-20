package Application.Interfaces;

import Domain.Announcement;

public interface ISubject {

    void addObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers(Announcement announcement);
}
