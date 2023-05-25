package com.store.inventorymanagement.infrastructure.adapters.driven.repositories;

import com.store.inventorymanagement.domain.dtos.In.OrderInDto;
import com.store.inventorymanagement.domain.dtos.In.ProductInDto;
import com.store.inventorymanagement.domain.dtos.Out.ResponsePurchaseRequestDto;
import com.store.inventorymanagement.domain.entities.Product;
import com.store.inventorymanagement.domain.repository.crud.OrderCrudRepository;
import com.store.inventorymanagement.domain.repository.crud.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    @Autowired
    private ProductCrudRepository productCrudRepository;

    public ResponsePurchaseRequestDto verify(OrderInDto newOrder) {
        String nombresProducsts = "";
        for (ProductInDto productInDto : newOrder.getProducts()) {
            Optional<Product> optionalProduct = productCrudRepository.findById(productInDto.getId());
            if (optionalProduct.isEmpty()) {
                String mensaje = new String("El producto con ID " + productInDto.getId() + " no existe.");
                ResponsePurchaseRequestDto response = new ResponsePurchaseRequestDto(false,mensaje);
                return response;
            }else{
                if((optionalProduct.get().getCantidadStock()<= productInDto.getCantidad())){

                    String mensaje = new String("El producto : " + optionalProduct.get().getNombre() +
                            " con id : "+optionalProduct.get().getId()+
                            " no cuenta con el stock suficiente. "+
                            "El stock actual es de "+ optionalProduct.get().getCantidadStock());

                    ResponsePurchaseRequestDto response = new ResponsePurchaseRequestDto(false,mensaje);
                    return response;
                }

            }
            nombresProducsts+=" "+optionalProduct.get().getNombre()+", ";
        }

        String mensaje = new String("Se aprobó la compra para el/los productos : "+nombresProducsts);

        ResponsePurchaseRequestDto response = new ResponsePurchaseRequestDto(true,mensaje);


        return response;
    }

}
