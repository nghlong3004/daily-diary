# Learn Ubuntu

- Ubuntu (và tất cả hệ điều hành Unix) chia quyền theo 3 nhóm người dùng:
- OWNER(user) | GROUP | OTHERS
1. OWNER (User - hay admin file)
Đây là người tạo ra file hoặc là người được chỉ định làm chủ.
Ví dụ máy có user nghlong3004, tạo file a.txt thì OWNER = nghlong3004
OWNER có nhiều quyền nhất trên file đó.
2. GROUP (nhóm người dùng)
Ngoài OWNER, Ubuntu có khái niệm group
Một group gồm nhiều user

- Ví dụ:
- group `staff`: có thẻ gồm: nghlong3004, a1, a2
- group `developers`: gồm nghlong3004, a4, a5
- nếu file thuộc group staff thì mọi người trong group staff có quyền dã design

3. OTHERS (người ngoài)
- tất cả những ai không phải owner, cũng không nằm trong group của file.
- thường bị hạn chế quyền nhất (chỉ được phép read)


## 1. ls - l
- Xem quyền file
- Syntax: ls -l
- Format: [Loại file][owner][group][others] user group size time name
1. Kiểu file:
    - - : file thường
    - d : fiolder (directory)
    - l : symlink
2. Quyền truy cập
Example: -rw-r--r-- 1 admin 197609 258 Nov 30 21:01 learning_ubuntu.md
- Mỗi thằng sẽ có tối đa 3 quyền là rwx nên map sẽ là rw-, r--, r--
- Ý nghĩa:
    - r = read
    - w = write
    - x = execute
    - - = không có quyền
## 2. chmod
- Thay đổi quyền file
- Syntax: chmod <quyền> <file>
- có 2 cách: symbolic và numeric
- cách 1: Symbolic
    - chmod u+x run.sh (thềm quyèn execute cho owner)
    - chmod g-w test.txt (xoá quyền write của group)
    - chmod o+r file.txt (thêm quyền read cho others)
    - chmod a+r file.txt (thềm quyền read cho all)
    - chmod a=rw, go=r file (all = rw, group = r, other = r)
- Ký hiệu:
    - u: user (owner)
    - g: group
    - o: others
    - a: all (u + g + o)
    - +: thêm quyền
    - -: bỏ quyền
    - =: gán quyền
- Cách 2: Numeric
    - r giá trị: 4
    - w giá trị 2
    - x giá trị 1
- ví dụ: chmod 753 scrip.sh 
- explain: 753 = 7 là owner = rwx(4 + 2 +1), 5 là group = r-x (4 + 0 + 1), 3 là others = -wx (0 + 2 + 1) 
- chmod 600 secret.txt là owner = rw-(4 + 2 + 0), group = --- (0 + 0 + 0), otherr = --- (0 + 0 + 0)

## 3. chown
- Đổi owner (chủ sở hữu)
- format: chown <owner>:<group> <file>
- Syntax: chown <user> <file>
- Example: sudo chown nghlong3004 README.md

## 4. chgrp 
- Đổi group
- Syntax: chgrp staff app.log


