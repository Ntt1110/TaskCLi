package com.example;

import java.util.Scanner;

import com.example.controller.TaskController;

public class CliApp {
    private final TaskController taskController;
    private final Scanner scanner;
    public CliApp(){
        this.taskController= new TaskController();
        this.scanner = new Scanner(System.in);

    }

    void start(){
        printWelcomeBanner();

        while (true) {
            System.out.print("\ntask-cli> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.println("Tạm biệt bạn! Hẹn gặp lại.");
                break;
            }

            // Tách lệnh chính và phần tham số (nếu có)
            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1] : "";

            // Điều hướng lệnh sang Controller hoặc xử lý trực tiếp giao diện
            switch (command) {
                case "add":
                    // Gọi controller xử lý logic thêm task
                    taskController.handleAdd(argument, scanner);
                    break;

                case "list":
                    System.out.println("Đang xử lý hiển thị danh sách...");
                    taskController.getAll();
                    break;
                case "update":
                    taskController.handleUpdate(argument, scanner);
                break;
                case "delete":
                    taskController.handleDelete(argument, scanner);
                 break;
                 case"update-status":
                 case "status":
                    taskController.handlehandleUpdateStaus(argument, scanner);
                case "help":
                    printWelcomeBanner();
                    break;

                default:
                    System.out.println("Lệnh không hợp lệ. Gõ 'help' để xem hướng dẫn.");
                    break;
            }
        }
    }

    private void printWelcomeBanner() {
        System.out.println("=========================================");
        System.out.println("      CHÀO MỪNG ĐẾN VỚI TASK TRACKER     ");
        System.out.println("=========================================");
        System.out.println("Các lệnh khả dụng:");
        System.out.println("  add       - Thêm task mới");
        System.out.println("  list      - Xem danh sách task");
        System.out.println("  update    - Cập nhật task");
        System.out.println("  delete    - Xóa một task theo ID");
        System.out.println("  update-status - Cập nhật trạng thái task (TODO, IN_PROGRESS, DONE)");
        System.out.println("  help      - Hiển thị lại hướng dẫn");
        System.out.println("  exit      - Thoát chương trình");
        System.out.println("=========================================");
    }
    
}
