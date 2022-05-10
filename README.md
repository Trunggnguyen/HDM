# HDM
### Các service hiện có:
- `Product`: port 8090
- `Customer`: port 8091
- `Shipment`: port 8092
- `Order`: port 8093
- `Process`: port 8080
### Kích hoạt process như sau:
- Method: POST
- Url: `[baseUrl]:8080`
- Body: 
<pre><code>{
    "customer": {
        "id": 2,
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
            "id": 2,
            "name": "Laptop Asus VivoBook",
            "description": "R5 5600H/8GB RAM/512GB SSD/14 Oled 2.8K/Win11/Bạc",
            "quantity": 0,
            "price": 2.2E7
        }
    ],
    "shipment": {
        "id": 4,
        "name": "Kerry TTC Express",
        "price": 200000.0
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