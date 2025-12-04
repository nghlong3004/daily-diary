# Learning Ubuntu

## ping
- Kiểm tra xem một host (server/địa chỉ IP/ domain) có hoạt động không
- Kiểm tra độ trễ mạng (latency)
- kiểm tra DNS có hoạt động hay không
### syntax
- ping <address>
- ping -c <number> <address>

### ICMP
- Mỗi lần ping nó sẽ gửi 1 gói tin ICMP
#### ICMP là gì ?
- Internet Control Message Protocol: là giao thức báo lỗi và kiểm soát mạng trong tầng Network
- Nó không dùng truyền dữ liệu như TCP hay UDP
- Nhiệm vụ của ICMP là:
    + Báo lỗi mạng
    + Kiểm tra đương đi của gói
    + Xác định host có reachable hay không
    + Đo thời gian phản hồi (round-trip time)
#### ICMP Hoạt đọng ra sao ?
- máy mình sẽ gửi ICMP Echo Request tới host
- Host nhận được và sẽ rep lại ICMP Echo Reply
- máy mình sẽ đo thời gian đi - về (latency)
---

## curl & wget
- Lấy dữ liệu từ internet
### curl
- Gửi request HTTP, test API
#### syntax
- curl <URL>
- curl -X <METHOD> <URL>
- curl -o <name_file> <URL>

### wget
- Tải file về máy
#### syntax
- wget <URL>
- wget -0 <new_name_file> <URL>

## ip a, ifconfig
- Xem cấu hình mạng

### ip a
- Xem tất cả network interface:
- ip a
+ IP máy
+ MAC address
+ trạng thái: UP, DOWN
+ interface: li, eth0 wlan0
#### syntax
- ip a: xem tất cả net work interface
- ip -<version> a: xem IP v<version>

### ifconfig
- Lệnh cũ

## ss và netstat
- Kiểm tra kết nối mạng, port đang mở
### ss
- Lệnh mới, nhanh hơn
#### syntax
- ss -tulnp: Xem tất cả các port đang nghe
+ t = TCP
+ u = UDP
+ l = listening
+ n = không resolve domain
+ p = process (PID)
- ss -tulnp | grep 8080: xem port 8080 có ai dùng không
- ss -s: xem connection đang mở
### netstat
- lệnh cũ, phải tải về: sudo apt install net-tools


