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
import org.search.system.cached.ResultCache;
import org.search.system.models.Page;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/*
 * Action presents result for search request
 *
 * @author Daniil Matkov
 */
public class ResultAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

    private String searchQuery;

    private ArrayList<Page> result;

    private HttpServletResponse servletResponse;

    private HttpServletRequest servletRequest;

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery.toLowerCase();
    }

    @Override
    public String execute() {
        Cookie history = null;
        for (Cookie cookie : servletRequest.getCookies()) {
            if (cookie.getName().equals("history")) {
                history = cookie;
            }

        }
        if (history == null) {
            history = new Cookie("history", "");
        }
        history.setValue(history.getValue() + '|' + searchQuery);
        servletResponse.addCookie(history);
        result = new ArrayList<>();
        try {
            result = ResultCache.resultsCache.get(searchQuery);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }


    public ArrayList<Page> getResult() {
        return result;
    }

    public void setResult(ArrayList<Page> result) {
        this.result = result;
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