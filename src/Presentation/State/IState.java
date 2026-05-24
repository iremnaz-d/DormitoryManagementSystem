package Presentation.State;

import Presentation.ConsoleInterface;

public interface IState {
    void handle(ConsoleInterface context);
}
