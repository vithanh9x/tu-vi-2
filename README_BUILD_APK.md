# Tử Vi Lạc Hồng 1.4 – Android APK

## Những điểm mới trong bản 1.4
- Xưng hô theo tuổi mụ và giới tính, dùng xuyên suốt tổng quan và phần luận giải: 0–15 tuổi là Quý Cháu Trai/Gái; 16–35 là Quý Anh/Chị; 36–49 là Quý Chú/Cô; 50–64 là Quý Bác; 65–79 là Quý Ông/Bà; từ 80 tuổi là Quý Cụ.
- Tổng quan lá số theo bố cục tham khảo XemTuong.net: họ tên, xưng hô, âm dương, tuổi, ngày âm/dương, Can Chi ngày/tháng/năm, giờ/phút sinh, Mệnh–Cục, nạp âm, cầm tinh, Chủ Mệnh/Chủ Thân, Con Nhà, Xuất Tướng Tinh, Độ Mạng, Cân Xương, hạn năm, thời điểm lập và điểm từng cung.
- Có trường nhập giờ/phút chính xác (ví dụ 14:15), tự quy về 12 canh giờ để an sao, đồng bộ với ô chọn canh giờ và lưu lại trong lịch sử/snapshot.
- Phân biệt nạp âm năm sinh với nạp âm Can Chi cung Mệnh dùng để diễn giải Cục. Ví dụ lá số mẫu: Mệnh an Tuất, Can Chi cung Mệnh Giáp Tuất, nạp âm Sơn Đầu Hỏa, Hỏa Lục Cục.
- Bổ sung ý tượng ngũ hành Cục và phần giải thích nạp âm.
- Thêm Lai Nhân Cung theo Can cung trùng Can năm sinh; hiển thị cung được nhận diện cùng phân tích nhóm tự lập Mệnh–Tài–Quan–Điền hoặc nhóm quan hệ/môi trường.
- Thêm Cách Cục Bình Giải có điều kiện: Khoa Quyền Lộc Giáp, Lộc Mã Giao Trì và các tổ hợp chính tinh chỉ được hiển thị khi dữ liệu an sao thỏa điều kiện đã lập trình. Khi không nhận diện được thì hiển thị trung tính, không tự gán cách cục cát.
- Bổ sung phần Cung Thân: vị trí Thân, sao tại cung Thân, đối chiếu Mệnh–Thân và bảng sáu vị trí Thân cư.
- Trẻ em được luận theo hướng môi trường nuôi dưỡng, học tập, thói quen và năng lực đang phát triển; không đóng khung nghề nghiệp, tài vận, hôn nhân hoặc hậu vận.
- Điểm Huyền Khí /100 là thang nội bộ của ứng dụng, không quy đổi giả lập sang thang /70 của XemTuong.net.

## Tính năng đang có từ 1.2
- Bộ máy luận giải 12 cung có xét chính tinh, phụ tinh, trạng thái sao, tam phương tứ chính, Tứ Hóa, ngũ hành, Tuần/Triệt và các lớp vận hạn có dữ liệu.
- Đủ 88 nhãn phụ tinh trong từ điển giải nghĩa.
- Hiển thị toàn bộ sao trong từng cung; ô cung tự tăng chiều cao để không cắt khuất.
- Xuất lá số JPG và PDF A4 ngang; Android 10+ lưu vào `Download/TuViLacHong/`.
- Lưu tối đa 50 lá số gần nhất trên thiết bị, có snapshot dữ liệu để mở lại.
- Mở khóa thủ công qua Zalo **034.559.3246**; nội dung mã yêu cầu được sao chép, người dùng tự dán và gửi.

## Build APK bằng GitHub Actions
1. Đưa toàn bộ nội dung ZIP vào thư mục gốc repository GitHub.
2. Push lên nhánh `main`/`master` hoặc mở **Actions → Build Android APK → Run workflow**.
3. Tải artifact **TuViLacHong-ThienCung-APK**; bên trong có `app-debug.apk`.

Workflow dùng JDK 17 và Gradle 8.4. Mã nguồn đã kiểm tra cú pháp JavaScript, kiểm tra quy đổi giờ/phút và smoke-test phần dựng tổng quan trong Node.js; chưa build APK trong môi trường hiện tại.

## Mở khóa thủ công
- Thanh toán tự động ngân hàng vẫn tạm hoãn. Giữ giá 5.000đ mở một cung và 10.000đ mở 12 cung.
- Người dùng bấm tạo mã yêu cầu, app sao chép nội dung và mở Zalo `https://zalo.me/0345593246`; người dùng tự dán rồi gửi.
- Quản trị viên xác minh chuyển khoản thủ công, dùng `ADMIN_CAP_MA_KICH_HOAT.html` cấp mã, sau đó gửi mã lại cho khách.
- Mã kích hoạt offline có khóa kiểm tra nhúng trong APK, chưa có mức chống gian lận như máy chủ.

## Giới hạn
- Bảng “Con Nhà / Xuất Tướng Tinh / Độ Mạng” hiện chỉ hiển thị khi có dữ liệu đối chiếu đã xác minh cho tổ hợp Can Chi. Mẫu Giáp Thìn trong ảnh người dùng gửi đã được khai báo; các tổ hợp khác không được tự đoán.
- Lịch sử lá số được lưu trên thiết bị hiện tại, chưa đồng bộ tài khoản/cloud.
- Một số lưu nguyệt/lưu hạn chưa được tính đầy đủ; app không tự tạo dự báo tháng khi thiếu dữ liệu an sao tương ứng.
- Tử Vi là hệ thống diễn giải truyền thống để tham khảo văn hóa, không phải phương pháp khoa học dự báo sự kiện hoặc tư vấn y tế/pháp lý/tài chính.
