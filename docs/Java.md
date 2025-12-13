# Tất tần tật về Java 1 &rarr; 25

## Java 1
### JDK 1.0 (1/1996)
- Phiên bản chính thức đầu tiên
- Ra mắt slogan huyền thoại "Write Once, Run Anywhere"
- Các tính năng cơ bản: Applet, AWT.
### JDK 2.0 (2/1997)
- Bổ sung JDBC 
- Giới thiệu Inner Class
- JavaBeans

## J2SE (Java 2 Platform)
- Từ phiên bản 1.2, Java đổi tên thành J2SE (Java 2 Standard Edition).
- J2SE 1.2 (12/1998): Đây là cột mốc quan trọng vì:
  - Ra mắt từ khoá strictfp.
  - Giới thiệu Collections Framework (List, Set, Map, ...)
  - Ra mắt Swing (Thư viện đồ hoạ mạnh hơn AWT)
- J2SE 1.3 (5/2000): 
  - Giới thiệu 1 HotSpot JVM (Giúp tối ưu hoá hiệu suất chạy mã).
  - Cải tiến RMI (Remote Method Invocation).
- J2SE 1.4 (2/2002):
  - Từ khoá assert (kiểm tra lỗi)
  - Hỗ trợ Regular Expressions (Biểu thức chính quy)
  - Xử lý ngoại lệ theo chuỗi (Exception chaining)
  - API mới cho I/O (NIO).
## Giai đoạn hiện đại hoá 5, 6, 7
Đây là giai đoạn java thay đổi cách đánh số phiên bản (Bỏ số 1.)
- J2SE 5.0 (9/2004): Một bản cập nhật khổng lồ thay đổi cách viết code Java
  - Generics: Cho phép định nghĩa kiểu dữ liệu chặt chẽ cho collections (Ví dụ List<String>)
  - Annotations: Giới thiệu siêu dữ liệu (@Override, @Deprecated).
  - Autoboxing/Unboxing: Map kiểu nguyên thuỷ và đối tượng.
  - Enumerations (Enum): Kiểu liệt kê.
  - Varargs: Tham số biến đổi
  - Foreach: for (String s: list);
- Java SE 6 (12/2006)
  - Không có nhiều thay đổi về cú pháp ngôn ngữ
  - Tập trung vào hiệu suất và thư viện
  - Cải thiện tích hợp các ngôn ngữ Scripting
- Java SE 7 (7/2011): Bản cập nhật lớn trước Java 8
  - Diamond Operator (<>): Giúp khai báo Generics ngắn gọn hơn.
  - Switch on String: Cho phép dùng chuỗi trong câu lệnh switch (Trước đó chỉ số hoặc enum).
  - try-with-resources: Tự đóng tài nguyên mà k cần khối finally
  - Bắt nhiều ngoại lệ (Multi-catch exceptions)

## Java 8
### 1. Lambda Expressions (Biểu thức Lambda)
Cho phép lập trình hàm (functional programming) bằng cách cho phép sử dụng các hàm vô danh (anonymous functions) 

Cung cấp cú pháp ngắn gọn để tạo các đoạn mã xử lý sự kiện hoặc triển khai functional interface chỉ chứa một phương thức duy nhất

```java
// Trước Java 8
Runnable runnable = new Runnable(){
  @Override 
  public void run(){
    System.out.println("Hello world!");
  }        
};

// Sau Java 8
Runnable runnable = () -> System.out.println("Hello world!");
```

Tại sao nên dùng ?
- Cung cấp implement cho Function Interface
- Viết ít code hơn
- Hiệu quả hơn nhờ việc hỗ trợ tuần tự (`sequential`) và song song (`parallel`) thông qua stream API

### 2. Functional Interfaces
Là Interface chỉ chứa 1 phương thức trừu tượng duy nhất được gọi là `Abstrac Method`.

Tính năng chính là khả năng sử dụng biểu thức lambda để triển khai phương thức đó.

Chú thích `@FunctionalInterface` để đánh dấu những Interface như vậy.

### 3. Stream API
Giới thiệu 1 trừu tượng mới là Stream để xử lý chuỗi các phần tử

Hỗ trợ các thao tác hàm trên streams như filter, map, reduce, ...

### 4. Method References (Phương thức tham chiếu)

Cung cấp cú pháp rút gọn cho biểu thức lambda

Cho phép tham chiếu đến phương thức hoặc constructor bằng toán tử ::

### 5. Optional
Một đối tượng chứa giá trị có thể null hoặc không null

Hỗ trợ kiểm tra null hiệu quả hơn và tránh Null Pointer exception

### 6. New Date and Time API (API Ngày và Giờ mới)
Gói java.time giới thiệu một API linh hoạt hơn để xử lý ngày và giờ.

### 7. Default method

Default Methods được giới thiệu để thêm tính năng mở rộng cho các interface mà không làm phá vỡ các lớp implement từ interface này.

Một interface có thể chứa phương thức mặc định, là phương thức có thể được triển khai bởi các lớp triển khai của interface đó. Các lớp triển khai có thể sử dụng phương thức mặc định này mà không cần phải triển khai lại nó.

### 8. Nashorn JavaScript Engine (Bộ Duyệt JavaScript Nashorn)

Thay thế bộ duyệt JavaScript cũ Rhino.

Cung cấp hiệu suất tốt hơn và tương thích tốt hơn với tiêu chuẩn JavaScript hiện đại.

### 9. Parallel Streams (Luồng Song Song)
Cho phép xử lý song song của streams bằng cách sử dụng phương thức parallel().

Tăng hiệu suất trên hệ thống đa lõi cho một số loại thao tác cụ thể.

### 10. Collectors
Giới thiệu một bộ các phương thức tiện ích trong lớp Collectors cho các thao tác phổ biến, như toList(), toSet(), joining(), v.v.

### 11. Functional Interfaces trong gói java.util.function

Functional interface mới như Predicate, Function, Consumer và Supplier để hỗ trợ biểu thức Lambda.

## Java 9
### 1. Cải tiến Process API
Java 9 giới thiệu cải tiến cho API Process, mang lại sự kiểm soát tốt hơn đối với các tiến trình native. Lớp mới ProcessHandle cho phép developer tương tác với các tiến trình và lấy ra các thông tin về chúng.

### 2. Collection Factory Methods
Java 9 đã thêm vào các giao diện bộ sưu tập (List, Set, Map, v.v.) các phương thức tạo đối tượng tĩnh mới, giúp tạo ra các phiên bản không thay đổi của các collection này trở nên thuận tiện hơn.

```java
void main (String[] args){
  List<String> colors = List.of("Red", "Blue");
  System.out.println(colors);
}
```

Lưu ý rằng các đối tượng được tạo bằng cách sử dụng Collection Factory Methods là không thay đổi (immutable), điều này nghĩa là sau khi được khởi tạo, bạn không thể thay đổi cấu trúc của chúng (thêm, loại bỏ phần tử). Điều này mang lại tính an toàn và dễ kiểm soát hơn trong quá trình lập trình.

### 3. Cải tiến Stream API
Stream API được cải thiện với nhiều phương thức mới như takeWhile, dropWhile, và ofNullable, giúp tăng tính linh hoạt và chức năng khi làm việc với luồng (streams).

- takeWhile: được sử dụng để lấy các phần tử từ stream cho đến khi một điều kiện nhất định được đáp ứng (trong trường hợp này, là số nhỏ hơn 5).
- dropWhile: được sử dụng để bỏ các phần tử từ stream trong khi một điều kiện nhất định được đáp ứng (trong trường hợp này, là số nhỏ hơn hoặc bằng 3).
- ofNullable: được sử dụng để tạo một stream từ một giá trị có thể là null, loại bỏ giá trị null (trong trường hợp này, loại bỏ tên null từ danh sách).

### 4. Private Methods trong Interfaces
Interface trong Java 9 có thể chứa phương thức riêng tư, cho lập trình viên triển đóng gói chức năng chung bên trong một giao diện mà không cần phải tiết lộ nó cho các lớp bên ngoài.

### 5. HTTP/2 Client:
Java 9 giới thiệu một thư viện HTTP client mới nhẹ hỗ trợ HTTP/2 và WebSocket. Thư viện này được thiết kế để hiệu quả và linh hoạt hơn so với API HttpURLConnection cũ.

## Java 10
1. Local-Variable Type Inference (var)
Java 10 giới thiệu khả năng sử dụng từ khóa var để đặt kiểu dữ liệu cho biến cục bộ. Điều này cho phép bạn khai báo biến cục bộ mà không cần chỉ định rõ kiểu dữ liệu, để trình biên dịch tự động suy luận dựa trên giá trị được gán.

```java
import java.net.http.HttpClient;
import java.io.BufferedReader;
import java.util.List;

public class LocalVarInference {

    /**
     * Cho phép: chỉ khi sử dụng làm biến cục bộ
     * Không cho phép: ở bất kỳ nơi nào khác (trường của lớp, tham số của phương thức, vv.)
     * Sử dụng 'var' một cách có trách nhiệm!
     *
     * Sử dụng:
     *  - khi rõ ràng về kiểu dữ liệu (string, int)
     *  - để rút gọn kiểu dữ liệu quá dài và phức tạp
     *
     * Không sử dụng:
     *  - khi giá trị trả về không rõ ràng (var data = service.getData();)
     */

    public static void main(String[] args) {

        // Cho phép, nhưng mang lại ít lợi ích
        var b = "b";
        var c = 5; // int
        var d = 5.0; // double
        var httpClient = HttpClient.newHttpClient();

        // Suy luận phức tạp hơn :)
        var list = List.of(1, 2.0, "3");

        // Lợi ích trở nên rõ ràng hơn với các kiểu dữ liệu có tên dài
        var reader = new BufferedReader(null);
        // so với
        BufferedReader reader2 = new BufferedReader(null);
    }
}

```
2. Optional API — giới thiệu phương thức mới
Phương thức mới: orElseThrow()

Phương thức này trả về giá trị nếu nó tồn tại, nếu không thì sẽ ném ra NoSuchElementException.

Phương thức này làm việc tương tự phương thức get(). Tuy nhiên, tên phương thức get() có thể dễ gây hiểu nhầm, đồng thời tên orElseThrow() sẽ có tính nhất quán hơn với các phương hiện có (ifPresentOrElse(), or(), orElse()và orElseGet()))

3. Garbage Collector Interface

Cải thiện khả năng cách ly mã nguồn của các bộ thu gom rác khac nhau bằng cách giới thiệu một bộ tu gom rác (GC) thống nhất

## Java 11
### 1.HTTP client
Java 11 đã giới thiệu một HTTP Client tích hợp trong gói java.net.http. Dưới đây là một ví dụ đơn giản về cách sử dụng HttpClient trong Java 11:

### 2. Các phương thức về File mới
Java 11 đã giới thiệu một số phương thức mới trong gói java.nio.file, cung cấp các chức năng bổ sung cho việc làm việc với tệp và thư mục. Một số phương thức đáng chú ý bao gồm:

- Files.readString(Path path) : Phương thức này được sử dụng để đọc nội dung của một tệp tin thành một chuỗi.

- Files.writeString(Path path, CharSequence content, OpenOption... options) : Phương thức này được sử dụng để ghi nội dung một chuỗi vào tệp tin.

- Files.readAllLines(Path path): Phương thức này được sử dụng để đọc tất cả các dòng từ tệp tin và trả về một danh sách (List<String>) chứa các dòng đó.

- Files.write(Path path, Iterable<? extends CharSequence> lines, OpenOption... options): Phương thức này được sử dụng để ghi một dãy các dòng (được đại diện bởi một Iterable) vào tệp tin

- Files.newBufferedReader(Path path): Phương thức này được sử dụng để tạo một đối tượng BufferedReader để đọc từ một tệp tin.

- Files.newBufferedWriter(Path path, OpenOption... options): Phương thức này được sử dụng để tạo một đối tượng BufferedWriter để ghi vào một tệp tin.

- files.mismatch(Path path1, Path path2): Phương thức Files.mismatch(Path path1, Path path2) được sử dụng để so sánh nội dung của hai tệp tin và trả về vị trí của byte đầu tiên không giống nhau. Nếu hai tệp tin giống nhau, phương thức sẽ trả về -1.

## JAVA 12
1. Compact Number Formatting (Định dạng số ngắn gọn)
Java 12 đã giới thiệu một tính năng mới có tên là “Compact Number Formatting” nằm trong JEP 357. Cải tiến này cung cấp cho chúng ta một cách ngắn gọn hơn để định dạng các số lớn theo cách dành riêng cho từng vùng miền.
2. String::indent (JEP 326)
String::indent là một phương thức giới thiệu trong Java 12 để thêm hoặc loại bỏ các dòng trống ở đầu chuỗi và cuối chuỗi (trailing và leading whitespaces). Nó trả về một bản sao của chuỗi với các thay đổi được thực hiện.

4. Cải tiến thêm java.util.stream.Collectors (JEP 325)
Lớp Collectors trong Java 12 đã giới thiệu các collectors như teeing, cho phép kết hợp hai collectors thành một collector duy nhất

## JAVA 14
1. “Switch Expressions” (SE) thay cho “Switch Statements” (SS)
Switch Expressions (SE) được giới thiệu dưới dạng tính năng xem trước trong Java 12 và được hoàn thiện trong Java 13. Cung cấp một cách mới và nhanh chóng hơn để viết các câu lệnh switch


Điều này giúp cải thiện độ đọc và bảo trì của mã, cũng như hỗ trợ tính năng mở rộng của ngôn ngữ.

2. "YIELD" Statement
Trong Java, từ khóa yield được giới thiệu trong phiên bản 13 để hỗ trợ tính năng "Switch Expressions" (SE). yield được sử dụng trong một biểu thức switch để trả về giá trị từ một khối mã của một trường hợp trong switch expression.

## JAVA 15
Text block giúp đơn giản hóa việc tạo và duy trì các chuỗi đa dòng trong code Java.

Duy trì Cấu Trúc: Text block giữ nguyên cấu trúc của chuỗi, cho phép bạn biểu diễn các chuỗi nhiều dòng một cách tự nhiên hơn, cải thiện khả năng đọc code.

Kiểm soát khoảng trắng: Các khoảng trắng ở đầu và cuối trên mỗi dòng được loại bỏ, mang lại khả năng kiểm soát thụt lề tốt hơn.

Chuỗi thoát (escape string): Chuỗi thoát vẫn hợp lệ trong các khối văn bản, cho phép bao gồm các ký tự đặc biệt.

## JAVA 16
1. Pattern Matching for instanceof
Là một tính năng trong Java giúp làm cho mã nguồn đơn giản hóa quá trình kiểm tra kiểu của đối tượng và thực hiện chuyển đổi ngay trong cùng một câu lệnh. Điều này giúp giảm bớt mã nguồn lặp lại và làm cho mã trở nên dễ đọc hơn.

Trước khi có pattern matching for instanceof, chúng ta thường phải sử dụng instanceof kết hợp với ép kiểu (cast) và sau đó kiểm tra lại kiểu để sử dụng đối tượng theo kiểu mong muốn.

2. Record
Trong Java, record là một loại mới của lớp đặc biệt được giới thiệu với bản tiêu chuẩn trong Java 16. record được thiết kế để đơn giản hóa việc tạo các lớp không thay đổi (Immutable class) chỉ chứa dữ liệu. Nó tự động tạo các phương thức getter, equals, hashCode và toString dựa trên các trường dữ liệu của nó.

Dưới đây là một số điểm chính về record trong Java:

- Dữ liệu Bất Biến (Immutable Data): Các trường dữ liệu của record là không thay đổi (immutable), nghĩa là sau khi tạo ra một record, các giá trị của các trường không thể thay đổi.

- Tự Động Tạo Phương Thức:

  - Phương thức getter cho mỗi trường dữ liệu.
  - Phương thức equals() để so sánh hai record dựa trên giá trị của các trường dữ liệu.
  - Phương thức hashCode() để tạo mã băm dựa trên các trường dữ liệu.
  - Phương thức toString() để tạo chuỗi biểu diễn record.
- Không Thể Kế Thừa:
  - record không thể mở rộng từ một lớp khác hoặc implement các interface khác.
  - Một record không thể là một lớp cha hay một interface.

record tự động tạo một constructor có tham số để khởi tạo các trường dữ liệu.

### 3. Date Time Formatter API
Trong Java 16, DateTimeFormatter hỗ trợ day period thông qua biểu tượng "B". Biểu tượng "B" được sử dụng để hiển thị hoặc phân tích các yếu tố như "AM" (Ante Meridiem) và "PM" (Post Meridiem) trong định dạng thời gian.

### 4. Changes in Stream API
Java 16 mang đến một số thay đổi đáng chú ý cho Stream API, làm cho nó trở nên mạnh mẽ và thuận tiện hơn để sử dụng. Dưới đây là những điểm nổi bật chính:

- Phương thức Stream.toList(): Phương thức mới này cung cấp một cách ngắn gọn để thu thập các phần tử của một stream vào một List. Trước đây, bạn phải sử dụng collect(Collectors.toList()), thì bây giờ có thể là không cần thiết nữa.
- Phương thức Stream.mapMulti(): Phương thức này cho phép bạn ánh xạ mỗi phần tử của một stream thành không hoặc nhiều phần tử, tạo ra một stream mới từ các phần tử kết quả. Nó hữu ích cho việc phân chia hoặc làm phẳng các cấu trúc dữ liệu phức tạp.

## JAVA 17
### 1. Sealed classes(Subclassing)
Lớp Sealed là một tính năng mới được giới thiệu trong Java 17 (JEP 409) mang lại sự kiểm soát mạnh mẽ hơn đối với các việc kế thừa. Về cơ bản, chúng cho phép bạn hạn chế lớp hoặc interface của mình chỉ có thể được extend hoặc implement bởi các lớp cụ thể. Những lợi ích mà nó mang lại bao gồm:

- Tăng cường An Toàn Kiểu: Bằng cách chỉ định các lớp con được phép, bạn sẽ ngăn chặn sự mở rộng không mong muốn có thể làm hỏng mã nguồn của bạn hoặc tạo ra lỗ hổng bảo mật.

- Thiết Kế Thư Viện: Bạn có thể tạo ra các hệ sinh thái đóng gói trong thư viện của mình, đảm bảo người dùng chỉ làm việc với các lớp mở rộng được phê duyệt và không tạo ra các triển khai không tương thích.

- Dễ Dàng Bảo Trì Mã Nguồn: Việc biết chính xác tập hợp các lớp con có thể xuất hiện giảm bớt sự phức tạp khi tư duy về code của bạn và làm cho nó dễ hiểu và dễ bảo trì hơn.

## JAVA 18
1. UTF-8 by Default
Java 18 biến UTF-8 thành mã hóa ký tự mặc định cho nền tảng, phù hợp với các tiêu chuẩn hiện đại và đơn giản hóa việc xử lý ký tự

- Một ví dụ đơn giản như này, mình có hàm viết văn bản “Happy Coding!” bằng tiếng Nhật và chạy chức năng trong Unix (Linux hoặc MacOS):

- Lúc này, nếu bạn chạy chức năng đọc bên dưới trong Windows, bạn sẽ gặp vấn đề không thể đọc được văn bản đã viết ở trên:

- Lý do là vì Unix lưu trữ tệp ở định dạng UTF-8 trong khi Windows đọc nó ở định dạng Windows-1252. Trong phiên bản Java 18 mới này, vấn đề này đã được giải quyết vì UTF-8 hiện được đặt mặc định.

### 2. Simple Web Server
Trong Java 18, nó cung cấp công cụ dòng lệnh để khởi động máy chủ web. Mặc dù công cụ này có thể không được khuyến nghị trong môi trường production nhưng nó rất hữu ích cho việc thử nghiệm.

Để khởi động máy chủ web chúng ta có thể sử dụng lệnh “jwebserver”. Theo mặc định, nó khởi chạy máy chủ trên localhost:8000.

Bạn có thể sử dụng -b để chỉ định địa chỉ IP mà máy chủ sẽ lắng nghe. Với -p, bạn có thể thay đổi cổng và -d thư mục mà máy chủ sẽ phục vụ. Còn -o, để định cấu hình đầu ra log. Ví dụ:

### 3. Triển khai lại Core Reflection bằng Method Handles
Mặc dù thay đổi này sẽ hiếm khi được sử dụng, nhưng bạn nên biết về sự thay đổi này nếu bạn làm việc với Java Reflection.

Java reflection là khả năng của một chương trình Java để kiểm tra, khám phá và thậm chí thay đổi cấu trúc của nó trong quá trình chạy. Reflection cung cấp các công cụ mạnh mẽ nhưng cũng có thể tạo ra mã khó bảo trì và hiệu suất không tốt nếu sử dụng không đúng cách.

Ở Java 18, quyết định đã được đưa ra để triển khai lại mã của các lớp reflection như java.lang.reflect.Method, Field, và Co****nstructor trên cơ sở của java.lang.invoke Method Handles. Method Handles là một phần của Java's Invokedynamic API, và chúng mang lại hiệu suất tốt hơn và khả năng tùy chỉnh cao hơn so với Core Reflection.

### 4. Ngừng sử dụng Finalization trong quản lý tài nguyên
Finalization là một phần của quản lý bộ nhớ tự động của Java, có nhiệm vụ dọn dẹp tài nguyên không còn sử dụng nữa, chẳng hạn như đóng tệp hoặc đóng kết nối cơ sở dữ liệu.

Tuy nhiên, việc sử dụng Finalization có những hạn chế và vấn đề, làm giảm hiệu suất và gây khó khăn trong việc dự đoán chính xác khi tài nguyên sẽ được giải phóng. Thậm chí, có thể xảy ra tình trạng Finalization không được gọi hoặc bị gọi quá muộn, dẫn đến lãng phí tài nguyên.

Đề xuất ngừng sử dụng Finalization là để mở đường cho các lựa chọn thay thế an toàn hơn và đáng tin cậy hơn. Các phương tiện như try-with-resources trong Java (kể từ Java 7) và sự sử dụng AutoCloseable interface là những ví dụ về các cách thức an toàn hơn để quản lý tài nguyên. Sự thay thế này giúp tăng hiệu suất, giảm khả năng xảy ra lỗi và làm cho mã nguồn dễ đọc và bảo trì hơn.

## JAVA 19
Ở phiên bản java này JDK cũng đã đưa ra một số tính năng nổi bật, nhưng chúng mới chỉ đang thử nghiệm hoặc đang phát triển để thu thập ý kiến từ cộng đồng và các trải nghiệm thực tế trước khi chúng trở thành một phần chính thức của JDK. Nên mình sẽ chưa đề cập tới ở đây.

## Java 20
Cũng tương tự như Java 19, thì Java 20 cũng như vậy.

## JAVA 21
### 1. Virtual Threads
Một trong những tính năng quan trọng nhất của Java 21 là Virtual Threads

Tính năng này giới thiệu các luồng nhẹ (lightweight threads) chạy trên các luồng của hệ điều hành (system threads), nhằm đơn giản hóa việc lập trình đồng thời và cải thiện hiệu suất cho một số khối lượng công việc nhất định.

Hiểu một cách đơn giản nó sẽ là như này, trong mô hình truyền thống của Java, mỗi luồng được tạo tương đương với một luồng hệ điều hành. Điều này có nghĩa là khi bạn tạo ra một luồng Java, JVM sẽ tạo một luồng hệ điều hành tương ứng và khi bạn tạo ra 100 luồng thì cũng sẽ có 100 luồng hệ điều hành tương ứng được tạo - tỉ lệ 1:1. Khi mở rộng ứng dụng, xu hướng là chúng ta sẽ cần càng nhiều threads hơn, dẫn đến memory tăng theo. Việc này tạo ra áp lực nên CPU. Thêm nữa, các developer ít kinh nghiệm thường mắc lỗi trong việc quản lý threads dẫn đến việc sử dụng chúng không hiệu quả.

Với Vitural Threads câu chuyện nay đã khác, threads Java & threads Os sẽ theo tỉ lệ: n:1. Tức là ta có thể chạy rất nhiều đoạn code bất động bộ với số lượng threads Os ít hơn, đôi khi chỉ cần 1. Thời gian khởi tạo & tài nguyên cần thiết của Vitural Thread ít hơn so với Threads Os. Vitural Threads sẽ được quản lý bởi JDK. Nhìn chung, tính năng này rất hữu ích và được cộng đồng đón nhận tích cực

Virtual Threads là một biến thể của java.lang.Thread nhưng nhẹ và linh hoạt hơn nhiều và là một phần của Project Loom không được hệ điều hành quản lý hoặc lên lịch. Thay vào đó, JVM sẽ chịu trách nhiệm làm điều này. Như các bạn đã biết, bất kỳ công việc thực tế nào cũng phải được chạy trong một luồng nền tảng (Platform Thread), nhưng JVM đang sử dụng khái niệm Carrier Thread , chính là các luồng nền tảng, để “mang” bất kỳ luồng ảo nào khi thực thi.

- Lợi ích mà Vitural Threads mang lại:
- Nhẹ hơn:
  - So với các luồng hệ điều hành, virtual threads có chi phí tạo và chuyển đổi ngữ cảnh đáng kể thấp hơn.
- Tăng hiệu suất đồng thời:
  - Có thể quản lý một số lượng lớn hơn các virtual threads một cách hiệu quả trong một số lượng giới hạn của các luồng hệ điều hành, giúp tận dụng tốt hơn các tài nguyên cho một số công việc cụ thể.
- Lập trình đồng thời (concurrency ) được đơn giản hóa:

  - Virtual threads loại bỏ nhu cầu quản lý và đồng bộ hóa luồng phức tạp, giúp làm đơn giản hóa lập trình đồng thời cho các nhà phát triển.






