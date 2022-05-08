# Acom telegram
- Chức năng: Gửi tin nhắn tới 1 username xác định
- Hiện tại username chỉ có duy nhất "cn20082000", có thể mở rộng thêm các username khác (tất nhiên vẫn fix cứng trong code, cụ thể tại file `common/FakeData.kt`).
- Nội dung chỉnh sửa trong `content`
### Cách sử dụng

- Request: `[ip address]:8089/api/message`
- Request body:
<pre>
<code>{
  "username": "cn20082000",
  "content": "test content"
}</code>
</pre>
- Reponse success:
<pre>
<code>{
  "data": "Message sent!"
}</code>
</pre>
- Reponse failure:
<pre>
<code>{
  "error": {
    "status": 400,
    "error": "UNKNOWN_USER",
    "message": "cannot find chat id for this username",
    "stacktrace": "..."
  }
}</code>
</pre>