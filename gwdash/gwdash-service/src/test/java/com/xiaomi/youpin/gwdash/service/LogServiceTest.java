/*
 *  Copyright 2020 Xiaomi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.xiaomi.youpin.gwdash.service;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LogServiceTest {
    private final String ProjectCompilation = "ProjectCompilation";
    private final String ProjectDeployment = "ProjectDeployment";
    private final String LogPath = "xxxx/log/gwdash/mione/";

    @Test
    public void init() {
        File file = new File(LogPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        Assert.assertTrue(file.exists()&&file.isDirectory());
    }

    @Test
    public void subscribe() {
        saveLog();
        LogService logService = new LogService();
        logService.getLog(ProjectCompilation,2L);
    }

    @Test
    public void saveLog() {
        LogService logService = new LogService();
        logService.saveLog(ProjectCompilation,1L,"first log");
        logService.saveLog(ProjectCompilation,1L,"second log"+System.lineSeparator());
        logService.saveLog(ProjectCompilation,1L,"third log"+System.lineSeparator());

        logService.saveLog(ProjectCompilation,2L,"first log");
        logService.saveLog(ProjectCompilation,2L,"second log"+System.lineSeparator());
        logService.saveLog(ProjectCompilation,2L,"third log"+System.lineSeparator());
    }

    @Test
    public void scheduledSave() {
        saveLog();
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogService logService = new LogService();
        logService.scheduledSave();
    }

    @Test
    public void scheduledDelete() {
        LogService logService = new LogService();
        logService.scheduledDelete();
    }
}