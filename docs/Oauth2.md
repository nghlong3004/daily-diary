# OAUTH 2.0
## Introduction
Trong `client-server` authentication model, client request vào một resource bị hạn chế (tài nguyên được bảo vệ) trên server thông qua việc xác thực với server bằng thông tin đăng nhập của chủ sở hữu tài nguyên thông tin đăng nhập. Để cung cấp cho các ứng dụng của bên thứ 3 quyền truy cập vào các tài nguyên bị hạn chế (access-restricted) thì chủ sở hữu tài nguyên (resource owner) phải chia sẻ thông tin của mình với bên thứ 3. Điều này nó tạo ra 1 vài vấn đề và hạn chế:

- Các ứng dụng bên thứ 3 được yêu cầu lưu trữ thông tin đăng nhập của resource owner để sử dụng trong tương lai, thường là mật khẩu ở dạng văn bản thuần tuý (clear-text)
- Servers are required to support password authentication, bất chấp những điểm yếu vốn có của mật khẩu.
- Các third-party application có được quyền truy cập quá rộng rãi vào các tài nguyên được bảo vệ của chủ sở hữu tài nguyên, khiến resources owner không có bất kỳ khả năng nào để hạn chế thời gian hoặc quyền truy cập vào một tập hợp con tài nguyên.
- Resource owners không thể thu hồi (revoke) quyền truy cập của bên thứ 3 riêng lẻ mà không thu hồi quyền truy cập của tất cả các bên thứ 3. Và việc này được thực hiện bằng cách thay đổi mật khẩu của bên thứ 3.
- Việc xâm phạm bất kỳ ứng dụng bên thứ 3 nào đều dẫn đến việc xâm phạm mật khẩu của end-user và tất cả data protected by that password.

OAuth giải quyết there issues by introducing an authorization layer and separating (tách biệt) the role (vai trò) of the client from that of the resource owner. In OAuth, the client requests access to resources controlled by the resource owner and hosted by the resource server, và được cấp một bộ thông tin xác thực khác với thông tin xác thực của chủ sở hữu tài nguyên.

Thay vì (Instead of) using the resource owner's credentials to access protected resources, the client obtains (sẽ nhận) an access token &rarr; một chuỗi kí tự biểu diễn phạm vi (scope), thời hạn (lifetime) và các thuộc tính truy cập cụ thể khác (other access attribute). Access token được cấp cho các client bên thứ 3 bởi authorization server với sự chấp thuậnt (the approval) of the resource owner. The client uses the access token to access the protected resources hosted by resource server.

OAuth được thiết kế để sử dụng với HTTP (RFC2616). Việc sử dụng OAuth 

## 1.1 Roles
OAuth defines four roles:

- `resource owner`: An entity capable (Có khả năg) granting access (cấp quyền truy cập) vào một protected resource. When the resource owner is a person, người đó được gọi là end-user.
- `resource server`: The Server hosting the protected resource (Máy chủ lưu trữ các tài nguyên được bảo vệ), có khả năng (capable) chấp nhận và phản hồi các yêu cầu tài nguyên được bảo vệ bằng cách sử dụng access tokens.
- `client`: Một ứng dụng thực hiện các yêu cầu tài nguyên được bảo vệ thay mặt cho resource owner và với authorization.Thuật ngữ (term) `client` không hàm ý bất kì triển khai cụ thế nào
- authorization server: server issuing (máy chủ cung cấp) access tokens to the client after successfully authenticating the resource owner and obtaining authorization (sẽ nhận được uỷ quyền)

the interaction (sự tương tác) the between `authorization server` (máy chủ xác thực) and `resource server` (máy chủ tài nguyên) nằm ngoài phạm vi của đặc tả này. The `authorization server` maybe the same server as resource server or a separate entity (một thực thể riêng biệt). A single `authorization server` may issue tokens accepted by multiple `resource server` (một máy chủ uỷ quyền có thể cấp một access token được chấp nhận bởi nhiều máy chủ tài nguyên).

## 1.2 Protocol flow

`Abstract Protocol Flow`

1. `Client` -Authorization request&rarr; `Resource Owner`
2. `Client` &larr;Authorization Grant- `Resource Owner`
3. `Client` -Authorization Grant&rarr; `Authorization Server`
4. `Client` &larr;Access Token- `Authorization Server`
5. `Client` -Access Token&rarr; `Resource Server`
6. `Client` &larr;Protected Resource- `Resource Server`

> Phương pháp ưu tiên ở bước 1 và 2 là `client` nhận được Authorization Grant from the `Resource Owner` là sử dụng `Authorization Server` làm trung gian (intermediary) 

## 1.3 Authorization Grant
### 1.3.1 Authorization Code

The `Client` directs the `resource owner` to an `authorization server` (Thông qua user-agent) server này sau đó hướng chủ sở hữu tài nguyên trở lại máy khách với mã uỷ quyền.

## 2. Đăng ký Client và cấu trúc bảo mật (RFC 6749 Section 2)
Trước khi bất kỳ luồng OAuth nào có thể bắt đầu, Client phải được dăng ký với `Authorization Server`. Quá trnh này thiết lập mối quan hệ tin cậy ban dầđầu và định hình các tham số bảo mật cho tàon bộ vòng đời ứng dụng.

### 2.1 Client Metadata
Khi đăng ký, nhà phát triển phải cung cáp các thông tin:

- Client Identifier (Client ID): Một chuỗi ký tự duy nhất đại diện cho ứng dụng. Client ID là thông tin công khai (Public), không phải bí mật. Nó được dùng để xây dựng một URL đăng nhập.
- Client Password (Client Serect): Một chuỗ bí mt chỉ đuược cấp cho Confidential Clients. Đây là `mật khẩu` của ứng dụng để chứng minh danh tính với `Authorization Server` khi trao đổi token qua kênh back-channel. Không nên nhúng `Client Secret` vào ứng dụng mobile hoặc SPA.
- Redirect URIs (Callback URLs): Danh sánh các địa chỉ URl mà `Authorization Server` được php trả người dùng về sau khi đăng nhập thành công.
  - Best Practice: RFC 6749 cho phép đăng ký nhiều URI, nhưng các chuẩn bảo mật hiện dại (OAuth 2.1) yêu cầu so khớp chính xác tuyệt đối từng ký tự của Redirect URI trong yêu cầu với danh sách đã đăng ký. Không được sử dụng wildcards để tránh tấn công Open Redirect

### 2.2 Client Authentication
RFC 6749 quy định cách Client chứng minh danh tính của mình tạo Token Endpoint.

- HTTP Basic Authentication: Client ID và Client Secret được mã hoá Base64 và gửi trong header: `Authorization: Basic...` Đây là phương pháp phổ biến nhất
- Request Body: Client ID và Client Secret được gửi như tham số trong phần thân (body) của POST request. Tuy nhiên, phương pháp này ít được khuyến khích hơn header.

Insight: Đối với Public CLients (như Mobile App), vì không có CLient Secret, việc xác thực client theo nghĩa truyền thống là không thể. Do đó, bảo mật của Public Clients phụ thuộc hoàn toàn vào cơ chế như PKCE (Proof Key for Code Exchange) và việc quản lý chặt chẽ Redirect URI.

## 3. Protocol Endpoints
OAuth 2.0 hoạt động dựa trn định tuyết HTTP Request tới các địa chỉ cụ thể. HIểu rõ chức năng và yêu cầu bảo mật của từng endpoint là cốt lõi để gỡ lỗi và triển khai.
### 3.1 Authorization Endpoint
Đây là nơi tương tác với User-Agent/Browser.

- Chức năng: Bắt đầu luồng uỷ quyền. Client redirect browser của người dùng đến đây.
- Phương thức: Thường là GET, nhưng cũng có thể hỗ trợ POST.
- Đặc điểm: Đây là Front Channel (Kênh trước). Dữ liệu truyền qua dây (trên URL) có nguy cơ bị lộ trong lịch sử trình duyệt hoặc logs. Do đó, không bao giờ gửi Access Token hay Refresh Token qua kênh này (Đây là lys do Implicit Grant bị loại bỏ).

### 3.2 Token Endpoint
Đây là nơi trao đổi mã xác thực lấy Token.
- Chức năng: CLient gửi Authorization Code (Hoặc  Refresh TOken) để đổi lấy Access Token.
- Phương thức: Bắt buộc là POST với định dang `application/x-www-form-urlencoder`
- Bảo mật: Đây là `Back Channel` (Kênh sau), kết nối trực tiếp từ Server của Client tới `Authorization Server`. Kết nối này bắt buộc phải sử dụng TLS (HTTPS) để bảo vệ Client Secret và Token.

### 3.3 Redirection Endpoint
Đây là địa chỉ trên phía `Client `dùng để nhận phản hồi từ `Authorization Server`

## 4. Authorization Grants: Phân tích chuyên sâu
RFC 6749 định nghĩa 4 loại Grant chính. Tuy nhiên, trong bối cảnh hiện nay đã thay đổi hoàn toàn cách sử dụng chúng. Phần này sẽ phân tích chi tiết từng loại, kèm theo đánh giá bảo mật hiện đại.
### 4.1 Authorization Code Grant
Đây là flow phổ biến và bảo mật nhất được thiết kế cho Confidential Clients và hiện nay (với sự bổ sung của PKCE) là tiêu chuẩn cho cả Public Clients..
#### 4.1.11 Step-by-Step Notebook
#### Bước 1: Authorization Request (Yêu cầu uỷ quyn) Client chuyển hướng trình duyệt đến Authorization Endpoint với các tham số sau:

|    Tham số    | Bắt buộc | Mô tả & Ý nghĩa                                                                                                    |
|:-------------:|:--------:|:-------------------------------------------------------------------------------------------------------------------|
| response_type |    Có    | Giá trị phải là `code`. Điều này báo hiệu cho server biết Client muốn nhận Authorization Code chứ không phải Token |
| client_id | Có | ID định danh ứng dụng đăng ký.                                                                                     |
| redirect_uri | Tuỳ chọn | URI mà người dùng sẽ được chuyển hướng về |
| scope | Tuỳ chọn | Phạm vi truy cập yêu cầu |
| state | Khuyến nghị | Chuỗi ngẫu nhiên dùng để chống CSRF. CLient sinh ra chuỗi này, lưu vào session, và kiểm tra lại khi nhận phản hồi |

#### Bước 2: User Consent & Response: Sau khi người dùng đăng nhập v cấp quyền, Authorization Server chuyển hướng trình duyệt về redirect_uri với:

- `code`: Mã uỷ quyền (Ngắn hạn)
- `state`: nếu có ở bước 1

#### Bước 3: Access Token Request (Trao đổi Token): Client thực hiện gọi POST trực tiếp (Back-channel) tới Token Endpoint:
```http 
POST /token HTTP/1.1
Host: server.example.com
Content-Type: application/x-www-form-urlencoded

grant_type=authorization_code
&code={AUTHORIZATION_CODE_FROM_STEP_2}
&redirect_uri={REDIRECT_URI_USED_IN_STEP_1}
&client_id={CLIENT_ID}
&client_secret={CLIENT_SECRET}
```
#### Bước 4: Token Response: Server trả về JSON chứa access_token và refresh_token (nếu có)

### 4.2 Authorization Code với PKCE
Ban đầu, Authorization Code flow có lỗ hổng trên ứng dụng di động (Public Clients) do chúng không có Client Secret. Kẻ tấn công có thể chặn Authorization Code và đổi lấy Token. PKCE (RFC 7636) ra đời để vá lỗ hổng này và bắt buc cho mọ loại CLient theo chuẩn OAuth 2.1.

#### 4.2.1 Cơ chế PKCE
PKCE thêm một lớp xác thực động (dynamic secret) cho mỗi request.

1. Code Verifier: Client sinh ra một chuỗi ngẫu nhân. Đây là bí mật tạm thời.
2. Code Challenge: Client băm (hash) chuỗi Verifier này để tạo ra Challenge.
3. Gửi Challenge: Trong bước 1, Client gửi kèm code_challenge và code_challenge_method. Server sẽ lưu lại Challenge này
4. Gửi Verifier: Trong bước 3, Client gửi kèm code_verifier gốc
5. Xác minh: Server băm code_verifier mới nhận dược
### 4.3 Implicit Grant
Trong quá khứ, Implicit Grant được dùng cho các ứng dụng SPA (JavaScript) vì trình duệt không được phép gọi POST qua domain khác và không thể giữ Client Secret
#### 4.3.1 Tại sao nó bị khai tử
Trong luồng này, response_type=token. Server trả Access Token trực tiếp trên URL (hash fragment) của trình duyệt

### 4.4 Resource Owner Password Credentials Grant (Deprecated)
Luồng này cho phép client thu thập trực tiếp `username` và `password` để gửi đi lấy token

### 4.5 Client Credentials Grant (Dành cho M2M)
Luồng này được dùng khi ứng dụng tự truy cập tài nguyên ủa chính nó hoặc tài nguyên không thuộc về người dùng

## 5. Token và Cơ chế quản lý vòng đời (RFC 6749)
### 5.1 Access Token (Mã truy cập)
- `Bản chất`: Là một chuỗi (THường là Bearer Token) đại diện cho quyền truy cập. RFC 6749 không quy định dạng Access TOken, nó có thể là một chuỗi ngẫu nhiên hoặc một chuỗi chứa dữ liệu tự ký (Self-contained Token như JWT)
- `Sử dụng`: Được gửi trong header HTTP: `Authorization: Bearer <token>`.
- `Rủi ro`: bất kì ai có được Bearer Token đều có thể sử dụng nó. Do đó, Access Token phải có thời hạn sống ngắn, thường từ 5 ến 60 phút

### 5.2 Refresh Token
- `Chức năng`: Được dùng để lấy Access Token mới khi cái cũ hết hạn mà không cần người dùng đăng nhập lại. Refresh Token có thời hạn dài ngày (vài ngày, vài tháng, hơajc vĩnh viễn cho đến khi bị thu hồi).
- `Bảo mật`: Refresh Token cực kỳ nhạy cảm. Nó chỉ được gửi tới Authorization Server, không bao giờ được gửi tới Resource Server.

### 5.3 Refresh Token Rotation
Đây là kỹ thuật bảo mật bắt buộc cho SPA và Mobile APP.

`Cơ chế hoạt động`:
1. Mỗi khi Client dùng Refresh Token để đổi lấy Access Token mới, Server sẽ cấp Access Token mới kèm một Refresh Token mới
2. Refresh Token cũ bị huỷ hiệu lực ngay lập tức.
3. Phát hiện trộm cắp (Reuse Detection): Nếu server nhận được yêu cầu sử dụng lại refresh token bị thu hô, Server biết token bị lộ. Server sẽ lập tức thu hồi toàn bộ chuõi token, bao gồm cả access token đang hoạt động và refresh token. Điều này buộc người dùng hợp pháp phải đăng nhập lại, nhưng ngăn chặn kẻ tấn công duy trì quyền truy cập.

## 6. Xử lý lỗi và dịnh dạng phản hồi
| Mã lỗi | Ý nghĩa | Hướng xử lý |
| :---: | :--- | :--- |
| invalid_request | Thiếu tham số bắt buộc hoặc tham số sai định dạng. | Kiểm tra lại code gửi request, debug các tham số |
| invalid_client | Client authentication thất bại (sai ID/Secret). | kiểm tra lại credentials, chú ý Basic Auth Header. |
| invalid_grant | Authorization Code hoặc Refresh Token không hợp lệ, hến hạn hoặc redirect_uri không khớp| Kiểm tra lại credentials, chú ý Basi Auth header |
| unauthorized_client | Client không được phép dùng Grant Type này. | Kiểm tra cấu hình Client trên Authorization Server. |
| unsupported_grant_type | Server không hỗ trợ loại Grant này. | Kiểm tra tài liệu của Server (ví dụ: Server tắt Password grant). |
| invalid_scope | Scope yêu cầu không hợp lệ. | Kiểm tra danh sách scope được phép.|

## 7. Security BCP
### 7.1 Cross-Site Request Forgery (CSRF)
- Kịch bản: Kẻ tấn công lừa trình duyệt của người dùng gửi một request đến Authorization Server mà người dùng không hay biết.
- Phòng chống: Sử dụng một tham số state.
  - Client tạo một chuỗi random, lưui vào cookie trình duyệt.
  - Gửi chuỗi này trong state của Authorization Request
  - Khi nhận callback, Client so sánh state trả về với state trong cookie.
### 7.2 Clickjacking
- kịch bản: Kẻ tán công nhúng trang đăng nhập/uỷ quyền vào một iframe trong suốt trên một trang web độc hại. người dùng thực tế bấm à nút Allow Access trên iframe
- Phòng chống: Authorization Server phải sử dụng Header X-Frame-Options: DENY hoặc Content-Security-Policy: frame-ancestors 'none' để cấm trang khác nhúng mình vào iframe.
### 7.3 Open Redirectors
- Kịch bản: Authorization Server cho phép redirect_uri không đăng ký hoặc đăng ký lỏng lẻo (wildcard). Kẻ tấn công tạo link ủy quyền nhưng trỏ redirect_uri về trang web độc hại của hắn để hứng Authorization Code.
- Phòng chống: Đăng ký chính xác (Exact match) toàn bộ chuỗi URI. Loại bỏ hoàn toàn wildcards trong OAuth 2.1.   

### 7.4 Token Leakage (Rò rỉ Token)
- Nguyên nhân: Token bị ghi vào server logs, bị lộ qua Referer header, hoặc lưu trong localStorage (nơi dễ bị tấn công XSS).
- Phòng chống:
  - Sử dụng Authorization Code Flow để Token không bao giờ xuất hiện trên URL.
  - Với SPA, lưu Token trong bộ nhớ (in-memory) hoặc sử dụng Service Worker/HttpOnly Cookies nếu có backend hỗ trợ (BFF - Backend For Frontend pattern).   
