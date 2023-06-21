package com.app.develite.tasks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task updatedTask) {
        Task existingTask = taskRepository.findById(taskId).orElse(null);
        if (existingTask != null) {
            // Update the task fields
            if (!existingTask.getTitle().equals(updatedTask.getTitle())) {
                existingTask.setTitle(updatedTask.getTitle());
            }

            if (!existingTask.getDescription().equals(updatedTask.getDescription())) {
                existingTask.setDescription(updatedTask.getDescription());
            }

            if (!existingTask.getStatus().equals(updatedTask.getStatus())) {
                existingTask.setStatus(updatedTask.getStatus());
            }

            if (!existingTask.getStart_date().equals(updatedTask.getStart_date())) {
                existingTask.setStart_date(updatedTask.getStart_date());
            }
            if (!existingTask.getEnd_date().equals(updatedTask.getEnd_date())) {
                existingTask.setEnd_date(updatedTask.getEnd_date());
            }

            if (!existingTask.getProject().equals(updatedTask.getProject())) {
                existingTask.setProject(updatedTask.getProject());
            }

            // Update other task fields as needed
            return taskRepository.save(existingTask);
        }
        return null;
    }

    public boolean deleteTask(Long taskId) {
        if (taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
            return true;
        }
        return false;
    }
}
