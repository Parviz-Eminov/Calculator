package Worker;

@FunctionalInterface
    interface OnTaskDoneListener {
        void onDone(String result);
}

public class Worker {

    private OnTaskDoneListener callback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            callback.onDone("Task " + i + " is done");
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Лямбда-выражение, которое просто выводит результат в консоль
        OnTaskDoneListener listener = System.out::println;

        // Передаём колбэк в Worker
        Worker worker = new Worker(listener);

        // Запуск "работы"
        worker.start();
    }
}



