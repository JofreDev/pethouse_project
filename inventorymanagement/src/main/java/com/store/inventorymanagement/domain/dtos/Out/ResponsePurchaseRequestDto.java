package com.store.inventorymanagement.domain.dtos.Out;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePurchaseRequestDto {

    private boolean aprobado;

    private String mensaje;

    public ResponsePurchaseRequestDto(boolean aprobado, String mensaje) {
        this.aprobado = aprobado;
        this.mensaje = mensaje;
    }
}
