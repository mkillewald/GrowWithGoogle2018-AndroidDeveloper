package com.example.android.todolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

// COMPLETED (5) Make this class extend ViewModel
public class AddTaskViewModel extends ViewModel {
    private static final String TAG = AddTaskViewModel.class.getSimpleName();

    // COMPLETED (6) Add a task member variable for the TaskEntry object wrapped in a LiveData
    private LiveData<TaskEntry> mTask;

    // COMPLETED (8) Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // Note: The constructor should receive the database and the taskId
    public AddTaskViewModel(AppDatabase database, int taskId) {
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        mTask = database.taskDao().loadTaskById(taskId);
    }

    // COMPLETED (7) Create a getter for the task variable\
    public LiveData<TaskEntry> getTask() {
        return mTask;
    }
}