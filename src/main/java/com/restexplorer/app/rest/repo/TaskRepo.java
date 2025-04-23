package com.restexplorer.app.rest.repo;

import com.restexplorer.app.rest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Long> {
}
