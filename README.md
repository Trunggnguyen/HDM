# HDM
### Các service hiện có:
- `Product`: port 8090
- `Customer`: port 8091
- `Shipment`: port 8092
- `Order`: port 8093
- `Email`: port 8094
- `Telegram`: port 8095
- `Process`: port 8080
### Kích hoạt process như sau:
- Method: POST
- Url: `[baseUrl]:8080`
- Body: 
<pre><code>{
    "customer": {
        "id": 1,
        "name": "Nguyễn Công Chính",
        "address": "Hà Nội",
        "tel": "0123456789",
        "email": "cn20082000@gmail.com",
        "telegramId": "1988889962"
    },
    "products": [
        {
            "id": 4,
            "name": "Laptop Asus Gaming TUF",
            "description": "i5 11400H/8GB RAM/512GB SSD/15.6 FHD 144hz/RTX 3050 4GB/Win11/Đen",
            "quantity": 5,
            "price": 4.7E7
        },
        {
            "id": 6,
            "name": "Máy tính bảng Samsung Galaxy Tab",
            "description": "32GB/8 inch/Wifi/4G/Android 9.0/Bạc",
            "quantity": 5,
            "price": 7000000.0
        }
    ],
    "shipment": {
        "id": 4,
        "name": "ViettelPost",
        "price": 70000.0`
    }
}</code></pre>
- Success response: `Success`
- Error response: `Failure! [error message]!`
- Uncatched response: 
<pre><code>{
    "timestamp": "",
    "status": ,
    "error": "",
    "trace": "",
    "message": "",
    "path": ""
}</code></pre>