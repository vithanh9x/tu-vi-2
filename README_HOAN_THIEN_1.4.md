# Tử Vi Lạc Hồng 1.4 – Hoàn thiện tổng quan và giờ sinh chính xác

## Nội dung bản 1.4
- Xưng hô theo tuổi mụ và giới tính: 0–15 Quý Cháu Trai/Gái; 16–35 Quý Anh/Chị; 36–49 Quý Chú/Cô; 50–64 Quý Bác; 65–79 Quý Ông/Bà; từ 80 tuổi Quý Cụ.
- Có thể nhập giờ/phút chính xác (ví dụ 14:15); ứng dụng tự quy đổi sang 12 canh giờ để an sao. Giờ/phút được lưu trong hồ sơ, lịch sử và snapshot.
- Tổng quan lá số có ngày âm/dương, Can Chi ngày/tháng/năm, giờ sinh chính xác, hạn năm, thời điểm lập, nạp âm năm sinh, Cục, Can Chi và nạp âm cung Mệnh, Cầm tinh, Chủ Mệnh/Chủ Thân, Con Nhà, Xuất Tướng Tinh, Độ Mạng, Cân Xương, Lai Nhân, điểm từng cung và điểm Huyền Khí nội bộ.
- Cục phân biệt hai lớp: nạp âm năm sinh và nạp âm Can Chi cung Mệnh. Với lá số Hoàng Trung theo dữ liệu ảnh, cung Mệnh ở Tuất, Can Chi cung Mệnh Giáp Tuất, nạp âm Sơn Đầu Hỏa, Cục Hỏa Lục Cục.
- Có mục Cách Cục Bình Giải; chỉ hiện cách cục khi điều kiện sao/vị trí được thỏa. Hai ví dụ trong ảnh: Khoa Quyền Lộc Giáp và Lộc Mã Giao Trì.
- Phần Cung Thân có ý nghĩa vị trí, sao tại cung, so sánh Mệnh–Thân và sáu vị trí Thân cư.
- Phần tổng quan trẻ nhỏ tập trung vào môi trường nuôi dưỡng, học tập, thói quen và năng lực đang hình thành; không phán định nghề nghiệp, hôn nhân, tài vận hoặc tuổi thọ.

## Các chức năng có từ bản 1.2
- 12 cung, bộ máy 108 sao theo bảng an sao Tân Biên đã chọn.
- 88 nhãn phụ tinh trong từ điển giải nghĩa.
- Tự tăng chiều cao ô cung để không cắt phụ tinh.
- Xuất JPG độ phân giải 2800 × 2100 và PDF A4 ngang.
- Lưu tối đa 50 lá số gần nhất trên thiết bị, kèm snapshot để mở lại.
- Mở khóa thủ công qua Zalo 034.559.3246, xác minh chuyển khoản thủ công.

## Giới hạn
- Điểm Huyền Khí /100 là điểm nội bộ của app; không giả quy đổi sang hệ điểm /70 của XemTuong.net.
- Bảng “Con Nhà / Xuất Tướng Tinh / Độ Mạng” chỉ hiển thị dữ liệu đã xác minh; hiện mẫu Giáp Thìn có dữ liệu từ ảnh người dùng, năm khác có thể báo chưa có bảng tra.
- Lịch sử lưu trên thiết bị, chưa đồng bộ tài khoản/cloud.
- Một số sao hạn lưu nguyệt/lưu nhật chưa được an đầy đủ.
- Tử Vi là hệ thống diễn giải truyền thống để tham khảo văn hóa, không phải công cụ khoa học dự báo sự kiện chắc chắn.

## Build
- Android Gradle Plugin 8.2.2, Java 17, Gradle 8.4 trong GitHub Actions.
- Workflow: `.github/workflows/build-apk.yml`.
- Push lên nhánh `main` hoặc chạy thủ công workflow **Build Android APK**; tải artifact `TuViLacHong-ThienCung-APK`, chứa `app-debug.apk`.
- Phiên này chưa build APK và chưa upload dự án lên GitHub.
