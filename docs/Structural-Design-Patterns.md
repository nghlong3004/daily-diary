# Structural Design Patterns

---
## 1. Adapter
- Adapter chuyển đổi giao diện (interface) của một class này sang một giao diện khác mà client đang mong đợi, để những class vốn không tương thích có thể làm việc với nhau
- Lý do ra đời (tại sao nên dùng )
    - Dùng thư viện bên thứ 3 nên không thể sửa SDKm cũng không muốn đổi hết code
    - Trong system có nhiều module cũ/mới, mỗi thằng expose một kiểu API khác nhau.
    - Tuân thủ Open/Closed Principle: Thay vì sửa Client (vi phạm OCP), bạn thêm một lớp Adapter (mở rộng mà không sửa).
---
## 2. Bridge
- Bridge tách phần trừu tượng (Abstraction) khỏi phần hiện thực (Implementation) để chúng có thể phát triển độc lập và tránh tạo ra quá nhiều class
### Khi nào dùng ?
- Dấu hiện bài toán:
    - Một lơp có 2 hoặc nhiều chiều biến thể độc lập nhau
    - Inheritance sẽ tạo ra quá nhiều subclass
    - Thay đổi implementation không đụng abstraction, hoặc ngược lại
    - Tách cái để người dùng tương tác (API) khỏi cái hoạt động phía sau
## 3. Composite
- Composite cho phép xử lý “obj đơn lẻ” và “tập hợp obj” theo cùng 1 cách thông qua một interface chung.
### Lý do ra đời
- Dạng bài toán
    - Gọi hung một method cho cả folder và file
    - xử menu đa cấp, mỗi menu có thể chứa menu con
    - có object phức tạp chia thành phần nhỏ, nhưng muốn client làm viẹc như một thẻ thống nhất.
### Khi nào dùng
- Dấu hiệu nhận biết bài toán:
    - cấu trúc đệ quy
    - dữ liệu dạng cây
    - leaf và composite đều là thành phần
    - Client phải tương tác với cả hai giống nhau
### Cấu trúc
- Có 3 role chính:
    1. Composite
    - Inteface chung cho left và Composite
    2. Left
    - Phàn tử cuối, không chứa gì
    3. Composite
    - Chứa nhiều Component
## 4. Decorator 
- Decorator cho phép bọc thêm hành vi cho một object mà không cần sửa code gốc và khôg cần inheritance 

### Lý do ra đời
- Inheritance tạo quá nhiều subclass
- Muốn thêm/tắt chức năng lúc runtime
- Tuân thủ Open/Closed Principle
- Giống filter trong spring boot

### Bài toán phù hợp
- Cần thêm nhiều tính năng nhỏ lẻ lên object
- Không muốn làm object phình to
- CLient vẫn muốn gọi object thông qua interface chung
- Cần nhiều lớp bọc chồng lên nhau

## 5. Facade
- Facade cung cấp một API đơn giản, gọn gàng để ẩn đi hệ thống phức tạp phía sau.

### Lý do ra đời
- Giảm độ phức tạp
- Giảm coupling giữa client và subsystem
- Đảm bảo clean architecture

### Dùng khi nào
- Client gọi quá nhiều class để làm 1 nhiệm vụ.
- Tách API đẹp đẽ ra khỏi hệ thống phức tạp.

## 6. Flyweigh
- Flyweight chia dữ liệu thành 2 loại
    - Intrinsic state (bất biến, dùng chung được)
    - Extrinsic state (bién đổi theo từng instance)
### Lý do ra đời
- Trong nhiều ứng dụng, có rất nhiều object giống nhau chỉ khác vài thông số
- Flyweigh giúp: Giảm lượng object tạo ra, tối ưu, tránh duplicate

### Dùng khi nào 
- Flyweight phù hợp khi:
    - Số lượng object khổng lồ (100k, 1 triệu…)
    - Nhiều object giống nhau tới 90%
    - Muốn tái sử dụng dữ liệu bất biến
    - Có cơ chế factory / pool để tái sử dụng

## 7. Proxy
- Proxy là lớp “đại diện” đứng trước một object thật để kiểm soát việc truy cập vào nó.

### Lý do ra đời
1. Kiểm soát truy cập (Access Control)
2. Lazy Loading
3. Remote Proxy
4. Smart Reference

### Khi nào dùng
- Cần chặn hoặc cho phép truy cập
- Cần tạo object khi cần, tránh tạo quá sớm
- Cần đại diện cho object thật ở xa
- Cần quản lý cache, nhưng ở mức object level chứ không phải behavior level như decorator

### Các loại proxy
1. Protection Proxy
Kiểm tra quyền truy cập
2. Virtual Proxy
Lazy Loading object thật
3. Remote Proxy
Gọi object thật từ một máy khác
4. Smart Proxy
Thêm logic quản lý tài nguyên, kiểm tra trạng thái, locking


