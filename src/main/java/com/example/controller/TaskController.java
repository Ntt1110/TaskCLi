package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.Service.TaskService;
import com.example.model.Task;

public class TaskController {

  private final  TaskService taskService;

    public TaskController(){
        this.taskService =  new TaskService();
    }
    public void handleAdd(String argument , Scanner scanner){
      String description = argument.replace("/", "").trim();

        if(description.isEmpty()){
            System.out.println("nhập nội dung muốn thêm ");
            description = scanner.nextLine().trim();
        }
        if(description.isEmpty()){
            System.out.println("nội dung không được trống");
            return;
        }
        taskService.addTask(description);
}
public void getAll(){
    List<Task> tasks = taskService.getAllTask();
    if(tasks.isEmpty()){
        System.out.println("danh sách đang Trống");
        return;
    }
    System.out.println("\n==================================================");
        System.out.println("                 DANH SÁCH TASK                   ");
        System.out.println("==================================================");
        for(Task task : tasks){
            System.out.println("ID" + task.getId());
            System.out.println("Nội dung   : " + task.getDescription());
            System.out.println("Trạng thái : " + task.getStatus());
            System.out.println("Ngày tạo   : " + task.getCreatedAt());
            System.out.println("--------------------------------------------------");
        }

}
public void handleUpdate(String argument, Scanner scanner){
    int id = -1;
    String newDescription = "";
    if (!argument.isEmpty()) {
        String[] parts = argument.split(" ", 2);
        try {
            id = Integer.parseInt(parts[0]);
            if (parts.length > 1) {
                newDescription = parts[1].replace("\"", "").trim();
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID phải là một số nguyên hợp lệ!");
            return;
        }
    }
  if(id == -1){
    System.out.println("Nhập ID của task cần cập nhật:");
    try {
        id = Integer.parseInt(scanner.nextLine().trim());
    } catch (Exception e) {
        System.out.println("Id không hợp lệ"+ e.getMessage());
    }
    if(newDescription.isEmpty()){
        System.out.println("nhập nội dung");
        newDescription = scanner.nextLine().replace("/", "").trim();
    }
   if (newDescription.isEmpty()) {
        System.out.println("Lỗi: Nội dung mới không được để trống!");
        return;
    }
    boolean succes = taskService.updateTask(id, newDescription);
    if (succes) {
        System.out.println("cập nhật thành công");
    }
    else {
        System.out.println("cập nhật thất bại");
    }
  }
  
}

public void handleDelete(String argument, Scanner scanner){
    int id = -1;
    String newDescription = "";
    if (!argument.isEmpty()) {
        String[] parts = argument.split(" ", 2);
        try {
            id = Integer.parseInt(parts[0]);
            if (parts.length > 1) {
                newDescription = parts[1].replace("\"", "").trim();
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID phải là một số nguyên hợp lệ!");
            return;
        }
    }
    if (id == -1) {
        System.out.print("Nhập ID của task cần xóa: ");
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID không hợp lệ!");
            return;
        }
    }
    boolean success = taskService.deleteTask(id);
    if (success) {
        System.out.println("=> Xóa task (ID: " + id + ") thành công!");
    } else {
        System.out.println("=> Không tìm thấy task có ID là: " + id);
    }
}
public void handlehandleUpdateStaus(String argument, Scanner scanner){
    int id = -1;
    String newStatus = "";
    if (!argument.isEmpty()) {
        String[] parts = argument.split(" ", 2);
        try {
            id = Integer.parseInt(parts[0]);
            if (parts.length > 1) {
                newStatus = parts[1].trim();
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID phải là một số nguyên hợp lệ!");
            return;
        }
    }
    if (id == -1) {
        System.out.print("Nhập ID của task cần cập nhật trạng thái: ");
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID không hợp lệ!");
            return;
        }
    }
    if (newStatus.isEmpty()){
        System.out.print("Nhập trạng thái mới (TODO, IN_PROGRESS, DONE): ");
        newStatus = scanner.nextLine().trim();
    }
    if (newStatus.isEmpty()) {
        System.out.println("Lỗi: Trạng thái không được để trống!");
        return;
    }
    boolean success = taskService.updateTaskStatus(id, newStatus);
    if (success) {
        System.out.println("=> cập nhật trạng thái  task (ID: " + id + ") thành công!");
    } else {
        System.out.println("=> Không tìm thấy task có ID là: " + id);
    }
}
}
