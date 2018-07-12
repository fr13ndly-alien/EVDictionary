********  ỨNG DỤNG TỪ ĐIỂN ANH - VIỆT  ********

Thông tin về tác giả:
Họ và tên: Lê Hữu Hiền
Số điện thoại: 01692171409
Email: huuhien.fsociety@gmail.com
Khoa công nghệ thông tin, trường Đại học Quy Nhơn

*Tài liệu này được đi kèm với mã nguồn của ứng dụng

* Sơ lược về sản phẩm:
	- Phần mềm hỗ trợ tra từ điển
	- Được viết bằng ngôn ngữ lập trình Java


* Chi tiết về sản phẩm:
	- Giao diện đồ họa được viết bằng Thư viện Java Swing.
	- Dữ liệu được tổ chức lưu trữ bằng bảng băm
	- Sử dụng file text để đọc dữ liệu từ điển và lưu vào bảng băm

** Mô hình các lớp của phần mềm

	* Lớp View: xây dựng giao diện đồ họa
	* Lớp DataStorage: tổ chức và lưu trữ dữ liệu từ điển
		+ Đối tượng Hashtable lưu cặp Key- Value dưới dạng
		Key: Từ tiếng Anh
		Value: mảng (Vector) các chuỗi bao gồm cách phát âm và từ loại + nghĩa
		(Có khả năng mở rộng)

** Các vấn đề gặp phải khi xây dựng phân mềm
	* Đọc dữ liệu từ file text gặp phải UTF-8 Encoding với BOM Marker.
	* Đi sai hướng thiết kế phần mềm, không xem xét cấu trúc ghi dữ liệu của file text đã xây dựng các lớp phức tạp, gây khó khăn về việc đọc dữ liệu
	* Vấn đề về dòng rỗng (dòng thứ 17 nếu đọc trong IDE) trong file anhvietDemoData.txt (đoạn code phát hiện ra lỗi ngay bên dưới)
		/*
		lineChar = line.toCharArray();                
        System.out.println(lineChar[0]);
        for(int j=0; j< lineChar.length; j++){
            System.out.print(lineChar[j]+ " ");
        }
        System.out.println("");
        */

** Các kĩ năng học được:
	* Hiểu được thuật toán Hashing
	* Xử lí dòng vào với UTF-8 Encoding BOM Marker
	* Kinh nghiệm trong việc thiết kế và phát triển phần mềm
	* Hiểu hơn về Constructor của các lớp tường minh Colection Interface (ex: new Vector<String> - Vector các đối tượng lơp String)
	* Chạy ứng dụng dưới chế độ Encoding

	* So sánh độ tốn tài nguyên của khối try catch và câu lệnh if