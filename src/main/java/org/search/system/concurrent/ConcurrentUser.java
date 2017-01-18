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

package org.search.system.concurrent;

import org.search.system.models.User;

import java.util.ArrayList;

/*
 * Thread-safe user decorator
 * @author Daniil Matkov
 */
public class ConcurrentUser {

    private final User origin;

    public ConcurrentUser(User origin) {
        this.origin = origin;
    }

    public synchronized String getAddress() {
        return this.origin.getAddress();
    }

    public synchronized String getCountry() {
        return this.origin.getCountry();
    }

    public synchronized void setCountry(String country) {
        this.origin.setCountry(country);
    }

    public synchronized String getLanguage() {
        return this.origin.getLanguage();
    }

    public synchronized void setLanguage(String language) {
        this.origin.setLanguage(language);
    }

    public synchronized ArrayList<String> getHistory() {
        return this.origin.getHistory();
    }

    public synchronized void addToHistory(String request) {
        this.origin.addToHistory(request);
    }

    public synchronized void clearHistory() {
        this.origin.clearHistory();
    }

    public synchronized void deleteHistory(String toDelete) {
        this.origin.deleteHistory(toDelete);
    }

    public synchronized void deleteHistory(int toDelete) {
        this.origin.deleteHistory(toDelete);
    }

    public synchronized String getId() {
        return this.origin.getId();
    }

    public synchronized void setId(String id) {
        this.origin.setId(id);
    }

}
