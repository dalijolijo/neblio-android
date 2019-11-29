package io.limx.core.coins.families;

import io.limx.core.coins.CoinType;
import io.limx.core.wallet.AbstractAddress;
import io.limx.core.exceptions.AddressMalformedException;
import io.limx.core.wallet.families.bitcoin.BitAddress;

import org.bitcoinj.core.AddressFormatException;

/**
 * @author John L. Jegutanis
 *
 * This is the classical Bitcoin family that includes Litecoin, Dogecoin, Dash, etc
 */
public abstract class BitFamily extends CoinType {
    {
        family = Families.BITCOIN;
    }

    @Override
    public BitAddress newAddress(String addressStr) throws AddressMalformedException {
        return BitAddress.from(this, addressStr);
    }
}
