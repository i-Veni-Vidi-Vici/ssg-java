package com.sh.app._01.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInfo {
    private Receiver receiver;
    private Address address;

    public void changeAddress(Address newAddress) {
        this.address = newAddress;
    }
}
