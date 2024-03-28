package arch.monolith.store;

import arch.monolith.catalog.Catalog;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/api/stores")
public class StoreResource {

    Logger logger;
    StoreService storeService;

    public StoreResource(Logger logger, StoreService storeService) {
        this.storeService = storeService;
        this.logger = logger;
    }

    @GET
    public RestResponse<List<Store>> getAllStores() {
        List<Store> stores = storeService.findAllStores();
        logger.info("Total number of stores: " + stores.size());
        return RestResponse.ok(stores);
    }

    @GET
    @Path("/{id}")
    public RestResponse<Store> getStore(@RestPath Long id) {
        Store store = storeService.findStoreById(id);
        if (store != null) {
            logger.info("Found store " + store);
            return RestResponse.ok(store);
        } else {
            logger.info("No store found with id " + id);
            return RestResponse.noContent();
        }
    }

    @GET
    @Path("/{id}/catalogs")
    public RestResponse<List<Catalog>> getStoreCatalogs(@RestPath Long id) {
        List<Catalog> catalogList = storeService.findStoreCatalogsById(id);
        if (catalogList.get(0) != null) {
            logger.info("Found catalogs of store id " + id);
            return RestResponse.ok(catalogList);
        } else {
            logger.info("No catalogs found with store id " + id);
            return RestResponse.noContent();
        }
    }

    @POST
    public RestResponse<Void> createStore(@Valid Store store, @Context UriInfo uriInfo) {
        store = storeService.persistStore(store);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(store.id));
        logger.info("New store created with URI " + builder.build().toString());
        return RestResponse.created(builder.build());
    }

    @PUT
    public RestResponse<Store> updateStore(@Valid Store store) {
        store = storeService.updateStore(store);
        logger.info("Store updated with new valued " + store);
        return RestResponse.ok(store);
    }

    @DELETE
    @Path("/{id}")
    public RestResponse<Void> deleteStore(@RestPath Long id) {
        storeService.deleteStore(id);
        logger.info("Store deleted with " + id);
        return RestResponse.noContent();
    }

}
