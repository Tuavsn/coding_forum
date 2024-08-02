package com.hoctuan.studentcodehub.model.entity.notify;

import com.hoctuan.studentcodehub.common.BaseEntity;
import com.hoctuan.studentcodehub.constant.NotifyStatus;
import com.hoctuan.studentcodehub.model.entity.account.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Notify extends BaseEntity {
    @ManyToOne(optional = false)
    private User source;

    @ManyToOne(optional = false)
    private User target;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String link;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private NotifyStatus status;
}
