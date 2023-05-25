package com.store.inventorymanagement.domain.dtos.In;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {

    private Integer idCliente;
}
