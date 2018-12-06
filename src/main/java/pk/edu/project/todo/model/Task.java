package pk.edu.project.todo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ADMIN on 12/6/2018.
 */
@Data
@Entity
@EqualsAndHashCode
@ToString
public class Task implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    private String taskTitle;

    public Task (){}

    public Task (String taskTitle){
        this.taskTitle = taskTitle;
    }
}
