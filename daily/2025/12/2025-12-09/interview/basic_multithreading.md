# Overview
## Thread là gì? Multi-thread là gì?

Thread (Luồng) về cơ bản là một tiến trình con (sub-process). Một đơn vị xử lý nhỏ nhất ủa máy tính có thể thực hiện một công việc riêng biệt. Trong java, các luồng được quản lý bởi máy ảo java (JVM)

Multi-Thread (đa luồng) là một tiến trình có thể thực hiện nhiều luồng đồng thời. Một ứng dụng Java ngoài luồng main có thể có các luồng khác thực thi đồng thời làm ứng dụng chạy nhanh và hiệu quả hơn.

## Đa nhiệm (multitasking)

Multitasking: Là khả năng chạy đồng thời một hoặc nhiều chương trình cùng một lúc trên hệ điều hành. Hệ điều hành quản lý việc này và sắp xếp lịch phù hợp cho các chương trình đó. Ví dụ, trên hệ điều hành windows chúng ta có làm việc đồng thời với các chương trình khác nhau như: Microsoft Word, Excel, Media Player, ...

Chúng ta sử dụng đa nhiệm để tận dụng tính năng của CPU

Đa nhiệm có thể đạt được bằng 2 cách:
1. Đa nhiệm dựa trên đơn tiến trình (Process) - Đa tiến trình (Multiprocessing)

- Mỗi tiến trình có địa  chỉ riêng trong bộ nhớ, tức là mỗi tiến trình phân bổ 1 vùng nhớ riệng biệt.
- Tiến trình là nặng
- Sự giao tiếp giữa các tiến trình có chi phí cao
- Chuyển đổi từ tiến trình này sang tiến trình khác đòi hỏi thời gian đăng ký việc lưu và tải các bản đồ bộ nhớ, danh sách cập nhật, ...

2. Đa nhiệm dựa trên luồng (Thread) - Đa luồng (Multithreading)

- Các luồng chia sẻ không gian địa chỉ ô nhớ giống nhau
- Luồng là nhẹ
- Sự giao tiếp giữa các luồng có chi phí thấp

Đa tiến trình (multiprocesssing) và đa luồng (multithreading) cả hai được sử dụng để tạo ra hệ thống đa nhiệm (multitasking). Nhưng chúng ta sử dụng đa luồng nhiều hơn đa tiến trình vì các luồng chia sẻ một vùng nhớ chung, Chúng hông phân bổ vùng nhớ riêng biệt để tiết kiệm bộ nhớ, và chuyển đổi ngữ cảnh giữa các luồng mất ít thời gian hơn tiến trình.

### Ưu điểm của đa luồng

- Nó không chặn người sử dụng vì các luồng là độc lập và có thể thực hiện nhiều việc cùng lúc.
- Mỗi luồng có thể dùng chung và chia sẻ nguồn tài nguyên trong quá trình chạy, nhưng có thể thực hiện một cách độc lập.
- Luồng là độc lập, vì vậy nó không ảnh hưởng đến luồng khác nếu ngoại lệ xảy ra trong một luồng duy nhất.


### Nhược điểm của đa luồng.
- Càng nhiều luồng thì xử lý càng phức tạp
- Xử lý vấn đề về tranh chấp bộ nhớ, đồng bộ dữ liệu khá phức tạp.
- Cần phải tránh các luồng khoá chết (dead lock), luồng chạy mà không làm gì trong ứng dụng cả.

## Vòng đời (life cycle) của một thread trong java

vòng đời của thread trong java được kiểm soát bởi JVM. Java định nghĩa các trạng thái của luồng trong các thuộc tính stati ủa lớp Thread.State:

- NEW: Đây là trạng thái khi luồng vừa được khởi tạo bằng method khởi tạo của lớp thread nhưng chưa được start(). Ở trạng thái này, luồng được tạo ra nhưng chưa được cấp phát tài nguyên và cũng chưa chạy. Nếu luồng đang ở trạng thái này mà ta gọi các phương thức ép buộc như stop, resume, suspend, ... sẽ là nguyên nhân xảy ra ngoại lệ IllegalThreadStateException.

- RUNNABLE: Sau khi gọi method start() thì luồng đã được cấp phát tài nguyên và các lịch điều phối CPU cho luồng cũng bắt đầu có hiệu lực. Ở đây chúng ta dùng trạng thái là Runnable chứ không phải Running, vì luồng không thực sự luôn chạy mà tuỳ vào hệ thống có sự điều phối của CPU khác nhau

- WAITING: Thread chờ không giới hạn cho đến khi một luồng khác đánh thức nó.

- TIME_WAITING: Thread chờ trong một thời gian nhất định, hoặc là có một luồng khác đánh thức nó.

- BLOCKED: Đây là 1 dạng của trạng thái "Not Runnable", là trạng thái khi Thread vẫn còn sống, nhưng hiện tại không được chọn để chạy. Thread chờ một monitor để unlock trên một đối tương nó mà nó cần.

- TERMINATED: Một Thread ở trong trạng thái terminated hoặc dead khi phương thức run() của nó bị thoát

## Các phương thức của class Thread thường hay sư dụng
- suspend(): method làm tạm dừng hoạt đọng của 1 luồng nào đó bằng cách nưng cung cấp CPU cho luồng này. Để cung cấp lại ta dùng resume(). Cần lưu ý là ta không thể dừng ngay hoạt đông của luồng bằng phương thức này. suspend() không dừng ngay tức thì hoạt động của luồng khi sau khi luồng này trả CPU về cho OS thì không cấp nữa
- resume(): method làm cho luồng chạy lại khi thread bị dừng do phương thức suspend(). method này sẽ đưa luồng vào lại lịch điều phói CPU để luồng được CPU chạy lại bình thường

...

## Một số thông tin liên quan tới luồng

### ĐỊnh dnh của luồng (ThreadId)

ThreadId là định danh của luồng, nó dùng để phân biẹt với các luồng khác trong cùng 1 tiến trình hoặc cùng tập luồng. Đây là thông số mà JVM tự tạo ra khi tạo luồng nên không thể sửa thông số này, nhưng có thể lấy qua getId()

### Tên của luồng (ThreadName)

Threadname là tên luồng, đây là thuộc tính ta có thể đặc hoặc không. Nếu không JVM sẽ tự đặt với quy tắc: "Thread-" + Thứ tự luồng được tạo ra, bắt đầu từ 0

### Độ ưu tiên của luồng (Priority)

Trong java, để đặt đô ưu tiên của 1 luồng thì dùng method: setPrioryty(int newPriority)

- int newPriority: giá trị từ 1 đến 10

Java định nghĩa sẵn 3 mức tiêu chuẩn:

- Thread.MIN_PRIORITY (giá trị 1)
- Thread.NORM_PRIORITY(giá trị 5)
- Thread.MAX_PRIORITY (giá trị 10)


