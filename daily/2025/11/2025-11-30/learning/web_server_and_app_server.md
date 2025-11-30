# Web Server and App Server

## Web Server và App Server khác nhau như thế nào ?
- Tuy ranh giới giữa hai khái niệm này ngày nay đôi khi bị xoá nhoà (do các phần mềm ngày càng đa năng), nhưng về mặt bản chất kiến trúc, chúng có nhiệm vụ rất khác nhau.
### Web Server (Máy chủ Web):
- Nhiệm vụ chính: Chuyên phục vụ các nội dung tĩnh (static content) như file HTML, CSS, JavaScript, hình ảnh, video
- Giao thứ: chủ yếu xử lý HTTP/HTTPS
- ví dụ: Nghinx, Apache HTTP Server.
- Đặc điểm: Tốc độ phản hòi cực nhanh, chịu tải cao cho các kết nối đồng thời.

### App Server (Máy chủ ứng dụng):
- Nhiệm vụ chính: Chuyên xử lý logic nghiệp vụ (dynamic content). Nó thực hiện cá tính toán, logic code (Java, Python, .NET, ...), và các kết nối với cơ sở dữ liệu
- Giao thứ: Ngoài HTTP, nó có thể hỗ trợ các giao thức khác phục vụ cho ứng dụngnhw RMI, RPC, ...
- Ví dụ: Apache Tomcat (cho Java, ...), JBoss, WebLogic, ...
- Đặc điểm: Nặng hơn WebServer vì phải chạy code và xử lý dữ liệu phức tạp

## Mô hình Reverse Proxy
- Nginx không chỉ là Web Server mà còn đóng vái trò Reverse Proxy (Proxy ngược)
- Không có reverse proxy: luồng sẽ là client gọi thẳng tởi App Server
- Có Reverse Proxy: Luồng sẽ là client gọi Nghinx, Nghinx gọi App Server như Tomcat.
- Lợi ích: 
    - Tối ưu hiệu suất: Nginx sẽ phân phối các yêu cầu này đến csac máy chủ Tomcat phía sau. Nó có thể dugnf thuật toán đề biết server nào đang ít kết nối nhất (rảnh nhất) để giao việc, hoặc chia đều lần lượt (Round Robin)
    - Dự phòng (High Availability): nếu một tomcat bị sập, Nginx sẽ biết và tự động chuyển hướng sang Tomcat khác
## Một vài thắc mác nhỏ
### Tại sao có nhiêu công cụ như Kafka, RabbitMQ, Redis, API Gateway
- Ví dụ về 1 cái nhà hàng:
    - Load Balancer (Nginx): là Lễ tân. Thấy 3 cừa vào bếp, lễ tân chia khach đều ra 3 cửa để không bị kẹt. 
    - API Gateway: Là Trưởng bộ phận lễ tân. Ngoài việc chia khách, người này còn kiẻm tra vé (Authentication), chặn khách quậy phá (Rate Limiting), và chỉ đường cho khách đi vào đúng khi vực (Routing). Mục đích: Quảy lý cửa ngõ tập trung
    - Redis: Là Tờ giấy nhớ (Cache). Khách hay hỏi Mật khẩu wifi là gì?. Thay vì chạy đi hỏi, lễ tân chỉ cần ghi câu trả lời lên tờ giấy gián ngay trên bàn. Khách hỏi nhìn vào đọ luôn. Mục đích: tăng tốc độ đọc dữ liệu hay dùng.
    - Kafka/RabbitMQ: Là hàng dợi/ máy in vé oder. Khi quán quán quá đông, đầu bếp không làm kịp. Thay vì từ chối khách, lễ tân in oder ra giấy và xếp thành chồng. Đầu bếp làm xong món này sẽ tự láy oder tiếp theo để làm. Mục đích: Xử lý bất đồng bộ để hệ thống không bị sập khi có quá nhiều yêu cầu cùng lúc.
### Frontend và backend nằm ở đâu
- Nginx có chứa Frontend không ? CÓ. như chúng ta đã thảo luận, Frontend (react, vue, angular sau khi build) thực chất chỉ là các file tĩnh (HTML, CSS, JS). Nginx là vua trong việc phụ vụ file tĩnh này.
    - khách truy cập vào domain thì nginx trả về file index.html (Frontend)
- Chúng nằm chung hay riêng server ? Cả hai đều được, tuỳ vào quy mô.
- Mô hình 1: All - in - one
- Thuê 1 server Ubuntu
- cài cả Nginx và tomcat lên
- Nginx lăng nghe port 80
    - Nếu client xem giao diện -> nginx lấy file ở thư mục Frontend trả vê
    - Nếu client đòi login (API) -> Nginx chuyển tiếp (Proxy) sang Tomcat đang chạy âm thầm ở Port 8080
- Mô hình 2: Decoupled
- Server A chỉ cài Nginx + Frontend 
- Server B chỉ cài Tomcat + Backend
## Làm thế nào để Nginx biết đường dẫn lối?
- Quay lại ví dụ lễ tân. Để lễ tan biét đưa khách lên tầng nào, họ cần một cuốn sổ tay hướng dẫn (đây chính là file cấu hình nginx.conf)
- Nginx sẽ soi yêu cầu của khách hàng dựa trên 2 yếu tố chính để quyét dịnh:
1. Tên miền (Server Name): Giống như hỏi khách bạn muốn thăm công ty nào
2. Đường dãn (Location Path): Giống như hỏi khách "Bạn muốn gặp phòng ban nào?"

