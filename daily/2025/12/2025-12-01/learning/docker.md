# Docker

## Chương 1: Container & Setting
### 1. Sự khác biệt cốt lõi: VM vs Container
- Khi dùng Ubuntu Server trên máy ảo - virual machine (VM), sẽ thấy nó t ốn RAM và hởi động lâu, đó là vì mỗi VM phải gánh nguyên một cái hệ điều hành (Guest OS) riêng.
- Docker Container thì khác. Nó không cài lại hệ điều hành, mà nó dùng chung nhân (Kernel) của máy chủ. Nó chỉ đóng gói những gì cần thiết nhất cho nên két quả: Docker nhẹ hơn, khởi động cũng nhanh hơn.
### 2. Khái niệm Image và Container
- Dockerfile: Giống như file .java (Source code). Đây là tờ giấy hướng dẫn cách tạo ra môi trường.
- Image: Giống như .class (Bytecode) hoặc khuôn bánh. Nó là thứ đã được build ra, bất biến (read-only).
- Container: Giống như Object (instance) được new ra từ Class. Đây là lúc ứng dụng chạy thực tế (Runtime)
- Từ 1 Image, có thể tạo ra hàng trăm Container chạy song song

### 3. Thực hành: Cài dặt Docker

## Chương 2: Đóng gói Spring Boot (Dockerfile)
- Trong chương này, mục tiêu là biến file .jar thành một docker image.
- Chuản bị thực hiện theo 3 bước sau:
### Bước 1: build ra file jar
### Bước 2: Tạo Dockerfile
### Bước 3: Build Image: docker build -t demo-app .
### Bước 4: Run Container: docker run -p 8080:8080 demo-app

## Chương 3: Quản lý dữ liệu & Cấu hình động
- Khi chạy Docker, cần nhớ nguyên tắc sau: Container là thứ "vô thường" (Ephemeral). Tức là khi bạn tắt hoặc xoá container đi, mọi dữ liệu bên trong nó sẽ biến mất.
- Để giải quyết, chúng ta dùng biến môi trường (Environment Variables) và Volumes.
### 1. Biến môi trường (Environment Variables) - -e
- Giả sử mình muốn đổi cổng của ứng dụng từ 8080 sang 9090 mà không muốn sửa code, hay build lại image. Spring Boot cho phép nhận cấu hình từ biến môi trường.
- Hãy thử lệnh sau (Thêm -e): docker run -e SERVER_PORT=9090 -p 8080:9090 demo-app
    - Giải thích: -e SERVER_PORT=9090: Docker truyền biến này vào trong container. Spring Boot tự hiểu SERVER_PORT tương đương với server.port trong application.properties.
    - p 8080:9090: Vì bên trong app đã đổi sang chạy port 9090, nên ta phải map port 9090 của container ra port 8080 của mấy thật.

### 2. Volumes (Lưu trữ dữ liệu) - -v
- Đây là cách chúng ta móc một thư mục trên máy thật vào bên trong container.
- Giả sử bạn muốn xem log hoặc lưu file upload. Ta sẽ tạo một thư mục trên máy thật để chứa dữ liệu àny
- Cách thực hiện:
    1. Tạo một thư mục tên docker-data ở ổ D
    2. Chạy lệnh sau (lưu ý đường dẫn Windows GitBash có thể hơi khá xíu, mình dùng format chuẩn): -v "đường-dẫn-máy-thật":"đường-dẫn-trong-container" tên image
        - docker run -v //d/docker-data:/app/data demo-app

## Chương 4: DOCKER COMPOSE (Dàn nhạc giao hưởng)
- Quay lại vấn đề lỗi kết nối database. Thay vì cố gắng đục tường để container kết nối ra máy thật, tại sao không đóng gói cả db vào Docker luôn?
- Khi đó App và Databse sẽ chạy trong cùng một mạn Docker, nhìn thấy nhau dễ dàng.
- Và để chạy 2 container cùng lúc (App + Databas), chúng ta không gõ lệnh docker lẻ tẻ nữa, chúng ta dùng Docker Compose
### Bước 1: Tạo file docker-compose.yml
### Bước 2: Chạy dàn nhạc docker-compose up

## Chương 5: Tối ưu hoá Image (MULTI_STAGE BUILD)
### Vấn đề:
1. Nặng: Image chứa cả bọ JDK đầy đủ, trong khi để chạy app chỉ cần bộ JRE (nhẹ hơn)
2. Phụ thuộc: hiện tại phải chạy mvn clean package ở ngoài máy thật rồi mới build docker. Nếu máy server không cài Maven thì làm sao ?
### Giải pháp: Multi-stage Build (Build đa giai đoạn): Chúng ta sẽ chia Dockerfile làm 2 gian đoạn:
- Giai đoạn 1 (Builder): Dùng Image có Maven đẻ build code ra file .jar (Dùng xong vứt đi cho nhẹ)
- Giai đoạn 2 (Runner): Dùng Image JRE siêu nhẹ, chỉ copy file .jar từ giai đoạn 1 sang để chạy

### 1. Viết lại Dockerfile
- Xoá nội dung cũ của Dockerfile và thay:
```ini
# Builder
FROM maven:3.9-eclipse-temurin-21-alpine AS build
# Tạo thư mục làm việc
WORKDIR /app
# Copy file pom.xml và source code vào
COPY pom.xml
COPY src./src

# Build ra file jar (bỏ qua test cho nhanh)
RUN mvn clean package -DskipTests

# Runner
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

```

### 2. Cập nhật docker-compose.yml 
- Vì bây giờ Docker sẽ tự build Maven bên trong nó, nên quá trình build sẽ lâu hơn một cút (Nó phải tải thư viện Maven về bên trong Container)
- Để tránh viẹc mỗi làn build nó tải lại toàn bộ thư viện Maven, chúng ta cần tạo them 1 cái Volume để lưu cache Maven

```ini
volumes:
    - maven_data:/root/.m2
volumes:
    maven_data:
```
