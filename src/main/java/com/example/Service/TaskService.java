package com.example.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.Repository.Taskrepository;
import com.example.model.Status;
import com.example.model.Task;

public class TaskService {
    // khởi tạo  đối tượng reposi
    private final Taskrepository taskrepository;
 public  TaskService(){
        this.taskrepository = new Taskrepository();
    }
    
public void addTask(String description){
// 1. Tải danh sách hiện tại từ file lên
List<Task> task = taskrepository.LoadTask();

// 2. Tính toán ID tự động tăng (Nếu list trống thì ID = 1, ngược lại lấy ID cuối + 1)
 int newID= task.isEmpty() ? 1 : task.get(task.size() - 1 ).getId()+1;

// 3. Lấy thời gian hiện tại định dạng chuẩn chuỗi
String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss"));

// 4. Khởi tạo đối tượng Task mới (mặc định status là TODO)
Task newtask = new Task(newID, description, now, now,Status.TODO);
// 5. Thêm vào danh sách và lưu ngược lại xuống file
task.add(newtask);
taskrepository.SaveTask(task);
// 6. In ra thông báo thành công theo đúng yêu cầu đề bài CLI
System.out.println("đã tạo task mới với id:" + newID);
}

public List<Task> getAllTask(){
    return taskrepository.LoadTask();
}
public boolean updateTask(int id , String newdescription){
   List<Task> tasks = taskrepository.LoadTask();
   boolean found = false;
   for (Task task : tasks){
    if(task.getId()== id){
        task.setDescription(newdescription);
        task.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
    found = true;
            break;
   }
   if (found) {
        taskrepository.SaveTask(tasks);;
        return true;
    }
    return false;
}
public boolean deleteTask(int id){
    List<Task> tasks = taskrepository.LoadTask();
    boolean removed  = tasks.removeIf(task -> task.getId() == id);

    if(removed){
        taskrepository.SaveTask(tasks);
        return true;
    }
    return false;

}
public boolean updateTaskStatus(int id , String newstatus){
   List<Task> tasks = taskrepository.LoadTask();
   boolean found = false;
   for (Task task : tasks){
    if(task.getId()== id){
        Status status = Status.valueOf(newstatus.toUpperCase());
        task.setStatus(status);;
        task.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
       
    }
    found = true;
            break;
   }
   if (found) {
        taskrepository.SaveTask(tasks);;
        return true;
    }
    return false;
}
}
