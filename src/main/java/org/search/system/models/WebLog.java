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

package org.search.system.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.security.SecureRandom;
import java.util.Date;

/**
 * @author Daniil Matkov
 * @since 13.07.2017
 */
public class WebLog {

    private int id;

    private String from;

    private String status;

    private String message;


    public WebLog(String from, String status, String message) {
        this.id = generateRandomInteger();
        this.from = from;
        this.status = status;
        this.message = message;
    }

    private static int generateRandomInteger() {
        SecureRandom rand = new SecureRandom();
        rand.setSeed(new Date().getTime());
        return rand.nextInt(Integer.MAX_VALUE);
    }

    public String toJsonString() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return "WebLog{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
