# Learning Ubuntu Day 2

## cp 
- coppy file / folder 

- Syntax: cp [option] source

- Option: 
    - empty khi coppy file -> file or file -> folder
    - -r khi coppy folder -> folder

- Example: 
    - cp file1.txt file2.txt
    - cp file.txt /d/long/document
    - cp -r folder1 folder2

## mv
- Move file, rename
- Syntax: mv source

- Example: 
    - mv old.txt new.txt
    - mv file.txt /d/long/document
    - mv file.txt /d/long/document/newFile.txt (di chuyển và rename)
## cat
- view file 
- Syntax: cat nameFile.txt
## less
- view file and scroll file được
- Syntax: less nameFile.txt
- Phím điều khiển:
    - lên, xuống: cuộn từng dòng (giống trong vi)
    - PageUp, PageDown: Cuộn nhanh
    - g: Về đầu file
    - G: xuống cuối file
    - /text: Tìm kiếm
    - q: Thoát
## head
- view x head line for file
- Syntax: head [option] nameFile.txt
- Example: head -n 20 nameFile.txt | head nameFile.txt (default 10 line)

## tail
- view x tail line for file
- Syntax: tail nameFile.log
- Example:
    - tail -f nameFile.log (follow filea realtime -> use debug backend)
    - tail -n 50 nameFile.log 
    - tail nameFile.log (default 10 line) 
- tail -f <name_file>: nó follow cái gì?
    - tra cứu name_file thành inode (number)
    - tail mở inode đó
    - tail ghi nhớ đang ơ byte cuối cùng
    - mối khi có dữ liệu mới ghi vào inode -> tail phát hiện ra log ra cmd
- tail -F <name_file>: -F (capital F) = follow name, reopen when replaced
    - -f follow by inode nên fail nếu file bị recreate
    - -F follow by name nên tự mở lại inode mới nếu bị thay thế
## inode
- inode = metedata của 1 file, chứa thông tin như:
    - kích thước file
    - quyền truy cập (chomod)
    - chủ sở hữu
    - thời gian tạo/ sửa
    - vị trí các block dữ liệu trên đĩa
    - số link tới file
    - ...
- inode không chứa tên file
- tên file nằm trong thư mục. Thư mục chỉ là map dạng
    - name_file -> inode_number
    - Example: mylog.txt -> inode 12345
- name file có thể đổi nhưng inode không đổi -> file vẫn là file đó
- Khi mở hoặc follow 1 file, system:
    - lấy tên file -> tìm inode của nó
    - Tail mở file dựa trên inode number
    - Rồi đọc dữ liệu thực tế từ các block trên ổ cứng
-> vì vậy tail follow inode, không phải theo dõi name file

## vi
- vim làm thay đổi inode nên -> tail -f nothing
- vi name_file rồi :wq -> step by step:
    - tạo file temp (inode mới)
    - Ghi nội dung mới vào temp
    - xoá file cũ (inode cũ)
    - đổi tên temp thành file cũ (nhưng inode là inode của temp
- làm sao để tail theo dỗi được ngay cả khi vim thay đổi inode ?
- dùng :w! để vim nó lưu luôn vào inode cũ chứ không tạo ra inode mới
