package dev.alexzvn.among.contract;

import java.util.List;

public interface Task {
    
    public boolean hasSubTask();

    public List<Task> getSubTask();
}
