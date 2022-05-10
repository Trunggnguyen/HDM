package com.acom.acomproduct.api

import com.acom.acomproduct.entity.Product
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/product")
class ProductApiController {

    val products = listOf(
        Product(1L, "Laptop Acer Gaming Nitro 5", "i5 11400H/8GBRam/512GB SSD/GTX1650 4G/15.6 inch FHD 144Hz/Win 11/Đen", 10),
        Product(2L, "Laptop Asus VivoBook", "R5 5600H/8GB RAM/512GB SSD/14 Oled 2.8K/Win11/Bạc", 0),
        Product(3L, "Laptop Asus ZenBook", "i5 1135G7/8GB RAM/512GB SSD/14 FHD/Win11/Cáp USB to LAN/Tím", 2),
        Product(4L, "Laptop Asus Gaming TUF", "i5 11400H/8GB RAM/512GB SSD/15.6 FHD 144hz/RTX 3050 4GB/Win11/Đen", 7),
        Product(5L, "Laptop Asus Gaming ROG Strix", "R7 4800H/8GB RAM/512GB SSD/15.6 FHD 144hz/GTX1650 4GB/Win11/Xám", 21),
        Product(6L, "Máy tính bảng Samsung Galaxy Tab", "32GB/8 inch/Wifi/4G/Android 9.0/Bạc", 16),
        Product(7L, "Microsoft Surface Pro", "i5 1035G4/8GB RAM/128GB SSD/12.3\"/Win10 Home/Bạc", 25),
    )

    @GetMapping(params = ["id"])
    fun getProduct(@RequestParam id: Long): Product? {
        return products.firstOrNull { p -> p.id == id }
    }

    @GetMapping(params = ["ids"])
    fun getProduct(@RequestParam ids: Array<Long>): List<Product> {
        val result = mutableListOf<Product>()
        ids.forEach {
            products.firstOrNull { p -> p.id == it }?.let { product ->
                result.add(product)
            }
        }
        return result
    }
}