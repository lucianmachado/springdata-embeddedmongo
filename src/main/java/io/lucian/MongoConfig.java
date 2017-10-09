package io.lucian;

import com.mongodb.*;
import com.mongodb.util.JSON;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.io.File;
import java.util.Scanner;


/**
 * Created by lucian on 07/10/2017.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
    @Autowired
    private Environment env;

    @Override
    protected String getDatabaseName() {
        return "mec";
    }

    @Override
    public Mongo mongo() throws Exception {
        Mongo mongo = new EmbeddedMongoBuilder()
                .version("2.6.1")
                .bindIp("127.0.0.1")
                .port(12345)
                .build();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("data-mongodb.json").getFile());
        String content = new Scanner(file).useDelimiter("\\Z").next();

        MongoClient client = new MongoClient("127.0.0.1", 12345);
        DB db = client.getDB("mec");
        DBCollection col = db.createCollection("ies", new BasicDBObject());

        JSONArray jsonArray = new JSONArray(content);
        for (Object json : jsonArray
                ) {
            DBObject dbObject = (DBObject) JSON
                    .parse(json.toString());
            col.save(dbObject);
        }
        return mongo;
    }
}
