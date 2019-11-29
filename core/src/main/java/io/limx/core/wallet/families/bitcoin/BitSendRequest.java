package io.limx.core.wallet.families.bitcoin;

import io.limx.core.coins.CoinType;
import io.limx.core.coins.Value;
import io.limx.core.coins.families.BitFamily;
import io.limx.core.util.TypeUtils;
import io.limx.core.wallet.SendRequest;

import org.bitcoinj.core.Coin;
import org.bitcoinj.core.Transaction;

import static io.limx.core.Preconditions.checkState;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author John L. Jegutanis
 */
public class BitSendRequest extends SendRequest<BitTransaction> {
    public BitSendRequest(CoinType type) {
        super(type);
    }

    /**
     * <p>Creates a new SendRequest to the given address for the given value.</p>
     *
     * <p>Be very careful when value is smaller than {@link Transaction#MIN_NONDUST_OUTPUT} as the transaction will
     * likely be rejected by the network in this case.</p>
     */

    public static BitSendRequest to(BitAddress destination, Value amount) {
        checkNotNull(destination.getType(), "Address is for an unknown network");
        checkState(TypeUtils.is(destination.getType(), amount.type), "Incompatible sending amount type");
        checkTypeCompatibility(destination.getType());

        BitSendRequest req = new BitSendRequest(destination.getType());

        Transaction tx = new Transaction(req.type);
        tx.addOutput(amount.toCoin(), destination);
        req.tx = new BitTransaction(tx);

        return req;
    }

    public static BitSendRequest emptyWallet(BitAddress destination) {
        checkNotNull(destination.getType(), "Address is for an unknown network");
        checkTypeCompatibility(destination.getType());

        BitSendRequest req = new BitSendRequest(destination.getType());

        Transaction tx = new Transaction(req.type);
        tx.addOutput(Coin.ZERO, destination);
        req.tx = new BitTransaction(tx);
        req.emptyWallet = true;

        return req;
    }

    private static void checkTypeCompatibility(CoinType type) {
        // Only Bitcoin family coins are supported
        if (!(type instanceof BitFamily)) {
            throw new RuntimeException("Unsupported type: " + type);
        }
    }
}
