# What is Ubuntu?

Ubuntu là một hệ điều hành dựa trên Linux

## Câu lệnh:
1. pwd
Viết tắt của print working dicrectory
Dùng để xem đang đứng ở thư mục nào
Example : pwd
2. ls -la
Viết tắt của list, l = long format, a = all hiển thị tất cả các file gồm file ẩn (băt đầu bằng .)
ls dùng để xem tất cả các file, thư mục trong thư mục hiện tại
ls - la, tương tự như ls nhưng chi tiết hơn gồm những file ẩn như .git
nó sẽ hiển thị :
- quyền truy cập (permissions)
- số link
- owner
- group
- kích thước
- ngày sửa đổi
- tên file
3. cd
viết tắt của change directory
dùng để nhảy sang thư mục khác
cd .. (lùi một thư mục)
cd ~ (quay ra home)
[^1] Trong Ubuntu không phân biệt ổ C, D... để di chuyển từ ổ này sang ổ khác gõ câu lệnh
df -h nó sẽ hiển thị ra Filesystem và để ý tới cột on khi đó chỉ cần gõ cd (câu lệnh trong
cột on) là di chuyển ra ổ đó
4. mkdir
make directory = tạo thư mục mới
example: mkdir name_folder
5. touch
touch = tạo file rỗng mới
example: touch name_file
6. rm
rm = remove = xoá
example : rm name_file
rm -r <name_folder> = xoá folder có file bên trong có hỏi lại (dùng y: yes, n: no)
rm -rf <name_folder> = xoá folder có file bên trong không hỏi lại
7. rmdir
rmdir = remove directory = xoá folder rỗng
