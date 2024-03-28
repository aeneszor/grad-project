package arch.monolith.store;


import arch.monolith.catalog.Catalog;
import arch.monolith.catalog.CatalogService;
import arch.monolith.inventory.InventoryService;
import arch.monolith.product.ProductService;
import arch.monolith.shipping.ShippingService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional
public class StoreService {

    private final CatalogService catalogService;
    private final InventoryService inventoryService;
    private final ShippingService shippingService;

    public StoreService(CatalogService catalogService, InventoryService inventoryService, ShippingService shippingService) {
        this.catalogService = catalogService;
        this.inventoryService = inventoryService;
        this.shippingService = shippingService;
    }

    @Transactional
    public List<Store> findAllStores() {
        return Store.listAll();
    }

    @Transactional
    public List<Catalog> findStoreCatalogsById(Long storeId) {
        Store store = Store.findById(storeId);
        List<Long> catalogIDs = store.catalogIDs;
        List<Catalog> catalogList = new ArrayList<>();
        for (Long catalogID : catalogIDs) {
            catalogList.add(catalogService.findCatalogById(catalogID));
        }
        return catalogList;
    }

    @Transactional
    public Store findStoreById(Long id){
        return Store.findById(id);
    }

    public Store persistStore(@Valid Store store) {
        store.persist();
        return store;
    }

    public Store updateStore(@Valid Store store) {
        Store entity = Store.findById(store.id);
        entity.name = store.name;
        entity.rating = store.rating;
        entity.catalogIDs = store.catalogIDs;
        entity.inventoryIDs = store.inventoryIDs;
        entity.shippingIDs = store.shippingIDs;
        return entity;
    }

    public void deleteStore(Long id) {
        Store store = Store.findById(id);
        store.delete();
    }
}
