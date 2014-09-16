package org.rakam.analysis;

import org.rakam.ServiceStarter;
import org.rakam.cache.CacheAdapter;
import org.rakam.database.DatabaseAdapter;
import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.core.json.JsonObject;

/**
 * Created by buremba <Burak Emre Kabakcı> on 03/09/14 02:02.
 */
public class AnalysisRequestHandler implements Handler<Message<JsonObject>> {
    private static final DatabaseAdapter databaseAdapter = ServiceStarter.injector.getInstance(DatabaseAdapter.class);
    private static final CacheAdapter cacheAdapter = ServiceStarter.injector.getInstance(CacheAdapter.class);

    @Override
    public void handle(Message<JsonObject> event) {
        JsonObject query = event.body();
        event.reply(new EventAnalyzer(cacheAdapter, databaseAdapter).handle(query));
    }
}