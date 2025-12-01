# Behavioral Design Patterns

## STRATEGY PATTERN
### 1. Khái niệm
Strategy tách thuật toán ra khỏi ngữ cảnh sử dụng, cho phép hoán đổi thuật toán tại runtime là client không biết chi tiết

### 2. Tại sao phải tách thuật toán
Ví dụ với một PaymentService  dạng như sau:
```java
if (method == "MOMO") {...}
else if (method == "VNPAY") {...}
else if (method == "CASH") {...}
```

** Đoạn code trên có 2 nhược điểm rõ nhất ** : Vi phạm OCP và Code rối/ khó mở rộng.

- Nên đây là lý do Strategy pattern ra đời

### 3. Strategy giải quyết vấn đề như thé nào 
** Ý tưởng ** :
    * Mỗi thuật toán chúng ta táh thành 1 class riêng
    * Tất cả cùng implement 1 interface chung.
    * Client chỉ giữ 1 reference đến interface này
    * Thay đổi loại thuật toán = thay đổi object, không sửa code
---

## TEMPLATE METHOD PATTERN
Template Method định nghĩa bộ khung của một thuật toán (một quy trình) trong class cha, và cho phép các bước cụ thể được ghi đè ở class con
> Define the skeleton of an algorithm in a method, defering some steps to subclasses
** Nghĩa là **:
* Quy trình không thay đổi
* Nhưng từng bước bên trong có thể thay đổi tuỳ hoàn cảnh

### Tại sao cần Template Method
Bởi vì có nhiều tình huống các lớp khác nhau làm giống nhau tới 80%, Nhưng 20% còn lại khác nhau
** Ví dụ **:
* Quy trình executeDatabaseOperation()
    1. Mở connection
    2. Chuẩn bị statement
    3. execute -> khác nhau
    4. xử lý result
    5. đóng connection
Chỉ bước số 3 khác nhau -> ta cho override lại

### Dùng khi nào
- Khi có quy trình cố định
- Nhưng 1 số bước muốn cho phép tuỳ biến
- Các class con share cung 1 flow, nhưng mỗi cái xử lý khác nhau.

---
## OBSERVER PATTERN
Một đối tượng thay đổi thì tất cả đối tượng đăng ký lắng nghe nó sẽ được thông báo tự động

### Tại sao cần Observer
- Nếu trong code có UserService.createUser(), và khi User đăng ký mình muốn:
    - Gửi email chào mừng
    - ghi log audit
    - gửi sự kiện sang kafka
    - gửi mã giảm giá.
- Nếu nhét hết vào trong createUser sẽ làm phình method, khó mở rộng -> vi phạm OCP, và hiẻn nhiên vi phạm SRPP

### Cách Observer giải quyết vấn đề:
** Ý tưởng ** :
* Subject (Publisher): Phát sự kiện
* Observers (Subscribers): đăng ký lắng nghe và tự xử lý khi có sự kiện mới
* Subject không cần biết có bao nhiêu observers, và mỗi observer làm gì

---
## STATE PATTERN
State cho phép một object thay đổi hành vi dựa trên trạng thái nội bộ của nó. Nhìn từ bên ngoài như thể object đổi class

### Lý do cần State
- Giả sử có Order với trạng thái:
    - PENDING
    - PAID
    - SHIPPED
    - DELIVERED
- Nếu bình thường sẽ phải dùng if-else/switch khắp nơi

### Ý tưởng 
- Mỗi trạng thái là một class
- Mỗi class định nghĩa hành vi của object khi dang ở trạng thái đó
- Object có biến currentState
- Khi gọi method nào đó -> state tự quyết định có chuyển sang trạng thái tiếp theo hay không

---
## COMMAND PATTERN
Command biến một hành động thành một object độc lập.
Object này chứa:
    * Dữ liệu để thực thi hành động
    * Hàm execute() để chạy
    * optionad: undo()
* Nghĩa là :
* Mỗi thao tác = 1 object -> có thể lưu, hàng đợi, log, undo, redo, ...

### Vấn đề mà Command giải quyết
Command biến một hành động (operation) thành một object riêng.
- Mỗi command object sẽ chứa:
    * Dữ liệu cần để thực thi
    * Hàm execute() -> làm
    * Optional: undo() -> hoàn tác
---
## Chain of Responsibility
Cho phép gửi một request đi qua một chuỗi các handler, mỗi handler:
    - Hoặc xử lý,
    - Hoăc chuyển tiếp cho handler tiếp theo trong chuỗi
---
