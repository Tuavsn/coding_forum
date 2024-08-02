package com.hoctuan.studentcodehub.model.dto.notify;

import com.hoctuan.studentcodehub.common.BaseRequestDTO;
import com.hoctuan.studentcodehub.constant.NotifyStatus;
import com.hoctuan.studentcodehub.model.entity.account.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class NotifyRequestDTO extends BaseRequestDTO {
    private User source;

    private User target;

    private String content;

    private String link;

    private NotifyStatus status;
}
