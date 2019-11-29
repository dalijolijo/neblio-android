package io.limx.core.wallet.families.bitcoin;

import io.limx.core.network.AddressStatus;
import io.limx.core.network.ServerClient.UnspentTx;
import io.limx.core.network.interfaces.TransactionEventListener;

import java.util.List;

/**
 * @author John L. Jegutanis
 */
public interface BitTransactionEventListener extends TransactionEventListener<BitTransaction> {
    void onUnspentTransactionUpdate(AddressStatus status, List<UnspentTx> UnspentTxes);
}
