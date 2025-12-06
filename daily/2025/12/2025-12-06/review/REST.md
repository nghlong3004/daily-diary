## REST
## RESTful API Web
#### Việc triển khi API Web RESTful là một API web sẻ dụng cá nguyên tắc khiến trúc chuyển trạng thái đại diện (REST) để đạt được giao diện liên kết lỏng lẻo, không trạng thái giữa máy khách và dịch vụ. API web RESTful hỗ trợ giao thức HTTP tiêu chuẩn để thực hiện các thao tác trên tài nguyên và trả về các biểu diễn tài nguyên có chứa hypermdeia links và mã trạng thái hoạt động HTTP
#### API web RESTful phải phù hợp với các nguyên tắc sau:
    - Platform independency (Độc lập nền tảng), ó nghĩa là khách hàng có thể gọi API web bất kể việc triển khai nội bộ. Để đạt được sự độc lập nền tảng, API web sử dụng HTTP làm giao thức chuẩn, cung cấp tài liệu rõ ràng và hỗ trợ định dạng trao đổi dữ liệu quen thuộc như JSON or XML
    - Loose coupling (Khớp nối lỏng lẻo), có nghĩa client và server có thể phát triển độc lập. CLient không cần biết cách triển khai nội bộ của server và server không cần biết cách triển khi nội bộ của client. Để đạt được Loose coupling trong API web RESTful, chỉ sử dụng các giao thức chuẩn và triển khai cơ chế cho phép máy khách và dịch vụ web đồng ý về định dạng của dữ liệu để trao đổi.

## Các khái niệm thiết kế API web RESTful
#### Để triển khai API web RESTful, cần hiểu các khái niệm sau:
    - Uniform Resource Identifier (Mã định danh tài nguyên thống nhất) (URI): REST API được thiết kế xung quanh các tài ngueyen, là bất kì loại đối tượng, dữ liệu hoặc dịch vụ nào mà máy khách có thể truy cập. Mỗi tài nguyên được đại diện bởi một URI xác định duy nhất tài nguyên đó. Ví dụ: URI cho một đơn đặt hàng khách hàng cụ thể có thể là:

```ini
https://api.contoso.com/oders/1
```
    - Resource representation (Đại diện tài nguyên): Xác định cách tài nguyên được xác định bởi URI của nó được mã hoá và vận chuyển qua giao thức HTTp ở định dạng cụ thể, chẳng hạn như XML or JSON. Client muốn lấy một resource ụ thể phải sử dụng URI của resource trong request tới API. API trả về biểu diẽn tài nguyên của dữ liệu mà URI chỉ ra. Ví dụ: client có thể thực hiện yêu cầu GET tới URI: **https://api.contoso.com/oders/1** để nhận body JSOn sau:

```json
{"orderId": 1, "orderValue":99.9, "productId": 1, "quantity":1}
```
    - Uniform Interface (Giao diện thống nhất) là cách các API RESTful đạt được sự kết hợp lỏng lẻo giữa triển khai client và service. Đối với các API REST được xây dựng dựa trên HTTP, Uniform Interface bao gồm việc sử dụng các động từ HTTP tiêu chuẩn để thực hiện các thao tác như: **GET**, **POST**, **PUT**, **PATCH**, **DELETE** trên tài nguyên.
    - Stateless request model (Mô hình yêu cầu không trạng thái): API RESTful sử dụng mô hình Stateless request, có nghĩa là các yêu cầu HTTP độc lập và có thể xảy ra theo bất kỳ thứ tự nào. Vì lý do này, việc lưu giữ thông tin trạng thái nhất thời giữa các yêu cầu là không khả thi. Nơi duy nhât mà thông tin được lưu trữ là trong chính các tài nguyên và mỗi yêu cầu phải là một hoạt động nguyên tử. Mô hình yêu cầu không trạng thái hỗ trợ khả năng mở rộng cao vì nó không cần giữ lại bât kỳ mối quan hệ nào giữa máy khách và máy chủ cụ thể. Tuy nhiên, mô hình không trạng thái cũng hạn ché khả năng mở rộng vì những thách thức với khả năng mở rộng lưu trữ back-end của dịh vụ web.
    - Hypermedia links (Kết nối siêu phương tiện): REST APi có thể được điều khiển bởi các liên kết hypermedia có trong mỗi biểu diễn tài nguyên. Ví dụ: Khối mã sau biểu thị biểu diễn JSON của một đơn hàng. Nó chứa các liên kết để nhận hoặc cập nhật khách hàng có liên quan đến đơn đặt hàng.
```json
{
  "orderID":3,
  "productID":2,
  "quantity":4,
  "orderValue":16.60,
  "links": [
    {"rel":"product","href":"https://api.contoso.com/customers/3", "action":"GET" },
    {"rel":"product","href":"https://api.contoso.com/customers/3", "action":"PUT" }
  ]
}
```
## Xác định URI tài nguyên API web RESTful
#### API web RESTful được tổ chức xung quanh các tài nguyên. Để tổ chức thiết kế API của bạn xung quanh các tài nguyên, hãy xác định các URI tài ngueyen ánh xạ tới các thực thể. Khi có thể, URI tài nguyên cơ sở dựa trên danh từ (Resource) chứ không phải động từ (các thao tác trên tài nguyên)
#### URI để tạo tài nguyên đơn hàng có thể giống như:
```http
https://api.contoso.com/orders // Good
```
#### Tránh sử dụng động từ trong URI để biểu diễn các phép toán:
```http
https://api.contoso.com/create-oder // Avoid
```
#### Cac thực thể thường được nhóm lại với nahu thành các bộ sưu tập như khách hàng hoặc đơn đặt hàng. Một collection lfa một resource riêng biệt với các item bên trong collection, vì vậy nó nên có URI riêng. Ví dụ: URI sau đây có thể đại diện cho tập hơn các đơn đặt hàng:
```http
https://api.contoso.com/oders
```

#### Sau khi máy khách truy xuất bộ sưu tập, nó có thể thực hiện yêu cầu GET tới URI của từng mục. Ví dụ: để nhận thông tin về một đơn hàng cụ thể, máy khách thực hiện yêu cầu HTTP GET trên URI `https://api.contoso.com/orders/1` để nhận nội dung JSON sau dưới dạng biểu diễn tài nguyên của dữ liệu đơn hàng nội bộ:
```json
{"orderId":1,"orderValue":99.9,"productId":1,"quantity":1}
```

## Quy ước đặt tên URI tài nguyên
#### Khi thiêt kế RESTful web API, điều quan trọng là sử dụng cac quy ước đặt tên và mối quan hệ cho chính xác cho các tài nguyên:
    - Sử dụng danh từ cho tên tài nguyên. Sử dụng danh từ biể thị tài ngueye. Ví dụ: Sử dụng `/orders` thay vì `/create-oder`. Cac phương thức HTTP GET, POST, PUT, PATCH và DELETE đã ngụ ý hành động bằng lời nói.
    - Sử dụng danh từ số nhiều để đặt tên cho URI bộ sưu tập: Nói chung, nó giúp sử dụng danh từ số nhiều cho các URI tham chiều các bộ sưu tập. Đó là một thực hành tốt để tổ chức URI cho các bộ sưu tập và các mục thành một hệ thống phân cấp. Ví dụ: `/customers` là con đường dẫn tới bộ sưu tập khách hàng, và `/customers/5` là đường dẫn đến khách hàng có ID bằng 5. Cách tiếp cận này giữ cho API web trực quan. Ngoài ra, nhiều khung API web có thể định tuyến các yêu cầu dựa trên đường dẫn URI được tham số hoá, vì vậy bạn có thẻe xác định tuyến đường cho nó là `/customers/{id}`
    - Hãy xem xét mối quan hệ giữa các loại tài nguyên khác nhau và cách bạn có thể phơi bày cac liên kết này. Ví dụ: các `/customers/5/oders` có thể đại diện cho tất cả các đơn đặt cho khách hàng 5. Bạn cũng có thể tiếp cập mói quan hệ theo hướng khác bằng cách đại diện cho hiệp hội một đơn đặt hàng đến mội khách hàng. Trong kịch bản này, URI có thể là /orders/99/custommer. Tuy nhiên, việc mở rộng mô hình này quá xa có thể trở nên cồng kềnh để thực hiện. Một cách tiếp cận tốt hơn là đưa các liên kết vào thân của thông báo phản hồi HTTP để khách hàng có thể truy cập các tài nguyên liên quan
    - Giữ cho các mối uqan hệ đơn giản và linh hoạt. Trong các hệ thống phức tạp hơn, bạn có thể có xu hướng cung cấp các URI cho phép khách hàng điều hướng qua nhiều cấp độ mối quan hệ, chẳng hạn như `/customers/1/order/99/products`. Tuy nhiên, mức độ phức tạp này có thể khó duy trì và không linh hoạt nếu mối quan hệ giữa cac nguồn lực thay đổi trong tương lai. Thay vào đó, hãy cố gắng giữ cho URI tương đối đơn giản. Sau khi ứng dụng có tham chiếu đến tài nguyên, bạn sẽ có thể sử dụng tham chiều này để tìm các mục liên quan đến tài nguyên đó. Bạn có thể thay thế truy vấn trước đó bằng URI `/customers/1/orders` để tìm tất cả các đơn đặt hàng cho khách hàng 1, và sau đó sử dụng `/orders/99/products` để tìm các sản phẩm theo thứ tự này

> Tránh yêu cầu các URI tai nguyên phức tạp hơn collection/item/collection
    - Tránh một số lượng lớn các nguồn lực. Tất cả các yêu cầu web đều áp dụng lên trên máy chủ web. Càng nhiều yêu cầu, tải càng lớn. Các API web hiển thị một số lượng lớn các tài nguyên nhỏ được gọi là API web trò truyện. Cố gắng tránh các API này vì chúng yêu cầu ứng dụg khách gửi nhiều yêu cầu để tìm tất cả dữ liệu mà nó yêu cầu. Thay vào đó, hãy xem xét việc phi chuaarn hoá dữ liệu và kết hợp thông tin liên quan thành các tài nguyên lớn hơn có thể được truy xuât thông qua một yêu cầu duy nhất. Tuy nhiên, bạn vẫn cần cân bằng cách tiếp cận này với chi phí tìm nạp dữ liệu mà khách hàng không cần. Truy xuất đối tượng lớn có thể làm tăng độ trễ của yêu cầu và phát sinh nhiều chi phí băng thông hơn. 
    - Tránh tạo các API phản ảnh cấu trúc bên trong của database: Mục đích REST là mô hình hoá cá thực thể và các hoạt động mà một ứng dụng có thể thực hiện trên các thực để. Khách hàng không nên tiếp xúc với việc triển khai nội bộ. Cách tiếp cận này làm tăng bề mặt tấnc ông và có thể dẫn tới rò rỉ dữ liệu. Thay vào đó, hãy nghĩ về API web như một sự trừu tượng của db. Nếu cần, hãy giới thiệu một lớp ánh xạ giữa db và API web. Lớp này đảm bảo các ứng dụng được tách biệt khỏi các thay đổi với lược đồ db cơ bản

## Xác định các phương thức RESTful web API
#### Các phương thức RESTful web API phù hợp với các phương thức yêu c ầu và loại phương thức được xác định bởi giao thức HTTP. Phàn này mô tả các phương thức yêu cầu phổ biến và các loại phương tiện được ssr dụng trong API web RESTful.

### Các phương thức HTTP
#### TRong RESTful API các phương thức phổ biến nhất là GET, POST, PUT, PATCH và DELETE. mõi phương thức tương ứng với một hoạt động cụ thể.
> bảng sau đây sử dụng một ví dụ về thương mại điện tử `customer` thực thẻ. API web không càn triển khai tất cả các phương thức yêu cầu. Các phương pháp mà nó thực hiện phụ thuộc vào kịch bản cụ thể.

| Resource | POST | GET | PUT | DELETE |
|---|---|---|---|---|
|`/customer`| Tạo khách hàng mới| Lấy tất cả khách hàng | Cập nhật hàng loạt khách hàng | Loại bỏ tất cả khách hàng|
|`/customer/1`| Lỗi | Lấy thông tin chi tiết của khách hàng 1| Cập nhật chi tiết của khách hàng 1 nếu nó tồn tại| Loại bỏ khách hàng 1|
|`/customer/1/orders| Tạo đơn hàng mới cho khách hàng 1| Lấy tất cả đơn hàng cho khách hàng 1| Cập nhật hàng loạt đơn đặt hàng cho khách hàng 1| Loại bỏ tất cả các đơn đặt hàng cho khách hàng 1|

### GET request
#### Yêu cầu GET truy xuất biểu diễn tài nguyên tại URi được chỉ định. Nội dung của thông báo phản hồi chứa thông tin chi tiết về tài nguyên được yêu cầu.
#### Yêu cầu GET phải trả về một trong các mã trạng thái sau:
| Mã trạng thái HTTP| Lý do|
|---|---|
| 200 (OK)| Phương thức đã trả về resource thành công|
| 204 (No content)| Nội dung phản không hồi không có, chảng hạn như yêu cầu tìm kiếm trả về không có kết quả nào trong phản hồi HTTP|
| 404 (Not found)| Không tìm thấy tài nguyên được yêu cầu

### POST request
#### Một yêu cầu POST nne tạo ra một tài nguyên, máy chủ gán URI cho tài nguyên mới và trả vè URI đó cho máy khách.
> Đối với các yêu cầu POST, khách hàng không nên cố gắng tạo URI của riêng mình. máy khách phải gửi yêu caafu tới URI của bộ sưu tập và server sẽ chỉ định URI cho tài nguyên mới. Nếu máy khách cố găng tạo URI của riêng mình và đưa ra yêu cầu POST tới một URI cụ thể, server sẽ trả về 400 (Bad Request) để cho biết phương thức này không hỗ trợ.

#### TRong RESTful, các yêu cầu POST được sử dụng đẻ thêm tài nguyên mới vào bộ sưu tập mà URI xác định. TUy nhiên, yêu cầu POST cũng có thẻ được sự dụng để gửi dữ liệu xử lý tới tài nguyên hiện có mà không cần tạo bất kì tài nguyên mới nào.

#### POST requeest phải trả về một trong các mã trạng thái sau:
| HTTP Status| Lý do|
|---|---|
| 200 (OK)| Phương thức đã thực hiện một số xử lý nhưng không tạo ra một tài nguyên mới. Kết quả của hạot động có thể đưa vào cơ quản phản hồi|
| 201 (Accept)| Tài nguyên dã được tạo thành công. URI của tài nguyên mới được bao gồm trong tiêu đề vị tí của phản hồi. Nội dung phản hòi chứa biểu diễn của tài nguyên.|
| 400 (Bad request)| Khách hàng đã đặt dữ liệu không hợp lệ trong yêu cầu. Nội dung phản hòi có thể chứa thêm thông tin về lỗi hoặc liên kết đến URI cung cấp thêm chi tiết|
| 405 (Method Not Allowed) | Client cố gắng thực hiện yêu cầu POST tới URI không hỗ trợ yêu cầu POST|

### PUT request
#### Yêu cầu PUT nên cập nhật tài nguyên hiẹn có néu nó tồn tại hoặc trong một số trường hợp, tạo tài nguyên mới nếu nó không tồn tại. Để thực hiện yêu cầu PUT:
1. Client chỉ định URI cho tài nguyên và bao gồm nội dung yêu cầu chứa bản trình bày đầy đủ về tài nguyên
2. Client đưa ra yêu cầu
3. Nếu tài nguyên có URI này tồn tại thì tài nguyên đó sẽ được thay thế. Nếu không, một tài nguyên mới sẽ được tạo nếu PATH hỗ trợ nó.
#### Các phương thức PUT được áp dụng cho các tài nguyên là các mục riêng lẻ, chẳng hạn như một khách hàng cụ thể, thay vì các bộ sưu tập. Một máy chủ có thể hỗ trợ cập nhật nhưng không hỗ trợ tạo thông qua PUT. Việc có hỗ trợ tạo thông qua PUT hay không phụ thuộc vào việc máy khách có thể gán URI một cách có ý nghĩa và đáng tin cậy cho tài nguyên trước khi nó tồn tại hay không. Nếu nó không thể, sau đó sử dụng POST để tạo tài nguyên và có máy chủ gán URI. Sau đó sử dụng PUT hoặc PATCH để cập nhật URI. 
> Yêu cầu PUT phải được vô năng, có nghĩa là việc gửi cùng một yêu cầu nhiều lần luôn dẫn đến việc cùng một tài nguyên được sửa đổi với cùng các giá trị. Nếu khách hàng gửi lại yêu cầu PUT, kết quả sẽ không thay đổi. Ngược lại, các yêu cầu POST và PATCH không được đảm bảo là bình thường 
#### PUT request trả về :
|HTTP Status| Lý do|
|---|---|
|200 (OK)| tài nguyên cập nhật thành công|
|201 (Accept)| Tài nguyên tạo thành công, Nội dung phản hòi có thể chứa biểu diễn tài nguyên|
|204 (No content)| tài nguyên cập nhật thành công nhưng phản không chứa bât kỳ nội dung nào.|
| 409 (Conflig)| Yêu cầu không thể hoàn thành do xung đột|

### PATCH request
#### Yêu cầu PATCH thực hiện cập nhật một phần tài nguyên hiện có. Máy khách chỉ định URI cho tài nguyên. Cơ quan yêu cầu chỉ định một tập hợp các thay đổi để áp dụng cho tài nguyên. Phương pháp này có thể hiệu quả hơn việc sử dụng các yêu cầu PUT vì máy khách chỉ gửi các thay đổi chứ không gửi toàn bộ biểu diễn của tài nguyên. PATCH cũng có thể tạo một tài nguyên mới bằng cách chỉ định một tập hợp các bản cập nhật cho một tài nguyên trống hoặc vô hiệu resource nếu server hỗ trợ hành động này 
#### Với yêu cầu PATCH, máy khách sẽ gửi một tập hợp các bản cập nhật tới tài nguyên hiện có dưới dạng tài liệu vá lỗi. Máy chủ xử lý tài liệu vá lỗi để thực hiện cập nhật. Tài liệu bản vá chỉ chỉ định một tập hợp các thay đổi để áp dụng thay vì mô tả toàn bộ tài nguyên. Đặc tả cho phương pháp PATCH, RFC 5789, không xác định định dạng cụ thể cho tài liệu vá lỗi. Định dạng phải được suy ra từ loại phương tiện trong yêu cầu. 
#### JSON merge patch đơn giản hơn JSON patch. Tài liệu vá lỗi có cấu trúc giống như tài nguyên JSON ban đầu, nhưng nó chỉ bao gồm tập hợp con các trường cần được thay đổi hoặc thêm vào. Ngoài ra, một trường có thể bị xóa bằng cách chỉ định null đối với giá trị trường trong tài liệu vá. Đặc tả này có nghĩa là bản vá hợp nhất không phù hợp nếu tài nguyên gốc có thể có các giá trị null rõ ràng. 
```json
{

    "name":"gizmo",
    "category":"widgets",
    "color":"blue",
    "price":10
}
```
#### Đây là một bản vá hợp nhất JSON có thể có cho tài nguyên này:
```json
{
    "price":12,
    "color":null,
    "size":"small"
}
```
| HTTP Status| Lý do|
|---|---|
|200 (OK)| Tài nguyên đã được cập nhật thành công|
| 400 (Bad request)| Tài liệu vá lỗi không đúng định dạng|
| 409 (Conflig) | Tài liệu vá lỗi hợp lệ nhưng các thay đổi không thẻ áp dụng cho tài nguyên ơ trạng thái hiẹn tại|
| 415 (Unsupported Media Type)| Định dạng tài liệu bản vá không được hỗ trợ|

## DELETE request
#### Một Delete request xoá tài nguyên tại một URI. Một Delete request phải trả về một trong các mã trạng thái HTTP sau:
|HTTP Status| Reason|
|---|---|
|204 (No content)| Tài nguyen bị xoá thành công. Quá trình này đã được xử lý thành công và không phản hồi gì|
| 404 (Not found)| Tài nguyên không tồn tại|

## Các loại MIME tài nguyên
#### Trong giao thức HTTP, các định dạng biểu diễn tài nguyên được chỉ định bằng cách sử dụng các loại phương tiện, còn được gọi là loại MIME. Đối với dữ liệu không nhị phân, hầu hết các API web đều hỗ trợ JSON (loại phương tiện = application/json) và có thể cả XML (loại phương tiện = application/xml). 
#### Tiêu đề Loại nội dung trong yêu cầu hoặc phản hồi chỉ định định dạng biểu diễn tài nguyên. Ví dụ sau đây thể hiện yêu cầu POST bao gồm dữ liệu JSON: 
```http
POST https://api.contoso.com/orders
Content-Type: application/json; charset=utf-8
Content-Length: 57

{"Id":1,"Name":"Gizmo","Category":"Widgets","Price":1.99}
```

#### Nếu máy chủ không hỗ trợ loại phương tiện, nó sẽ trả về mã trạng thái HTTP 415 (Loại phương tiện không được hỗ trợ).
#### Một yêu cầu máy khách có thể bao gồm một tiêu đề Chấp nhận có chứa danh sách các loại phương tiện mà máy khách chấp nhận từ máy chủ trong thông báo phản hồi. Ví dụ: 
```http
GET https://api.contoso.com/orders/2
Accept: application/json, application/xml
```
#### Nếu máy chủ không thể khớp với bất kỳ loại phương tiện nào được liệt kê, nó sẽ trả về mã trạng thái HTTP 406 (Không được chấp nhận).  

## Thực hiện phân trang và lọc dữ liệu  
#### Để tối ưu hóa việc truy xuất dữ liệu và giảm kích thước tải trọng, hãy triển khai phân trang dữ liệu và lọc dựa trên truy vấn trong thiết kế API của bạn. Những kỹ thuật này cho phép khách hàng chỉ yêu cầu tập hợp con dữ liệu họ cần, điều này có thể cải thiện hiệu suất và giảm mức sử dụng băng thông. 
- Phân trang chia các tập dữ liệu lớn thành các phần nhỏ hơn, có thể quản lý được. Sử dụng các tham số truy vấn như limit để chỉ định số lượng mặt hàng cần trả lại và offset để chỉ định điểm bắt đầu. Đảm bảo cũng cung cấp các giá trị mặc định có ý nghĩa cho limit và offset, chẳng hạn như limit=25 và offset=0. Ví dụ: 
```http
GET /orders?limit=25&offset=50
```
- `limit`: chỉ định số lượng mục tối đa trả về.
> Để giúp ngăn chặn các cuộc tấn công từ chối dịch vụ, hãy xem xét áp đặt giới hạn trên đối với số lượng mặt hàng được trả lại. Ví dụ, nếu service của bạn đặt max-limit=25, và một khách hàng yêu cầu limit=1000, dịch vụ của bạn có thể trả về 25 mục hoặc lỗi HTTP BAD-REQUEST, tùy thuộc vào tài liệu API.  
- `offset`: chỉ định mục bắt đầu cho dữ liệu.
- Lọc cho phép khách hàng tinh chỉnh tập dữ liệu bằng cách áp dụng các điều kiện. API có thể cho phép máy khách vượt qua bộ lọc trong chuỗi truy vấn của URI:  
```http
GET /orders?minCost=100&status=shipped
```
- `minCost`: lọc các đơn hàng có chi phí tối thiểu là 100.
- 'status': Lọc các đơn hàng có trạng thái cụ thể.
#### Hãy xem xét các phương pháp hay nhât sau:
- Sắp xếp cho phép khách hàng sắp xếp dữ liệu bằng cách sử dụng a sort tham số như sort=price"  
> Phương pháp sắp xếp có thể có tác động tiêu cực đến bộ nhớ đệm vì các tham số chuỗi truy vấn tạo thành một phần của mã định danh tài nguyên mà nhiều triển khai bộ đệm sử dụng làm khóa cho dữ liệu được lưu trong bộ nhớ đệm.  
- Lựa chọn trường cho các phép chiếu do khách hàng xác định cho phép khách hàng chỉ xác định các trường mà họ cần bằng cách sử dụng a fields tham số như fields=id,name. Ví dụ: bạn có thể sử dụng tham số chuỗi truy vấn chấp nhận danh sách các trường được phân cách bằng dấu phẩy, chẳng hạn như /đơn đặt hàng?trường=Sản phẩmID,Số lượng. 
## Thực hiện versioning  
#### API web không duy trì trạng thái tĩnh. Khi yêu cầu kinh doanh thay đổi, các bộ sưu tập tài nguyên mới sẽ được thêm vào. Khi các tài nguyên mới được thêm vào, mối quan hệ giữa các tài nguyên có thể thay đổi và cấu trúc dữ liệu trong tài nguyên có thể được sửa đổi. Cập nhật API web để xử lý các yêu cầu mới hoặc khác nhau là một quá trình đơn giản nhưng bạn phải xem xét tác động của những thay đổi đó đối với các ứng dụng khách sử dụng API web. Nhà phát triển thiết kế và triển khai API web có toàn quyền kiểm soát API đó nhưng họ không có cùng mức độ kiểm soát đối với các ứng dụng khách do các tổ chức đối tác xây dựng. Điều quan trọng là tiếp tục hỗ trợ các ứng dụng khách hiện có trong khi cho phép các ứng dụng khách mới sử dụng các tính năng và tài nguyên mới. 
### Không versioning 
#### Cách tiếp cận này là đơn giản nhất và có thể làm việc cho một số API nội bộ. thay đổi đáng kể có thể được biểu diễn dưới dạng tài nguyên mới hoặc liên kết mới. Việc thêm nội dung vào tài nguyên hiện có có thể không mang lại thay đổi đột phá vì các ứng dụng khách không mong đợi xem nội dung này sẽ bỏ qua nội dung đó.
### Có versioning
#### Mỗi lần bạn sửa đổi API web hoặc thay đổi lược đồ tài nguyên, bạn sẽ thêm số phiên bản vào URI cho mỗi tài nguyên. Các URI hiện có trước đó sẽ tiếp tục hoạt động bình thường bằng cách trả về các tài nguyên phù hợp với lược đồ ban đầu của chúng. 
#### Ví dụ, các address trường trong ví dụ trước được cấu trúc lại thành các trường con chứa từng phần cấu thành của địa chỉ, chẳng hạn như streetAddress, city, state, và zipCode. Phiên bản tài nguyên này có thể được hiển thị thông qua URI chứa số phiên bản, chẳng hạn như https://api.contoso.com/v2/customers/3: 
```http
HTTP/1.1 200 OK
Content-Type: application/json; charset=utf-8

{"id":3,"name":"Fabrikam, Inc.","dateCreated":"2025-03-22T12:11:38.0376089Z","address":{"streetAddress":"1 Microsoft Way","city":"Redmond","state":"WA","zipCode":98053}}
```
#### Cơ chế lập phiên bản này đơn giản nhưng phụ thuộc vào máy chủ để định tuyến yêu cầu đến điểm cuối thích hợp. Tuy nhiên, nó có thể trở nên khó sử dụng khi API web trưởng thành thông qua một số lần lặp và máy chủ phải hỗ trợ nhiều phiên bản khác nhau. Theo quan điểm thuần túy, trong mọi trường hợp, các ứng dụng khách lấy cùng một dữ liệu (khách hàng 3), do đó URI không được khác nhau tùy theo phiên bản. Lược đồ này cũng làm phức tạp việc triển khai HATEOAS vì tất cả các liên kết cần bao gồm số phiên bản trong URI của chúng. 
