package com.example.Repository;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Taskrepository {
    public static final String FILE_NAME = "Task.json";
    public final  Gson gson;

 public    Taskrepository(){
        this.gson= new GsonBuilder().setPrettyPrinting().create();
    }

    public List<Task> LoadTask(){
        File file = new File(FILE_NAME);
        if(!file.exists()){
            return new ArrayList<>();
        }
        try(FileReader Reader = new FileReader(file)){
            Type taskListType = new TypeToken<List<Task>>() {}.getType();
            List<Task> task = gson.fromJson(Reader, taskListType);
            return task != null ? task : new ArrayList<>(); 
        } catch (Exception e) {
           System.out.println("lỗi đọc file"+e.getMessage());
           return new ArrayList<>();
        }

    }
    public void SaveTask(List<Task> task){
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(task, writer);
            
        } catch (Exception e) {
            System.out.println("lỗi lưu file"+ e.getMessage());
        }
    }
}
