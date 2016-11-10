package org.search.system.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.search.system.dao.PageDao;
import org.search.system.models.Page;
import org.search.system.parsers.HtmlParser;

/**
 * Created by Daniil on 10.11.2016.
 */
public class AddAction extends ActionSupport {
    private String url;

    @Override
    public String execute() {
        HtmlParser parser = new HtmlParser();
        Page result = parser.parse(url);
        PageDao pageDao = new PageDao();
        pageDao.insert(result);
        return SUCCESS;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
