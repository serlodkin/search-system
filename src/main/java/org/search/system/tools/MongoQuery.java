/*
MIT License

Copyright (c) 2016-2017 Daniil Matkov

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package org.search.system.tools;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.bson.Document;
import org.search.system.managers.DatabaseManager;
import org.search.system.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/*
 * Returns List database elements from collection by query
 *
 * @author Daniil Matkov
 */
public class MongoQuery<T> {

    private static final DatabaseManager databaseManager = new DatabaseManager();

    private Class<T> typeParameterClass;

    public MongoQuery(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public ArrayList<T> getDataByTag(String databaseName, String tag, Document query){
        ArrayList<T> result=new ArrayList<>();
        try {
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