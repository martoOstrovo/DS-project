package apm.ds.auctionservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String itemName;
    private String description;
    private Double currentPrice;

    public Item(Long userId, String itemName, String description, Double currentPrice) {
        this.userId = userId;
        this.itemName = itemName;
        this.description = description;
        this.currentPrice = currentPrice;
    }
}
