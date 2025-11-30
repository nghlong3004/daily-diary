# Nginx 
## Install Nginx
- trước khi install 1 cái gì trên server thì nên update trước
- type: 
    - 1. `sudo apt update`
    - 2. `sudo apt install nginx -y`

## Cấu hình Reverse Proxy
- Bây giờ, chúng ta sẽ dạy cho Nginx cách chuyển tiếp yêu cầu cho Tomcat.
- Tạo 1 file cấu hình mới
- sudo vi /etc/nginx/sites-available/<name_file>
- listen 80: Nginx sẽ đón khách ở cổng 80
- proxy_pass http://localhost:8080: Đây là dòng quan trọng nhất! nó bảo Nginx: Mọi yêu cầu vào đay, hãy chuyể tiếp sang cho ông Tomcat đang ngồi ở localhost:8080
- Tại sao lại không có đuôi file, khác với Window (dựa vào đuoi .exe, .txt để biết file là gì), Linuxx không quan tâm đến đuôi file. Nó chỉ quan tâm đến nội dung bên trong và quyền hạn cùa file đó. thường người ta hay đặt là <name_file>.conf để con người dẽ nhìn và quản lý.
- Tại sao systemd lại phải có .service ? vì systemd quản lý rát nhiều loại đơn vị(unit) khác nhau: .service, .timer, .socket, ...
- để kiểm tra xem không gõ sai gì trong file, chạy kiểm tra theo cú pháp:
- `sudo nginx -t`
- nếu test thì ok chuẩn, nhưn có một cú lừa ở đây, giờ nó chỉ đang lưu trữ ở trong sites-available chứ chưa đưa vào danh sách sử dụng sites-enabled
- chúng ta cần 2 bước để dán thông báo này lên:
    1. Gỡ bỏ trang mặc định, Nginx thường có sẵn trang Welcome to Nginx chiếm cổng 80. Chúng ta cần gỡ nó xuống
    2. Kích hoạt app: tạo một đường dẫn từ thư mục lưu trữ sang thư mục kích hoạt
- chạy lần lượt 3 lệnh:
    1. xoá cấu hình mặc định: `sudo rm /etc/nginx/sites-enabled/default
    2. Tạo liên kết kích hoạt cấu hình: `sudo ln -s /etc/nginx/sites-available/<name_file>.conf /etc/nginx/sites-enabled/`
    3. Yêu cầu Nginx nạp lại cấu hình ngay lập tức: `sudo systemctl reload nginx`

