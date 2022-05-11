# Acom email
- Chức năng: gửi mail hàng loạt.
- Địa chỉ gửi sửa trong `destinations`
- Tiêu đề mail sửa trong `subject`
- Nội dung mail sửa trong `content`
### Cách sử dụng

- Request: `[ip address]:8088/api/email`
- Request body:
<pre>
<code>{
  "destinations": [
    "cn20082000@gmail.com"
  ],
  "subject": "Test subject",
  "content": "test content"
}</code>
</pre>
- Reponse success:
<pre>
<code>{
  "data": "Email sent!"
}</code>
</pre>
- Reponse failure:
<pre>
<code>{
  "error": {
    "status": 400,
    "error": "MISSING_SUBJECT",
    "message": "missing subject",
    "stacktrace": "..."
  }
}</code>
</pre>