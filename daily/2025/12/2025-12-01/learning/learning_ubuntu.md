# Learning Ubuntu day 4

## 1. Find
- Cú pháp cơ bản: find <path> -name "<name>"
- Tìm file theo tên: find . -name "<name>"
- Tìm thư mục: find <path> -type d -name "<name>"
- Tìm file  theo phần mở rộng: find . -type f -name " *.java "
- Tìm file theo kích thước : find . -size +10M
- Tìm file rồi xoá: find . -name "*.log" -type f -delete
- Tìm file rồi thực thi: find . -name "*.sh" -exec chmod +x {} \;
## 2. grep
- Tìm nội dung bên trong file
- Cú pháp: grep "chuỗi cần tìm" <file>
- Tìm chuỗi "TODO" trong tất cả file trong thư mục: grep -r "TODO" .
- Hiển thị số dòng: grep -n "main" *.java
- Tìm chính xác 1 từ : grep -w "Log" data.txt

## 3. Locate 
- Tìm theo database
- Cài đặt: sudo apt install mlocate
- sudo updatedb
- Tìm file: locate abc.txt
- Tìm file theo folder: locate /home/log | grep abc
## 4. tar
- nén file & giải nén file .tar, .tar.gz
- nén thư mục thành file .tar: 
    - tar -cvf archive.tar folder/
    - c = create
    - v = verbose (hiện file)
    - f = specify file
- nén thành .taz.gz
- tar -czvf archive.tar.gz folder/
- giải nén .tar
    - tar -xvf archive.tar
 - giải nén .tar.gz
    - tar -xzvf archive.tar.gz
- Chỉ xem nội dung trong file tar:
    - tar -tf archive.tar.gz

## 5. zip & unzip
- Nén file: zip file.zip file1 file 2 file3
- nén cả thư mục: zip -r project.zip project/
- Giải nén: unzip file.zip
- giải nén vào thư mục chỉ định: unzip file.zip -d new_folder/

## 6. gzip 
- Nén file .gz
- Nén: gzip file.txt
- Giữ lại file gốc: gzip -k file.txt
- Giải nén: gunzip file.txt.gz
