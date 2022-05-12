package com.acom.acomshipment.api

import com.acom.acomshipment.entity.Shipment
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/shipment")
class ShipmentApiController {

    val shipments = listOf(
        Shipment(1, "Giao Hàng Tiết Kiệm", 100000.0),
        Shipment(2, "Giao hàng nhanh", 120000.0),
        Shipment(3, "VNPost", 150000.0),
        Shipment(4, "ViettelPost", 70000.0),
        Shipment(5, "Kerry TTC Express", 200000.0),
        Shipment(6, "DHL Expres", 110000.0),
    )

    @GetMapping("/{id}")
    fun getShipment(@PathVariable id: Long): Shipment? {
        return shipments.firstOrNull { s -> s.id == id }
    }
}