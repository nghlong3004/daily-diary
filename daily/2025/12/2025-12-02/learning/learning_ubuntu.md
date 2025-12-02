# Learning Ubuntu 

## ps
Xem process nào đang chạy

1. Liệt kê toàn bộ process đang chạy
- ps aux
2. Tìm process theo tên
- ps aux | prep java
- ps aux | prep nginx
3. Hiển thị process dạng cây
- ps axjf
---

## top
Xem tài nguyên realtime (CPU, RAM)

1. Mở giao diện realtime
- top
- Nó hiển thị:
    - CPU% từng process
    - RAM sử dụng
    - Load average
---

## htop
Bản đẹp hơn của top
- Nếu chưa có phải cài: sudo apt install htop
1. Mở giao diện
- htop
---

## kill
Kết thúc tiến trình thoe PID

1. Xem PID
- ps aux | grep java
2. Kill bình tường
- kill 1234
3. Kill mạnh (bắt buộc dừng)
- kill -9 1234
---

## pkill
kill theo tên

1. Kill tất cả process tên java
- pkill java
2. Kill 1 process chứa tên
- pkill -f java
3. Kill theo user
- pkill -u ubuntu

## df
Xem dung lượng ở đĩa
1. Xem tất cả ổ đãi theo dạng dễ học
- df -h
2. Xem riêng ổ gốc
- df -h /
3. Ý nghĩa cột:
- Filesystem: ổ
- Size: tổng
- Used: đã dùng
- Avail: còn lại
- Mounted on: đường mount

## du
Xem dung lượng thư mục
1. Xem dung lượng folder hiện tại
- du -sh
2. Xem dung lượng từng folder trong thư mục hiện tại
- du -sh *
3. Xem một folder bất kì
- du -sh /<name_folder>

## free
Xem RAM
1. XEM RAM VÀ swap
- free -h
2. Ý nghĩa
- total: tổng RAM
- used: đã dùng
- free: trống hoàn toàn
- available: RAM thực sự còn để dùng

