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

package org.search.system.utils;

import com.google.common.base.Objects;
import org.search.system.interfaces.Logger;
import org.search.system.loggers.FileLogger;
import org.search.system.loggers.WebLogger;
import org.search.system.models.Config;
import org.search.system.parsers.ConfigParser;
import java.util.Objects;

/*
 * Log utils
 * @author Daniil Matkov
 */
public class LogUtil {

    public static void log(String info) {
        Logger logger = null;
        Config config = null;
        try {
            config = new ConfigParser().getConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (config == null) {
            return;
        }
        if (Objects.equals(config.getLoggingType(), "external")) {
            try {
                logger = new WebLogger();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!Objects.equals(config.getLoggingType(), "none")) {
            logger = new FileLogger();
        }

        if (logger != null) {
            logger.log(info);
        }
    }

}
