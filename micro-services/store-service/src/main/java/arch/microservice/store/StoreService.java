package arch.microservice.store;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional
public class StoreService {

    @Transactional
    public List<Store> findAllStores() {
        return Store.listAll();
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
