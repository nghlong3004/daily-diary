# DevSecOps
## DevSecOps Overview
DevSecOps là viết tắt của Development, Security và Operations là một framework tích hợp bảo mật vào tất cả các giao đoạn phát triển phần mềm. Các tổ chức áp dụng phương pháp này vào để giảm rủi ro phát hành mã có chứa lỗ hổng bảo mật. Thông qua cộng tác, tự động hoá và quy trình các rõ ràng, các nhóm có chung trách nhiệm về bảo mật, thay vì để đến cuối cùng khi mà các vấn đề có thể khó giải quyết và tốn kém hơn nhiều. DevSecOps là một thành phần quan trọng của **multiclound security strategy**
 
Nói cách ngắn gọn: DevSecOps là mt framework mở rộng DevOps bằng cách tích hợp security vào giai đoạn software development lifecycle (SDLC), thúc đẩy sự hợp tác của các bên development, security and operations để cung cấp phần mềm an toàn 1 cách hiệu quả.
### Traditional Approach
#### Security as a Bottleneck (An ninh như 1 nút thắt cổ chai)
- An ninh như 1 cánh cổng cuối cùng, làm chậm quá trình phát triển.
- Đánh giá thủ công dẫn đến việc phát hiện lỗ hổng bị trì hoãn
- Chi phí cao cho việc sửa lỗi sau khi triển khai mối quan hệ đối đầu giữa nhóm triển khai và nhóm bảo mật
### DevSecOps Approach
#### DevSecOps Approach: Security as an Enabler (Bảo mật như một công cụ hỗ trợ)
- Bảo mật được tích hợp toàn bộ trong SDLC
- Kiểm tra tự động để phát triển sớm.
- shift-left security để chủ động bảo vệ
- Cải thiện an ninh liên tục

### Software Development Life Cycle (SDLC)
- Requirements &rarr; Design &rarr; Development &rarr; Testing &rarr; Deployment
### Secure Software Development Life Cycle (SSDLC)
- Requirements, risk analysis (phân tích rủi ro) &rarr; Threat modeling (mô hình hoá mối đe doạ), architecture review (đánh giá kiến trúc) &rarr; Static analysis (SCA (Software Composition Analysis - Phân tích Thành phần Phần mềm) và SAST (Static Application Security Testing - Kiểm thử Bảo mật Ứng dụng Tĩnh) (Phân tích tĩnh) &rarr; Dynamic testing (DAST) &rarr; Pentest, Workload protection
## Value Proposition
- DevSecOps không chỉ đơn thuần là cải thiện bảo mật, mà còn là thúc đẩy kết quả kinh doanh. Bằng cách tích hợp bảo mật từ sớm và thường xuyên, các tổ chức có thể đạt được những lợi ích đáng kể về tốc độ, tối ưu chi phí và quản lý rủi ro.
### Product Team
- Tăng tốc độ đưa sản phẩm ra thị trường
  - Tốc độ triển khai nhanh hơn 2,5 lần
  - Giảm 50% sự chậm trễ liên quan đến các vấn đề bảo mật
  - Thực hiện song song quy trình phát triển và kiểm định bảo mật
### Leader
- Tối ưu hoá chi phí
  - Sửa lỗi sớm trong chu trình rẻ hơn gấp 10 lần
  - Giảm 60-80% mức độ thiệt hại từ các vụ vi phạm bảo mật
  - Tự động hóa việc báo cáo tuân thủ
### Security Team
- Tăng cường khả năng giảm thiểu rủi ro
  - Giảm 70% các lỗ hổng bảo mật nghiêm trọng
  - Thời gian trung bình để khôi phục (MTTR) nhanh hơn 96%
## DevSecOps Maturity Model
### Ad-hoc Security (Bảo mật tự phát)
- Đánh giá bảo mật thủ công
- Đội ngũ bảo mật bị cô lập (Hoạt động tách biệt)
- Cách tiếp cận thụ động (reactive)
### Reactive Security (bảo mật thụ động)
- Các công cụ bảo mật cơ bản
- Có một phaafn tự động hoá
- tích hợp bảo mật sau giai đoạn phát triển
### Proactive Security (Bảo mật chủ động)
- Các thực hành shift-left
- Kiểm thử tự động
- Chương trình security champions
### Predictive Security (bảo mật dự báo)
- Mô hình hoá mối đe do
- Kiểm thử dựa trên rủi do
- Giám sát liên tục
### Autonomous Security (Bảo mật tự hành)
- Bảo mật vận hành bằng AI
- Hệ thng tự phục hồi
- Bảo mật không chạm (Zero touch)
## Infrastructure as Code
- GitLab &rarr; TFSec (Terraform) &rarr; aws (DevOps Engineer)
### Triển khai hạ tầng đám mây an toàn với GitLab CI/CD, Terraform & Tfsec - Quản lý hạ tầng đa đám mây:
- kiểm soát bảo mật chủ đông: Tích hợp Tfsec vào quy trình (pipeline) để quét và phát hiện các cấu hình Terraform thiếu an toàn trước khi triển khai
- Quản lý trạng thái (state) tập trung: Sử dụng S3/DynamoDB (hoặc các dịch vụ tương đương) để đảm bảo tính nhất quán và ngăn ngừa xung đột.
- Kiểm soát truy cập nghiêm ngặt: Áp dụng IAM/OIDC với cơ chế đặc quyền tối thiểu (lest privilege) cho các pipeline.

## VinSOC DevSecOps Model
### Advantages
**1. Strengthening security from the start:**
   
Bảo mật được tích hợp xuyên suốt Chu trình Phát triển Phần mềm (SDLC), cho phép phát hiện và khắc phục các lỗ hổng sớm hơn, từ đó giúp giảm thiểu chi phí khắc phục.

**2. Automating security testing:**

Tích hợp các công cụ như SAST, DAST, SCA và quét IaC vào quy trình CI/CD giúp thực hiện kiểm tra bảo mật liên tục và giảm thiểu các sai sót do con người.

**3. Shortening release time:**

Nhờ vào quy trình CI/CD được tự động hóa và các kiểm soát bảo mật liên tục, thời gian đưa sản phẩm ra thị trường được giảm thiểu đáng kể.

**4. High scalability and adaptability:**

Mô hình này có khả năng mở rộng linh hoạt theo nhu cầu của doanh nghiệp và tích hợp với các công nghệ hiện đại như Container, Serverless và các môi trường Cloud-native (thuần đám mây).

### Disadvantages
**1. High initial investment cost:**

Đòi hỏi sự đầu tư vào các công cụ bảo mật, hạ tầng CI/CD, đào tạo nhân sự và thay đổi các quy trình hiện tại.

**2. Demands changes in the enterprise's software development process:**

Việc chuyển đổi từ mô hình truyền thống sang DevSecOps đòi hỏi sự đồng thuận và thay đổi tư duy toàn diện giữa các phòng ban.

**3.Complexity in tool integration:**

Việc tích hợp nhiều công cụ bảo mật vào quy trình (pipeline) có thể gây ra xung đột và ảnh hưởng đến hiệu năng nếu không được tối ưu hóa đúng cách.

## Mistakes in Implementing DevSecOps That Lead to Failure

**1. Treating DevSecOps as a tool-only solution**

Many organizations believe that simple integrating security tools into the CI/CD pipeline is sufficient, neglecting the importance of processes, people, and a security-first culture

**2. Lack of collaboration between development, operations, and security team*

**3. No training or security awareness for development teams**

**4. Poorly integrated security tools disrupting the pipeline**

**5. No feedback or cuntinuous improvement mechanisms**

**6. Not measuring the effectiveness of DevSecOps implementation**
**7. Rigid application of DevSecOps without adapting to organizational scale** 