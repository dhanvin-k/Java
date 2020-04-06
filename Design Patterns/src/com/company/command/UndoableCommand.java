package com.company.command;

public interface UndoableCommand extends Command {
    void undo();
}
