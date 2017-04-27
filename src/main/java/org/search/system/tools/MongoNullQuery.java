package org.search.system.tools;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.bson.Document;
import org.search.system.managers.DatabaseManager;
import org.search.system.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/*
 * Returns List database elements from collection, with query=null
 *
 * @author Daniil Matkov
 */
public class MongoNullQuery<T> {

    private static final DatabaseManager databaseManager = new DatabaseManager();

    private Class<T> typeParameterClass;

    public MongoNullQuery(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public ArrayList<T> getDataByTag(String databaseName,String tag){
        ArrayList<T> result=new ArrayList<>();
        try {
            Document query = null;
            List<Document> data = databaseManager.find(databaseName, tag, query);
            Gson gson = new Gson();
            for (Document doc : data){
                result.add(gson.fromJson(doc.toJson(), this.typeParameterClass));
            }
        } catch (JsonSyntaxException ex) {
            LogUtil.log(ex.toString());
        }
        return result;
    }
}
