# Acom telegram
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