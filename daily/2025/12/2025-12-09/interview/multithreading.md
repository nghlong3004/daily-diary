# Multithreading in Java
## What is multithreading
Về cốt lõi, đa luồng cho phép một chương trình chạy đồng thời nhiều phần mã của nó. Một sợi chỉ đơn vị nhỏ nhất của một quá trình và đa luồng bao gồm việc chạy nhiều luồng cũng một lúc, cho phép thực thi song song các tác vụ. Điều này có thể dẫn đến hiệu suât và khả năng đáp ứng tốt hơn, đặc biệt là trong các ứng dụng sử dụng nhiều tài nguyên hoặc những ứng dụng cần xử lý nhiều hoạt động đồng thời.

Lợi ích của multithreading:
- Cải thiện hiệu suất: Bằng cách chia một tác vụ trên nhiều luồng, công việc có thể được thực hiện nhanh hơn so với chạy nó trong một luồng duy nhất
- Tăng cường khả năng đáp ứng: Các ứng dụng, đặc biệt là GUI hoặc máy chủ web, có thể vẫn đáp ứng trong khi xử lý các hoạt động chạy dài ở chế độ nền.
- Sử dụng tài nguyên tốt hơn: CPU hiện đại có nhiều lõi và đa luồng dảm bảo rằng tất cả chúng đều được sử dụng hiệu quả.

Tuy nhiện, multithreading không phải là không có thách thức. Các luồng cần phối hợp khi truy cập các tài nguyên được chia sẻ và việc xử lý không đúng cách có thể dẫn đến các vấn đề như bế tắc hoặc điều kiện chạy đua. Đó là lý do tài sao hiểu các cơ chế cơ bản và sử dụng các công cụ phù hợp là điều cần thiết để lập trình đa luồng thành công

## Tổng quan về Multithreading trong Java

Java được xây dựng với đa luồng ở cốt lõi của nó, và nó cung cấp nhiều cách để tạo và quản lý các luồng. Cho dù bạn đang xử lý các tác vụ dơn giản hay các hoạt động đồng thời phức tạp, Java cung cấp tính linh hoạt thông qua các API khác nhau.

### Tạo Threard trong Java

Có 2 cách chính tạo thread trong Java là: Mở rộng class Thread hoặc implements interface Runnable

1. extends class Thread

Một trong những cách đơn giản nhất để tạo một thread là extends các class Thread và Override method run()

```java
public class MyThread extends Thread{
    public void run(){
        for(int i = 0; i < 5; ++i){
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
        }
    }
}
```

Trong ví dụ, nếu tạo 2 luồng thread1, thread2 ở main các method start() được sử dụng để bắt đầu thực thi trong một thread mới

2. implements Interface Runnable
```java
public class MyRunnable implements Runnable {
    public void run() {
        // Code to be executed in the new thread
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread1.start(); // Starts a new thread
        thread2.start(); // Starts another thread
    }
}

```

3. Sử dụng Lambda Expressions (Java 8+)

Với sự ra đời của Java 8, có thể sử dụng lambda để đơn giản hoá việc implements Interface Runnable
```java

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }
}

```

## Quản lý luồng với ExecutorService

Khi làm việc với nhiều luồng, việc quản lý thủ công việc tạo luồng có thể trở nên cồng kềnh. Java cung cấp các Interface ExecutoreService, cung cấp một cách linh hoạt và hiệu quả để quản lý nhóm luồng.

Dịch vụ thực thi quản lý một nhóm các chủ đề điều đó có thể được sử dụng lại để thực thi nhiều tác vụ, thay vì tạo một luồng mới cho mỗi thao tác. Điều này làm giảm chi phí tạo luồng và cải thiện hiệu suất

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        // Create a thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println("Thread " + Thread.currentThread().getId() + " is running");
            });
        }

        // Shutdown the executor service
        executor.shutdown();
    }
}

```

Trong ví dụ này, một `ExecutorService` được toạ với một pool cố định 2 Thread. Các submit() method được sử dụng để gán các tác vụ cho thread pool, và executor quản lý vòng đời thread cho bạn. Khi tất cả các nhiệm vụ được hoàn thành, các shutdown() method được gọi để dừng executor

## Synchronized và Thread - safe

Multithreading đưa ra nhu cầu đồng bộ hoá khi nhiều luồng truy cập vào một tài nguyên được chia sẻ. Nếu không có sự đồng bộ hoá thích hợp, có thể xảy ra hỏng dữ liệu hoặc trạng thái không nhất quán, Java cung cấp các từ khoá synchronized để đảm bảo chỉ có một luồng tại một thời điểm có thể truy cập các phần của mã.

```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join(); // Wait for thread1 to finish
        thread2.join(); // Wait for thread2 to finish

        System.out.println("Final count: " + counter.getCount());
    }
}

```

Trong ví dụ increment() method được synchronized để đảm bảo rằng chỉ một luông có thể sửa count tại một thời điểm

## Multithreading trong Spring và Spring Boot

Spring Framework cung cấp các công cụ mạnh mẽ để xử lý các tác vụ đa luồng và không đồng bộ. Bằng cách trừu tượng hoá phần lớn sự phức tạp xung quanh việc quản lý luồng, Spring đơn giản hoá quy trình chạy các tác vụ đồng thời và cung cấp cá cơ chế tích hợp để xử lý không đồng bộ hoạt động với boilerplate tối thiểu.

### Giới thiệu về tính năng Asynchronous của Spring

Spring cho phép bạn tạo và quản lý các tác vụ không đồng bộ với nhiều loại trừu tượng. Cách tiếp cận phổ biến nhất là sử dụng anonitation @Async, nhưng Spring cũng cung cấp hỗ trợ phức tạp cho các kịch bản phức tạp hơn, chẳng hạn như các tác vụ được lên lịch, người thực thi tác vụ và thâm chí là lập trình phản ứng ho I/O không hặn.

Spring Boot đặc biệt, giúp dễ dàng cấu hfinh và sử dụng các tính năng này mà không cần thiết lập phức tạp.

### Thực hiện các phương thức không đồng bộ với @Async

Khi áp dụng cho một method, nó cho phép method thực thi trong một thread riêng biệt, giải phóng thread chính để tiếp tục thực thi các tác vụ khác. Điều này đặc biệt hữu ích cho các hoạt động dài hạn mà bạn không muốn chặn luồng chính của ứng dụng.

kích hoạt thực thi không đồng bộ: Để sử dụng @Asynch, phải bật hỗ trợ async in your application spring bằng cách thêm @EnableAsync cho một lớp cấu hình

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AsyncConfig {
}

```

```java

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async
    public CompletableFuture<String> performAsyncTask() {
        try {
            // Simulate a long-running task
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture("Task completed");
    }
}


```

Trong ví dụ trên, method performAsyncTask() được đánh dấu bằng Async, có nghĩa là phương thức này được gọi, spring sẽ tự động thực thi nó trong một thread riêng biệt từ thread pool, cho phép thread chính tiếp tục mà không cần đợi nhiệm vụ hoàn thành.


### Tuỳ chỉnh Async Behavior với ThreadPoolTaskExecutor

Theo mặc định, Spring Boot sử dụng một thread pool đơn giản khi thực thi tác vụ không đồng bộ. Tuy nhiên, trong môi trường production, bạn có thể muốn tuỳ chỉnh nhóm luồng cho phù hợp với nhu cầu của ứng dụng. Spring boot cung cấp các ThreadPoolTaskExecutor với mục đích này, cho phép bạn cấu hình cá tham số nhóm luồng như kích thước nhóm lõi, kích thước nhóm tối đa và dung lượng hàng đợi.

```java

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("MyExecutor-");
        executor.initialize();
        return executor;
    }
}


```

Trong ví dụ này, các ThreadPoolTaskExecutor được cấu hình với: 
- Kích thước Core Pool: Số lượng thread tối thiểu sẽ luôn có sẵn.
- Kích thước Max Pool: Số lượng thread tối đa có thể tạo.
- Queue Capacity: Có bao nhiêu tác vụ có t hể được xếp hàng khi các luồng mới được tạo
- Thread Name Prefix: Mẫu đặt tên tuỳ chỉnh có các thread trong trình thực thi này.

Để sử dụng nhóm luồng tuỳ chỉnh này, phương thức chú thích bằng @Async sẽ t ự động sử dụng taskExecutor được định nghĩa trong cấu hình.

- CorePoolSize: Số lượng thread luôn có sẵn (Ngay cả khi không hoạt động). Một là mặc định.
- MaxPoolSize: Số lượng thread tối đa. Tăng điều này nếu các tác vụ thường bị chặn hoặc chờ đợi trên các tài nguyên bên ngoài.
- QueueCapacity: Số lượng tác vụ có thể được xếp hàng trước khi các luồng mới được tạo. Đối với tác vụ ngắn, Hàng đợi lớn hơn sẽ hiệu quả. ĐỐi vối với tác vụ dài, hãy xem xét một hàng đợi nhỏ hơn để tránh sự chậm trễ kéo dài.

### Scheduling Tasks with @Scheduled

Một tính nang mạnh mẽ khác trong Spring Boot là khả năg lên lịch các tác vụ để chạy theo các khoảng thời gian hoặc thời gian cụ thể bằng cách sử dụng @Scheduled. Điều này rất hữu ích cho việc chạy các công việc nền, chẳng hạn như dọn dẹp database, tạo báo cáo hoặc gửi thông báo định kì.

Kích hoạt lập lịch: thêm @EnableScheduling cho một class config

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedulerConfig {
}


```

Bây giờ, bạn có thể tạo các method được lập lcijh để chạy theo các khoảng thời gian cố định, sử dụng biểu thức cron hoặc sau một độ trẽ cụ thể

```java

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Scheduled(fixedRate = 5000)
    public void performTask() {
        System.out.println("Task executed every 5 seconds");
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void performTaskAtNoon() {
        System.out.println("Task executed at 12 PM every day");
    }
}


```

### TaskExecutor Cho trừu tượng cao cấp hơn

Spring cung cấp các interface TaskExecutor như một sự trừu tương hoá cấp cao hơn để quản lý các tác vụ không đồng bộ. Điều này cho phép thực thi Runnable mà không xử lý các chi tiết cấp thấp hơn của quản lý luồng

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class TaskExecutorService {

    @Autowired
    private TaskExecutor taskExecutor;

    public void executeAsyncTask() {
        taskExecutor.execute(() -> {
            System.out.println("Task executed asynchronously using TaskExecutor");
        });
    }
}

```

Các TaskExecutor giao diện được Autowired vào, và exxecuteAsyncTask() sử dụng nó để thực thi một task không đồng bộ. Điều này cung cấp một cách đơn giản và sạch sẽ để cchajy các tác vụ nền không cần tạo luồng mới theo cách thủ công
