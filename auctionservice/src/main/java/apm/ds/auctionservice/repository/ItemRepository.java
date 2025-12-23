package apm.ds.auctionservice.repository;

import apm.ds.auctionservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByItemName(String itemName);

    void removeUserByItemName(String itemName);
    List<Item> findItemsByUserId(Long userId);
}
