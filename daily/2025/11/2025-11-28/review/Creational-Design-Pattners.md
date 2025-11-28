# Creational Design Patterns

## Singleton Pattern

Đảm bảo một class chỉ có duy nhất một instance trong toàn bộ hệ thống và cung cáp một điểm truy cập toàn cục tới instance đó.

Vì sao không dùng static, có static thì càn gì Singleton ?
- Trong java khi là static thì không cần object, không thay thế được bằng class khác, không implement interface được, khó dùng với Dependency Injection

- Khi là Singleton: vẫn là object, vẫn implement interface, có thể DI, có thể control được lifecycle của nó

## Builder Pattern

Tách việc xây dựng object phức tạp thành từng bước, và cho phép sử dụng lại quá trình xây dựng để tạo ra các phiên bản khác nhau.

## Factory Method Pattern

Cung cấp một interface để tạo object nhưng để cho subclass quyết định class cụ thểnafo sẽ được tạo

## Abstract Factory Pattern

Dùng để tạo ra nguyên một họ (family) sản phẩm liên quan mà không làm lẫn lộn giữa các phiên bản. Mỗi Factory cụ thể đảm bảo tạo ra toàn bộ sản phẩm đồng bộ theo một theme/loại

## Prototype Pattern

Tạo object mới bằng cách nhân bản (clone) một object gốc (prototype), thay vì tạo từ đầu bằng constructor

### Shallow Copy (copy nông)
Copy các giá trị primitive
Copy _reference_ đối với object

### Deep Copy (copy sâu)
Coppy toàn bộ object graph thành new object

- TRONG JAVA:
    - Implements lại Cloneable dùng super.clone() 
    - Nhưng phải lưu ý là nó vẫn là Shallow Copy vì object bên trong class đó làm gì biết là dùng super.clone() -> bug 
    - Lưu ý trong Java Cloneable nó không có method clone() mà nó dùng cơ chế magic của Java 

