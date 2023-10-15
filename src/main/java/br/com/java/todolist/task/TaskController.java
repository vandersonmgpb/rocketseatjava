package br.com.java.todolist.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.java.todolist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepositoty taskRepositoty;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);

        var currentDate = LocalDateTime.now();
        // 10/11/2023 - Current
        // 10/10/2023 - StartAt
        if(currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("A data de início / data término deve ser maior do que a data atual");
        }
       
        if(taskModel.getStartAt().isAfter(taskModel.getStartAt())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("A data de início menor do que a data atual");
        }

        var task = this.taskRepositoty.save(taskModel);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/")
    public List<TaskModel> list(HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        var tasks = this.taskRepositoty.findByIdUser((UUID) idUser);
        return tasks;
    }

    //http://localhost:8080/task/892347823-cdfgcvb-832748234
    @PutMapping("/{id}")
    public TaskModel update(@RequestBody TaskModel taskModel, @PathVariable UUID id, HttpServletRequest request){
        
        var task = this.taskRepositoty.findById(id).orElse(null);

        Utils.copyNonNullProperties(taskModel, task);
        
        return this.taskRepositoty.save(task);
    }

}
