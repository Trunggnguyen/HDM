package com.acom.acomproduct.api

import com.acom.acomproduct.entity.Product
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping
class ProductApiController {

    val products = listOf(
        Product(1L, "Laptop Acer Gaming Nitro 5", "i5 11400H/8GBRam/512GB SSD/GTX1650 4G/15.6 inch FHD 144Hz/Win 11/Đen", 10, 12000000.0),
        Product(2L, "Laptop Asus VivoBook", "R5 5600H/8GB RAM/512GB SSD/14 Oled 2.8K/Win11/Bạc", 0, 22000000.0),
        Product(3L, "Laptop Asus ZenBook", "i5 1135G7/8GB RAM/512GB SSD/14 FHD/Win11/Cáp USB to LAN/Tím", 2, 25000000.0),
        Product(4L, "Laptop Asus Gaming TUF", "i5 11400H/8GB RAM/512GB SSD/15.6 FHD 144hz/RTX 3050 4GB/Win11/Đen", 7, 47000000.0),
        Product(5L, "Laptop Asus Gaming ROG Strix", "R7 4800H/8GB RAM/512GB SSD/15.6 FHD 144hz/GTX1650 4GB/Win11/Xám", 21, 2000000.0),
        Product(6L, "Máy tính bảng Samsung Galaxy Tab", "32GB/8 inch/Wifi/4G/Android 9.0/Bạc", 16, 7000000.0),
        Product(7L, "Microsoft Surface Pro", "i5 1035G4/8GB RAM/128GB SSD/12.3\"/Win10 Home/Bạc", 25, 15000000.0),
    )

    @GetMapping(params = ["id"])
    fun getProduct(@RequestParam id: Long): Product? {
        return products.firstOrNull { p -> p.id == id }
    }

    @PutMapping
    fun updateProduct(@RequestBody product: Product): Product? {
        val index = products.indexOfFirst { p -> p.id == product.id }
        if (index >= 0) {
            products[index].quantity = product.quantity
            return products[index]
        }
        return null
    }
}