package org.search.system.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.search.system.dao.PageDao;
import org.search.system.models.Page;
import org.search.system.parsers.HtmlParser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Daniil on 10.11.2016.
 */
public class AddAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private String url;
    private HttpServletResponse servletResponse;
    private HttpServletRequest servletRequest;

    @Override
    public String execute() {
        HtmlParser parser = new HtmlParser();
        Page result = parser.parse(url);
        PageDao pageDao = new PageDao();
        pageDao.insert(result);
        Cookie history = null;
        for (Cookie cookie : servletRequest.getCookies()) {
            if (cookie.getName().equals("history")) {
                history = cookie;
            }

        }
        if (history == null) {
            history = new Cookie("history", "");
        }
        history.setValue(history.getValue() + '|' + url);
        servletResponse.addCookie(history);

        return SUCCESS;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.servletResponse = servletResponse;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.servletRequest = servletRequest;
    }
}
