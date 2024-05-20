package com.billionaire.backend.global.common;

import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@SuperBuilder
public abstract class BaseAuditDto {
    @JsonInclude(Include.NON_NULL)
    private Date createdAt;
    @JsonInclude(Include.NON_NULL)
    private String createdBy;
    @JsonInclude(Include.NON_NULL)
    private Date modifiedAt;
    @JsonInclude(Include.NON_NULL)
    private String modifiedBy;
}
