/*
MIT License

Copyright (c) 2016 Daniil Matkov

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
 * Action to add new web page
 * @author Daniil Matkov
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
        this.servletRequest = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.servletResponse = httpServletResponse;
    }
}
