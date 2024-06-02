import ru.praktikum.local.kanban.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");

        Task firstTestTask = new Task("first test task", " description for first test task");
        Task secondTestTask = new Task("second test task", " description for second test task");

        Epic firstEpic = new Epic("first test epic", "first epic description");
        Epic secondEpic = new Epic("second test epic", "second epic description");

        Subtask st = new Subtask("test subtask", "test decription for subtask", secondTestTask);

        TaskManager tm = new TaskManager();

        tm.Create(firstTestTask);
        tm.Create(secondTestTask);
        tm.Create(st);
        tm.Create(firstEpic);
        tm.Create(secondEpic);


        firstEpic.LinkTask(firstTestTask);
        secondEpic.LinkTask(secondTestTask);

        System.out.println(tm.GetEpicByID(firstEpic.getId()));
        System.out.println(tm.GetEpicByID(secondEpic.getId()));
        System.out.println(tm.GetSubtaskByID(st.getId()));

        firstTestTask.setStatus(TaskStatus.status.DONE);
        tm.Update(firstTestTask);

        System.out.println(tm.GetEpicByID(firstEpic.getId()));


    }
}
