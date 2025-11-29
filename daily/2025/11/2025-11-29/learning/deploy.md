# Deploy Spring Boot App

## 1. Đóng gói (Maven & JAR)
- Trong Java Spring Boot, quy trình này thường đi qua các bước được gọi là "Lifecycle" (vòng đời).
- Với Maven, mình cần đóng gói code thành 1 package.
- Câu lệnh: `mvn clean package`
  - **Ý nghĩa:** Dọn dẹp file rác ở lần build trước (`clean`) và đóng gói code thành 1 file .jar (`package`).

## 2. Server
- Server thực chất là một máy tính được kết nối mạng 24/7, nhưng khác máy tính cá nhân ở chỗ:
  - **Không màn hình, không chuột:** Điều khiển từ xa hoàn toàn bằng dòng lệnh (Command Line Interface).
  - **Hệ điều hành:** Đa số chạy Linux (ví dụ như Ubuntu) vì nhẹ, miễn phí và ổn định.
  - **Giao thức:** Dùng SSH (Secure Shell) để giao tiếp.
  - **Syntax:** `ssh -p <port> <username>@<ip_address>`
- **Lưu ý:** Khi config trên VirtualBox, cần thiết lập **Port Forwarding** (chuyển tiếp cổng máy thật -> cổng máy ảo).

## 3. Runtime (Môi trường chạy)
- Vì dùng Spring Boot nên server bắt buộc phải có JDK để chạy file `.jar`.
- Trong Ubuntu, công cụ quản lý cài đặt phần mềm gọi là `apt`.

### Step 1: Update
- Lệnh: `sudo apt update`
- **Giải thích:** `sudo` (SuperUser DO) nghĩa là "chạy với quyền Admin". Hệ thống sẽ yêu cầu nhập password.

### Step 2: Install
- Lệnh: `sudo apt install openjdk-21-jdk`
- Máy sẽ chạy một lúc rồi hỏi xác nhận: "Do you want to continue? [Y/n]" -> Chọn Y.

## 4. Upload file (SCP)
- Chúng ta có 2 môi trường:
  1. Máy Windows (Local)
  2. Server (Remote)
- Để upload file lên server, dùng công cụ **SCP** (Secure Copy).

### Các bước thực hiện:
1. Mở 1 cửa sổ CMD/Terminal mới trên Windows.
2. `cd` vào folder chứa file cần chuyển.
3. Gõ lệnh: `scp -P <port> <filename> <username>@<ip_address>:~`

- **Giải thích:**
  - `scp`: Secure Copy.
  - `-P`: Chỉ định Port (Lưu ý P viết hoa).
  - `:`: Dấu hai chấm ngăn cách địa chỉ server và đường dẫn đích.
  - `~`: Dấu ngã biểu thị thư mục Home của user trên Linux.

- **Câu hỏi:** Tại sao `scp` dùng `-P` còn `ssh` dùng `-p`?
  - `ssh`: dùng `-p` (thường) cho Port.
  - `scp`: dùng `-P` (hoa) cho Port.
  - **Lý do:** Trong lệnh `scp`, chữ `-p` thường đã được dùng cho **preserve** (bảo tồn ngày giờ/quyền hạn file).

- **Upload Folder:** Cần thêm cờ `-r` (recursive - đệ quy).
  - Syntax: `scp -P <port> -r <folder_name> <username>@<ip_address>:~`

## 5. Run Application (Thủ công)
- Lệnh: `java -jar <filename>.jar`

## 6. Mở đường cho ứng dụng (Port Forwarding)
- Mặc định mới chỉ mở cổng 22 (SSH). Cần mở cổng 8080 để truy cập Web.
1. Tắt server tạm thời (hoặc để chạy nền).
2. **Đục lỗ cổng 8080 trên VirtualBox:**
   - Menu **Devices** -> **Network** -> **Network Settings** -> **Port Forwarding**.
   - Bấm dấu `+`.
   - Name: `Web` (hoặc tên tùy ý).
   - Host Port: `8080` (cổng trên Windows).
   - Guest Port: `8080` (cổng của ứng dụng trong Linux).
3. Chạy lại ứng dụng.

## 7. Systemctl (Quản lý dịch vụ)
- Trong Linux có một "người quản gia" tên là **Systemd**. Ta sẽ nhờ người này trông coi ứng dụng 24/7.

### Step 1: Lấy đường dẫn tuyệt đối
- Lệnh: `readlink -f <filename>.jar` -> Copy kết quả.

### Step 2: Tạo Service file
- Mở trình soạn thảo: `sudo nano /etc/systemd/system/<service_name>.service`
- **Giải thích:**
  - `/etc/systemd/system/`: Thư mục chứa file cấu hình service do người dùng tạo.
  - `.service`: Đuôi file bắt buộc.

**Nội dung file cấu hình:**

```ini
[Unit]
Description=My Spring Boot App
# Chỉ chạy sau khi mạng đã sẵn sàng
After=network.target

[Service]
# Chạy dưới quyền user (quan trọng để bảo mật, tránh dùng root)
User=<username>
# Lệnh chạy app (Bắt buộc dùng đường dẫn tuyệt đối cho java và file jar)
ExecStart=/usr/bin/java -jar /home/<username>/<filename>.jar
# Tự động khởi động lại nếu app bị crash
Restart=always
# Nghỉ 10s trước khi restart để tránh crash loop
RestartSec=10

[Install]
# Tự khởi động khi server vào chế độ đa người dùng
WantedBy=multi-user.target

### Step 3: Kích hoạt dịch vụ:
1. Nạp cấu hình mới: `sudo systemctl daemon-reload`
2. Cho phép tự khởi đông cùng OS: `sudo systemctl enable <service_name>`
3. Bắt đầu chạy ngay: `sudo systemctl start <service_name>` (nó sẽ không hiện nếu thành công gì vì "No news is good news")

## 8 Cách lệnh Systemctl cơ bản
1. Stop (Tăt tạm thời): `sudo systemctl stop <service_name>`
    - Ứng dụng dừng ngay.
    - Nếu khởi động lại máy chủ, ứng dụng vãn tự chạy lại (nếu đã Enable)
2. Disable: `sudo systemctl disable <service_name>`
    - Không dừng ứng dụng đang chạy
    - Chỉ có tác dụng cho lần khởi động tiếp theo
3. Restart: `sudo systemctl restart <service_name>`
    -Dùng khi cập nhật code mới (ghi đè file .jar) hoặc sửa file config.
4. Status: `sudo systemctl status <service_name>`

## 9. Follow Log
- Để xem log real-time
- Syntax: `sudo journalctl -u <service_name> -f
    - `journalctl`: công cụ đọc nhật ký hệ thống
    - `-u`: Unit (tên dịch vụ)
    - `-f`: Follow
