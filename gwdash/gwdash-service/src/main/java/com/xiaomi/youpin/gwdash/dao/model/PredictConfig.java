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

package com.xiaomi.youpin.gwdash.dao.model;

import com.xiaomi.youpin.gwdash.common.PredictStatusEnum;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Data
@Table("predict_config")
public class PredictConfig {

    @Id
    private long id;

    @Column("project_id")
    private long projectId;

    @Column
    private String domain;

    @Column
    private String type;

    @Column
    private int qps;

    /**
     * @see PredictStatusEnum
     */
    @Column
    private Integer status;

    /**
     * mischedule task id
     */
    @Column("task_id")
    private int taskId;

    @Column
    private long ctime;

    @Column
    private long utime;
}