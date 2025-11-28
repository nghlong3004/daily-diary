# OOP
## Encapsulation
- nó là đóng gói dữ liệu và hành vi lại với nhau trong một class.
- nói cách khác một object sẽ gồm dữ liệu (fiels) và hành động (methods) đi chung gộp thành một gói.
- Trong java thường thể hiện bằng:
    - _private_ field
    - _public_ method (getter, setter, hành vi khác)
Encapsulation không bắt buộc phản ẩn dữ liệu, mà nó nói về việc dữ liệu và logic liên quan được gom nhóm cùng một khối
- Trong encapsulation có một thuật ngữ được gọi là data hiding
- Data hiding có nghĩa là giấu dữ liệu bên trong, không cho phép bên ngoài truy cập dữ liệu trực tiếp.
- Trong java các trường (Fields) thể hiện bằng private
- Data hiding chỉ cho phép chỉnh sửa giữ liệu thông qua các hàm
- Data hiding là một phần của Encapsulation vì nó chỉ có khái niệm là che giấu dữ liệu đó, còn Encapsulation là gộp dữ liệu và hành vi lại với nhau

## Inheritance
- Cho phép một subclass kế thừa thuộc tính và phương thức từ một superclas, giúp tái sử dụng mã nguồn và mở rộng mà không cần viết lại.
- Trong java thể hiện qua từ khoá extends
- Quan hệ is a
- Trong java từ khoá extends chỉ cho phép kế thừa 1 class, vì nếu không nó sẽ gây diamond problem nghĩa là xung đột method, vì vậy trong java chỉ cho kế thừa một class, nhưng lại cho phép implements nhiều interface để mở rộng khả năng.
- Method overriding xảy ra khi một subclass định nghĩa lại một phương thức đã có ở super class, với cùng tên, tham số, kiểu trả về nhằm thay đổi hoặc mở rộng hành vi.
- Overrider diễn ra khi runtime
- Trong java, khi override, kiểu trả về có thể là covariant tức là kiểu trả về của subclass được phép là kiểu con của kiểu tra về ở superclass
- Constructor: Subclass không kế thừa constructor, nhưng hi tạo đối tượng subclas, cóntructor của superclass luôn được gọi trước, thông qua super()

## Polymorphism
- Tính chất cho phép cùng một lời gọi phương thức nhưng có thể dẫn dến các cách thực thi khác nhau, tuỳ thuộc vào kiểu đổi tượng thực tế tại thời điểm này.
- Trong java có 2 dạng là Compile-time polymorphism và Runtime polymorphism
1. Compile-time polymorphism
- Thực hiện method overloading (cùng tên method nhưng khác tham số)
2. Runtime polymorphism 
- Thực hiện method overriding và upcasting (gọi method qua kiểu cha nhưng thực thi kiểu con)
- Polymorphism runtime xảy ra khi ta gọi phương thức qua biến kiểu cha, nhưng thực thi theo kiểu đổi tượng con thực sự tại runtime

## Abstraction
- Abstraction là quá trình ẩn đi các chi tiết phức tạp và chỉ lộ ra những đặc điẻm, hành vi cốt lõi mà đối tượng cần phải có.
- Trong java, abstraction được thực hiện qua abstract class và interface
1. Abstract class
- Có thể có method đã có code và method abstract (không có body)
- Dùng khi các class con có điểm chung và chia sẻ code
2. Interface
- Chỉ chứa hành vi thuần tuý (trước java 8)
- Từ java 8+ có thêm default method, static method
- Dùng để mô tả bản hợp đồng cho nhiều class cùng tuân theo
3. Khác biệt
- Abstract != Interface
- Abstract class -> dùng khi các class có liên hệ chặt chẽ.
- Interface -> dùng để buộc nhiều class khác nhau phải tuân theo một hành vi chung
- Khi nào nên chọn Abstract thay vì Inteface ?
    - khi các subclass cần chia sẻ nhiều thuộc tính chung
    - hành vi chung
    - cần một phần code chung (non-abstract method)
    - nhưng mỗi subclass cũng có hành vi riêng cần override
- Khi nào nên chọn Interface thay vì Astract class
    - Chỉ muốn mô tả hành vi
    - các class không liên quan vẫn có thể implement được
    - không có thuộc tính chung
    - không cần chia sẻ code
- Abstract class mô tả bản chất (what it is), interface mô tả khả năng (what it can do)

